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
import vooga.fighter.model.objects.MapObject;
import vooga.fighter.view.Canvas;

@InputClassTarget
public class MapEditorController extends Controller{
	
	    private static final String INPUT_PATHWAY = "vooga.fighter.input.MapEditorMapping_en_US";
	    private MapEditorMode myEditTarget;

	    public MapEditorController () {
	        super();
	    }   
		
	    public void initializeRest(Canvas frame, ControllerDelegate manager, 
                GameInfo gameinfo) {
        super.initializeRest(frame, manager, gameinfo);
        setInput(manager.getInput());
        getInput().replaceMappingResourcePath(INPUT_PATHWAY);
        getInput().addListenerTo(this);
        GameLoopInfo gameLoopInfo = new GameLoopInfo((LevelMode) getMode());
        setLoopInfo(gameLoopInfo);
        gameinfo.setGameLoopInfo(gameLoopInfo);
    }

	    public void notifyEndCondition (String endCondition) {
	    	removeListener();
	    	getManager().notifyEndCondition(endCondition);
	    }
	    

	    
	    public void loadMode() {
	       // List<Integer> characterNames = myGameInfo.getCharacters();
	        String mapID = getGameInfo().getMapName();
	   //     Mode temp = new LevelMode(this, mapID);
	   //     setMode(temp);
	    }
	    
	    public void initializeMode() {
	    	
	    }
	    
	    public Controller getController() {
	    	return this;
	    }

	    public void setEditTarget(MapEditorMode map) {
	    	myEditTarget = map;
	    }

	    /*
	    @Override
	    public Controller getController (ControllerDelegate delegate, GameInfo gameinfo) {
	        return new MapEditorController(super.getName(), super.getView(),
	                                   delegate, gameinfo);
	    }
	    

	    @Override
	    protected Input makeInput () {
	        Input input = new Input(INPUT_PATHWAY, super.getView());
	        input.addListenerTo(this);
	    	return input;
	    }
	    */
	    
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
	    
}

