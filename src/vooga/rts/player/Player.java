package vooga.rts.player;

import java.awt.Graphics2D;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import vooga.rts.IGameLoop;
import vooga.rts.gamedesign.sprite.gamesprites.interactive.InteractiveEntity;
import vooga.rts.gamedesign.sprite.gamesprites.interactive.units.Unit;
import vooga.rts.manager.*;
import vooga.rts.map.GameMap;

public abstract class Player implements IGameLoop, IProductionObserver {    
	
	private IndividualResourceManager myResourceManager;
    private IndividualUnitManager myUnitManager;
    private IndividualBuildingManager myBuildingManager;
    private int myTeamID;
    private GameMap myMap;
    
    
    public Player() {
        myResourceManager = new IndividualResourceManager();
        myUnitManager= new IndividualUnitManager();
        
    }
    
    public Player(GameMap map) {
        this();
        myMap = map;
    }
    
    public void addProduction(Unit newProduction) {
    	myUnitManager.addUnit(newProduction);
    }
    
    public void updateResource(HashMap<String, Integer> updatedResources) {
    	myResourceManager.setResources(updatedResources);
    }

    public IndividualResourceManager getIndividualResourceManager () {
        return myResourceManager;
    }

    public IndividualUnitManager getUnits () {
        return myUnitManager;
    }

    public IndividualBuildingManager getBuildings () {
        return myBuildingManager;
    }

    public int getTeamID () {
        return myTeamID;
    }
    
    public void setTeamID (int id) {
        myTeamID = id;
    }

    /*
     * (non-Javadoc)
     * 
     * @see vooga.rts.IGameLoop#update(double)
     */
    @Override
    public void update (double elapsedTime) {
        myUnitManager.update(elapsedTime);
    }

    /*
     * (non-Javadoc)
     * 
     * @see vooga.rts.IGameLoop#paint(java.awt.Graphics2D)
     */
    @Override
    public void paint (Graphics2D pen) {
        myUnitManager.paint(pen);
    }
    
    public GameMap getMap () {
        return myMap;
    }
}
