package vooga.rts.gamedesign.strategy.occupystrategy;

import java.util.ArrayList;
import java.util.List;

import vooga.rts.action.InteractiveAction;
import vooga.rts.commands.Command;
import vooga.rts.gamedesign.sprite.gamesprites.GameEntity;
import vooga.rts.gamedesign.sprite.gamesprites.interactive.InteractiveEntity;
import vooga.rts.gamedesign.sprite.gamesprites.interactive.buildings.Building;
import vooga.rts.gamedesign.sprite.gamesprites.interactive.units.Soldier;
import vooga.rts.gamedesign.sprite.gamesprites.interactive.units.Unit;
import vooga.rts.gamedesign.state.DetectableState;
import vooga.rts.util.Location3D;

/**
 * 
 * This class implements OccupyStrategy and is used as an instance in 
 * interactives for objects that can be occupied by types of Units specified.
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
	private int myOccupierID;
	
	public CanBeOccupied() {
		myOccupiers = new ArrayList<Unit>();
		myValidOccupierType = new ArrayList<String>();
		myMaxOccupiers = DEFAULT_MAX_OCCUPIERS;
		myOccupierID = 0;
	}

	public void createOccupyActions(final InteractiveEntity entity) {
		entity.addAction("be occupied!", new InteractiveAction(entity) {
			@Override
			public void update(Command command) {
			}
			
			@Override
			public void apply(InteractiveEntity i) {
				System.out.println("Goes here!");
				if (myOccupiers.size() < myMaxOccupiers && verifyOccupier(entity, (Unit)i)) {
					System.out.println("Verified!!");
					//i.setVisible(false);
					//i.getEntityState().setDetectableState(DetectableState.NOTDETECTABLE);
					if (myOccupierID == 0) {
						myOccupierID = i.getPlayerID();
					}
					myOccupiers.add((Unit)i);
					entity.setChanged();
					entity.notifyObservers(i);
				}
			}

			@Override
			public void apply() {
				return;
			}
		});
		
		entity.addAction("puke all I have", new InteractiveAction(entity) {
			@Override
			public void update(Command command) {
			}

			@Override
			public void apply() {
				List<Unit> occupiers = myOccupiers;
				myOccupierID = 0;
				myOccupiers = new ArrayList<Unit>();
				for (Unit u: occupiers) {
					u.getEntityState().setDetectableState(DetectableState.NOTDETECTABLE);
					u.setVisible(false);
					//u.setVisible(true);
					//u.setWorldLocation(new Location3D());
					entity.setChanged();
					entity.notifyObservers(u);
				}
			}
		});
	}
	
	public void addValidClassType(Unit validOccupier) {
		Class cls = validOccupier.getClass();
		String className = cls.getName();
		myValidOccupierType.add(className);
	}
	
	private boolean verifyOccupier(GameEntity entity, InteractiveEntity occupier) {
		Class cls = occupier.getClass();
		if (myOccupierID != 0 && myOccupierID != occupier.getPlayerID()) {
			return false;
		}
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
	
	public void setOccupierID(int id) {
		myOccupierID = id;
	}
	
	public int getOccupierID() {
		return myOccupierID;
	}
	
	public List<Unit> getOccupiers() {
		return myOccupiers;
	}
	
	public void setOccupiers(ArrayList<Unit> u) {
		myOccupiers = u;
	}
	
	public int getMaxOccupiers() {
		return myMaxOccupiers;
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
