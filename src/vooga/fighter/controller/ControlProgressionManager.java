package vooga.fighter.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.ResourceBundle;

/**
 * 
 * @author Jack Matteucci
 * @author Jerry Li
 *
 */
public class ControlProgressionManager {
                
	private static final String NEXT = "Next";
	private static final String BACK = "Back";
	private Map<String, Controller> myControllerMap;
	
	public ControlProgressionManager(Map<String, Controller> controllerMap) {
		myControllerMap = controllerMap;
		
	}
	
	
	public Controller getNextController(String condition) {
	    try {
	        return myControllerMap.get(condition);
	    }
	    catch (Exception e) {
	        throw new NullPointerException("No such level"); 
	    }
	}
	
	
	public Controller getController(String string) {
	    return myControllerMap.get(string);
	}

//	
//	private boolean checkTourney(String currentController, GameInfo info){
//		return (currentController.equals(SCORECONTROLLER)&&TOURNEY.equals(info.getGameMode()));
//	}
//
//	
//	private String selectTourneyLevel(GameInfo info){
//		List<String> mapsplayed = info.getMapsPlayed();
//		if(mapsplayed.size() == info.getMapCount()) return MAINMENU;
//		boolean mapselected = false;
//		while(!mapselected){
//			int randomlevel = (int)(Math.random()*info.getMapCount()); 
//			String map = info.getMapNames().get(randomlevel);
//			if(!mapsplayed.contains(map)){
//				info.setMapName(map);
//				info.getMapsPlayed().add(map);
//				return myGameInfo.getGameMode();
//			}
//		}
//		return MAINMENU; //Can't go wrong with MainMenu!
//
//	}
}

