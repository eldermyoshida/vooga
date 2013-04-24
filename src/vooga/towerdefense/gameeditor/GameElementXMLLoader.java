package vooga.towerdefense.gameeditor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.w3c.dom.Element;
import util.XMLTool;
import vooga.towerdefense.attributes.Attribute;
import vooga.towerdefense.attributes.AttributeManager;
import vooga.towerdefense.factories.GameElementFactory;
import vooga.towerdefense.gameElements.GameElement;
import vooga.towerdefense.model.GameMap;
import vooga.towerdefense.util.Location;
import vooga.towerdefense.util.Pixmap;

public class GameElementXMLLoader {
    private static final String GAME_ELEMENTS_TAG = "GameElements";
    private static final String ATTRIBUTES_TAG = "Attributes";
    private static final String TYPE_TAG = "type";
    private static final String IMAGE_TAG = "image";
    private static final String VALUE_TAG = "value";
    
    
    private XMLTool myXMLTool;
    private GameMap myGameMap;    
    
    public GameElementXMLLoader(GameMap gameMap, XMLTool xmlTool, String xmlFilePath) {
        myXMLTool = xmlTool;
        myGameMap = gameMap;
        myXMLTool.setDoc(xmlFilePath);
    }
    
    public List<GameElement> loadGameElements() {
        Element gameElementsElement = myXMLTool.getElementFromTag(GAME_ELEMENTS_TAG);        
        Map<String, Element> subElements = myXMLTool.getMapElementFromParent(gameElementsElement);
        
        List<GameElement> gameElements = new ArrayList<GameElement>();
        for (Element subElement : subElements.values()) {
            gameElements.add(loadGameElement(subElement));
        }
        return gameElements;
    }
    
    public GameElement loadGameElement(Element gameElement) {
        Map<String, Element> subElements = myXMLTool.getMapElementFromParent(gameElement);
        
        String gameElementName = myXMLTool.getTagName(gameElement);
        Pixmap elementImage = loadElementImage(subElements.get(IMAGE_TAG));
        Location elementLocation = null;
        String elementType = loadGameElementType(subElements.get(TYPE_TAG));
        List<Attribute> attributes = loadAttributes(subElements.get(ATTRIBUTES_TAG));        
        
        AttributeManager am = new AttributeManager();
        am.addAttributes(attributes);
        
        GameElementFactory geFactory = new GameElementFactory(gameElementName,
                                                              elementImage,
                                                              elementLocation,
                                                              elementType,
                                                              am);
        geFactory.initialize(myGameMap);
        return geFactory.createElement();
    }     
    
    private Pixmap loadElementImage(Element imageElement) {
        String imagePath = myXMLTool.getContent(imageElement);        
        return new Pixmap(imagePath);
    }
    
    private String loadGameElementType(Element typeElement) {
        return myXMLTool.getContent(typeElement);
    }
    
    private List<Attribute> loadAttributes(Element attributesElement) {
        List<Attribute> attributes = new ArrayList<Attribute>();
        Map<String, Element> subElements = myXMLTool.getMapElementFromParent(attributesElement);
        for (String attributeName : subElements.keySet()) {
            Attribute attribute = loadAttribute(subElements.get(attributeName));
            attributes.add(attribute);
        }
        return attributes;
    }
    
    private Attribute loadAttribute(Element attributeElement) {
        Map<String, Element> subElements = myXMLTool.getMapElementFromParent(attributeElement);
        return new Attribute(myXMLTool.getTagName(attributeElement), loadAttributeValue(subElements.get(VALUE_TAG)));
    }
    
    private double loadAttributeValue(Element valueElement) {
        return Double.parseDouble(myXMLTool.getContent(valueElement));
    }
}
