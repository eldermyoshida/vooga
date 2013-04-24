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
import vooga.fighter.model.objects.AttackObject;
import vooga.fighter.model.objects.CharacterObject;
import vooga.fighter.model.objects.EnvironmentObject;
import vooga.fighter.model.objects.MapObject;
import vooga.fighter.model.LevelMode;
import vooga.fighter.model.Mode;
import vooga.fighter.model.objects.CharacterObject;
import vooga.fighter.model.utils.UpdatableLocation;
import vooga.fighter.util.CollisionManager;
import vooga.fighter.util.Paintable;
import vooga.fighter.view.Canvas;

//Two EnvironmentObjects collided!

/**
 * 
 * @author Jerry Li
 * 
 * @author Jack Matteucci
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

    public LevelController(String name, Canvas frame, ControllerDelegate manager, 
                GameInfo gameinfo) {
        super(name, frame, manager, gameinfo);
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
        LevelMode temp = new LevelMode(new CollisionManager());
        super.setMode((Mode) temp);
        myInputObjects = temp.getCharacterObjects();
    }
    
    public void initializeMode(){
        loadMap(getGameInfo().getMapName());
        loadCharacters(getGameInfo().getCharacters(), getMode().getMap().getStartPositions());
        loadHealth();
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
    		    for (int i = 0; i < levelmode.getCharacterObjects().size(); i++) {
			//for(CharacterObject character: levelmode.getCharacterObjects()){
				if(!levelmode.getCharacterObjects().get(i).hasHealthRemaining()) {
				    
				    getGameInfo().addWinners(i);
				    return true;
				}
			}
			return false;
		}
    };
    
    ModeCondition lowhealthcondition = new ModeCondition() {
    	public boolean checkCondition(Mode mode) {
    		LevelMode levelmode = (LevelMode) mode;
			for(CharacterObject character: levelmode.getCharacterObjects()){
				if(!character.hasHealthRemaining()) {
				    return true;
				}
			}
			return false;
		}
    };
    
    public void developerUpdate(){
    	;
    }
    
    

    public void loadHealth() {
        for (int i = 0; i < getMode().getCharacterObjects().size(); i++) {
            getMode().getHealthStats().add(getMode().getCharacterObjects().get(i).getHealth());
        }
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
     * Loads the character objects for the selected characters using the ObjectLoader.
     */
    public void loadCharacters(List<String> characterNames, List<UpdatableLocation> startingPos) {
        for (int i = 0; i < characterNames.size(); i++) {
            String charName = characterNames.get(i);
            UpdatableLocation start = startingPos.get(i);
            CharacterObject newCharacter = new CharacterObject(charName, start);
            getMode().addObject(newCharacter);
            getMode().addCharacter(newCharacter);
        }
    }

    
    
}