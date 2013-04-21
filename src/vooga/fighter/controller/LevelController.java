package vooga.fighter.controller;



import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;

import util.Location;
import util.input.*;
import vooga.fighter.model.LevelMode;
import vooga.fighter.model.Mode;
import vooga.fighter.model.objects.CharacterObject;
import vooga.fighter.model.LevelMode;
import vooga.fighter.model.Mode;
import vooga.fighter.model.objects.CharacterObject;
import vooga.fighter.util.Paintable;
import vooga.fighter.view.Canvas;


/**
 * 
 * @author Jerry Li
 * 
 * @Modified by Jack Matteucci
 * 
 * This is the basic controller used for levels.  It is attached to the LevelMode, so
 * one may see how the LevelMode is intantiated within this hierarchy if he/she may
 * need to extend controller.  Most extensions should just  subclass this class, as 
 * it provides the functionality to change winning conditions/ special conditions/
 * inputs.
 * 
 */

public abstract class LevelController extends Controller {
    private static final String INPUT_PATHWAY = "vooga.fighter.config.leveldefault";
    private List<CharacterObject> myInputObjects;
    private List<ModeCondition> myWinConditions;
    private List<ModeCondition> myUniqueConditions;

    public LevelController () {
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
        myWinConditions =new ArrayList<ModeCondition>();
        myUniqueConditions =new ArrayList<ModeCondition>();
        setupConditions();
        gameinfo.setGameLoopInfo(gameLoopInfo);
    }

    
    public void loadMode() {
        List<String> characterNames = getGameInfo().getCharacters();
        String mapID = getGameInfo().getMapName();
        LevelMode temp = new LevelMode(characterNames, mapID);
        setMode((Mode) temp);
        myInputObjects = temp.getMyCharacterObjects();
    }
    
    protected List<CharacterObject> getInputObjects(){
    	return myInputObjects;
    }
   
    public LevelMode getMode(){
    	return (LevelMode) super.getMode();
    }
    
    public Controller getController() {
        return this;
    }
   
    public void removeListener(){
    	super.removeListener();
    	getInput().removeListener(this);
    }
    
    protected void addWinCondition(ModeCondition condition){
    	myWinConditions.add(condition);
    }
    
    protected void addUniqueCondition(ModeCondition condition){
    	myUniqueConditions.add(condition);
    }
    
    protected List<ModeCondition> getWinConditions(){
    	return myWinConditions;
    }
    
    protected List<ModeCondition> getUniqueConditions(){
    	return myUniqueConditions;
    }
    
    public void setupConditions(){
    	addWinCondition(wincondition);
    }
    
    public void checkConditions(){
    	for(ModeCondition condition : getWinConditions()){
    		if(condition.checkCondition(getMode())) getManager().notifyEndCondition("ScoreScreen");
    	}
    }
    
    ModeCondition wincondition = new ModeCondition() {
    	public boolean checkCondition(Mode mode) {
    		LevelMode levelmode = (LevelMode) mode;
			for(CharacterObject character: levelmode.getMyCharacterObjects()){
				if(!character.hasHealthRemaining()) return true;
			}
			return false;
		}
    };
    
    ModeCondition lowhealthcondition = new ModeCondition() {
    	public boolean checkCondition(Mode mode) {
    		LevelMode levelmode = (LevelMode) mode;
			for(CharacterObject character: levelmode.getMyCharacterObjects()){
				if(!character.hasHealthRemaining()) return true;
			}
			return false;
		}
    };
    
    
}