package vooga.scroller.marioGame.spritesDefinitions.movements;

import util.Vector;
import vooga.scroller.sprites.movement.Movement;
import vooga.scroller.sprites.movement.MovementHelper;
import vooga.scroller.sprites.superclasses.NonStaticEntity;


public class MovementTest extends Movement {

    private NonStaticEntity myEntity;
    private MovementHelper helper;
    
    public MovementTest (NonStaticEntity nse) {
        super();
        myEntity = nse;
        helper = new MovementHelper(myEntity);
    }


    //NOTE: you can have execute take whatever parameters necessary to calculate the Vector to return
    public Vector execute () {
        return null; //fill out how you want this movement type to move your sprite 
    }

}
