package vooga.rts.gamedesign.strategy.occupystrategy;

import java.util.ArrayList;
import java.util.List;

import vooga.rts.gamedesign.sprite.gamesprites.GameEntity;
import vooga.rts.gamedesign.sprite.gamesprites.interactive.units.Soldier;
import vooga.rts.gamedesign.sprite.gamesprites.interactive.units.Unit;

/**
 * 
 * This class implements OccupyStrategy and is used as an instance in 
 * interactives for objects that are able to occupy IOccupiables. The occupy 
 * method in this class will specify how the interactive will occupy the 
 * IOccupiable.
 * 
 * @author Ryan Fishel
 * @author Kevin Oh
 * @author Francesco Agosti
 * @author Wenshun Liu 
 *
 */
public class CanBeOccupied implements OccupyStrategy{
	public static final int DEFAULT_MAX_OCCUPIERS = 10;
	
	private List<Unit> myOccupiers;
	private List<String> myValidOccupierType;
	private int myMaxOccupiers;
	
	public CanBeOccupied() {
		myOccupiers = new ArrayList<Unit>();
		myValidOccupierType = new ArrayList<String>();
	}
	
	public void getOccupied(Unit u) {
		if (myOccupiers.size() < myMaxOccupiers) {
			u.setVisible(false);
			//TODO: make the unit not detectable. Consider move out of player's unit list.
			myOccupiers.add(u);
		}
	}
	
	public void addValidClassType(Unit validOccupier) {
		Class cls = validOccupier.getClass();
		String className = cls.getName();
		//System.out.println("class name that's added: " + className);
		myValidOccupierType.add(className);
	}
	
	private boolean verifyOccupier(Unit u) {
		Class cls = u.getClass();
		for (String s: myValidOccupierType) {
			while (cls != null) {
				String className = cls.getName();
				//System.out.println("class name to be compared: "+ className);
				if (className.equals(s)) {
					return true;
				}
				cls = cls.getSuperclass();
			}
		}
		return false;
	}
	
	/**
	 * TESTING FOR VERIFYING VALID OCCUPIER
	 * @param argus
	 */
	public static void main(String[] argus) {
		OccupyStrategy o = new CanBeOccupied();
		o.addValidClassType(new Unit());
		Soldier s = new Soldier();
		Unit u = new Unit();
		//System.out.println("Soldier: " + verifyOccupier(s));
		//System.out.println("Unit: " + verifyOccupier(u));
	}

}
