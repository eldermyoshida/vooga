package vooga.rts.gamedesign.upgrades;

import vooga.rts.gamedesign.sprite.gamesprites.interactive.InteractiveEntity;


public class DamageUpgradeNode extends UpgradeNode {

    public DamageUpgradeNode (UpgradeTree upgradeTree,
                              String upgradeType,
                              int upgradeValue,
                              int costedResourceAmount) {
        super(upgradeTree, upgradeType, upgradeValue, costedResourceAmount);
    }

    @Override
    public void upgrade (InteractiveEntity requester) {
        //requester.getAttackStrategy().getCurrentWeapon().addDamage(getUpgradeValue());
    	getReflectionHelper().changeValue("myDamage",
    			requester.getAttackStrategy().getCurrentWeapon().getProjectile(),
    			getUpgradeValue());
    }
}
