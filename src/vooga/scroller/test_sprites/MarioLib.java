package vooga.scroller.test_sprites;

import java.awt.Dimension;
import vooga.scroller.sprite_superclasses.NonStaticEntity;
import vooga.scroller.sprite_superclasses.StaticEntity;
import vooga.scroller.util.Location;
import vooga.scroller.util.Pixmap;

/**
 * This class is a convenient way to gather all the classes and use reflection
 * to retrieve all classes. Not sure if this is the best way to implement this.
 * But it is definitely better than having to parse the package. -DF
 * TODO
 *
 */
public class MarioLib {
    
    public class Coin extends StaticEntity {

        

        
        public Coin (Pixmap image, Location center, Dimension size) {
            super(image, center, size);
            // TODO Auto-generated constructor stub
        }

        
        public void print() {
            System.out.println("Coin");
        }
        




    }
    
    public class Koopa extends NonStaticEntity {


        public Koopa (Pixmap image, Location center, Dimension size) {
            super(image, center, size);
        }

        public void print() {
            System.out.println("Koopa");
        }
        

        
    }

    public class Turtle extends NonStaticEntity {

        
        public Turtle (Pixmap image, Location center, Dimension size) {
            super(image, center, size);
            // TODO Auto-generated constructor stub
        }

        public void print() {
            System.out.println("Turtle");
        }

    }

    public class Platform extends StaticEntity{

        public Platform (Pixmap image, Location center, Dimension size) {
            super(image, center, size);
            // TODO Auto-generated constructor stub
        }
    
        public void print() {
            System.out.println("Platform");
        }
    }   
}
