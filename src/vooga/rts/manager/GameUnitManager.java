package vooga.rts.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import vooga.rts.gamedesign.sprite.gamesprites.GameEntity;
import vooga.rts.gamedesign.sprite.gamesprites.interactive.buildings.Building;
import vooga.rts.gamedesign.sprite.gamesprites.interactive.units.Unit;
import vooga.rts.gamedesign.state.MovementState;
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
	private Map<Integer, ArrayList<Unit>> myBuildingUnits;
	
	public GameUnitManager() {
		myPlayers = new ArrayList<Player>();
		myPlayerUnits = new HashMap<Integer, ArrayList<Unit>>();
		myBuildingUnits = new HashMap<Integer, ArrayList<Unit>>();
	}
	
	public void addPlayer(Player player, int playerID) { //TODO: superclass for common methods
														// refactor needed
    	myPlayers.add(player);
    	myPlayerUnits.put(playerID, new ArrayList<Unit>());
    }
	
	public void addEntity(Building building) {
    	myBuildingUnits.put(building.getBuildingID(), new ArrayList<Unit>());
    }
	
	public void addPlayerUnit(Unit u) {
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
	
	public void addEntityUnit(Building building, Unit u) {
		ArrayList<Unit> newUnitList = myBuildingUnits.get(building.getBuildingID());
		newUnitList.add(u);
		myBuildingUnits.put(building.getBuildingID(), newUnitList);
		removePlayerUnit(u);
	}
	
	public void removeEntityUnit(Building building) {
		ArrayList<Unit> entityUnitList = myBuildingUnits.get(building.getBuildingID());
		myBuildingUnits.put(building.getBuildingID(), new ArrayList<Unit>());
		int playerID = building.getOccupyStrategy().getOccupierID();
		ArrayList<Unit> oldPlayerUnitList = myPlayerUnits.get(playerID);
		Random r = new Random();
		for (Unit u: entityUnitList) {
			u.setVisible(true);
			u.setWorldLocation(100+r.nextInt(100), 100+r.nextInt(100), 100 + r.nextInt(100)); //TODO: need to set raily points;
			u.getEntityState().setMovementState(MovementState.STATIONARY);
			oldPlayerUnitList.add(u);
			//TODO: can't select. Not add to player properly.
		}
		myPlayerUnits.put(playerID, oldPlayerUnitList);
		myPlayers.get(playerID-1).getUnits().setAllUnits(oldPlayerUnitList);
	}
	
	public Map<Integer, ArrayList<Unit>> getPlayerUnits() {
		return myPlayerUnits;
	}
}
