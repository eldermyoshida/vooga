package vooga.rts.gamedesign.upgrades;

import vooga.rts.gamedesign.Weapon;
import vooga.rts.gamedesign.sprite.InteractiveEntity;
import vooga.rts.gamedesign.strategy.attackstrategy.CanAttack;

public class AttackUpgradeNode extends UpgradeNode {
	
	/**
	 * 
	 * @param upgradeTree
	 * @param id
	 * @param upgradeType
	 * @param upgradeValue 0 represents changing from Cannot to CanAttack; positive
	 * values represent changing in range in Weapon that is belonged to CanAttack.
	 */
	//TODO: now upgradeValue is only Integer. See if need to be generic based on the need.
	public AttackUpgradeNode(UpgradeTree upgradeTree, int id, String upgradeType, int upgradeValue){
		super(upgradeTree, id, upgradeType, upgradeValue);
	}
	
	/**
	 * Applies the upgrade to an individual InteractiveEntity by calling
	 * related method.
	 */
	@Override
	public void apply(InteractiveEntity requester) {
		if (getUpgradeValue() == 1) {
			requester.setAttackStrategy(new CanAttack());
		}else {
			//TODO: now upgrades the range for all weapons. See if this is the case
			for (Weapon w: requester.getAttackStrategy().getWeapons()) {
				w.addRange(getUpgradeValue());
			}
		}
	}

}
