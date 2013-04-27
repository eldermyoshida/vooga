package vooga.towerdefense.gameeditor.gamemaker;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.w3c.dom.Element;
import util.XMLTool;
import vooga.towerdefense.gameeditor.gamemaker.xmlwriters.ActionXMLWriter;
import vooga.towerdefense.gameeditor.gamemaker.xmlwriters.GameElementXMLWriter;
import vooga.towerdefense.gameeditor.gamemaker.xmlwriters.LevelXMLWriter;
import vooga.towerdefense.gameeditor.gamemaker.xmlwriters.MapXMLWriter;
import vooga.towerdefense.gameeditor.gamemaker.xmlwriters.RuleXMLWriter;
import vooga.towerdefense.gameeditor.gamemaker.xmlwriters.ViewXMLWriter;


/**
 * Class that creates the xml document for saving the game in.
 * Uses input from the game editor classes.
 * 
 * @author Leonard K. Ng'eno
 * @author Angelica Schwartz
 * 
 */
public class XMLWriter {

    public static final String XML_EXTENSION = ".xml";
    public static final String GAME_TAG = "game";
    public static final String VIEW_TAG = "view";
    public static final String GAME_ELEMENT_TAG = "gameelement";
    public static final String LEVEL_TAG = "level";
    public static final String IMAGE_TAG = "image";
    public static final String TYPE_TAG = "type";
    public static final String MAP_TAG = "map";
    public static final String DIMENSION_TAG = "dimension";
    public static final String WIDTH_TAG = "width";
    public static final String HEIGHT_TAG = "height";
    public static final String TILE_TAG = "tile";
    public static final String GRID_TAG = "grid";
    public static final String RULES_TAG = "rules";
    public static final String PARAMETER_TAG = "parameter";
    public static final String SCREEN_LOCATION_TAG = "location";
    public static final String ATTRIBUTES_TAG = "attributes";
    public static final String ACTIONS_TAG = "actions";
    public static final String RESOURCE_PATH = "/src/vooga/towerdefese/resources/";
    public static final String UNIT_INDICATOR = "Unit";

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
        LevelXMLWriter writer = new LevelXMLWriter(myXMLDoc);
        writer.write(myLevelParent, name, rules, actions);
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
        MapXMLWriter writer = new MapXMLWriter(myXMLDoc);
        writer.write(myMapParent, name, image, width, height, tileSize, map);
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
        GameElementXMLWriter writer = new GameElementXMLWriter(myXMLDoc);
        writer.write(myGameElementParent, type, name, path, attributes, actions);
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
        ViewXMLWriter writer = new ViewXMLWriter(myXMLDoc);
        writer.write(myViewParent, dimension, viewInfo, map);
    }

    /**
     * adds the rules to the game.
     * 
     * @param rulesText
     */
    public void addRulesToGame (String rulesText) {
        RuleXMLWriter writer = new RuleXMLWriter(myXMLDoc);
        writer.write(myRuleParent, rulesText);
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
