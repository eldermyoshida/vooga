package vooga.scroller.sprites.interfaces;

import vooga.scroller.sprites.superclasses.Player;

public interface IPlayer {
    
    public Player getPlayer(); 
    public void incrementScore(int increment);
    public void takeHit(int damage);
     
}
