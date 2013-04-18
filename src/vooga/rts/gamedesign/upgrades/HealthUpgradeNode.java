package vooga.rts.gamedesign.upgrades;

import vooga.rts.gamedesign.sprite.InteractiveEntity;

public class HealthUpgradeNode extends UpgradeNode {
	
	public HealthUpgradeNode(UpgradeTree upgradeTree, String upgradeType, int upgradeValue){
		super(upgradeTree, upgradeType, upgradeValue);
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
