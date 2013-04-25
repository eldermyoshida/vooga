package games.scroller.arcadedemopackage;

import java.awt.Dimension;
import util.Location;
import vooga.scroller.level_editor.library.EncapsulatedSpriteLibrary;
import vooga.scroller.level_editor.library.ISpriteLibrary;
import vooga.scroller.sprites.interfaces.ICollectible;
import vooga.scroller.sprites.interfaces.IEnemy;
import vooga.scroller.sprites.movement.Movement;
import vooga.scroller.sprites.movement.TrackPlayer;
import vooga.scroller.sprites.superclasses.GameCharacter;
import vooga.scroller.util.ISpriteView;
import vooga.scroller.util.Pixmap;
import vooga.scroller.util.Sprite;

/**
 * implement types of Sprites that will be in you game in this file with the
exception of the Sprite that extends Player
 * @author Will Nance
 *
 */
public class DemoLib extends EncapsulatedSpriteLibrary{

    public DemoLib () {
        // TODO Auto-generated constructor stub
    }
    
    public static class Astroid extends GameCharacter implements IEnemy{
        private static final String DEFAULT_IMG = "astroid.jpg";
        public static final int DEFAULT_DAMAGE =1; 
        private int SPEED = 30;
        private int RADIUS = 45;
        private Movement movement = new TrackPlayer(this, getLocatable(), SPEED, RADIUS);
        
        public Astroid ( Location center , Dimension size, int health ) {
            super(makePixmap(DEFAULT_IMG),  center, size, health, DEFAULT_DAMAGE);
        }
        
        @Override
        public void handleDeath () {
            // do nothing since the example doestn do anything
        }
        public void update (double elapsedTime, Dimension bounds) {
            movement.execute();
            super.update(elapsedTime, bounds);
        }
        
    }
    
    public static class Astronaut extends GameCharacter implements ICollectible {
        private static final String DEFAULT_IMG = "astronaut.png";
        public static final int DEFAULT_DAMAGE =0; 
        private int SPEED = 30;
        private int RADIUS = 45;
        private static final Dimension DEFAULT_SIZE = new Dimension(20 , 20);
        private static final int DEFAULT_VALUE = 1;
        private static final int DEFAULT_HEALTH = 1;
        private Movement movement = new TrackPlayer(this, getLocatable(), SPEED, RADIUS);
        
        public Astronaut (Location center) {
            super(makePixmap(DEFAULT_IMG), center, DEFAULT_SIZE, DEFAULT_HEALTH, DEFAULT_DAMAGE);
        }

        @Override
        public int getValue () {
            return DEFAULT_VALUE;
        }

        @Override
        public void handleDeath () {
            //Hopefully the thing automatically dies?
        }
        
    }
 


    public static Pixmap makePixmap (String fileName) {
        return makePixmap(getImagesDirectory(), fileName);
    }

    private static String getImagesDirectory () {
        return "/games/scroller/arcadedemopackage/images/";
    }
}
