package vooga.fighter.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class ControlProgressionManager {
        
        
	private static final String NEXT = "Next";
	private static final String BACK = "Back";
	private GameInfo myGameInfo;
	private List<Controller> myControllerList;
	
	public ControlProgressionManager(GameInfo gameinfo) {
		myGameInfo = gameinfo;
		
	}
	
	public void setControllerProgression(List<Controller> controllerProgression) {
	    myControllerList = controllerProgression;
	}
	
	public Controller getNextController(Controller currentController, String Condition){
		for(int i=1; i<myControllerList.size(); i++ ){
			if(currentController.equals(myControllerList.get(i))){
//				if(checkTourney(currentController, myGameInfo) && Condition.equals(NEXT)) 
//					return selectTourneyLevel(myGameInfo);
				if(Condition.equals(NEXT)){
					return myControllerList.get(i+1);
				}
				else if(Condition.equals(BACK)) {
				    return myControllerList.get(i -1);
				}
			}
		}
		return myControllerList.get(0); //Can't go wrong with MainMenu!
	}
	
	public Controller getController(int index) {
	    return myControllerList.get(index);
	}
//	
//	public String getFirstController(){
//		return MAINMENU;
//	}
//	
//	
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
