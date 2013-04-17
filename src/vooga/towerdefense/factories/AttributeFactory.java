package vooga.towerdefense.factories;

import vooga.towerdefense.attributes.AttributeManager;

/**
 * Basic attribute factory that creates and populates new attribute for specific elements
 * @author Matthew Roy
 *
 */
public class AttributeFactory {
    
    public AttributeFactory() {
        
    }
    
    public AttributeFactory(String elementName) {
        
    }
    
    
    public AttributeManager makeAttributes() {
        AttributeManager manager = new AttributeManager();
        return manager;
    }

}
