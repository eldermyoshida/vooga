package vooga.towerdefense.factories;

import java.util.List;

import vooga.towerdefense.attributes.Attribute;
import vooga.towerdefense.attributes.AttributeManager;

/**
 * Basic attribute factory that creates and populates new attribute for specific elements
 * @author Matthew Roy
 *
 */
public class AttributeManagerFactory {
    
	private List<Attribute> inputAttributes;
	
    public AttributeManagerFactory(List<Attribute> gameElementAttributes) {
        inputAttributes = gameElementAttributes;
    }
    
    public AttributeManagerFactory(String elementName) {
        
    }
    
    public AttributeManager makeAttributeManager() {
        AttributeManager manager = new AttributeManager();
        manager.addAttributes(inputAttributes);
        return manager;
    }

}
