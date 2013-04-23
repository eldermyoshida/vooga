package vooga.fighter.controller;

import java.util.ArrayList;
import java.util.List; 

import util.input.src.input.Input;
import vooga.fighter.input.AlertObject;
import vooga.fighter.input.InputClassTarget;
import vooga.fighter.input.InputMethodTarget;
import vooga.fighter.input.PositionObject;
import vooga.fighter.model.CollisionManager;
import vooga.fighter.model.LevelMode;
import vooga.fighter.model.MapEditorMode;
import vooga.fighter.model.Mode;
import vooga.fighter.model.objects.CharacterObject;
import vooga.fighter.model.objects.EnvironmentObject;
import vooga.fighter.model.objects.MapObject;
import vooga.fighter.view.Canvas;

@InputClassTarget
public class MapEditorController extends Controller{
	
	    private static final String INPUT_PATHWAY = "vooga.fighter.input.MapEditorMapping_en_US";
	    private MapEditorMode myEditTarget;

	    public MapEditorController () {
	        super();
	    }   
		
	    public MapEditorController(String name, Canvas frame, ControllerDelegate manager, 
                GameInfo gameinfo) {
        super(name, frame, manager, gameinfo);
        setInput(manager.getInput());
        getInput().replaceMappingResourcePath(INPUT_PATHWAY);
        getInput().addListenerTo(this);
<<<<<<< HEAD
        GameLoopInfo gameLoopInfo = new GameLoopInfo((LevelMode) getMode());
        setLoopInfo(gameLoopInfo);
        gameinfo.setGameLoopInfo(gameLoopInfo);
=======
     //   GameLoopInfo gameLoopInfo = new GameLoopInfo((MapEditorMode) getMode());
    //    setLoopInfo(gameLoopInfo);
     //   gameinfo.setGameLoopInfo(gameLoopInfo);
>>>>>>> added removeState to GameObjects, finished placement method for editor
	    }
	    
	    public Controller getController(String name, Canvas frame, ControllerDelegate manager, GameInfo gameinfo) {
	        Controller controller = new MainMenuController(name, frame, manager, gameinfo);
	        return controller;
	    }

	    public void notifyEndCondition (String endCondition) {
	    	removeListener();
	    	getManager().notifyEndCondition(endCondition);
	    }
	    
	    public MapEditorMode getMode(){
	    	return (MapEditorMode) super.getMode();
	    }
	    
	    public void loadMode() {
	        MapEditorMode temp = new MapEditorMode(new CollisionManager());
	        super.setMode((Mode) temp);
	    }
	    
	    public void initializeMode() {
	    	loadMap(getGameInfo().getMapName());
	    }
	    
	    public Controller getController() {
	    	return this;
	    }

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
	    
	    @InputMethodTarget(name = "load")
	    public void loadMap (AlertObject alObj)  {
	    	
	    }
	    
	    @InputMethodTarget(name = "save")
	    public void saveMap (AlertObject alObj)  {
	    	myEditTarget.writeMap();
	    }
	    
	    @InputMethodTarget(name = "select")
	    public void select (PositionObject posObj)  {
	    	myEditTarget.select(posObj.getPoint2D());
	    }
	    
	    @InputMethodTarget(name = "nextObject")
	    public void nextObject (AlertObject alObj)  {
	    	myEditTarget.nextObject();
	    }
	    
	    @InputMethodTarget(name = "prevObject")
	    public void prevObject (AlertObject alObj)  {
	    	myEditTarget.prevObject();
	    }
	    
	    @InputMethodTarget(name = "quit")
	    public void quit (AlertObject alObj)  {
	    	notifyEndCondition("MainMenu");
	    }
	    
	    public void checkConditions() {
	    }
	    
	    public void developerUpdate() {
	    	
	    }
	    
}

