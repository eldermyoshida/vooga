package vooga.scroller.sprites.interfaces;


public interface IEnemy extends ISprite {
    
    public void takeHit(int damage);
    public int getHit();

}
