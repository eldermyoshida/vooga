package vooga.rts.state;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observer;
import vooga.rts.commands.Command;
import vooga.rts.commands.DragCommand;
import vooga.rts.controller.Controller;
import vooga.rts.gamedesign.factories.Factory;
import vooga.rts.gamedesign.sprite.gamesprites.Projectile;
import vooga.rts.gamedesign.sprite.gamesprites.Resource;
import vooga.rts.gamedesign.sprite.gamesprites.interactive.InteractiveEntity;
import vooga.rts.gamedesign.sprite.gamesprites.interactive.units.Unit;
import vooga.rts.gamedesign.sprite.gamesprites.interactive.buildings.Building;
import vooga.rts.gamedesign.strategy.attackstrategy.CanAttack;
import vooga.rts.gamedesign.strategy.gatherstrategy.CanGather;
import vooga.rts.gamedesign.strategy.occupystrategy.CanBeOccupied;
import vooga.rts.gamedesign.sprite.map.Terrain;
import vooga.rts.gamedesign.strategy.production.CanProduce;
import vooga.rts.gamedesign.weapon.Weapon;
import vooga.rts.manager.PlayerManager;
import vooga.rts.map.GameMap;
import vooga.rts.player.HumanPlayer;
import vooga.rts.player.Player;
import vooga.rts.player.Team;
import vooga.rts.resourcemanager.ResourceManager;
import vooga.rts.util.Camera;
import vooga.rts.util.DelayedTask;
import vooga.rts.util.FrameCounter;
import vooga.rts.util.Information;
import vooga.rts.util.Location;
import vooga.rts.util.Location3D;
import vooga.rts.util.Pixmap;
import vooga.rts.util.PointTester;


/**
 * The main model of the game. This keeps track of all the players, the
 * humanplayer associated with the local game, plus the map.
 * 
 * @author Challen Herzberg-Brovold
 * 
 */

public class GameState extends SubState implements Controller {
    private static final Location3D DEFAULT_SOLDIER_ONE_RELATIVE_LOCATION = new Location3D(300, 300, 0);
    private static final Location3D DEFAULT_SOLDIER_TWO_RELATIVE_LOCATION = new Location3D(0, 500, 0);
    private static final Location3D DEFAULT_SOLDIER_THREE_RELATIVE_LOCATION = new Location3D(300, 0 , 0);
    private static final Information DEFAULT_SOLDIER_INFO =
    		new Information("Marine", "I am a soldier of Nunu.", null, "buttons/marine.png");
    private static final Location3D DEFAULT_WORKER_RELATIVE_LOCATION = new Location3D(200, 200, 0);
    private static final Information DEFAULT_WORKER_INFO = new Information("Worker",
            "I am a worker. I am sent down from Denethor, son of Ecthelion ",
            null, "images/scv.png");
    private static final Location3D DEFAULT_PRODUCTION_RELATIVE_LOCATION = new Location3D(000, 500, 0);
    private static final Information DEFAULT_PRODUCTION_INFO = new Information("Barracks",
    		"This is a barracks that can make awesome pies", null,
            "buttons/marine.png");
    private static final Location3D DEFAULT_OCCUPY_RELATIVE_LOCATION = new Location3D(300, 100, 0);
    private static final Information DEFAULT_OCCUPY_INFO = 
    		new Information("Garrison", "This is a garrison that soldiers can occupy", null,
            "buttons/marine.png");
	
    private static GameMap myMap;
    private static PlayerManager myPlayers;
            
    private List<DelayedTask> myTasks;
    private FrameCounter myFrames;

    private Rectangle2D myDrag;
    private Factory myFactory;

    public GameState (Observer observer) {
        super(observer);
        myFactory = new Factory();
        myFactory.loadXMLFile("Factory.xml");
        myMap = new GameMap(new Dimension(4000, 2000), true);
        myPlayers = new PlayerManager();
        // myMap = new GameMap(8, new Dimension(512, 512));

        myFrames = new FrameCounter(new Location(100, 20));
        myTasks = new ArrayList<DelayedTask>();
        setupGame();
    }

    @Override
    public void update (double elapsedTime) {
        myMap.update(elapsedTime);
        getPlayers().update(elapsedTime);
        
        for (DelayedTask dt : myTasks) {
            dt.update(elapsedTime);
        }
        
        yuckyUnitUpdate(elapsedTime);
        myFrames.update(elapsedTime);
    }

