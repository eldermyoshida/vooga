package vooga.towerdefense.action.attack;
import vooga.towerdefense.action.TargetedAction;
import vooga.towerdefense.attributes.Attribute;
import vooga.towerdefense.factories.elementfactories.GameElementFactory;
import vooga.towerdefense.gameelements.GameElement;
import vooga.towerdefense.model.GameMap;
import util.Location;

/**
 * Creates projectiles aimed at a target. Targets info pass on to projectiles created.
 * Projectiles created gave its own follow up action predfined by XML.
 * 
 * @author Xu Rui
 */
public class LaunchProjectile extends TargetedAction {

	private Attribute myUnitsRemaining;
	private Attribute myCooldown;
	private GameElementFactory myProjectileFactory;
	
	private Location mySource;
	private GameMap myMap;
	private double myTimer;
	private boolean targetDetectionOn; //true if fire only upon target detection

	public LaunchProjectile(Attribute cooldown, Attribute numProjectiles,
			Location startLocation, GameElementFactory projectileFactory,
			GameMap map, boolean targetdetection) {
		super();
		myCooldown = cooldown;
		myUnitsRemaining = numProjectiles;
		mySource = startLocation;
		myProjectileFactory = projectileFactory;
		myMap = map;
		myTimer = 0;
		targetDetectionOn = targetdetection;
	}

	@Override
	public void update(double elapsedTime) {
		setEnabled(checkLaunchCondition());
		if (isEnabled()){
			executeAction(elapsedTime);
		}
	}

	@Override
	public void executeAction(double elapsedTime) {
		if (myTimer > myCooldown.getValue()) {
			spawnProjectile();
			myTimer = 0;
		}
		myTimer += elapsedTime;
	}
	
	/**
	 * Returns true only if remaining projectiles >0 and there are targets.
	 * 
	 * @return
	 */
	public boolean checkLaunchCondition(){
		boolean checker = !(myUnitsRemaining.getValue()<=0);
		if (targetDetectionOn){
			checker = checker && !getTargets().isEmpty();
		}
		return checker;
	}
	
	/**
	 * Creates a projectile with action of shooting at targets.
	 * 
	 * @param elapsedTime
	 */
	public void spawnProjectile() {
		GameElement projectile = myProjectileFactory.createElement(mySource);
		for (TargetedAction a : projectile.getTargetedActions()) {
			a.setSingleTarget(getSingleTarget());
		}
		myMap.addGameElement(projectile);
		myUnitsRemaining.modifyValue(-1);
	}
}
