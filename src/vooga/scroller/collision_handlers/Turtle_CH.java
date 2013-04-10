
package vooga.scroller.collision_handlers;

import vooga.scroller.test_sprites.Coin;
import vooga.scroller.test_sprites.Koopa;
import vooga.scroller.test_sprites.Mario;
import vooga.scroller.test_sprites.Platform;
import vooga.scroller.test_sprites.Turtle;
import vooga.scroller.test_sprites.Type;
import vooga.scroller.util.Sprite;
import vooga.scroller.design_patterns.Visitor;

public class Turtle_CH extends CollisionHandler implements Visitor {

    @Override
    public void visit (Mario mario) {
        System.out.println("Turtle has just collided with Mario!");
        
    }

    @Override
    public void visit (Coin coin) {
        System.out.println("Turtle has just collided with Coin!");
        
    }

    @Override
    public void visit (Koopa koopa) {
        System.out.println("Turtle has just collided with Koopa!");
        
    }

    @Override
    public void visit (Platform platform) {
        System.out.println("Turtle has just collided with Platform!");
        
    }

    @Override
    public void visit (Turtle turtle) {
        System.out.println("Turtle has just collided with Turtle!");
        
    }

    public void handleTurtleCollision (Sprite obj2) {
        handleCollision(Type.TURTLE, this, obj2);

    }
}
