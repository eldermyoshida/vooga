package vooga.scroller.sprites.interfaces;

public interface ICollectible extends ISprite {
     
    public int getValue();
    public void takeHit(int hitValue);
    public int getHealth();

}
