package vooga.fighter.controller;

import vooga.fighter.game.GameInstance;
import vooga.fighter.game.SplashScreen;



import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import vooga.fighter.view.Canvas;


public class ModeFactory {
	private static final String DEFAULT_RESOURCE_PACKAGE = "vooga.fighter.config.";
	
	private Map<String, Mode> myModeMap;
	private Canvas myCanvas;
    private ResourceBundle myResources;
    private Map<String, String> myLevelPathMap; 
    private List<String> myLevelNames;
    private MediaManager myMediaManager;
    
	
	public ModeFactory(Canvas frame, MediaManager mediamanager) {
		myCanvas = frame;
		myModeMap = new HashMap<String, Mode>();
		myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "LevelConfig");
		myLevelPathMap = new HashMap<String, String>();
		myLevelNames = new ArrayList<String>();
		myMediaManager = mediamanager;
		readFile(myResources, myLevelPathMap, myLevelNames);
		loadGame(myCanvas, myModeMap, myLevelPathMap, myLevelNames);
	}
	
	public Map getMap(){
		return myModeMap;
	}
	
    private void readFile(ResourceBundle resources, Map<String, String> levelpathmap, List<String> levelnames) {
        Enumeration<String> keys = resources.getKeys();
        while(keys.hasMoreElements()) {
            String key = keys.nextElement();
            levelpathmap.put(key, resources.getObject(key).toString());
            levelnames.add(key);
        }
    }
    
    private void loadGame(Canvas frame, Map<String, Mode> modemap, Map<String, String> levelpathmap, 
    	   List<String> levelnames) {
		Mode mode = new SplashScreen(frame, levelnames.get(0));
		modemap.put(mode.getModeName(), mode);
    	for(int i = 0; i < levelnames.size()-1; i++) {
            Mode level = new GameInstance(levelnames.get(i), levelpathmap.get(i), levelnames.get(i+1));
            modemap.put(level.getModeName(), level);
        }
    	Mode level = new GameInstance(levelnames.get(levelnames.size()-1), 
    			levelpathmap.get(levelnames.size()-1), mode.getModeName());
    	modemap.put(level.getModeName(), level);
    }



}
