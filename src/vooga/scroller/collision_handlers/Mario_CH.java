
package vooga.scroller.collision_handlers;

import vooga.scroller.test_sprites.Coin;
import vooga.scroller.test_sprites.Koopa;
import vooga.scroller.test_sprites.Mario;
import vooga.scroller.test_sprites.Platform;
import vooga.scroller.test_sprites.Turtle;
import vooga.scroller.test_sprites.Type;
import vooga.scroller.util.Sprite;
import vooga.scroller.view.View;
import vooga.scroller.design_patterns.Visitor;

public class Mario_CH extends CollisionHandler implements Visitor {

    private View myView;
    
    public Mario_CH (View view) {
        myView = view;
    }
    
    @Override
    public void visit (Mario mario) {
        System.out.println("Mario has just collided with Mario!");
        
    }

    @Override
    public void visit (Coin coin) {
        System.out.println("Mario has just collided with Coin!");
        
    }

    @Override
    public void visit (Koopa koopa) {
        System.out.println("Mario has just collided with Koopa!");
        
    }

    @Override
    public void visit (Platform platform) {
        endGame();
        System.out.println("Mario has just collided with Platform!");
        
    }


    @Override
    public void visit (Turtle turtle) {
        System.out.println("Mario has just collided with Turtle!");
        
    }

    public void handleMarioCollision (Sprite obj2) {        
        handleCollision(Type.MARIO, this, obj2);
    }
    
    private void endGame () {
        myView.win();        
    }
}
