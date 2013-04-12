
package vooga.scroller.sprites.test_sprites.mario;

import java.awt.Dimension;
import java.util.List;
import vooga.scroller.sprites.state.State;
import vooga.scroller.sprites.state.StateManager;
import vooga.scroller.sprites.superclasses.NonStaticEntity;
import vooga.scroller.sprites.superclasses.Player;
import vooga.scroller.sprites.superclasses.StaticEntity;
import vooga.scroller.util.Location;
import vooga.scroller.util.Pixmap;
import vooga.scroller.view.View;

public class Mario extends Player {

    //private StateManager myStateManager;
    
    View myView;
    //private Location myOriginalCenter;
    //private Dimension mySize;
    //private Pixmap myImage;
    
    

    public Mario (Pixmap image, Location center, Dimension size, View view) {
        super(image, center, size, view);
        myView = view;
        //myOriginalCenter = center;
        //mySize = size;
        //myImage = image;
        // TODO Auto-generated constructor stub
    }

    public void print() {
        System.out.println("Mario");
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
    
    
    public class Turtle extends NonStaticEntity {

        
        public Turtle (Pixmap image, Location center, Dimension size) {
            super(image, center, size);
            // TODO Auto-generated constructor stub
        }

        public void print() {
            System.out.println("Turtle");
        }

    }
}



