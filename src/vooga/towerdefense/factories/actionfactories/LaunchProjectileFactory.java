package vooga.towerdefense.factories.actionfactories;

import java.util.Map;

import vooga.towerdefense.action.Action;
import vooga.towerdefense.action.attack.LaunchProjectile;
import vooga.towerdefense.factories.ActionAnnotation;
import vooga.towerdefense.factories.elementfactories.GameElementFactory;
import vooga.towerdefense.gameelements.GameElement;

/**
 * This is an action factory that builds a LaunchProjectile action.
 * 
 * @author XuRui
 * 
 */

public class LaunchProjectileFactory extends ActionFactory {

	/*
	 * private String myFactoryName; private String myNumProjectile; private
	 * String myCoolDownReference;
	 */
	private int myNumUnits;
	private int myCooldown;
	private String myFactory;

	/**
	 * constructor
	 * 
	 * @param factory
	 */
	public LaunchProjectileFactory(
			@ActionAnnotation(name = "projectile", value = "name") String factory,
			@ActionAnnotation(name = "num_of_projectile", value = "attribute") String numUnits,
			@ActionAnnotation(name = "cooldown", value = "attribute") String cooldown) {
		super();
		myNumUnits = Integer.parseInt(numUnits);
		myCooldown = Integer.parseInt(cooldown);
		myFactory = factory;
		// myFactoryName = factory;
		// myNumProjectile = numProjectile;
		// myCoolDownReference = coolDownReference;
	}

	/**
	 * Builds a LaunchProjectile action with GameElementFactory already added
	 * into corresponding attribute manager.
	 */
	@Override
	protected Action buildAction(GameElement e) {
		// return new
		// LaunchProjectile(e.getAttributeManager().getAttribute(myCoolDownReference),
		// e.getAttributeManager().getAttribute(myNumProjectile), e.getCenter(),
		// e
		// .getAttributeManager().getGameElementFactory(myFactoryName),
		// getMap());
		return new LaunchProjectile( myCooldown, myNumUnits,e.getCenter(), e
				.getAttributeManager().getGameElementFactory(myFactory),
				getMap());
	}

}
