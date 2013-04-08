package vooga.rts.player;

import java.awt.Graphics2D;
import vooga.rts.IGameLoop;
import vooga.rts.gamedesign.sprite.rtsprite.interactive.Interactive;
import vooga.rts.manager.*;


public abstract class Player implements IGameLoop {

    private ResourceManager myResourceManager;
    private UnitManager myUnitManager;
    private BuildingManager myBuildingManager;
    private int myTeamID;
    
    public Player() {
        myResourceManager = new ResourceManager();
        myUnitManager= new UnitManager();
    }

    public ResourceManager getResourceManager () {
        return myResourceManager;
    }

    public ResourceManager removeResources (Interactive i) {
        return myResourceManager;

    }

    public UnitManager getUnits () {
        return myUnitManager;
    }

    public BuildingManager getBuildings () {
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

}
