package vooga.rts.gamedesign.strategy.vooga.rts.gamedesign.strategy.upgradestrategy;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import vooga.rts.action.InteractiveAction;
import vooga.rts.commands.Command;
import vooga.rts.gamedesign.sprite.gamesprites.interactive.InteractiveEntity;
import vooga.rts.gamedesign.upgrades.UpgradeNode;
import vooga.rts.gamedesign.upgrades.UpgradeTree;

public class CanUpgrade implements UpgradeStrategy{
	private UpgradeTree myUpgradeTree;
	
	public CanUpgrade(UpgradeTree upgradeTree) {
		myUpgradeTree = upgradeTree;
	}
	
	public void createUpgradeActions(final InteractiveEntity entity) {
		for (final UpgradeNode upgrade: myUpgradeTree.getCurrentUpgrades()) {
			entity.addAction("upgrade: " + upgrade.getUpgradeName(), new InteractiveAction(entity) {
				@Override
	            public void update (Command command) {
	            }

	            @Override
	            public void apply () {
	                upgrade.apply(entity);
	            }
			});
		}
	}
}
