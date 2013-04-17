package vooga.towerdefense.factories;

import vooga.towerdefense.gameElements.GameElement;

/**
 * A factory that creates game elements based on preset data
 * Reads from an xmlfile (eventually)
 * @author Matthew Roy
 * @author Xu Rui
 *
 */
public class GameElementFactory {
    /**
     * Name of the element that is defined in this class. For convenience.
     */
    private String myName;
    private GameElementDefinition myDefinition; 
    //private AttributeFactory myFactory;
    
    public GameElementFactory() {
    // TowerFactory myTowerFactory = new TowerFactory(TowerDefinition);
     //Tower tower1 = myTowerFactory.make(Location);
    }
    
    public GameElementFactory(String elementName, GameElementDefinition definition) {
        myName = elementName;
        myDefinition = definition;
    }
    
    public GameElementDefinition getDefinition() {
        return myDefinition;
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
		return new GameElement(myDefinition.getImage(), 
				myDefinition.getCenter(), 
				myDefinition.getSize(), 
				createAttributeFactory().makeAttributes(), 
				createActionFactory().createActions());
    	
    }

}
