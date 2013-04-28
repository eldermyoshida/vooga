package vooga.towerdefense.action;

import vooga.towerdefense.factories.elementfactories.GameElementFactory;
import vooga.towerdefense.gameelements.GameElement;
import vooga.towerdefense.model.GameMap;

/**
 * Creates a new game element
 * 
 * @author Matthew Roy
 *
 */
public class CreateElement extends Action {
    
    private GameElementFactory myFactory;
    private GameElement myCreator;
    private GameMap myMap;
    
    public CreateElement(GameMap map, GameElement creator, GameElementFactory factory) {
        super();
        myMap = map;
        myCreator = creator;
        myFactory = factory;
    }

    /**
     * 
     * @param elapsedTime 
     */
    @Override
    public void executeAction (double elapsedTime) {
        GameElement element = myFactory.createElement(myCreator.getCenter());
        myMap.addGameElement(element);
    }

}
