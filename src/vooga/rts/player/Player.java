package vooga.rts.player;

import vooga.rts.IGameLoop;
import vooga.rts.gamedesign.sprite.rtsprite.interactive.Interactive;
import vooga.rts.manager.*;

public abstract class Player implements IGameLoop {

	private ResourceManager myResourceManager;
	private UnitManager myUnitManager;
	private BuildingManager myBuildingManager;
	private int myTeamID;

	
	public ResourceManager getResourceManager () {
		return myResourceManager;
	}
	
	public ResourceManager removeResources (Interactive i) {
		return myResourceManager;
		
	}
	
	public UnitManager getUnits() {
		return myUnitManager;
	}
	
	public BuildingManager getBuildings() {
		return myBuildingManager;
	}
	
	public int getTeamID() {
		return myTeamID;
	}
	
}
