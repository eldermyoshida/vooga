package vooga.rts.gamedesign.upgrades;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import vooga.rts.gamedesign.sprite.gamesprites.interactive.InteractiveEntity;
import vooga.rts.player.Player;


/**
 * This class specifies an upgrade and is used to apply the upgrade to the
 * object that is being upgraded.
 * 
 * @author Ryan Fishel
 * @author Kevin Oh
 * @author Francesco Agosti
 * @author Wenshun Liu
 * 
 */
public class UpgradeNode {

    private UpgradeTree myUpgradeTree;
    private Map<String, Integer> myCost;
    private String myUpgradeName;
    private int myUpgradeValue;
    private boolean myHasBeenUpgraded;
    private List<UpgradeNode> myChildren; // set to list for the Head.

    public UpgradeNode () {
        this(null, null, 0, 0);
    }

    public UpgradeNode (UpgradeTree upgradeTree,
                        String upgradeName,
                        int upgradeValue,
                        int costedResourceAmount) {
        myCost = new HashMap<String, Integer>();
        myUpgradeTree = upgradeTree;
        myUpgradeName = upgradeName;
        myChildren = new ArrayList<UpgradeNode>();
        myHasBeenUpgraded = false;
        myUpgradeValue = upgradeValue;
        myCost = new HashMap<String, Integer>();
        myCost.put("resource", costedResourceAmount); // TODO: Deal with cost
    }

    public void apply (InteractiveEntity requester) {
    	upgrade(requester);
    	myUpgradeTree.activateNode(this, requester);
    	return;
    }

    public void upgrade(InteractiveEntity requester) {
    	return;
    	//TODO: add to subclasses
    }
    
    public boolean validUpdate (Player player) {
        /*
         * for (String resourceType : myCost.keySet()) {
         * if (player.getIndividualResourceManager().getAmount(resourceType) < myCost
         * .get(resourceType)) {
         * return false;
         * }
         * }
         */
        return true;
    }

    public List<UpgradeNode> getChildren () {
        return myChildren;
    }

    public void addChild (UpgradeNode upgrade) {
        myChildren.add(upgrade);
    }

    public UpgradeTree getUpgradeTree () {
        return myUpgradeTree;
    }

    public String getUpgradeName () {
        return myUpgradeName;
    }

    public boolean getHasBeenUpgraded () {
        return myHasBeenUpgraded;
    }

    public int getUpgradeValue () {
        return myUpgradeValue;
    }

    public Map<String, Integer> getCost () {
        return myCost;
    }
}
