package vooga.towerdefense.action;

import vooga.towerdefense.gameElements.GameElement;
import vooga.towerdefense.util.Location;

/**
 * 
 * Creates a projectile aimed at a target
 * @author Matthew Roy
 *
 */
public class LaunchProjectile extends Action {

    /**
     * @param initiator
     */
    public LaunchProjectile (GameElement initiator, Location startLocation) {
        super(initiator);
        
    }
    
    
    
    

    /**
     * Overrides from superclasses
     * @param elapseTime 
     */
    @Override
    public void executeAction (double elapseTime) {
        // TODO Auto-generated method stub

    }

    /**
     * Overrides from superclasses
     * @param elapsedTime 
     */
    @Override
    public void update (double elapsedTime) {
        
    }

}
