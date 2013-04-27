package vooga.towerdefense.gameeditor.gameloader;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.w3c.dom.Element;
import util.XMLTool;
import vooga.towerdefense.factories.actionfactories.ActionFactory;
import vooga.towerdefense.factories.attributefactories.AttributeFactory;
import vooga.towerdefense.factories.attributefactories.AttributeManagerFactory;
import vooga.towerdefense.factories.elementfactories.GameElementFactory;
import vooga.towerdefense.model.GameMap;
import util.Pixmap;


public class GameElementXMLLoader {
    private static final String GAME_ELEMENTS_TAG = "gameelements";
    private static final String ATTRIBUTES_TAG = "attributes";
    private static final String IMAGE_TAG = "image";
    private static final String TYPE_TAG = "type";
    private static final String DIMENSION_TAG = "dimension";
    private static final String ACTIONS_TAG = "actions";
    
    private XMLTool myXMLTool;
    
    public GameElementXMLLoader(XMLTool xmlTool) {
        myXMLTool = xmlTool;
    }
    
    public Map<String, GameElementFactory> loadGameElementFactories (GameMap map) {
        //TODO: This needs to be passed in as a parameter
        Element gameElementsElement = myXMLTool.getElement(GAME_ELEMENTS_TAG);        
        List<Element> subElements = myXMLTool.getChildrenList(gameElementsElement);
        
        Map<String, GameElementFactory> gameElementFactories = new HashMap<String, GameElementFactory>();
        for (Element subElement : subElements) {
            gameElementFactories.put(myXMLTool.getTagName(subElement), loadGameElementFactory(subElement, map));
        }
        return gameElementFactories;
    }
    
    public GameElementFactory loadGameElementFactory (Element gameElement, GameMap map) {
        Map<String, Element> subElementMap = myXMLTool.getChildrenElementMap(gameElement);
        
        String gameElementName = myXMLTool.getTagName(gameElement);
        String gameElementType = loadType(myXMLTool.getElement(TYPE_TAG));
        Pixmap elementImage = loadElementImage(subElementMap.get(IMAGE_TAG));
        Dimension elementDimension = loadDimension(subElementMap.get(DIMENSION_TAG));
        List<AttributeFactory> attributeFactories = 
                loadAttributeFactories(subElementMap.get(ATTRIBUTES_TAG));
        
        ActionXMLLoader loader = new ActionXMLLoader(myXMLTool);
        List<ActionFactory> actionFactories = loader.loadActionFactories(subElementMap.get(ACTIONS_TAG), map);
        
        AttributeManagerFactory managerFactory = new AttributeManagerFactory(attributeFactories);
        
        GameElementFactory geFactory = new GameElementFactory(gameElementName,
                                                              gameElementType,
                                                              elementImage,
                                                              elementDimension,
                                                              managerFactory,
                                                              actionFactories);
        geFactory.initialize(map);
        return geFactory;
    }
    
    private Pixmap loadElementImage (Element imageElement) {
        String imagePath = myXMLTool.getContent(imageElement);
        //TODO: Wtf is this?
        return new Pixmap("/vooga/towerdefense" + imagePath);
    }
    
    private String loadType (Element typeElement) {
        return myXMLTool.getContent(typeElement);
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
    
    private Dimension loadDimension(Element dimensionElement) {
        String dimensionString = myXMLTool.getContent(dimensionElement);
        String[] dimensionStringArray = dimensionString.split(",\\s+");
        return new Dimension(Integer.parseInt(dimensionStringArray[0]), 
                             Integer.parseInt(dimensionStringArray[1]));
    }
}
