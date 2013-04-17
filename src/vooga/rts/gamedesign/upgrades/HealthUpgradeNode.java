package vooga.rts.gamedesign.upgrades;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import vooga.rts.gamedesign.sprite.GameEntity;
import vooga.rts.gamedesign.sprite.InteractiveEntity;

public class HealthUpgradeNode extends UpgradeNode {
	
	public HealthUpgradeNode(UpgradeTree upgradeTree, int id, String upgradeType, int upgradeValue){
		super(upgradeTree, id, upgradeType, upgradeValue);
	}
	
	/**
	 * Applies the upgrade to an individual InteractiveEntity by calling
	 * related method.
	 */
	@Override
	public void apply(InteractiveEntity requester) {
		requester.addMaxHealth(getUpgradeValue());
	}

}
