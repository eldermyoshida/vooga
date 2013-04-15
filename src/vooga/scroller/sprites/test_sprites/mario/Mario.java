
package vooga.scroller.sprites.test_sprites.mario;

import java.awt.Dimension;
import util.Location;
import vooga.scroller.scrollingmanager.ScrollingManager;
import vooga.scroller.sprites.superclasses.NonStaticEntity;
import vooga.scroller.sprites.superclasses.Player;
import vooga.scroller.util.Pixmap;
import vooga.scroller.view.View;

public class Mario extends Player {

    private static int health = 5;

    public Mario (Location center, Dimension size, View view, ScrollingManager sm) {
        super(new Pixmap("mario_stand.png"), center, size, view, sm, health);
    }

    public void print() {
        System.out.println("Mario");
    }
    
    public void hit(NonStaticEntity nse){
        int hit = nse.getHit();
        super.takeHit(hit);
    }

    public int getHP () {
        return health;
    }
    
}



