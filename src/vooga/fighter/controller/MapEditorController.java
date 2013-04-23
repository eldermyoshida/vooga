package vooga.fighter.controller;

import java.util.ArrayList;
import java.util.List; 

import util.input.src.input.Input;
import vooga.fighter.input.AlertObject;
import vooga.fighter.input.InputClassTarget;
import vooga.fighter.input.InputMethodTarget;
import vooga.fighter.input.PositionObject;
import vooga.fighter.model.LevelMode;
import vooga.fighter.model.MapEditorMode;
import vooga.fighter.model.Mode;
import vooga.fighter.model.objects.CharacterObject;
import vooga.fighter.model.objects.EnvironmentObject;
import vooga.fighter.model.objects.MapObject;
import vooga.fighter.util.CollisionManager;
import vooga.fighter.view.Canvas;

/**
 * Controller class to handle the creation of an instance of the map editor, as
 * well as handling inputs for the mode. Allows users to edit existing maps or 
 * create entirely new maps. Map editor allows the addition of environmental objects,
 * and the selection of starting positions, background, and music.
 * @author matthewparides, Jack Matteucci, Jerry Li
 *
 */
@InputClassTarget
public class MapEditorController extends Controller{
	
	    private static final String INPUT_PATHWAY = "vooga.fighter.input.MapEditorMapping_en_US";
	    private MapEditorMode myEditTarget;

	    /**
	     * constructor
	     */
	    public MapEditorController () {
	        super();
	    }   
		
	    /**
	     * constructor - sets instance variables of the super class and the input
	     * @param name
	     * @param frame
	     * @param manager
	     * @param gameinfo
	     */
	    public MapEditorController(String name, Canvas frame, ControllerDelegate manager, 
                GameInfo gameinfo) {
	    	super(name, frame, manager, gameinfo);
	    	setInput(manager.getInput());
	    	getInput().replaceMappingResourcePath(INPUT_PATHWAY);
	    	getInput().addListenerTo(this);
	    }
	    
	    /**
	     * loads relevant data into this controller and returns it
	     */
	    public Controller getController(String name, Canvas frame, ControllerDelegate manager, GameInfo gameinfo) {
	        Controller controller = new MainMenuController(name, frame, manager, gameinfo);
	        return controller;
	    }

	    /**
	     * notifies the manager that this state has completed
	     */
	    public void notifyEndCondition (String endCondition) {
	    	removeListener();
	    	getManager().notifyEndCondition(endCondition);
	    }
	    
	    /**
	     * returns this controller's mode
	     */
	    public MapEditorMode getMode(){
	    	return (MapEditorMode) super.getMode();
	    }
	    
	    /**
	     * loads the mode for this controller
	     */
	    public void loadMode() {
	        MapEditorMode temp = new MapEditorMode(new CollisionManager());
	        super.setMode((Mode) temp);
	    }
	    
	    /**
	     * loads the user-selected map 
	     */
	    public void initializeMode() {
	    	loadMap(getGameInfo().getMapName());
	    }
	    
	    /**
	     * returns this controller
	     */
	    public Controller getController() {
	    	return this;
	    }

	    /**
	     * sets the edit target of this controller
	     * @param map
	     */
	    public void setEditTarget(MapEditorMode map) {
	    	myEditTarget = map;
	    }

	    /**
	     * Loads the environment objects for a map using the ObjectLoader.
	     */
	    public void loadMap(String mapName) {
	    	getMode().setMap(new MapObject(mapName));
	        List<EnvironmentObject> mapObjects = getMode().getMap().getEnviroObjects();
	        for (EnvironmentObject object : mapObjects) {
	        	getMode().addObject(object);
	        }
	    }
	    
	    /**
	     * prompts a user for a new 
	     * @param alObj
	     */
	    @InputMethodTarget(name = "load")
	    public void loadMap (AlertObject alObj) {
	    	String mapName = "";
	    	loadMode();
	    	loadMap(mapName);
	    }
	    
	    /**
	     * saves the current edit target map to the maps xml file
	     * @param alObj
	     */
	    @InputMethodTarget(name = "save")
	    public void saveMap (AlertObject alObj) {
	    	myEditTarget.writeMap();
	    }
	    
	    /**
	     * performs appropriate action for the user selecting a location to place an object
	     * in the UI.
	     * @param posObj
	     */
	    @InputMethodTarget(name = "select")
	    public void objectSelect (PositionObject posObj) {
	    	myEditTarget.objectSelect(posObj.getPoint2D());
	    }
	    
	    /**
	     * performs appropriate action for the user selecting a location to place a starting location
	     * in the UI.
	     * @param posObj
	     */
	    @InputMethodTarget(name = "startselect")
	    public void startLocSelect (PositionObject posObj) {
	    	myEditTarget.startLocSelect(posObj.getPoint2D());
	    }
	    
	    /**
	     * selects the next player whose starting position is to be placed
	     * @param alObj
	     */
	    @InputMethodTarget(name = "nextPlayer")
	    public void nextPlayer (AlertObject alObj) {
	    	myEditTarget.nextPlayer();
	    }
	    
	    /**
	     * selects the next player whose starting position is to be placed
	     * @param alObj
	     */
	    @InputMethodTarget(name = "prevPlayer")
	    public void prevPlayer (AlertObject alObj) {
	    	myEditTarget.prevPlayer();
	    }
	    
	    /**
	     * selects the next object in the editTarget's collection of 
	     * placeable objects
	     * @param alObj
	     */
	    @InputMethodTarget(name = "nextObject")
	    public void nextObject (AlertObject alObj) {
	    	myEditTarget.nextObject();
	    }
	    
	    /**
	     * selects the previous object in the editTarget's collection of
	     * placeable objects
	     * @param alObj
	     */
	    @InputMethodTarget(name = "prevObject")
	    public void prevObject (AlertObject alObj) {
	    	myEditTarget.prevObject();
	    }
	    
	    /**
	     * quits the mapEditor and returns to the main menu
	     * @param alObj
	     */
	    @InputMethodTarget(name = "quit")
	    public void quit (AlertObject alObj) {
	    	notifyEndCondition("MainMenu");
	    }
	    
	    /**
	     * prompts the user for a filepath for the background image, and sets
	     * that path in the edit target.
	     * @param alObj
	     */
	    @InputMethodTarget(name = "getBackground")
	    public void getBackground (AlertObject alObj) {
	    	String filePath = "";
	    	myEditTarget.setBackground(filePath);
	    }
	    
	    /**
	     * prompts the user for a filepath for the sound file, and sets that path in 
	     * the edit target.
	     * @param alObj
	     */
	    @InputMethodTarget(name = "getSound")
	    public void getSound (AlertObject alObj) {
	    	String filePath = "";
	    	myEditTarget.setSound(filePath);
	    }
	    
	    public void checkConditions() {
	    }
	    
	    public void developerUpdate() {
	    	
	    }
	    
}

