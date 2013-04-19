package vooga.rts.state;

import java.applet.AudioClip;
import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observer;
import vooga.rts.commands.Command;
import vooga.rts.controller.Controller;
import vooga.rts.controller.PlayerController;
import vooga.rts.gamedesign.sprite.gamesprites.Projectile;
import vooga.rts.gamedesign.sprite.gamesprites.Resource;
import vooga.rts.gamedesign.sprite.gamesprites.interactive.InteractiveEntity;
import vooga.rts.gamedesign.sprite.gamesprites.interactive.buildings.Barracks;
import vooga.rts.gamedesign.sprite.gamesprites.interactive.buildings.Building;
import vooga.rts.gamedesign.sprite.gamesprites.interactive.buildings.UpgradeBuilding;
import vooga.rts.gamedesign.sprite.gamesprites.interactive.units.Soldier;
import vooga.rts.gamedesign.sprite.gamesprites.interactive.units.Unit;
import vooga.rts.gamedesign.sprite.gamesprites.interactive.units.Worker;
import vooga.rts.gamedesign.strategy.attackstrategy.CanAttack;
import vooga.rts.gamedesign.weapon.Weapon;
import vooga.rts.map.GameMap;
import vooga.rts.player.HumanPlayer;
import vooga.rts.player.Player;
import vooga.rts.player.Team;
import vooga.rts.resourcemanager.ResourceManager;
import vooga.rts.util.Location3D;
import vooga.rts.util.Pixmap;
import vooga.rts.util.PointTester;
import vooga.rts.util.Sound;


// TODO: implement the game state with all unit managers that there needs to be. Muy importante.
// TODO: think of how decisions are going to be made with the controllers.

public class GameState extends SubState implements Controller {

    private final static int DEFAULT_NODE_SIZE = 8;
    private Map<Integer, Team> myTeams;
//    private GameMap myMap;
    private HumanPlayer myHumanPlayer;
    private List<Player> myPlayers;
//    private Resource r;
//    private Building building;
//    private UpgradeBuilding upgradeBuilding;
    private PointTester pt;
    private Robot myMouseMover;

    public GameState (Observer observer, Dimension gameSize) {
        super(observer);
        myTeams = new HashMap<Integer, Team>();
        myPlayers = new ArrayList<Player>();
//        myMap = new GameMap(8, new Dimension(512, 512));
        pt = new PointTester();
        try {
            myMouseMover = new Robot();
        }
        catch (AWTException e) {
            // Cannot move the camera
        }
        setupGame();
    }

    @Override
    public void update (double elapsedTime) {
        myHumanPlayer.update(elapsedTime);

    }

    @Override
    public void paint (Graphics2D pen) {
        for (Player p: myPlayers) {
            p.paint(pen);
        }
    }

    @Override
    public void receiveCommand (Command command) {
        sendCommand(command);
    }

    @Override
    public void sendCommand (Command command) {
        myHumanPlayer.sendCommand(command);
    }

//    private void setupGame () {
//        System.out.println("Game is starting setup");
//
//        try {
//            // Factory factory = new Factory();
//
//            // UpgradeTree resultTree = factory.loadXMLFile("XML_Sample");
//            /*
//             * upgradeBuilding = new UpgradeBuilding(new
//             * Pixmap(ResourceManager.instance
//             * ().loadFile("images/barracks.jpeg")), new Location(700,700), new
//             * Dimension(150,150), null, 1,300);
//             */
//            PlayerController p1 = new HumanPlayer();
//            Pixmap p =
//                    new Pixmap(ResourceManager.getInstance()
//                            .<BufferedImage> getFile("images/sprites/soldier.png",
//                                                     BufferedImage.class));
//            Dimension s = new Dimension(90, 90);
//            r =
//                    new Resource(new Pixmap(ResourceManager.getInstance()
//                            .<BufferedImage> getFile("images/mineral.gif", BufferedImage.class)),
//                                 new Location3D(300, 300, 0), new Dimension(60, 60), 0, 400);
//            Sound soun =
//                    new Sound(ResourceManager.getInstance().getFile("sounds/pikachu.wav",
//                                                                    AudioClip.class));
//            Unit a = null;
//            a = new Soldier(p, new Location3D(200, 250, 0), s, soun, 1, 400);
//            System.out.println("Player ID for a: " + a.getPlayerID());
//            // a.setUpgradeTree(resultTree,a.getPlayerID());
//            // upgradeBuilding.addUpgradeActions(resultTree);
//            Projectile proj =
//                    new Projectile(new Pixmap(ResourceManager.getInstance()
//                            .<BufferedImage> getFile("images/bullet.png", BufferedImage.class)),
//                                   a.getWorldLocation(), new Dimension(30, 30), 2, 10, 1);
//            a.setAttackStrategy(new CanAttack());
//            a.getAttackStrategy().addWeapons(new Weapon(0, proj, 500, a.getWorldLocation(), 175));
//            Unit b = new Soldier(p, new Location3D(300, 150, 0), s, soun, 1, 300);
//            System.out.println("Player ID for b: " + b.getPlayerID());
//
//            Projectile proj2 =
//                    new Projectile(new Pixmap(ResourceManager.getInstance()
//                            .<BufferedImage> getFile("images/bullet.png", BufferedImage.class)),
//                                   b.getWorldLocation(), new Dimension(30, 30), 1, 10, 1);
//            b.setAttackStrategy(new CanAttack());
//            b.getAttackStrategy().addWeapons(new Weapon(0, proj2, 400, b.getWorldLocation(), 200));
//
//            Unit c = new Soldier(p, new Location3D(500, 800, 0), s, soun, 2, 500);
//
//            Projectile proj3 =
//                    new Projectile(new Pixmap(ResourceManager.getInstance()
//                            .<BufferedImage> getFile("images/bullet.png", BufferedImage.class)),
//                                   c.getWorldLocation(), new Dimension(30, 30), 1, 10, 1);
//            c.setAttackStrategy(new CanAttack());
//            Unit w =
//                    new Worker(new Pixmap(ResourceManager.getInstance()
//                            .<BufferedImage> getFile("images/scv.gif", BufferedImage.class)),
//                               new Location3D(500, 200, 0), s, soun, 20, 40, 40);
//            c.getAttackStrategy().addWeapons(new Weapon(0, proj3, 450, c.getWorldLocation(), 200));
//
//            p1.getUnits().addUnit(a);
//            p1.getUnits().addUnit(b);
//            p1.getUnits().addUnit(w);
//            PlayerController p2 = new HumanPlayer();
//            p2.getUnits().addUnit(c);
//
//            addPlayer(p1, 1);
//            addPlayer(p2, 2);
//
//            building =
//                    new Barracks(new Pixmap(ResourceManager.getInstance()
//                            .<BufferedImage> getFile("images/barracks.jpeg", BufferedImage.class)),
//                                 new Location3D(800, 500, 0), new Dimension(150, 150), null, 1, 300);
//            System.out.println("Setup Game");
//            myHuman = (HumanPlayer) p1;
//
//        }
//        catch (Exception e) {
//            // trollolol
//        }

//    }
    
    public void addPlayer (int id) {
        if (myPlayers.size() == 0) {
            myHumanPlayer = new HumanPlayer(id);
            myPlayers.add(myHumanPlayer);
        }
        else {
            myPlayers.add(new Player(id));
        }
    }
    
    public void setupGame(){
        addPlayer(1);
        myHumanPlayer.add(new Soldier());
        myHumanPlayer.add(new Soldier(new Location3D(200, 200, 0)));
    }
}
