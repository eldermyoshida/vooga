package vooga.rts.gamedesign.upgrades;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import vooga.rts.gamedesign.sprite.GameEntity;
import vooga.rts.gamedesign.sprite.InteractiveEntity;

public class HealthUpgradeNode extends UpgradeNode {
	
	public HealthUpgradeNode(UpgradeTree upgradeTree, int id, String upgradeType, String upgradeObject, int upgradeValue){
		super(upgradeTree, id, upgradeType, upgradeObject, upgradeValue);
	}
	
	
	/**
	 * Applies the health upgrade by the method that updates health.
	 */
	@Override
	public void apply()
			throws IllegalArgumentException, IllegalAccessException,
			InvocationTargetException, InstantiationException,
			SecurityException, NoSuchMethodException {
        for (InteractiveEntity i: getUpgradeTree().getUsers()){
        	apply(i);
        }
	}
	
	@Override
	public void apply(InteractiveEntity requester) { //TODO: figure out which one should actually be called under Action
		requester.addMaxHealth(getUpgradeValue());
	}

}
