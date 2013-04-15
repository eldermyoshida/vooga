package vooga.rts.gamedesign.sprite.rtsprite.interactive.units;

import java.awt.Dimension;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import vooga.rts.gamedesign.action.Action;
import vooga.rts.gamedesign.sprite.GameSprite;
import vooga.rts.gamedesign.sprite.InteractiveEntity;
import vooga.rts.gamedesign.sprite.rtsprite.interactive.IGatherable;
import vooga.rts.gamedesign.sprite.rtsprite.interactive.IOccupiable;
import vooga.rts.gamedesign.strategy.gatherstrategy.CannotGather;
import vooga.rts.gamedesign.strategy.gatherstrategy.GatherStrategy;
import vooga.rts.gamedesign.strategy.occupystrategy.CannotOccupy;
import vooga.rts.gamedesign.strategy.occupystrategy.OccupyStrategy;
import vooga.rts.gamedesign.upgrades.UpgradeNode;
import vooga.rts.gamedesign.upgrades.UpgradeTree;
import vooga.rts.util.Location;
import vooga.rts.util.Pixmap;
import vooga.rts.util.Sound;
/**
 * This class is an extension of InteractiveEntity, and represents shapes that
 * have the potential to gather resources (contains GatherStrategy) and the
 * potential to be occupied (contains OccupyStrategy). The movement of Units
 * are defined by the AI Engine.
 * 
 * @author Ryan Fishel
 * @author Kevin Oh
 * @author Francesco Agosti
 * @author Wenshun Liu
 *
 */
public class Unit extends InteractiveEntity {
	
	private static UpgradeTree myUpgradeTree;
    private List<GameSprite> myKills; //TODO: WHAT TYPE SHOULD IT BE??
    // private boolean myIsLeftSelected; // TODO: also need the same thing for Projectiles
    // private boolean myIsRightSelected; // TODO: should be observing the mouse action instead!!
    //private PathingHelper myPather;
    private OccupyStrategy myOccupyStrategy;

    public Unit() {
    	this(null);
    }
    
    public Unit (UpgradeTree upgradeTree) { //TESTING PURPOSE. FEEL FREE TO DELETE
    	this(null, new Location(0,0), new Dimension(30, 30), null, 0, 50, upgradeTree);
    }
    
    /**
     * Creates a new unit with an image, location, size, sound, teamID and health
     * 
     * @param image is the image of the unit
     * @param center is the position of the unit on the map
     * @param size is the size of the unit
     * @param sound is the sound the unit makes
     * @param playerID is the ID for the team that the unit is on
     * @param health is the max health of the unit
     */
    public Unit (Pixmap image, Location center, Dimension size, Sound sound, int playerID, int health) {
        this(image, center, size, sound, playerID, health, null);
    }
    
    /**
     * Only be used when the first Unit under the same UpgradeTree is created.
     * @param image
     * @param center
     * @param size
     * @param sound
     * @param playerID
     * @param health
     * @param upgradeTree
     */
    public Unit (Pixmap image, Location center, Dimension size, Sound sound, int playerID, int health, UpgradeTree upgradeTree) {
        super(image, center, size, sound, playerID, health);
        //myPather = new PathingHelper();
        myOccupyStrategy = new CannotOccupy();
        if (upgradeTree != null) {
        	myUpgradeTree = upgradeTree;
        	addUpgradeActions(this);
        }
        myUpgradeTree.addUser(this);
    }
    
    @Override
    public UpgradeTree getUpgradeTree() {
    	return myUpgradeTree;
    }
    
    /**
     * Adds the list of available upgrades into the list of available actions.
     */
    private void addUpgradeActions(final Unit unit){
        List<UpgradeNode> currentUpgrades = myUpgradeTree.getCurrentUpgrades();
    	for (final UpgradeNode u: currentUpgrades) {
    		 getActions().add(new Action(u.getUpgradeType(), null, "An upgrade action for soldier"){
    	            @Override
    	            public void apply() throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException{
    	                u.apply();
    	            }
    	        });
    	}
    }
    
    /**
     * Occupies an IOccupiable object specified by occupy strategy.
     * @param o
     */
    public void occupy(IOccupiable o) {
    	if(myOccupyStrategy.canOccupy(o)){
    	    o.getOccupied(this);
    	}
    }
}
