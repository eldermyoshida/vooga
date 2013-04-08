package collision_handlers;

import test_sprites.Coin;
import test_sprites.Koopa;
import test_sprites.Mario;
import test_sprites.Platform;
import test_sprites.Turtle;
import test_sprites.Type;
import util.Sprite;
import design_patterns.Visitor;

public class Koopa_CH extends CollisionHandler implements Visitor {

    @Override
    public void visit (Mario mario) {
        System.out.println("Koopa has just collided with Mario!");
        
    }

    @Override
    public void visit (Coin coin) {
        System.out.println("Koopa has just collided with Coin!");
        
    }

    @Override
    public void visit (Koopa koopa) {
        System.out.println("Koopa has just collided with Koopa!");
        
    }

    @Override
    public void visit (Platform platform) {
        System.out.println("Koopa has just collided with Platform!");
        
    }

    @Override
    public void visit (Turtle turtle) {
        System.out.println("Koopa has just collided with Turtle!");
        
    }

    public void handleKoopaCollision (Sprite obj2) {
        handleCollision(Type.KOOPA, this, obj2);
    }
}
