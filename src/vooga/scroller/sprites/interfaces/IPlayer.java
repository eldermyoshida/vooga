package vooga.scroller.sprites.interfaces;

import util.Vector;
import vooga.scroller.sprites.superclasses.Player;

public interface IPlayer extends ISprite {
    
    public void incrementScore(int increment);
    public void takeHit(int damage);
    public double getX ();
    public int getHit ();
    public void addVector (Vector r);
    public Vector getVelocity ();
    public double getY ();
    public double getWidth ();
    public void setCenter (double d, double y);
    public double getHeight ();
    
    public Player getPlayer ();

     
}
