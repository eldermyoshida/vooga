
package vooga.towerdefense.factories;

import java.util.ArrayList;

import vooga.towerdefense.action.Action;
import vooga.towerdefense.attributes.AttributeManager;
import vooga.towerdefense.gameElements.Unit;
import vooga.towerdefense.util.Location;

/**
 * @author Matthew Roy
 *
 */
public abstract class UnitFactory extends GameElementFactory {

    /**
     * 
     */
    public UnitFactory () {
        // TODO Auto-generated constructor stub
    }

    /**
     * @param elementName
     * @param definition
     */
    public UnitFactory (String elementName, GameElementDefinition definition) {
        super(elementName, definition);
        // TODO Auto-generated constructor stub
    }
    
    
    public AttributeManagerFactory createAttributeFactory() {
        AttributeManagerFactory factory = new AttributeManagerFactory();
        return factory;
    }
    
    public ActionFactory createActionFactory() {
        ActionFactory actFactory = new ActionFactory();
        return actFactory;
    }
    
    public Unit createUnit(Location putHere){
        GameElementDefinition myDefinition = getDefinition();
        
        AttributeManager AM = new AttributeManager();
        Unit myUnit = new Unit(null, null, null);
        ArrayList<Action> actions = new ArrayList<Action>();
        
        return myUnit;
        
    }

}