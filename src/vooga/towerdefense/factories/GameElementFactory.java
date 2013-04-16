package vooga.towerdefense.factories;

/**
 * A factory that creates game elements based on preset data
 * Reads from an xmlfile (eventually)
 * @author Matthew Roy
 *
 */
public class GameElementFactory {
    /**
     * Name of the element that is defined in this class. For convenience.
     */
    private String myName;
    private GameElementDefinition myDefinition;
    
    private AttributeFactory myFactory;
    
    public GameElementFactory() {
        
    }
    
    public GameElementFactory(String elementName, GameElementDefinition definition) {
        myName = elementName;
        myDefinition = definition;
    }
    
    /**
     * Adds an attribute to this element's factory
     */
    public void addAttribute() {
        
    }
    
    
    public AttributeFactory createAttributeFactory() {
        AttributeFactory factory = new AttributeFactory();
        
        return factory;
    }
    
    public ActionFactory createActionFactory() {
        ActionFactory actFactory = new ActionFactory();
        
        return actFactory;
    }

}
