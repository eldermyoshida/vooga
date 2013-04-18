package vooga.fighter.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class ControlProgressionManager {

	private static final String MAINMENU = "MainMenu";
	private static final String CHARACTERSELECT = "CharacterSelect";
	private static final String MAPSELECT = "MapSelect";
	private static final String LEVELCONTROLLER = "LevelController";
	private static final String SCORECONTROLLER = "ScoreController";
	private static final String TOURNEY = "Tourney";
	private static final String NEXT = "Next";
	private static final String BACK = "Back";
	private GameInfo myGameInfo;
	private List<String> myControllerList;
	
	public ControlProgressionManager(GameInfo gameinfo) {
		myGameInfo = gameinfo;
		myControllerList = new ArrayList<String>();
	}
	
	protected void setupMap(List<String> list){
		list.clear();
		list.add(MAINMENU);
		list.add(MAINMENU);
		list.add(CHARACTERSELECT);
		list.add(MAPSELECT);
		list.add(SCORECONTROLLER);
		list.add(MAINMENU);
	}
	
	public String getNextController(String currentController, String Condition){
		for(int i=1; i<myControllerList.size(); i++ ){
			if(currentController.equals(myControllerList.get(i))){
				if(checkTourney(currentController, myGameInfo) && Condition.equals(NEXT)) 
					return selectTourneyLevel(myGameInfo);
				else if(Condition.equals(NEXT)) return myControllerList.get(i+1);
				else if(Condition.equals(BACK)) return myControllerList.get(i -1);
			}
		}
		return MAINMENU; //Can't go wrong with MainMenu!
	}
	
	private boolean checkTourney(String currentController, GameInfo info){
		return (currentController.equals(SCORECONTROLLER)&&TOURNEY.equals(info.getGameMode()));
	}

	
	private String selectTourneyLevel(GameInfo info){
		List<Integer> mapsplayed = info.getMapsPlayed();
		if(mapsplayed.size() == info.getMapCount()) return MAINMENU;
		boolean mapselected = false;
		while(!mapselected){
			int randomlevel = (int)(Math.random()*info.getMapCount()); 
			if(!mapsplayed.contains(randomlevel)){
				info.setMapName(randomlevel);
				info.getMapsPlayed().add(randomlevel);
				return LEVELCONTROLLER;
			}
		}
		return MAINMENU; //Can't go wrong with MainMenu!

	}
}
