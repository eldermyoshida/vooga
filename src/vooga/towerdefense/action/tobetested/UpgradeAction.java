package vooga.towerdefense.action.tobetested;

import java.util.List;
import vooga.towerdefense.action.Action;

/**
 * 
 * Upgrades a unit or tower
 * TODO: Make this do something
 * 
 * @author Matthew Roy
 *
 */
public class UpgradeAction extends Action {
	List<UpgradeAction> myUpgradeHierarchy;
	
	public UpgradeAction(List<UpgradeAction> upgradeHierarchy){
		myUpgradeHierarchy = upgradeHierarchy;
	}

	public void checkUpgradeCondition() { }

    /**
     * 
     * @param elapsedTime 
     */
    @Override
    public void executeAction (double elapsedTime) {
        // TODO Auto-generated method stub
        
    }
}
