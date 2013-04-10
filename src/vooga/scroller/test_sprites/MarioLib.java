package vooga.scroller.test_sprites;

import java.awt.Dimension;
import vooga.scroller.level_editor.ISpriteLibrary;
import vooga.scroller.sprite_superclasses.NonStaticEntity;
import vooga.scroller.sprite_superclasses.StaticEntity;
import vooga.scroller.util.Location;
import vooga.scroller.util.Pixmap;
import vooga.scroller.util.Sprite;

/**
 * This class is a convenient way to gather all the classes and use reflection
 * to retrieve all classes. Not sure if this is the best way to implement this.
 * But it is definitely better than having to parse the package. -DF
 * TODO
 *
 */
public class MarioLib implements ISpriteLibrary {
    private static final Dimension DEFAULT_SIZE = new Dimension(30, 30);
    
    public class Coin extends StaticEntity {

        private static final String DEFAULT_IMG = "coin.gif";
        
        
        public Coin (Location center) {
            super(new Pixmap(DEFAULT_IMG), center, DEFAULT_SIZE);
            // TODO Auto-generated constructor stub
        }

        
        public void print() {
            System.out.println("Coin");
        }
        




    }
    
    public class Koopa extends NonStaticEntity {

        private static final String DEFAULT_IMG ="koopa.gif";

        public Koopa (Location center) {
            super(new Pixmap(DEFAULT_IMG), center, DEFAULT_SIZE);
        }

        public void print() {
            System.out.println("Koopa");
        }
        

        
    }

    public class Turtle extends NonStaticEntity {

        private static final String DEFAULT_IMG = "turtle.gif";
        
        public Turtle (Location center) {
            super(new Pixmap(DEFAULT_IMG), center, DEFAULT_SIZE);
            // TODO Auto-generated constructor stub
        }

        public void print() {
            System.out.println("Turtle");
        }

    }

    public class Platform extends StaticEntity{
        
        private static final String DEFAULT_IMG = "platform.gif";

        public Platform (Location center) {
            super(new Pixmap(DEFAULT_IMG), center, DEFAULT_SIZE);
            // TODO Auto-generated constructor stub
        }
    
        public void print() {
            System.out.println("Platform");
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public Class<? extends Sprite>[] getSpritesClasses() {
        return (Class<? extends Sprite>[]) this.getClass().getClasses();
    }   
}
