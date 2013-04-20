package vooga.rts.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import vooga.rts.gamedesign.sprite.gamesprites.GameEntity;
import vooga.rts.gamedesign.sprite.gamesprites.interactive.buildings.Building;
import vooga.rts.gamedesign.sprite.gamesprites.interactive.units.Unit;
import vooga.rts.player.Player;

/**
 * This class stores all the units in the game and manages their 
 * distribution among players.
 * 
 * @author Wenshun Liu
 * 
 */

public class GameUnitManager {
	private List<Player> myPlayers;
	private Map<Integer, ArrayList<Unit>> myPlayerUnits;
	private Map<GameEntity, ArrayList<Unit>> myEntityUnits;
	
	public GameUnitManager() {
		myPlayers = new ArrayList<Player>();
		myPlayerUnits = new HashMap<Integer, ArrayList<Unit>>();
		myEntityUnits = new HashMap<GameEntity, ArrayList<Unit>>();
	}
	
	public void addPlayer(Player player, int playerID) { //TODO: superclass for common methods
														// refactor needed
    	myPlayers.add(player);
    	myPlayerUnits.put(playerID, new ArrayList<Unit>());
    }
	
	public void addEntity(GameEntity entity) {
    	myEntityUnits.put(entity, new ArrayList<Unit>());
    }
	
	public void addPlayerUnit(Unit u) {
		System.out.println("adds player Unit!");
		ArrayList<Unit> newUnitList = myPlayerUnits.get(u.getPlayerID());
		newUnitList.add(u);
		myPlayerUnits.put(u.getPlayerID(), newUnitList);
		myPlayers.get(u.getPlayerID()-1).getUnits().setAllUnits(newUnitList);
	}
	
	public void removePlayerUnit(Unit u) { //TODO: check if removed when Unit's dead
		ArrayList<Unit> newUnitList = myPlayerUnits.get(u.getPlayerID());
		int removeIndex = newUnitList.indexOf(u);
		newUnitList.remove(removeIndex);
		myPlayerUnits.put(u.getPlayerID(), newUnitList);
		myPlayers.get(u.getPlayerID()-1).getUnits().setAllUnits(newUnitList);
	}
	
	public void addEntityUnit(GameEntity entity, Unit u) {
		ArrayList<Unit> newUnitList = myEntityUnits.get(entity);
		newUnitList.add(u);
		myEntityUnits.put(entity, newUnitList);
		removePlayerUnit(u);
	}
	
	public Map<Integer, ArrayList<Unit>> getPlayerUnits() {
		return myPlayerUnits;
	}
}
