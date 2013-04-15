package vooga.rts.gamedesign.sprite.rtsprite.interactive.buildings;

import java.awt.Dimension;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import vooga.rts.gamedesign.action.Action;
import vooga.rts.gamedesign.sprite.rtsprite.interactive.units.Unit;
import vooga.rts.gamedesign.upgrades.UpgradeNode;
import vooga.rts.util.Location;
import vooga.rts.util.Pixmap;
import vooga.rts.util.Sound;

public class UpgradeBuilding extends Building{

	public UpgradeBuilding(Pixmap image, Location center, Dimension size,
			Sound sound, int playerID, int health) {
		super(image, center, size, sound, playerID, health, null);
		addUpgradeActions();
	}
	
	/**
     * Adds the list of available upgrades into the list of available actions.
     */
    private void addUpgradeActions(){
        List<UpgradeNode> currentUpgrades = getUpgradeTree().getCurrentUpgrades();
    	for (final UpgradeNode u: currentUpgrades) {
    		 getActions().add(new Action(u.getUpgradeType(), null, "An upgrade action for soldier"){
    	            @Override
    	            public void apply() throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException{
    	                //u.apply(unit);
    	            }
    	        });
    	}
    }

	@Override
	public void getOccupied(Unit u) {
		// TODO Auto-generated method stub
		
	}
}
