package vooga.towerdefense.factories.actionfactories;

import vooga.towerdefense.action.Action;
import vooga.towerdefense.gameelements.GameElement;

/**
 * @author Matthew Roy
 *
 */
public class DeathPackageFactory extends ActionFactory{
    
    /**
     * Default unit death
     * USES:
     * Health Attribute
     * Worth Attribute
     * Remove from map
     */
    public DeathPackageFactory() {
        super();
    }

    /**
     * 
     * @param e
     * @return 
     */
    @Override
    protected Action buildAction (GameElement e) {
        // TODO Auto-generated method stub
        return null;
    }

}
