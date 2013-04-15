
package vooga.scroller.sprites.test_sprites.mario;

import java.awt.Dimension;
import util.Location;
import vooga.scroller.scrollingmanager.ScrollingManager;
import vooga.scroller.sprites.superclasses.NonStaticEntity;
import vooga.scroller.sprites.superclasses.Player;
import vooga.scroller.util.Pixmap;
import vooga.scroller.util.Sprite;
import vooga.scroller.view.View;

public class Mario extends Player {

    private static final int MAX_JUMPS = 2;
    private static final Pixmap DEFAULT_IMAGE = new Pixmap("llama_still.gif");
    private static int health = 5;
    private int myJumpCount;

    public Mario (Location center, Dimension size, View view, ScrollingManager sm) {
        super(DEFAULT_IMAGE, center, size, view, sm, health);
        myJumpCount = 0;
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
    
    public void jump() {
        if(this.getVelocity().getComponentVector(Sprite.UP_DIRECTION).getMagnitude() < .5 &&
                this.getVelocity().getComponentVector(Sprite.DOWN_DIRECTION).getMagnitude() < .5 && myJumpCount < MAX_JUMPS ) {
           
            this.addVector(UP_VELOCITY);
            myJumpCount +=1;
        }

    }
    
    @Override
    public void update (double elapsedTime, Dimension bounds) {
        if (myJumpCount == MAX_JUMPS && this.getVelocity().getComponentVector(Sprite.UP_DIRECTION).getMagnitude() < .5) {
            myJumpCount = 0;
        }
        super.update(elapsedTime, bounds);
    }   
}