    @Override
    public void paint (Graphics2D pen) {
        pen.setBackground(Color.BLACK);
        myMap.paint(pen);
        getPlayers().getHuman().paint(pen);

        if (myDrag != null) {
            pen.draw(myDrag);
        }
        
        Camera.instance().paint(pen);
        myFrames.paint(pen);
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
        getPlayers().addPlayer(1);
        Location3D playerOneBase = getPlayers().getHuman().getBase();
        
        Unit worker =  (Unit) myFactory.getEntitiesMap().get("worker").copy();
        worker.setWorldLocation(new Location3D(playerOneBase.getX() +
        		DEFAULT_WORKER_RELATIVE_LOCATION.getX(), playerOneBase.getY() +
        		DEFAULT_WORKER_RELATIVE_LOCATION.getY(), playerOneBase.getZ() +
        		DEFAULT_WORKER_RELATIVE_LOCATION.getZ()));
        worker.move(worker.getWorldLocation());
        worker.setInfo(DEFAULT_WORKER_INFO);
        getPlayers().getHuman().add(worker);
       
        Unit soldierOne = (Unit) myFactory.getEntitiesMap().get("combat").copy(); //TODO: refactor!
        soldierOne.setWorldLocation(new Location3D(playerOneBase.getX() +
        		DEFAULT_SOLDIER_ONE_RELATIVE_LOCATION.getX(), playerOneBase.getY() +
        		DEFAULT_SOLDIER_ONE_RELATIVE_LOCATION.getY(), playerOneBase.getZ() +
        		DEFAULT_SOLDIER_ONE_RELATIVE_LOCATION.getZ()));
        soldierOne.move(soldierOne.getWorldLocation());
        soldierOne.setInfo(DEFAULT_SOLDIER_INFO);
        getPlayers().getHuman().add(soldierOne);
        
        Building startProduction= (Building) myFactory.getEntitiesMap().get("home").copy();
        startProduction.setWorldLocation(new Location3D(playerOneBase.getX() +
        		DEFAULT_PRODUCTION_RELATIVE_LOCATION.getX(), playerOneBase.getY() +
        		DEFAULT_PRODUCTION_RELATIVE_LOCATION.getY(), playerOneBase.getZ() +
        		DEFAULT_PRODUCTION_RELATIVE_LOCATION.getZ()));
        startProduction.move(startProduction.getWorldLocation());
        startProduction.setInfo(DEFAULT_PRODUCTION_INFO);
        getPlayers().getHuman().add(startProduction);

        //this is for testing
        final Building f = startProduction;
        myTasks.add(new DelayedTask(2, new Runnable() {
            @Override
            public void run () {
                f.getAction((new Command("make Marine"))).apply();
            }
        }, true));
        
        Building startOccupy = (Building) myFactory.getEntitiesMap().get("garrison").copy();
        startOccupy.setWorldLocation(new Location3D(playerOneBase.getX() +
        		DEFAULT_OCCUPY_RELATIVE_LOCATION.getX(), playerOneBase.getY() +
        		DEFAULT_OCCUPY_RELATIVE_LOCATION.getY(), playerOneBase.getZ() +
        		DEFAULT_OCCUPY_RELATIVE_LOCATION.getZ()));
        startOccupy.move(startProduction.getWorldLocation());       
        startOccupy.setInfo(DEFAULT_OCCUPY_INFO);
        getPlayers().getHuman().add(startOccupy);

        //This is for testing
        final Building testGarrison = startOccupy;
        
        myTasks.add(new DelayedTask(10, new Runnable() {
            @Override
            public void run () {
                if (testGarrison.getOccupyStrategy().getOccupiers().size() > 0) {
                    System.out.println("will puke!");
                    testGarrison.getAction(new Command("deoccupy")).apply();
                }                
            }
        }));
        
        
        getPlayers().addPlayer(2);
        Location3D playerEnemyBase = getPlayers().getPlayer(1).getEnemyBase();
        
        Unit enemySoldierOne = (Unit) myFactory.getEntitiesMap().get("combat").copy();
        enemySoldierOne.setWorldLocation(new Location3D(playerEnemyBase.getX() +
        		DEFAULT_SOLDIER_ONE_RELATIVE_LOCATION.getX(), playerEnemyBase.getY() +
        		DEFAULT_SOLDIER_ONE_RELATIVE_LOCATION.getY(), playerEnemyBase.getZ() +
        		DEFAULT_SOLDIER_ONE_RELATIVE_LOCATION.getZ()));
        enemySoldierOne.move(enemySoldierOne.getWorldLocation());
        getPlayers().getPlayer(1).add(enemySoldierOne);
        
        Building enemyProduction= (Building) myFactory.getEntitiesMap().get("home").copy();
        enemyProduction.setWorldLocation(new Location3D(playerEnemyBase.getX() +
        		DEFAULT_PRODUCTION_RELATIVE_LOCATION.getX(), playerEnemyBase.getY() +
        		DEFAULT_PRODUCTION_RELATIVE_LOCATION.getY(), playerEnemyBase.getZ() +
        		DEFAULT_PRODUCTION_RELATIVE_LOCATION.getZ()));
        enemyProduction.move(enemyProduction.getWorldLocation());
        enemyProduction.setInfo(DEFAULT_PRODUCTION_INFO);
        getPlayers().getPlayer(1).add(enemyProduction);
        
        //this is for testing
        final Building g = enemyProduction;
        myTasks.add(new DelayedTask(2, new Runnable() {
            @Override
            public void run () {
                g.getAction((new Command("make Marine"))).apply();
            }
        }, true));
        
        
        for (int j = 0; j < 10; j++) {
            getMap().getResources().add(new Resource(new Pixmap("images/mineral.gif"),
                                                     new Location3D(600 + j * 30, 600  - j * 20, 0),
                                                     new Dimension(50, 50), 0, 200, "mineral"));
        }

        for (int j = 0; j < 4; j++) {
            for (int k = 0; k < 8; k++) {
                getMap().getTerrain().add(new Terrain(new Pixmap("images/gold.png"),
                                                      new Location3D(100 + k * 25, 100, j * 25),
                                                      new Dimension(50, 50)));
            }
            
        }
    }

    private void yuckyUnitUpdate (double elapsedTime) {

        List<InteractiveEntity> p1 = getPlayers().getTeam(1).getUnits();
        List<InteractiveEntity> p2 = getPlayers().getTeam(2).getUnits();
        
        // now even yuckier
        for (int i = 0; i < p1.size(); ++i) {
            if (p1.get(i) instanceof Unit) {
                for (int j = i + 1; j < p1.size(); ++j) {
                    ((Unit) p1.get(i)).occupy(p1.get(j));
                }
            }
        }        
    }
    
    public static PlayerManager getPlayers() {
        return myPlayers;
    }

    public static GameMap getMap () {
        return myMap;
    }

    public static void setMap (GameMap map) {
        myMap = map;
    }
}
