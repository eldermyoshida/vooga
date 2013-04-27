package vooga.towerdefense.gameeditor.gamemaker.xmlwriters;

import org.w3c.dom.Element;
import util.XMLTool;
import vooga.towerdefense.gameeditor.gamemaker.XMLWriter;

/**
 * LevelXMLWriter writes the levels of the game
 *      to the specified XML doc in the correct format.
 *
 * @author Angelica Schwartz
 */
public class LevelXMLWriter {
    
    private XMLTool myXMLTool;
    private RuleXMLWriter myRuleParser;
    private ActionXMLWriter myActionParser;
    
    public LevelXMLWriter(XMLTool xmlTool) {
        myXMLTool = xmlTool;
        myRuleParser = new RuleXMLWriter(myXMLTool);
        myActionParser = new ActionXMLWriter(myXMLTool);
    }
    
    /**
     * writes a level to the XML file.
     * @param parent
     * @param name
     * @param rules
     * @param actions
     */
    public void write(Element parent, String name, String rules, String actions) {
        Element thisLevel = myXMLTool.makeElement(name);
        myXMLTool.addChild(parent, thisLevel);
        myRuleParser.write(thisLevel, rules);
        Element actionElement = myXMLTool.makeElement(XMLWriter.ACTIONS_TAG);
        myXMLTool.addChild(thisLevel, myActionParser.parse(actionElement, actions));
    }

}
