package vooga.towerdefense.gameeditor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.w3c.dom.Element;
import vooga.towerdefense.util.XMLTool;
import vooga.scroller.level_editor.Level;
import vooga.towerdefense.model.rules.Rule;

public class LevelsXMLLoader {
    private static final String LEVELS_TAG = "Levels";
    private static final String RULES_TAG = "Rules";
    private static final String VALUE_TAG = "value";
    
    private XMLTool myXMLTool;
    
    public LevelsXMLLoader(XMLTool xmlTool, String xmlFilePath) {
        myXMLTool = xmlTool;  
        myXMLTool.setDoc(xmlFilePath);
    }
    
    public List<Level> getLevels() {
        Element levelsElement = myXMLTool.getElementFromTag(LEVELS_TAG);
        
        Map<String, Element> subElements = myXMLTool.getMapElementFromParent(levelsElement);
        
        List<Level> levels = new ArrayList<Level>();
        for (Element subElement : subElements.values()) {
            levels.add(getLevel(subElement));
        }
        return levels;
    }
    
    private Level getLevel(Element levelElement) {
        Map<String, Element> subElements = myXMLTool.getMapElementFromParent(levelElement);
        
        List<Rule> rules = getRules(subElements.get(RULES_TAG));
        
        Level level = null;
        return level;
    }
    
    private List<Rule> getRules(Element rulesElement) {
        Map<String, Element> subElements = myXMLTool.getMapElementFromParent(rulesElement);
        
        List<Rule> rules = new ArrayList<Rule>();
        for (Element subElement : subElements.values()) {
            rules.add(getRule(subElement));
        }
        
        return rules;
    }
    
    private Rule getRule(Element ruleElement) {
        Map<String, Element> subElements = myXMLTool.getMapElementFromParent(ruleElement);
        String ruleValue = getRuleValue(subElements.get(VALUE_TAG));
        
        Rule r = null;
        return r;
    }
    
    private String getRuleValue(Element valueElement) {
        return myXMLTool.getContent(valueElement);        
    }
    
}
