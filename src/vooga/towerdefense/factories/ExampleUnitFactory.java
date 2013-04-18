
package vooga.towerdefense.factories;

import java.util.ArrayList;
import vooga.towerdefense.action.Action;
import vooga.towerdefense.action.Move;
import vooga.towerdefense.attributes.Attribute;
import vooga.towerdefense.attributes.AttributeConstants;
import vooga.towerdefense.attributes.AttributeManager;
import vooga.towerdefense.gameElements.Unit;
import vooga.towerdefense.util.Location;

/**
 * @author Matthew Roy
 *
 */
public class ExampleUnitFactory extends UnitFactory {

    /**
     * 
     */
    public ExampleUnitFactory () {
        // TODO Auto-generated constructor stub
    }

    /**
     * @param elementName
     * @param definition
     */
    public ExampleUnitFactory (String elementName, GameElementDefinition definition) {
        super(elementName, definition);
        // TODO Auto-generated constructor stub
    }
    
    public Unit createUnit(Location putHere, TrollUnitDefinition myDef){
        TrollUnitDefinition myDefinition = myDef;
        
        AttributeManager AM = new AttributeManager();
        AM.addAttribute(new Attribute(AttributeConstants.MOVE_SPEED, 50.0));
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
        actions.add(new Move(myUnit, AM.getAttribute(AttributeConstants.MOVE_SPEED), AM.getAttribute(AttributeConstants.DIRECTION)));
        myUnit.addActions(actions);
        
        return myUnit;
        
    }

}

