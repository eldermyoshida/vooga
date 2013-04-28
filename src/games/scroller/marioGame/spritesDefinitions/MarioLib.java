package games.scroller.marioGame.spritesDefinitions;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import util.Location;
import vooga.scroller.level_editor.library.EncapsulatedSpriteLibrary;
import vooga.scroller.level_management.LevelPortal;
import vooga.scroller.sprites.Sprite;
import vooga.scroller.sprites.animation.Animation;
import vooga.scroller.sprites.animation.MovingSpriteAnimationFactory;
import vooga.scroller.sprites.interfaces.ICollectible;
import vooga.scroller.sprites.interfaces.IEnemy;
import vooga.scroller.sprites.interfaces.IPlatform;
import vooga.scroller.sprites.interfaces.Locatable;
import vooga.scroller.sprites.movement.BackAndForth;
import vooga.scroller.sprites.movement.Movement;
import vooga.scroller.sprites.movement.TrackPlayer;
import vooga.scroller.sprites.superclasses.GameCharacter;
import vooga.scroller.sprites.superclasses.Player;
import vooga.scroller.util.ISpriteView;
import vooga.scroller.util.Pixmap;
import util.Vector;


/**
 * This class is a convenient way to gather all the classes and use reflection
 * to retrieve all classes. Not sure if this is the best way to implement this.
 * But it is definitely better than having to parse the package. -DF
 * The Classes are static to allow instantiation w/o an instance of MarioLib.
 * TODO - Decide Whether to keep this implementation or switch to ENUM
 * Moreover, it is an example of the sprite-specification file the game designer
 * will need to provide.
 */
public class MarioLib extends EncapsulatedSpriteLibrary {
    private static final Dimension DEFAULT_SIZE = new Dimension(32, 32);
    private static final Location DEFAULT_LOC = new Location(32, 32);
    private static final int DEFAULT_HEALTH = 1;
    private static final int DEFAULT_DAMAGE = 0;

    public static class Coin extends GameCharacter implements ICollectible {

        private static final String DEFAULT_IMG = "coin.png";
        private static final int DEFAULT_COIN_VALUE = 900;

        public Coin () {
            this(DEFAULT_LOC);
        }

        public Coin (Location center) {
            super(makePixmap(DEFAULT_IMG), center, DEFAULT_SIZE, DEFAULT_HEALTH, DEFAULT_DAMAGE);
        }

        @Override
        public int getValue () {
            return DEFAULT_COIN_VALUE;
        }

        @Override
        public void handleDeath () {
            // killing this does not do anything           
        }

    }

    public static class Koopa extends GameCharacter implements IEnemy {
        private static final String DEFAULT_IMG = "koopa.png";
        private static final Dimension KOOPA_SIZE = new Dimension(32, 64);
        private int SPEED = 30;
        private int RADIUS = 45;
        private TrackPlayer movement = new TrackPlayer(this, getLocatable(), SPEED, RADIUS);

        public Koopa () {
            this(DEFAULT_LOC);
        }

        public Koopa (Location center) {
            super(makePixmap(DEFAULT_IMG), center, KOOPA_SIZE, new Integer(1), new Integer(1));
        }

        public void update (double elapsedTime, Dimension bounds) {
            movement.execute();
            super.update(elapsedTime, bounds);
        }

        @Override
        public void handleDeath () {
            // TODO Auto-generated method stub   
        }
        
        
        // TODO :This is hacky
        @Override
        public void addTarget(Locatable target){
            movement.setTarget(target);
        }

    }

    public static class Turtle extends GameCharacter implements IEnemy {

        private static final String DEFAULT_IMG = "turtle.gif";
        private int SPEED = 30;
        private int RADIUS = 45;
        private Movement movement = new TrackPlayer(this, getLocatable(), SPEED, RADIUS);


        public Turtle () {
            this(DEFAULT_LOC);
        }

        public Turtle (Location center) {
            super(makePixmap(DEFAULT_IMG), center, DEFAULT_SIZE, new Integer(1), new Integer(2));
        }

        public void update (double elapsedTime, Dimension bounds) {
            movement.execute();
            super.update(elapsedTime, bounds);
        }

        @Override
        public void handleDeath () {
            // TODO Auto-generated method stub   
        }
    }

    public static class Platform extends Sprite implements IPlatform {

        private static final String DEFAULT_IMG = "block.png";

        public Platform () {
            this(DEFAULT_LOC);
        }

        public Platform (Location center) {
            this(DEFAULT_IMG, center, DEFAULT_SIZE);
        }

