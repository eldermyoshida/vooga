package vooga.towerdefense.factories.actionfactories;

import util.Sound;
import vooga.towerdefense.action.Action;
import vooga.towerdefense.action.SoundAction;
import vooga.towerdefense.gameElements.GameElement;

/**
 * @author Matthew Roy
 *
 */
public class SoundActionFactory extends ActionFactory {

    Sound mySound;
    
    public SoundActionFactory(String soundPath) {
        super();
        mySound = new Sound(soundPath);
    }
    
    /**
     * 
     * @param e
     * @return 
     */
    @Override
    protected Action buildAction (GameElement e) {
        return new SoundAction(mySound);
    }

}
