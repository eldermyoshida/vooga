package vooga.rts.gamedesign.upgrades;

import java.awt.Dimension;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import vooga.rts.gamedesign.sprite.InteractiveEntity;
import vooga.rts.gamedesign.sprite.rtsprite.interactive.units.Soldier;
import vooga.rts.util.Location;
import vooga.rts.util.Pixmap;
import vooga.rts.util.Sound;

public class ArmorUpgradeNode extends UpgradeNode {

    public ArmorUpgradeNode(int id, String upgradeType, String upgradeObject, int upgradeValue){
       super(id, upgradeType, upgradeObject, upgradeValue);
    }
    
    @Override
    public void apply(List<InteractiveEntity> requester) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, InstantiationException, SecurityException, NoSuchMethodException {
        for (InteractiveEntity i: requester){
        	Class thisClass = i.getClass();
            //System.out.println(thisClass.getName());
            //Object iClass = thisClass.newInstance();
            Class[] params = new Class[] {int.class};
            //Object[] args = new Object[] {};
            Method thisMethod = thisClass.getDeclaredMethod("upgradeHealth", params);
            thisMethod.invoke(i, getUpgradeValue());
        }
    }
    
    /**
	 * Testing purpose.
	 * @param args
	 * @throws IllegalArgumentException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws InstantiationException
	 * @throws NoSuchMethodException
	 */
	/**public static void main (String[] args) throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
    	ArmorUpgradeNode a = new ArmorUpgradeNode();
		Interactive i = new Soldier(new Pixmap("soldier.png"), new Location(0,0), new Dimension(50, 50), new Sound("pikachu.wav"), 0, 0);
    	System.out.println(i.getHealth());
    	a.apply(i);
    	System.out.println(i.getHealth());
	}*/
}
