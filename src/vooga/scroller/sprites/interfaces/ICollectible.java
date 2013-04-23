package vooga.scroller.sprites.interfaces;

/**
 * 
 * 
 * @author Jay Wang
 */
public interface ICollectible extends ISprite {
     
    public int getValue();
    public void takeHit(int hitValue);
    public int getHealth();

}
