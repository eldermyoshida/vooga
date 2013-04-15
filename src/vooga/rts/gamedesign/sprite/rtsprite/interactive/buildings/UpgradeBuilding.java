package vooga.rts.gamedesign.sprite.rtsprite.interactive.buildings;

import java.awt.Dimension;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import vooga.rts.gamedesign.action.Action;
import vooga.rts.gamedesign.sprite.rtsprite.interactive.units.Unit;
import vooga.rts.gamedesign.upgrades.UpgradeNode;
import vooga.rts.gamedesign.upgrades.UpgradeTree;
import vooga.rts.util.Location;
import vooga.rts.util.Pixmap;
import vooga.rts.util.Sound;

public class UpgradeBuilding extends Building{

	//TESTING PURPOSE. FEEL FREE TO DELETE
	public UpgradeBuilding(){
		this(null, new Location(0,0), new Dimension(30,30), null, 0, 100);
	}
	
	public UpgradeBuilding(Pixmap image, Location center, Dimension size,
			Sound sound, int playerID, int health) {
		super(image, center, size, sound, playerID, health, null);
	}
	
	/**
     * Adds the list of available upgrades into the list of available actions.
     */
    public void addUpgradeActions(UpgradeTree upgradeTree){
        List<UpgradeNode> currentUpgrades = upgradeTree.getCurrentUpgrades();
    	for (final UpgradeNode u: currentUpgrades) {
    		 getActions().add(new Action(u.getUpgradeType(), null, "An upgrade action for soldier"){
    	            @Override
    	            public void apply() throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException{
    	                u.apply();
    	            }
    	        });
    	}
    }

	@Override
	public void getOccupied(Unit u) {
		// TODO Auto-generated method stub
		
	}
}
