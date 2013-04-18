package vooga.rts.gamedesign.upgrades;

import vooga.rts.gamedesign.sprite.InteractiveEntity;

public class DamageUpgradeNode extends UpgradeNode {

	public DamageUpgradeNode(UpgradeTree upgradeTree, String upgradeType, int upgradeValue){
		super(upgradeTree, upgradeType, upgradeValue);
	}
	
	@Override
	public void apply(InteractiveEntity requester) {
		// Currently no need to check for can or cannot attack and if weapon's empty. Watch for updates
		requester.getAttackStrategy().getCurrentWeapon().addDamage(getUpgradeValue());
	}
}
