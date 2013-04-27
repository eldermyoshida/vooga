package vooga.towerdefense.gameeditor.gamemaker;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.w3c.dom.Element;
import util.XMLTool;


/**
 * Class that creates the xml document for saving the game in.
 * Uses input from the game editor classes.
 * 
 * @author Leonard K. Ng'eno
 * 
 */
public class XMLWriter {

    private static final String XML_EXTENSION = ".xml";
    private static final String GAME_TAG = "game";
    private static final String VIEW_TAG = "view";
    private static final String GAME_ELEMENT_TAG = "gameelement";
    private static final String LEVEL_TAG = "level";
    private static final String IMAGE_TAG = "image";
    private static final String TYPE_TAG = "type";
    private static final String MAP_TAG = "map";
    private static final String DIMENSION_TAG = "dimension";
    private static final String WIDTH_TAG = "width";
    private static final String HEIGHT_TAG = "height";
    private static final String TILE_TAG = "tile";
    private static final String GRID_TAG = "grid";
    private static final String RULES_TAG = "rules";
    private static final String PARAMETER_TAG = "parameter";
    private static final String SCREEN_LOCATION_TAG = "location";
    private static final String ATTRIBUTES_TAG = "attributes";
    private static final String ACTIONS_TAG = "actions";
    private static final String RESOURCE_PATH = "/src/vooga/towerdefese/resources/";
    private static final String UNIT_INDICATOR = "Unit";

    private XMLTool myXMLDoc;
    private Element myRoot;
    private Element myViewParent;
    private Element myGameElementParent;
    private Element myMapParent;
    private Element myLevelParent;
    private Element myRuleParent;
    private ActionXMLWriter myActionParser;
    private String myName;
    private List<String> myCreatedUnits;

    XMLWriter () {
        myCreatedUnits = new ArrayList<String>();
        initializeXML();
    }

    /**
     * Starts a new XML file & initializes the main parent elements
     */
    private void initializeXML () {
        myXMLDoc = new XMLTool();
        myRoot = myXMLDoc.makeRoot(GAME_TAG);
        myViewParent = myXMLDoc.makeElement(VIEW_TAG);
        myXMLDoc.addChild(myRoot, myViewParent);
        myMapParent = myXMLDoc.makeElement(MAP_TAG);
        myXMLDoc.addChild(myRoot, myMapParent);
        myGameElementParent = myXMLDoc.makeElement(GAME_ELEMENT_TAG);
        myXMLDoc.addChild(myRoot, myGameElementParent);
        myRuleParent = myXMLDoc.makeElement(RULES_TAG);
        myXMLDoc.addChild(myRoot, myRuleParent);
        myLevelParent = myXMLDoc.makeElement(LEVEL_TAG);
        myXMLDoc.addChild(myRoot, myLevelParent);
        myActionParser = new ActionXMLWriter(myXMLDoc);
    }

    /**
     * Saves the XML file.
     */
    public void saveFile () {
        myXMLDoc.writeFile(RESOURCE_PATH + myName + XML_EXTENSION);
    }

    /**
     * Creates a new level in the game and adds it to the XML file.
     * 
     * @param name The name of the level
     * @param rules A map of rules, which controls different instructions for updating scores and
     *        determining other game states
     * @param actions Any action present in the game.
     */
    public void addLevelToGame (String name, String rules, String actions) {
        Element thisLevel = myXMLDoc.makeElement(name);
        myXMLDoc.addChild(myLevelParent, thisLevel);
        Element ruleElement = addRulesToFile(rules);
        myXMLDoc.addChild(thisLevel, ruleElement);
        Element actionElement = myXMLDoc.makeElement(ACTIONS_TAG);
        myXMLDoc.addChild(thisLevel, myActionParser.parse(actionElement, actions));
    }

    /**
     * Adds a map to the XML file.
     * 
     * @param name The name of the map, used as a tag. This name will be formatted.
     * @param image A string URL to the background image
     * @param width The width determined by the user
     * @param height The height of the map determined by the user
     * @param tile Size The size of a tile
     * @param map The grid
     */
    public void addMapToGame (String name,
                              String image,
                              String width,
                              String height,
                              String tileSize,
                              String map) {
        Element thisMap = myXMLDoc.makeElement(name.trim());
        myXMLDoc.addChild(thisMap, IMAGE_TAG, image);
        myXMLDoc.addChild(thisMap, WIDTH_TAG, width);
        myXMLDoc.addChild(thisMap, HEIGHT_TAG, height);
        myXMLDoc.addChild(thisMap, TILE_TAG, tileSize);
        myXMLDoc.addChild(thisMap, GRID_TAG, map);
        myXMLDoc.addChild(myMapParent, thisMap);
    }

