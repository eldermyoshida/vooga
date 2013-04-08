package vooga.rts.gamedesign.upgrades;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import vooga.rts.gamedesign.sprite.rtsprite.interactive.Interactive;

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

    private String myUpgradeType;
    private int myUpgradeValue;
    private String myUpgradeObject;
    private boolean myHasBeenUpgraded;
    private ArrayList<UpgradeNode> myChildren; //set to list for the Head.

    public UpgradeNode(){
        this(null, null, 0);
    }

    public UpgradeNode(String upgradeType, String upgradeObject, int upgradeValue){
        myUpgradeType = upgradeType;
        myChildren = new ArrayList<UpgradeNode>();
        myHasBeenUpgraded = false;
        myUpgradeObject = upgradeObject;
        myUpgradeValue = upgradeValue;
    }

    /**
     * Applies the effect of this Upgrade type to the given interactive.
     * @param interactive
     * @throws InvocationTargetException 
     * @throws IllegalAccessException 
     * @throws IllegalArgumentException 
     * @throws InstantiationException 
     * @throws NoSuchMethodException 
     * @throws SecurityException 
     */
    public void apply(Interactive interactive) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, InstantiationException, SecurityException, NoSuchMethodException {
    }

    public ArrayList<UpgradeNode> getChildren(){
        return myChildren;
    }

    public String getUpgradeType(){
        return myUpgradeType;
    }

    public boolean getHasBeenUpgraded(){
        return myHasBeenUpgraded;
    }

    public String getUpgradeObject(){
        return myUpgradeObject;
    }

    public int getUpgradeValue(){
        return myUpgradeValue;
    }
}