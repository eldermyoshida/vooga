package vooga.rts.gamedesign.sprite.gamesprites.interactive.buildings;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import vooga.rts.gamedesign.action.Action;
import vooga.rts.gamedesign.action.ProductionAction;
import vooga.rts.gamedesign.sprite.gamesprites.interactive.IOccupiable;
import vooga.rts.gamedesign.sprite.gamesprites.interactive.InteractiveEntity;
import vooga.rts.gamedesign.sprite.gamesprites.interactive.units.Soldier;
import vooga.rts.gamedesign.upgrades.UpgradeNode;
import vooga.rts.gamedesign.upgrades.UpgradeTree;
import vooga.rts.util.Location;
import vooga.rts.util.Location3D;
import vooga.rts.util.Pixmap;
import vooga.rts.util.Sound;
import vooga.towerdefense.gameElements.Unit;


/**
 * This is an abstract class that represents a building. It will be extended
 * by specific types of buildings such as AttackTower.
 * 
 * @author Ryan Fishel
 * @author Kevin Oh
 * @author Francesco Agosti
 * @author Wenshun Liu
 * 
 */
public class Building extends InteractiveEntity implements IOccupiable {
	private static int PRODUCE_TIME = 90;
    private static UpgradeTree myUpgradeTree;
    private Location3D myRallyPoint;
    private List<InteractiveEntity> myProducables;
    private List<InteractiveEntity> myInteractiveEntities;
    
    public Building (Pixmap image,
            Location3D center,
            Dimension size,
            Sound sound,
            int playerID,
            int health, UpgradeTree upgradeTree) {
    	super(image, center, size, sound, playerID, health);
        myRallyPoint = new Location3D(getWorldLocation().getX(), getWorldLocation().getY() + 50, 0);
        myProducables = new ArrayList<InteractiveEntity>();
        myInteractiveEntities = new ArrayList<InteractiveEntity>();
        initProducables();
        addProductionActions(this);
        setRallyPoint(new Location3D(300,400,0));
        if (upgradeTree != null) {
        	myUpgradeTree = upgradeTree;
        }
    }
    
    
    
    @Override
    public UpgradeTree getUpgradeTree() {
    	return myUpgradeTree;
    }
    
    @Override
    public void getOccupied(Unit unit) {
        //u.occupy(this);
    }
    
    
    /*
     * FOR TESTING: CALLED IN CONSTRUCTOR TO INITIALIZE PRODUCABLE LIST 
     */
    private void initProducables() {
        addProducable(new Soldier());
    }
    
    public void addProductionActions(Building productionBuilding) {
        getActions().add(new ProductionAction("soldier",null,"I maketh un soldier", productionBuilding.getWorldLocation()){
            @Override
            public void apply(int playerID) {
                InteractiveEntity ie = getProducables().get(0).copy();
                Location3D ieLoc = new Location3D(getProducedFrom());                
                ie.setWorldLocation(ieLoc.getX(), ieLoc.getY(), 0);
                //these below are for testing purposes 
                ie.move(getRallyPoint());
                //this part below will not be in actual implementation as I will notify player/unit manager that a new unit should be added to the player
                myInteractiveEntities.add(ie);
            }
        });
    }
    
    @Override
    public void paint(Graphics2D pen) {
        super.paint(pen);
        for(int i = 0; i < myInteractiveEntities.size(); i++) {
            myInteractiveEntities.get(i).paint(pen);
        }
    }
    
	/**
     * Adds the list of available upgrades into the list of available actions.
     */
    public void addUpgradeActions(UpgradeTree upgradeTree){
    	List<UpgradeNode> initialUpgrades = upgradeTree.getCurrentUpgrades();
    	addUpgradeActions(initialUpgrades);
    }
    
    public void addUpgradeActions(List<UpgradeNode> nodeList) {
    	for (final UpgradeNode u: nodeList) {
   		 getActions().add(new Action(u.getUpgradeName(), null, "An upgrade action"){
   	            @Override
   	            public void apply(int playerID) throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException{
   	                u.apply(playerID);
   	                getActions().remove(this);
   	                if (!u.getChildren().isEmpty()) {
   	                	addUpgradeActions(u.getChildren());
   	                }
   	            }
   	        });
   	}
    }
    /*
     * returns the list of producables
     */
    public List<InteractiveEntity> getProducables() {
        return myProducables;
    }
    
    /**
     * Returns the rally point of the production building. 
     * Will be used to move the newly created units to
     * @return myRallyPoint, the rally point of the 
     * production building 
     */
    public Location3D getRallyPoint() {
        return myRallyPoint;
    }
    /*
     * Test method to add an interactive entity to 
     */
    public void addProducable(InteractiveEntity i) {
        myProducables.add(i);
    }
    
    /**
     * Sets the rally point of the production building
     * @param rallyPoint the location of the new rally point 
     */
    public void setRallyPoint(Location3D rallyPoint) {
    	myRallyPoint = rallyPoint;
    }
   

	/**
	 * TESTING PURPOSE.
	 * Mimics player's click on action. Now invoke action after certain time. 
	 */
	@Override
	public void update(double elapsedTime) {
		super.update(elapsedTime);
		PRODUCE_TIME -= 1/elapsedTime;
		if(PRODUCE_TIME <= 0) { 
			try {
				findAction("Boost1").apply(1);
			} catch (Exception e) {
				e.printStackTrace();
			} 
			PRODUCE_TIME = 90;
		}
        for(InteractiveEntity ie : myInteractiveEntities) {
            ie.update(elapsedTime);
        }
		
	}

}
