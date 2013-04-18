package vooga.towerdefense.gameElements;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import vooga.towerdefense.action.Action;
import vooga.towerdefense.attributes.AttributeConstants;
import vooga.towerdefense.attributes.AttributeManager;
import vooga.towerdefense.util.Location;
import vooga.towerdefense.util.Pixmap;
import vooga.towerdefense.gameElements.GameElement;

/**
 * GameElement projectile that can affect other game elements.
 * 
 */
public class Projectile extends GameElement {
	private GameElement myTarget;
	private GameElement myInitiator;

	public Projectile(Pixmap image, Dimension size, GameElement initiator,
			GameElement target, List<Action> actions,
			AttributeManager attributes) {
		super(image, initiator.getCenter(), size, attributes, actions);
		myTarget = target;
		myInitiator=initiator;

	}

	/*
	 * public Projectile (GameElement initiator, GameElement target,
	 * List<Action> actions) { super(DEFAULT_IMAGE, initiator.getCenter(),
	 * DEFAULT_SIZE, DEFAULT_ACTIONS); myAttributeManager =
	 * initiator.getAttributeManager();
	 * 
	 * }
	 * 
	 * public Projectile(Location spawn,GameElement target){
	 * super(DEFAULT_IMAGE,spawn,DEFAULT_SIZE,DEFAULT_ACTIONS); }
	 */
	public void update(double elapsedTime) {
		// to-do mostly needs to move towards target;
	}

	public GameElement getTarget() {

		return myTarget;
	}

	public void addTarget() {

	}

	public Location getAttackCenter() {
		return super.getCenter();
	}

}
