
package vooga.scroller.test_sprites;

import java.awt.Dimension;
import java.util.List;

import vooga.scroller.sprites.state.State;
import vooga.scroller.sprites.superclasses.Player;
import vooga.scroller.util.Location;
import vooga.scroller.util.Pixmap;
import vooga.scroller.view.View;

public class Mario extends Player {

    List<State> myStates;    
    State currentState; 
    View myView;
    private Location myOriginalCenter;
    private Dimension mySize;
    private Pixmap myImage;
    
    

    public Mario (Pixmap image, Location center, Dimension size, View view) {
        super(image, center, size, view);
        myView = view;
        myOriginalCenter = center;
        mySize = size;
        myImage = image;
        // TODO Auto-generated constructor stub
    }

    public void print() {
        System.out.println("Mario");
    }


    public void changeState(State newState) {
        currentState = newState;
    }
    
}



