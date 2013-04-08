
package vooga.scroller.test_sprites;

import java.awt.Dimension;
import vooga.scroller.collision_handlers.Coin_CH;
import vooga.scroller.sprite_superclasses.StaticEntity;
import vooga.scroller.util.Location;
import vooga.scroller.util.Pixmap;

public class Coin extends StaticEntity {

    
    private Coin_CH collisionHandler = new Coin_CH();
    
    public Coin_CH getCollisionHandler () {
        return collisionHandler;
    }

    public void setCollisionHandler (Coin_CH collisionHandler) {
        this.collisionHandler = collisionHandler;
    }
    
    public Coin (Pixmap image, Location center, Dimension size) {
        super(image, center, size);
        // TODO Auto-generated constructor stub
    }

    
    public void print() {
        System.out.println("Coin");
    }
    
    @Override
    public Type getType() {
        return Type.COIN;
    }



}
