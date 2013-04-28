package vooga.towerdefense.gameeditor.gameloader.xmlloaders;

import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Element;
import util.XMLTool;
import vooga.towerdefense.factories.attributefactories.AttributeFactory;

public class AttributeXMLLoader {
    
    private XMLTool myXMLTool;
    
    public AttributeXMLLoader(XMLTool xmlTool) {
        myXMLTool = xmlTool;
    }
    
    public List<AttributeFactory> loadAttributeFactories (Element attributesElement) {
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
