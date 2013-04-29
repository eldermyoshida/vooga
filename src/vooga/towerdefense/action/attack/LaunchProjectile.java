package vooga.towerdefense.action.attack;

import java.util.List;

import vooga.towerdefense.action.TargetedAction;
import vooga.towerdefense.action.waveactions.WaveAction;
import vooga.towerdefense.attributes.Attribute;
import vooga.towerdefense.factories.elementfactories.GameElementFactory;
import vooga.towerdefense.gameelements.GameElement;
import vooga.towerdefense.model.GameMap;
import util.Location;

/**
 * Creates a projectile aimed at a target, target needs to be predefined by FindTarget action.
 * Projectile created continues the follow up actions.
 * 
 * @author Matthew Roy
 * @author Zhen Gou
 * @author Xu Rui
 */
public class LaunchProjectile extends TargetedAction {

	private int myUnitsRemaining;
	private int myCooldown;
	private int myClock;
	private GameElementFactory myProjectileFactory;
	private Location myStart;
	private GameMap myMap;
	//private List<GameElement> myTargets;

    public LaunchProjectile (int cooldown, int numProjectiles, Location startLocation, GameElementFactory projectileFactory, GameMap map) {
    	//super((int)cooldown.getValue(), (int) numProjectiles.getValue(), projectileFactory, map);
		super();
		myUnitsRemaining = numProjectiles;
		myCooldown = cooldown;
		myClock = 0;
		myProjectileFactory = projectileFactory;
    	myStart = startLocation;
    	myMap = map;
    }

    /**
     * Creates a projectile with action of shooting at targets. 
     * 
     * @param elapsedTime 
     */
    public void spawnUnit() {
    	System.out.println("spawning unit");
    	//myTargets = getTargets();
        GameElement projectile = myProjectileFactory.createElement(myStart);
        //System.out.printf("projectile targeted actions size %d\n", projectile.getTargetedActions().size());
        for (TargetedAction a: projectile.getTargetedActions()){
        	a.setTarget(getTargets().remove(0));
        	System.out.printf("passed on to projectile targets size %d\n", getTargets().size());
        }
        myMap.addGameElement(projectile);
        myUnitsRemaining--;
    }
    
    @Override
    public void update(double elapsedTime){
    	setEnabled(true);
    	executeAction(elapsedTime);
    }
	@Override
	public void executeAction(double elapsedTime) {
		System.out.printf("launchprojectile targets are %d\n\n", getTargets().size());
		if (myUnitsRemaining == 0 || getTargets().isEmpty()) {
			setEnabled(false);
		} else if (myClock > myCooldown) {
			spawnUnit();
			myClock = 0;
		}
		myClock += elapsedTime;
		
		if(myUnitsRemaining <= 0) {
			setEnabled(false);
		}	}
}
