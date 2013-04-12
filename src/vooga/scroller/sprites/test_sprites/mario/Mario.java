
package vooga.scroller.sprites.test_sprites.mario;

import java.awt.Dimension;
import java.util.List;
import vooga.scroller.scrollingmanager.ScrollingManager;
import vooga.scroller.sprites.IPaintable;
import vooga.scroller.sprites.state.State;
import vooga.scroller.sprites.superclasses.NonStaticEntity;
import vooga.scroller.sprites.superclasses.Player;
import vooga.scroller.util.Location;
import vooga.scroller.util.Pixmap;
import vooga.scroller.view.View;

public class Mario extends Player {

    private int myHP;
    private View myView;

    public Mario (IPaintable image, Location center, Dimension size, View view, ScrollingManager sm) {
        super(image, center, size, view, sm);
        myView = view;
        myHP = 2;
    }

    public void print() {
        System.out.println("Mario");
    }
    
    public void hit(NonStaticEntity nse){
        int hit = nse.getHit();
        myHP -= hit;
    }

    public int getHP () {
        return myHP;
    }
    
}



