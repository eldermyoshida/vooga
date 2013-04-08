
package vooga.scroller.test_sprites;

import java.awt.Dimension;
import vooga.scroller.collision_handlers.Koopa_CH;
import vooga.scroller.sprite_superclasses.NonStaticEntity;
import vooga.scroller.util.Location;
import vooga.scroller.util.Pixmap;

public class Koopa extends NonStaticEntity {

    private Koopa_CH collisionHandler = new Koopa_CH();
    
    
    public Koopa_CH getCollisionHandler () {
        return collisionHandler;
    }

    public void setCollisionHandler (Koopa_CH collisionHandler) {
        this.collisionHandler = collisionHandler;
    }
    
    public Koopa (Pixmap image, Location center, Dimension size) {
        super(image, center, size);
    }

    public void print() {
        System.out.println("Koopa");
    }
    
    @Override
    public Type getType() {
        return Type.KOOPA;
    }
    
}
