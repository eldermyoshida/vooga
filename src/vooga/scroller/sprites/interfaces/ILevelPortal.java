package vooga.scroller.sprites.interfaces;

import vooga.scroller.sprites.superclasses.Player;

/**
 * This interface should be implemented by any Level Portal. 
 * 
 * @author Jay Wang
 */
public interface ILevelPortal extends ISprite {

    /** 
     * If a player collides with a level portal, this method should be called on the 
     * level portal - goToNextLevel. This method would need the player passed in as a 
     * parameter. 
     */
    public void goToNextLevel (Player player);
}
