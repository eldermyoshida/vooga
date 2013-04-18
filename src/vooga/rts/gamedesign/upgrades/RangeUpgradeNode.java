package vooga.rts.gamedesign.upgrades;

import vooga.rts.gamedesign.sprite.InteractiveEntity;

public class RangeUpgradeNode extends UpgradeNode {
	public RangeUpgradeNode(UpgradeTree upgradeTree, String upgradeType, int upgradeValue){
		super(upgradeTree, upgradeType, upgradeValue);
	}
	
	@Override
	public void apply(InteractiveEntity requester) {
		requester.getAttackStrategy().getCurrentWeapon().addRange(getUpgradeValue());
	}
}
