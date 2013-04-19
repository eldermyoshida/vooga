
package vooga.towerdefense.factories;

import java.util.ArrayList;

import vooga.towerdefense.action.Action;
import vooga.towerdefense.action.FollowPath;
import vooga.towerdefense.action.Move;
import vooga.towerdefense.attributes.Attribute;
import vooga.towerdefense.attributes.AttributeConstants;
import vooga.towerdefense.attributes.AttributeManager;
import vooga.towerdefense.gameElements.Unit;
import vooga.towerdefense.model.GameMap;
import vooga.towerdefense.model.Path;
import vooga.towerdefense.util.Location;

/**
 * @author Matthew Roy
 * @author Jimmy Longley
 *
 */
public class ExampleUnitFactory extends UnitFactory {

	private GameMap myGameMap;
    /**
     * @param elementName
     * @param definition
     */
    public ExampleUnitFactory (String elementName, GameElementDefinition definition, GameMap gameMap) {
        super(elementName, definition);
        myGameMap = gameMap;
    }
    
    public Unit createUnit(Location putHere) {
    	return createUnit(putHere, new TrollUnitDefinition());
    }
    
    public Unit createUnit(Location putHere, TrollUnitDefinition myDef){
        TrollUnitDefinition myDefinition = myDef;
        
        AttributeManager AM = new AttributeManager();
        AM.addAttribute(new Attribute(AttributeConstants.MOVE_SPEED, 150.0));
        AM.addAttribute(new Attribute(AttributeConstants.DIRECTION, 50.0));
        AM.addAttribute(new Attribute(AttributeConstants.ATTACK_INTERVAL, 50.0));
        Unit myUnit;
        if(putHere != null) {
            myUnit = new Unit(myDefinition.myImage, 
                                   putHere, 
                                   myDefinition.getSize(), AM);
        }
        else {
            myUnit = new Unit(myDefinition.getImage(), 
                              myDefinition.getCenter(), 
                              myDefinition.getSize(), AM);
        }
        
        ArrayList<Action> actions = new ArrayList<Action>();
        actions.add(new Move(myUnit));
        Path path = myGameMap.getShortestPath(putHere, myGameMap.default_end_location);
        actions.add(new FollowPath(myUnit, path));
        myUnit.addActions(actions);
        
        return myUnit;
        
    }

}

