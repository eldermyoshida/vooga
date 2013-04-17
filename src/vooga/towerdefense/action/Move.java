package vooga.towerdefense.action;

import vooga.towerdefense.attributes.Attribute;
import vooga.towerdefense.gameElements.GameElement;

/**
 * Uses the sprite move method
 * @author Matthew Roy
 *
 */
public class Move extends Action {
    
    private Attribute myMovespeed;
    private Attribute myDirection;

    /**
     * @param initiator
     */
    public Move (GameElement initiator, Attribute movespeed, Attribute direction) {
        super(initiator);
        myMovespeed = movespeed;
        myDirection = direction;
    }
    
    @Override
    public void update(double elapsedTime) {
        getInitiator().setVelocity(myDirection.getValue(), myMovespeed.getValue());
        getInitiator().getVelocity().scale(elapsedTime);
        getInitiator().translate(getInitiator().getVelocity());
    }

}
