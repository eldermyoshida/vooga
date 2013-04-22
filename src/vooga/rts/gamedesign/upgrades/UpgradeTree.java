package vooga.rts.gamedesign.upgrades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import vooga.rts.action.Action;
import vooga.rts.gamedesign.sprite.gamesprites.GameEntity;
import vooga.rts.gamedesign.sprite.gamesprites.interactive.InteractiveEntity;
import vooga.rts.gamedesign.sprite.gamesprites.interactive.buildings.UpgradeBuilding;
import vooga.rts.gamedesign.state.MovementState;


/**
 * This class is the tree of upgrades that any object that can be upgraded will
 * hold. For example, every unit will have an upgrade tree (and each unit of
 * the same type will have the same upgrade tree). Upgrades are being stored
 * in a tree like structure because in some cases upgrades are specified in
 * certain branches so that buying a certain tier 1 upgrade does not
 * necessarily mean that all tier 2 upgrades are now available. For example
 * buying the tier 1 armor upgrade does not mean that the tier 2 weapon upgrade
 * is available (only the tier 2 armor upgrade would be available). If there
 * are multiple types of tier 1 upgrades, the root of the tree would not
 * contain an upgrade.
 * 
 * @author Ryan Fishel
 * @author Kevin Oh
 * @author Francesco Agosti
 * @author Wenshun Liu
 * 
 */
public class UpgradeTree {
    private UpgradeNode myHead;
    private List<UpgradeNode> myCurrentUpgrades;
    private List<InteractiveEntity> myUsers;
    private List<String> myUserTypes;
    private List<Action> myActions;

    public UpgradeTree () {
        myHead = new UpgradeNode();
        myCurrentUpgrades = new ArrayList<UpgradeNode>();
        myUsers = new ArrayList<InteractiveEntity>();
        myUserTypes = new ArrayList<String>();
        myActions = new ArrayList<Action>();
    }

    /**
     * Updates the list of current and next upgrades based on the given
     * UpgradeNode, which is newly activated
     * 
     * @param u
     */
    public void activateNode (UpgradeNode u) {
        myCurrentUpgrades.remove(u);
        if (!u.getChildren().isEmpty()) {
            for (UpgradeNode node : u.getChildren()) {
                myCurrentUpgrades.add(node);
            }
        }
    }

    /**
     * Updates the list of current and next upgrades. Only to be called when
     * upgradeTree is first created.
     */
    public void updateTreeStatus () {
        for (UpgradeNode u : myHead.getChildren()) {
            UpgradeNode current = u;
            while (!u.getChildren().isEmpty() && u.getChildren().get(0).getHasBeenUpgraded()) {
                current = current.getChildren().get(0);
            }
            if (!current.getChildren().isEmpty()) {
                current = current.getChildren().get(0);
                myCurrentUpgrades.add(current);
            }
        }
        updateActions();
    }
    
    private void updateActions() {
    	for (UpgradeNode currentUpgrade: myCurrentUpgrades) {
    		
    	}
    }

    public void addBranch (String branchName) {
        UpgradeNode branch = new UpgradeNode(this, branchName, 0, 0);
        myHead.addChild(branch);
    }

    public UpgradeNode findNode (String upgradeName) {
        UpgradeNode current = myHead;
        while (!current.getChildren().isEmpty()) {
            for (UpgradeNode u : current.getChildren()) {
                if (u.getUpgradeName().equals(upgradeName)) {
                    return u;
                }
                else {
                    current = u;
                }
            }
        }
        return null;
    }

    /**
     * Finds the most advanced upgrade has been made in the giving upgrade type.
     * 
     * @param upgradeType
     * @return
     */
    public UpgradeNode findCurrent (String upgradeType) {
        UpgradeNode current = new UpgradeNode();
        for (UpgradeNode n : myHead.getChildren()) {
            if (n.getUpgradeName().equals(upgradeType)) {
                current = n;
            }
        }

        while (current != null) {
            if (current.getHasBeenUpgraded()) {
                current = current.getChildren().get(0);
            }
            else {
                break;
            }
        }
        return current;
    }

    public void addUserType(Object newUserType) {
    	myUserTypes.add(newUserType.getClass().getName());
    }
    
    public List<InteractiveEntity> getUsers () {
        return myUsers;
    }

    public void verifyAndAddUser (InteractiveEntity i) {
        if (validUser(i)){
        	myUsers.add(i);
        }
    }
    
    private boolean validUser(InteractiveEntity potentialUser) { //TODO: could have put this into util
    	Class cls = potentialUser.getClass();
        for (String s : myUserTypes) {
            while (cls != GameEntity.class) {
                String className = cls.getName();
                if (className.equals(s)) {
                    return true;
                }
                cls = cls.getSuperclass();
            }
        }
        return false;
    }

    public List<UpgradeNode> getCurrentUpgrades () {
        return myCurrentUpgrades;
    }

    public UpgradeNode getHead () {
        return myHead;
    }
}
