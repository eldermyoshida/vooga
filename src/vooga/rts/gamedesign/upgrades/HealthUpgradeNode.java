package vooga.rts.gamedesign.upgrades;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import vooga.rts.gamedesign.sprite.InteractiveEntity;

public class HealthUpgradeNode extends UpgradeNode {
	public static final String HEALTH_UPGRADE_METHOD_NAME = "upgradeHealth";
									//TODO: check method name
	public static final Class[] HEALTH_UPGRADE_METHOD_PARAM = new Class[] {int.class};
	
	public HealthUpgradeNode(int id, String upgradeType, String upgradeObject, int upgradeValue){
		super(id, upgradeType, upgradeObject, upgradeValue);
	}
	
	
	/**
	 * Applies the health upgrade by the method that updates health.
	 */
	@Override
	public void apply(List<InteractiveEntity> requester)
			throws IllegalArgumentException, IllegalAccessException,
			InvocationTargetException, InstantiationException,
			SecurityException, NoSuchMethodException {
        for (InteractiveEntity i: requester){
        	Class thisClass = i.getClass(); //TODO: need to check path (in case in super class)
            Class[] params = HEALTH_UPGRADE_METHOD_PARAM;
            Method thisMethod = thisClass.getDeclaredMethod(HEALTH_UPGRADE_METHOD_NAME, params);
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
	public static void main (String[] args) throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
    	//TEST reading file - build tree - upgrade property
	}
}
