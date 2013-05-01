package vooga.rts.state;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.xml.parsers.ParserConfigurationException;
import util.Location;
import vooga.rts.commands.Command;
import vooga.rts.commands.DragCommand;
import vooga.rts.controller.Controller;
import vooga.rts.game.RTSGame;
import vooga.rts.gamedesign.factories.Factory;
import vooga.rts.gamedesign.sprite.gamesprites.Resource;
import vooga.rts.gamedesign.sprite.gamesprites.interactive.InteractiveEntity;
import vooga.rts.gamedesign.sprite.gamesprites.interactive.buildings.Building;
import vooga.rts.gamedesign.sprite.gamesprites.interactive.units.Unit;
import vooga.rts.gamedesign.sprite.map.Terrain;
import vooga.rts.leveleditor.components.MapLoader;
import vooga.rts.manager.PlayerManager;
import vooga.rts.map.GameMap;
import vooga.rts.map.MiniMap;
import vooga.rts.util.Camera;
import vooga.rts.util.DelayedTask;
import vooga.rts.util.FrameCounter;
import vooga.rts.util.Information;
import vooga.rts.util.Location3D;
import vooga.rts.util.Pixmap;
import vooga.rts.util.Scale;
import vooga.rts.util.TimeIt;


/**
 * The main model of the game. This keeps track of all the players, the
 * humanplayer associated with the local game, plus the map.
 * 
 * @author Challen Herzberg-Brovold
 * 
 */
public class GameState extends SubState implements Controller, Observer {
    private static final Location FPS_SCREEN_LOC = new Location(50, 15);

    private static final Location3D DEFAULT_SOLDIER_ONE_RELATIVE_LOCATION = new Location3D(100,
                                                                                           100, 0);

    private static final Location3D DEFAULT_WORKER_RELATIVE_LOCATION = new Location3D(200, 200, 0);

    private static final Location3D DEFAULT_PRODUCTION_RELATIVE_LOCATION = new Location3D(000, 500,
                                                                                          0);

    private static final Location3D DEFAULT_OCCUPY_RELATIVE_LOCATION = new Location3D(300, 300, 0);

    private static GameMap myMap;
    private static PlayerManager myPlayers = new PlayerManager();

    private List<DelayedTask> myTasks;
    private FrameCounter myFrames;

    private Rectangle2D myDrag;

    private MiniMap myMiniMap;

    private boolean isGameOver;

    public GameState (Observer observer) {
        super(observer);
        myFrames = new FrameCounter(FPS_SCREEN_LOC);
        myTasks = new ArrayList<DelayedTask>();
        myPlayers.addObserver(this);
        isGameOver = false;
    }

    @Override
    public void update (double elapsedTime) {
        myMap.update(elapsedTime);
        getPlayers().update(elapsedTime);

        for (DelayedTask dt : myTasks) {
            dt.update(elapsedTime);
        }
        myFrames.update(elapsedTime);
    }

    @Override
    public void paint (Graphics2D pen) {
        Scale.unscalePen(pen);
        pen.setBackground(Color.BLACK);
        myMap.paint(pen);

        // myMiniMap.paint(pen);

        if (myDrag != null) {
            pen.draw(myDrag);
        }

        Camera.instance().paint(pen);
        myFrames.paint(pen);
        Scale.scalePen(pen);
        getPlayers().getHuman().paint(pen);
    }

    @Override
    public void receiveCommand (Command command) {
        // If it's a drag, we need to do some extra checking.
        if (command instanceof DragCommand) {
            myDrag = ((DragCommand) command).getScreenRectangle();
            if (myDrag == null) {
                return;
            }
        }
        sendCommand(command);
    }

    @Override
    public void sendCommand (Command command) {
        getPlayers().getHuman().sendCommand(command);
    }

    public void setupGame () {
        // Add player to team 1
        getPlayers().addPlayer(1);
        // Add player to team 2
        getPlayers().addPlayer(2);

        for (int i = 0; i < 2; i++) {
            getPlayers().getPlayer(i).setBase(getMap().getPlayerLocations().get(i));
            getPlayers().getPlayer(i).getResources()
                    .setInitialValues(RTSGame.getFactory().getStarterPack());
            generateInitialSprites(i);
        }        
    }

    private void generateInitialSprites (int playerID) {
        Location3D baseLocation = getPlayers().getPlayer(playerID).getBase();
        Unit worker = (Unit) RTSGame.getFactory().getEntitiesMap().get("worker").copy();
        worker =

        (Unit) setLocation(worker, baseLocation, DEFAULT_WORKER_RELATIVE_LOCATION);

        getPlayers().getPlayer(playerID).add(worker);

        Unit soldierOne = (Unit) RTSGame.getFactory().getEntitiesMap().get("Marine").copy();
        soldierOne =

        (Unit) setLocation(soldierOne, baseLocation, DEFAULT_SOLDIER_ONE_RELATIVE_LOCATION);

        getPlayers().getPlayer(playerID).add(soldierOne);

        Building startProduction =
                (Building) RTSGame.getFactory().getEntitiesMap().get("home").copy();
        startProduction =
                (Building) setLocation(startProduction, baseLocation,
                                       DEFAULT_PRODUCTION_RELATIVE_LOCATION);
        getPlayers().getPlayer(playerID).add(startProduction);
        

        Building startOccupy =
                (Building) RTSGame.getFactory().getEntitiesMap().get("garrison").copy();
        startOccupy =
                (Building) setLocation(startOccupy, baseLocation, DEFAULT_OCCUPY_RELATIVE_LOCATION);
        getPlayers().getPlayer(playerID).add(startOccupy);

    }

    private InteractiveEntity setLocation (InteractiveEntity subject,
                                           Location3D base,
                                           Location3D reference) {
        subject.setWorldLocation(new Location3D(base.getX() + reference.getX(), base.getY() +
                                                                                reference.getY(),
                                                base.getZ() + reference.getZ()));
        subject.move(subject.getWorldLocation());
        return subject;
    }

    public void setGameOver () {
        isGameOver = true;
    }

    public static PlayerManager getPlayers () {
        return myPlayers;
    }

    public static GameMap getMap () {
        return myMap;
    }

    @Override
    public void update (Observable arg0, Object arg1) {
        if (arg1 instanceof GameOver) {
            setGameOver();
            setChanged();
            notifyObservers(arg1);    
        }
    }

    public static void setMap (GameMap map) {
        myMap = map;
    }

    @Override
    public void activate () {
    }

    public void setupMap (String mapfile) {
        MapLoader ml = null;
        try {
            ml = new MapLoader();
            ml.loadMapFile(mapfile);
        }
        catch (ParserConfigurationException e) {
        }
        catch (Exception e1) {
        }
        if (ml.getMyMap().getPlayerLocations().size() < 2) {
            return;
        }
        setMap(ml.getMyMap());
        myMiniMap = new MiniMap(getMap(), new Location(50, 500), new Dimension(150, 200));
        setupGame();
    }
}
