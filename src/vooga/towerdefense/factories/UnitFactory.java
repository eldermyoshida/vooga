package vooga.towerdefense.factories;

import vooga.towerdefense.gameElements.GameElement;

/**
 * @author Matthew Roy
 *
 */
public class UnitFactory extends GameElementFactory {

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
    
    
    public AttributeFactory createAttributeFactory() {
        AttributeFactory factory = new AttributeFactory();
        return factory;
    }
    
    public ActionFactory createActionFactory() {
        ActionFactory actFactory = new ActionFactory();
        return actFactory;
    }
    
    public GameElement createGameElement(){
        GameElementDefinition myDefinition = getDefinition();
        GameElement myElement = new GameElement(myDefinition.getImage(), 
                                myDefinition.getCenter(), 
                                myDefinition.getSize(), 
                                createAttributeFactory().makeAttributes(), 
                                createActionFactory().createActions());
        return myElement;
        
    }

}
