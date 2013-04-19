package vooga.towerdefense.gameElements;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import vooga.towerdefense.action.Action;
import vooga.towerdefense.attributes.AttributeConstants;
import vooga.towerdefense.attributes.AttributeManager;
import vooga.towerdefense.model.Path;
import vooga.towerdefense.util.Location;
import vooga.towerdefense.util.Pixmap;
import vooga.towerdefense.util.Vector;

/**
 * 
 * unit e.g. an enemy. It will have a state manager to display different animations under different
 * situations/ **but for testing purpose now, it's not added yet!**
 * 
 * also, needs to have a move action in its actions in order to move according to path;
 * 
 * @author Matthew Roy
 * @author Zhen Gou
 *
 */
public class Unit extends GameElement {
	private static final double DISTANCE_OFFSET = 5;
	private static final AttributeConstants ATTRIBUTE_CONSTANTS = new AttributeConstants();
	private Path myPath;
	private Location myCurrentPathNode;
    /**
     * @param image
     * @param center
     * @param size
     * @param attributes
     * @param actions
     */
    public Unit (Pixmap image,
                 Location center,
                 Dimension size,
                 AttributeManager attributes,
                 List<Action> actions, Path path) {
        super(image, center, size, attributes, actions);
        myPath=path;
    }

    /**
     * @param image
     * @param center
     * @param size
     * @param actions
     */
    public Unit (Pixmap image, Location center, Dimension size, List<Action> actions) {
        super(image, center, size, actions);
    }
    
    /**
     * @param image
     * @param center
     * @param size
     * @param am
     */
    public Unit (Pixmap image, Location center, Dimension size, AttributeManager am) {
        super(image, center, size, am);
    }
    
    /**
     * @param image
     * @param center
     * @param size
     */
    public Unit (Pixmap image, Location center, Dimension size) {
        super(image, center, size);
    }
    
    @Override
    public void update(double elapsedTime){
    	updateDirection(elapsedTime);
    	executeActions(elapsedTime);
    	
    }

	private void executeActions(double elapsedTime) {
		for (Action act: getActions()){
    		act.executeAction(elapsedTime);
    	}
	}
    
/**
 * decides whether the unit has reached current Node, so to decide whether to change direction
 * @param elapsedTime
 */
	private void updateDirection(double elapsedTime) {
		//TODO:remove this temporary code
		if(myCurrentPathNode == null) {
			//path is not being initialized
	        List<Location> locations = new ArrayList<Location>();
	        locations.add(new Location(500,250));
	        locations.add(new Location(50, 50));
	        locations.add(new Location(100, 0));
	        locations.add(new Location(0, 100));
	        locations.add(new Location(300, 450));
	        myPath = new Path(locations);
			
			changeNode();
		}
		////
		else if (getCenter().distance(myCurrentPathNode)<DISTANCE_OFFSET){
			changeNode();
		}	
	}
/**
 * movement logic, if path has next, change movement direction towards next node, 
 * if not, stop moving
 */
	private void changeNode() {
		if (myPath.hasNext()){
			myCurrentPathNode=myPath.next();
			System.out.println("myCurrentPathNode: " + myCurrentPathNode);
			System.out.println("my position: " + getCenter());
			Vector newDirection= getCenter().difference(myCurrentPathNode);
			//for some reason, this method gives the wrong sign on the angle
			newDirection = new Vector(-1*newDirection.getDirection(), newDirection.getMagnitude());
			System.out.println("set new direction to " + newDirection);
			getAttributeManager().getAttribute(ATTRIBUTE_CONSTANTS.DIRECTION).setValue(newDirection.getDirection());
		}
		
		else{
			getAttributeManager().getAttribute(ATTRIBUTE_CONSTANTS.MOVE_SPEED).setValue(0);
		}
		
	}
		
	

}
