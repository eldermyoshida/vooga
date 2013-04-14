package vooga.towerdefense.gameElements;

import java.awt.Dimension;
import java.util.List;

import vooga.towerdefense.action.AbstractAction;
import vooga.towerdefense.action.ComboAttackAction;
import vooga.towerdefense.action.Targetable;
import vooga.towerdefense.util.Location;
import vooga.towerdefense.util.Pixmap;
import vooga.towerdefense.util.Vector;

/**
 * Basic unit to help test Basic tower.
 * 
 * @author XuRui
 *
 */
public class BasicUnit extends Unit implements Targetable {

	public BasicUnit(Location destination, Pixmap image, Location center,
			Dimension size, Vector velocity, Attributes attributes,
			List<AbstractAction> actions) {
		super(destination, image, center, size, velocity, attributes, actions);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void takeDamage(double attack) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAttackerType(ComboAttackAction attack) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getAttackerType() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isRightAttacker(ComboAttackAction attack) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAlive() {
		// TODO Auto-generated method stub
		return false;
	}

}
