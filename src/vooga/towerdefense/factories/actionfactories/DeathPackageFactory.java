<<<<<<< HEAD
package vooga.towerdefense.factories.actionfactories;

import vooga.towerdefense.action.Action;
import vooga.towerdefense.gameelements.GameElement;
import vooga.towerdefense.model.GameMap;
import vooga.towerdefense.model.Player;

/**
 * @author Matthew Roy
 *
 */
public class DeathPackageFactory extends ActionFactory{
    
       
    ActionFactory myDeath;
    ActionFactory myPlayerValue;
    ActionFactory myRemoveElement;
    
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
    
    
    public void initialize (GameMap map, Player player) {
        super.initialize(map, player);
        makeComboFactories();
        myDeath.initialize(map, player);
        myPlayerValue.initialize(map, player);
        myRemoveElement.initialize(map, player);
    }
    
    
    public void makeComboFactories() {
        myDeath = new OnDeathFactory();
        myRemoveElement = new RemoveElementFactory();
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
=======
package vooga.towerdefense.factories.actionfactories;

import vooga.towerdefense.action.Action;
import vooga.towerdefense.action.actionlist.OnDeath;
import vooga.towerdefense.gameelements.GameElement;
import vooga.towerdefense.model.GameMap;
import vooga.towerdefense.model.Player;

/**
 * @author Matthew Roy
 *
 */
public class DeathPackageFactory extends ActionFactory{
    
       
    ActionFactory myDeath;
    ActionFactory myPlayerValue;
    ActionFactory myRemoveElement;
    
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
    
    
    public void initialize (GameMap map, Player player) {
        super.initialize(map, player);
        makeComboFactories();
        myDeath.initialize(map, player);
        myPlayerValue.initialize(map, player);
        myRemoveElement.initialize(map, player);
    }
    
    
    public void makeComboFactories() {
        myDeath = new OnDeathFactory();
        myRemoveElement = new RemoveElementFactory();
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
>>>>>>> 5e19c39dff81bf6c2de831c89190c05d84f454ad
