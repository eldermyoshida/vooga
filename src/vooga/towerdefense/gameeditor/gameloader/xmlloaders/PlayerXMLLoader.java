package vooga.towerdefense.gameeditor.gameloader.xmlloaders;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.w3c.dom.Element;
import util.XMLTool;
import vooga.towerdefense.attributes.AttributeManager;
import vooga.towerdefense.controller.Controller;
import vooga.towerdefense.factories.attributefactories.AttributeFactory;
import vooga.towerdefense.factories.attributefactories.AttributeManagerFactory;
import vooga.towerdefense.model.Player;

/**
 * This class is responsible for loading the Player
 * object from an XML file.
 */
public class PlayerXMLLoader {
    
    private static final String PLAYER_TAG = "player";
    private static final String ATTRIBUTES_TAG = "attributes";
    
    private XMLTool myXMLTool;
    
    public PlayerXMLLoader(XMLTool xmlTool) {
        myXMLTool = xmlTool;
    }
    
    public Player loadPlayer(Controller controller) {
        Element playerElement = myXMLTool.getElement(PLAYER_TAG);
        Element attributeParent = myXMLTool.getElement(ATTRIBUTES_TAG);
        Map<String, Element> attributes = myXMLTool.getChildrenElementMap(attributeParent);
        List<AttributeFactory> attributeFactories = 
                loadAttributeFactories(attributeParent);        
        AttributeManagerFactory attributeManagerFactory = new AttributeManagerFactory(attributeFactories);
        AttributeManager attributeManager = attributeManagerFactory.makeAttributeManager();
        return new Player(controller, attributeManager);
        
    }
    
    private List<AttributeFactory> loadAttributeFactories (Element attributesElement) {
        List<AttributeFactory> attributes = new ArrayList<AttributeFactory>();
        
        List<Element> subElements = myXMLTool.getChildrenList(attributesElement);
        for (Element subElement : subElements) {
            AttributeFactory attribute = loadAttributeFactory(subElement);
            attributes.add(attribute);
        }
        return attributes;
    }
    
    private AttributeFactory loadAttributeFactory (Element attributeElement) {
        return new AttributeFactory(myXMLTool.getTagName(attributeElement),
                                    loadAttributeValue(attributeElement));
    }
    
    private double loadAttributeValue (Element valueElement) {
        return Double.parseDouble(myXMLTool.getContent(valueElement));
    }

}
