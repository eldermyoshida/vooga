package vooga.scroller.sprites.interfaces;

import vooga.scroller.util.Sprite;

public interface IEnemy {
    
    public Sprite getEnemy();
    public void takeHit(int damage);
    public int getHit();

}