        public Platform (String img, Location center, Dimension size) {
            super(makePixmap(img), center, size);
        }
    }

    public static class Plant extends GameCharacter implements IEnemy {
        private static final String DEFAULT_IMG = "plant.png";

        public Plant () {
            this(DEFAULT_LOC);
        }

        public Plant (Location center) {
            super(makePixmap(DEFAULT_IMG), center, new Dimension(32, 32), DEFAULT_HEALTH,
                  new Integer(2));
        }

        @Override
        public void handleDeath () {
            // TODO Auto-generated method stub
            
        }

    }

    public static class MovingPlatformOne extends Sprite implements IPlatform {

        private static final String DEFAULT_IMG = "platform.gif";
        private static final int DEFAULT_SPEED = 100;
        private static final Vector DEFAULT_VELOCITY = new Vector(Sprite.DOWN_DIRECTION,
                                                                  DEFAULT_SPEED);
        private int SPEED = 30;
        private Point2D START = new Point2D.Double(500.0, 100.0);
        private Point2D END = new Point2D.Double(200.0, 500.0);

        private Movement movement = new BackAndForth(this, START, END, SPEED);

        public MovingPlatformOne () {
            this(DEFAULT_LOC);
        }

        public MovingPlatformOne (Location center) {
            super(makePixmap(DEFAULT_IMG), center, new Dimension(96, 32));
        }

        public void update (double elapsedTime, Dimension bounds) {
            movement.execute();
            super.update(elapsedTime, bounds);
        }

    }


    public static class LevelTwoBlockOne extends Platform implements IPlatform {

        private static final String DEFAULT_IMG = "leveltwoblock1.png";
        private static final Dimension DEFAULT_SIZE = new Dimension(128, 96);

        public LevelTwoBlockOne () {
            this(DEFAULT_LOC);
        }

        public LevelTwoBlockOne (Location center) {
            super(DEFAULT_IMG, center, DEFAULT_SIZE);
        }

        public void print () {
        }
    }

    public static class LevelTwoBlockTwo extends Platform implements IPlatform {

        private static final String DEFAULT_IMG = "leveltwoblock2.png";
        private static final Dimension DEFAULT_SIZE = new Dimension(96, 32);

        public LevelTwoBlockTwo () {
            this(DEFAULT_LOC);
        }

        public LevelTwoBlockTwo (Location center) {
            super(DEFAULT_IMG, center, DEFAULT_SIZE);
        }

        public void print () {
        }
    }

    public static class LevelTwoBlockThree extends Platform implements IPlatform {

        private static final String DEFAULT_IMG = "leveltwoblock3.png";
        private static final Dimension DEFAULT_SIZE = new Dimension(768, 192);

        public LevelTwoBlockThree () {
            this(DEFAULT_LOC);
        }

        public LevelTwoBlockThree (Location center) {
            super(DEFAULT_IMG, center, DEFAULT_SIZE);
        }

        public void print () {
        }
    }
    
    public static class ItemBlock extends Sprite implements IPlatform {

        private static final String BLOCK_IMG = "itemBlock.gif";
        
        public ItemBlock () {
            super(makePixmap(BLOCK_IMG), DEFAULT_LOC, DEFAULT_SIZE);
        }
        
    }

    public static class DoorPortal extends LevelPortal {

        private static final String PORTAL_IMG = "door.png";
        private static final Dimension PORTAL_SIZE = new Dimension(32, 64);

        @Override
        public ISpriteView initView () {
            return makePixmap(PORTAL_IMG);
        }

        @Override
        public Dimension initSize () {
            return PORTAL_SIZE;
        }
    }
    
    public static class StarPortal extends LevelPortal {

        private static final String PORTAL_IMG = "star.png";
        private static final Dimension PORTAL_SIZE = new Dimension(32, 32);

        @Override
        public ISpriteView initView () {
            return makePixmap(PORTAL_IMG);
        }

        @Override
        public Dimension initSize () {
            return PORTAL_SIZE;
        }
    }

    /**
     * TODO - how to enforce implementation of this?
     * 
     * @return
     */
    public static String getImagesDirectory () {
        return "/vooga/scroller/marioGame/images/";
    }

    public static Pixmap makePixmap (String fileName) {
        return makePixmap(getImagesDirectory(), fileName);
    }

    public static void addLeftRightAnimationToPlayer (Player player, String baseFileName) {
        MovingSpriteAnimationFactory msaf =
                new MovingSpriteAnimationFactory(getImagesDirectory(), baseFileName);
        Animation<Sprite> playerAnimation = msaf.generateAnimation(player);
        player.setView(playerAnimation);
    }

}
