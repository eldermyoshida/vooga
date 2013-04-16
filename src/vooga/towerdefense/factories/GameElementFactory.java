package vooga.towerdefense.factories;

/**
 * A factory that creates game elements based on preset data
 * Reads from an xmlfile (eventually)
 * @author Matthew Roy
 *
 */
public class GameElementFactory {
    
    
    
    public GameElementFactory() {
        
    }
    
    
    public AttributeFactory createAttributeFactory() {
        AttributeFactory factory = new AttributeFactory();
        return factory;
    }

}
