package vooga.rts.gamedesign.upgrades;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import vooga.rts.gamedesign.Weapon;
import vooga.rts.gamedesign.sprite.InteractiveEntity;

public class DamageUpgradeNode extends UpgradeNode {

	public DamageUpgradeNode(UpgradeTree upgradeTree, int id, String upgradeType, String upgradeObject, int upgradeValue){
		super(upgradeTree, id, upgradeType, upgradeObject, upgradeValue);
	}
	
	/**
	 * Applies the damage upgrade by the method that updates damage.
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
	public void apply(InteractiveEntity requester) {
		if (requester.getAttackStrategy().getCanAttack() && !requester.getAttackStrategy().getWeapons().isEmpty()){
			requester.getAttackStrategy().getCurrentWeapon().addDamage(getUpgradeValue());
		}
	}
}
