package vooga.scroller.test_sprites;

import java.awt.Dimension;
import java.util.List;
import collision_handlers.Mario_CH;
import design_patterns.State;
import sprite_superclasses.Player;
import util.Location;
import util.Pixmap;
import view.View;

public class Mario extends Player {

    private Mario_CH collisionHandler;
    List<State> myStates;    
    State currentState; 
    View myView;
    private Location myOriginalCenter;
    private Dimension mySize;
    private Pixmap myImage;
    
    
    
    public Mario_CH getCollisionHandler () {
        return collisionHandler;
    }

    public void setCollisionHandler (Mario_CH collisionHandler) {
        this.collisionHandler = collisionHandler;
    }
    
    public Mario (Pixmap image, Location center, Dimension size, View view) {
        super(image, center, size, view);
        myView = view;
        myOriginalCenter = center;
        mySize = size;
        myImage = image;
        collisionHandler = new Mario_CH(view);
        // TODO Auto-generated constructor stub
    }

    public void print() {
        System.out.println("Mario");
    }
    
    @Override
    public Type getType() {
        return Type.MARIO;
    }
    

   
    
    
    public void update(double elapsedTime, Dimension bounds) {
//        Commented out for scrolling testing
//        currentState.update();
        // move based on input
//      ONLY FOR TESTING
        int key = myView.getLastKeyPressed();
        if (key == MOVE_LEFT)
        {
            translate(LEFT_VELOCITY);
        }
        if (key == MOVE_RIGHT)
        {
            translate(RIGHT_VELOCITY);
        }
        if (key == MOVE_UP)
        {
            translate(UP_VELOCITY);
        }
        if (key == MOVE_DOWN)
        {
            translate(DOWN_VELOCITY);
        }
//        ONLY FOR TESTING
    }
   
    public void changeState(State newState) {
        currentState = newState;
    }
}



