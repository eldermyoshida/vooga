package vooga.towerdefense.action;

import vooga.towerdefense.factories.elementfactories.GameElementFactory;

/**
 * @author Matthew Roy
 *
 */
public class CreateElement extends Action {
    
    private GameElementFactory myFactory;
    
    public CreateElement(GameElementFactory factory) {
        super();
        myFactory = factory;
    }

    /**
     * 
     * @param elapsedTime 
     */
    @Override
    public void executeAction (double elapsedTime) {
        // TODO Auto-generated method stub

    }

}
