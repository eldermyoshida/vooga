package vooga.scroller.sprites.interfaces;

import vooga.scroller.sprites.superclasses.Player;

/**
 * This is the interface your player(s) need to implement. Most collisions will be a collision 
 * between IPlayer and something. 
 * @author Jay Wang
 *
 */
public interface IPlayer extends ISprite {
    
    /**
     * This method is called when a collision between a Player and another sprite merits 
     * the need to change the score of the Player. Send in the value you want to change your 
     * player's score by. 
     * @param increment
     */
    public void incrementScore(int increment);
    
    /** 
     * This method is called when a collision between a Player and another sprite merits 
     * the need to decrement the health of the player. 
     * @param damage
     */
    public void takeHit(int damage);
    
    /** 
     * This method is called when the caller needs to know how much damage a player can inflict. 
     * @return int - the hit damage the player can do 
     */
    public int getHit ();

    
    /** 
     * This method is called ONLY when the player and a level portal collide. That collision needs to get 
     * the player because it needs to send the player into the level portal method goToNextLevel(). 
     * @return player
     */
    public Player getPlayer ();

     
}
