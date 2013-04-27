package vooga.towerdefense.action.actionlist;

import vooga.towerdefense.action.Action;
import vooga.towerdefense.attributes.Attribute;
import util.Location;
import util.Vector;

/**
 * Uses the sprite move method
 * 
 * @author Matthew Roy
 * @author Jimmy Longley
 * @author Xu Rui
 * @author Zhen Gou
 *
 */
public class Move extends Action {
    private Location myCenter;
    private Attribute mySpeed;
    private Attribute myDirection;

    public Move (Location location, Attribute movespeed, Attribute direction) {
    	mySpeed = movespeed;
    	myCenter = location;
    	myDirection = direction;
    }
    
    @Override
    public void executeAction(double elapsedTime) {
//        System.out.println(myDirection.getValue());
//        System.out.println(mySpeed.getValue());
//        Vector v = new Vector(myDirection.getValue(), mySpeed.getValue());
        Vector v = new Vector(0, 20);
        v.scale(elapsedTime / 1000);
        myCenter.translate(v);
    }


}