    /**
     * Creates a new game element based on user input and adds it to the game.
     * 
     * @param type Determines the type of element
     * @param name is the game element's name
     * @param path is the image path
     * @param attributes is the map of attribute name to value
     * @param actions is the map of action name to value
     */
    public void addGameElementToGame (String type,
                                      String name,
                                      String path, String dimension,
                                      Map<String, String> attributes,
                                      String actions) {
        if (type.equals(UNIT_INDICATOR)) {
            myCreatedUnits.add(name);
        }
        addGameElementToFile(myGameElementParent, type, name, path, attributes, actions);
    }

    /**
     * Adds a game element to the XML file.
     * 
     * @param parent is the parent element
     * @param name is the game element's name
     * @param path is the image path
     * @param attributes is the map of attribute name to value
     * @param actions is the map of action name to value
     */
    private void addGameElementToFile (Element parent,
                                       String type,
                                       String name,
                                       String path,
                                       Map<String, String> attributes,
                                       String actions) {
        Element gameElement = myXMLDoc.makeElement(name);
        myXMLDoc.addChild(parent, gameElement);
        myXMLDoc.addChild(gameElement, IMAGE_TAG, path);
        myXMLDoc.addChild(gameElement, TYPE_TAG, type);
        Element attributeElement = myXMLDoc.makeElementsFromMap(ATTRIBUTES_TAG, attributes);
        myXMLDoc.addChild(gameElement, attributeElement);
        Element actionElement = myXMLDoc.makeElement(ACTIONS_TAG);
        myXMLDoc.addChild(gameElement, myActionParser.parse(actionElement, actions));
    }

    /**
     * adds the rules to the file.
     * 
     * @param rulesText
     * @return the parent element of the rules
     */
    private Element addRulesToFile (String rulesText) {
        Element ruleParent = myXMLDoc.makeElement(RULES_TAG);
        String[] rules = rulesText.split("\n");
        for (String r : rules) {
            if (!r.equals("")) {
                String[] rule = r.split(" ");
                Element thisRule = myXMLDoc.makeElement(rule[0]);
                for (int i = 1; i < rule.length; i++) {
                    myXMLDoc.addChild(thisRule, PARAMETER_TAG, rule[i]);
                }
                myXMLDoc.addChild(ruleParent, thisRule);
            }
        }
        return ruleParent;
    }

    /**
     * 
     * @param dimension
     * @param viewInfo
     * @param map
     */
    public void addViewToGame (String dimension,
                               List<String> viewInfo,
                               Map<String, List<String>> map) {
        Element viewscreen = myXMLDoc.makeElement("Dimension");
        myXMLDoc.addChild(myViewParent, viewscreen);
        myXMLDoc.addChild(viewscreen, DIMENSION_TAG, dimension);

        for (String s : viewInfo) {
            if (!s.equals("")) {
                String[] characteristics = s.split(" ");
                if (!characteristics[0].equals("")) {
                    Element screen = myXMLDoc.makeElement(characteristics[0]);
                    myXMLDoc.addChild(myViewParent, screen);
                    myXMLDoc.addChild(screen, DIMENSION_TAG, characteristics[1]);
                    myXMLDoc.addChild(screen, SCREEN_LOCATION_TAG, characteristics[2]);
                    if (characteristics[0].equals("MultipleScreenPanel")) {
                        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                            if (entry.getKey().equals(characteristics[3])) {
                                for (String str : entry.getValue()) {
                                    String[] values = str.split(" ");
                                    Element screen2 = myXMLDoc.makeElement(values[1]);
                                    myXMLDoc.addChild(screen, screen2);
                                    myXMLDoc.addChild(screen2, DIMENSION_TAG, values[2]);
                                    myXMLDoc.addChild(screen2, SCREEN_LOCATION_TAG, values[0]);
                                }
                            }
                        }
                    }

                }
            }
        }
    }

    /**
     * adds the rules to the game.
     * 
     * @param rulesText
     */
    public void addRulesToGame (String rulesText) {
        myRuleParent = addRulesToFile(rulesText);
    }

    /**
     * Gets the list of already created units.
     * 
     * @return a list of unit names as strings.
     */
    public List<String> getUnits () {
        return myCreatedUnits;
    }

}
