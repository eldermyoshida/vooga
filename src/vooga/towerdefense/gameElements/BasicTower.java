package vooga.towerdefense.gameElements;

import java.awt.Dimension;
import java.util.List;

import vooga.towerdefense.action.AbstractAction;
import vooga.towerdefense.action.Attacker;
import vooga.towerdefense.action.InfoBridge;
import vooga.towerdefense.action.Targetable;
import vooga.towerdefense.action.Upgradable;
import vooga.towerdefense.util.Location;
import vooga.towerdefense.util.Pixmap;

/**
 * Basic tower that is capable of shooting a unit. 
 * 
 * @author XuRui
 *
 */
public class BasicTower extends GameElement implements Attacker, InfoBridge {

	List<AbstractAction> myActions;
	Attributes myAttributes;
	
	public BasicTower(Pixmap image, Location center, Dimension size,
			Attributes attributes, List<AbstractAction> actions) {
		super(image, center, size, attributes, actions);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Unit[] getUnits() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GameElement[] getGameElements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Targetable[] getTargetables() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Upgradable[] getUpgradables() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Targetable[] getTargetsWithinRadiusOfGivenLocation(Location source,
			double radius, int howMany) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addGameElement(Projectile projectile) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getAttackRadius() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNumberOfTargets() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getAttackDamage() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Targetable getTarget() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addTarget() {
		// TODO Auto-generated method stub
		
	}

}
