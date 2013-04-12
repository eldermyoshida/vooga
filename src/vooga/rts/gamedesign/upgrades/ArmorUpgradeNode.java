package vooga.rts.gamedesign.upgrades;

import java.awt.Dimension;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import vooga.rts.gamedesign.sprite.rtsprite.interactive.Interactive;
import vooga.rts.gamedesign.sprite.rtsprite.interactive.units.Soldier;
import vooga.rts.util.Location;
import vooga.rts.util.Pixmap;
import vooga.rts.util.Sound;

public class ArmorUpgradeNode extends UpgradeNode {

    public ArmorUpgradeNode(String upgradeType, String upgradeObject, int upgradeValue){
       super(upgradeType, upgradeObject, upgradeValue);
    }
    
    @Override
    public void apply(Interactive interactive) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, InstantiationException, SecurityException, NoSuchMethodException {        
        if (interactive instanceof Soldier) {
            interactive.setHealth(myValue);
        }
        
        Class thisClass = interactive.getClass();
        //System.out.println(thisClass.getName());
        //Object iClass = thisClass.newInstance();
        Class[] params = new Class[] {int.class};
        //Object[] args = new Object[] {};
        Method thisMethod = thisClass.getDeclaredMethod("upgradeHealth", params);
        thisMethod.invoke(interactive, getUpgradeValue());
    }
}
