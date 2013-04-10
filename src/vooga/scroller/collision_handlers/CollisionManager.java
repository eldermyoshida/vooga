package vooga.scroller.collision_handlers;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import vooga.scroller.test_sprites.Coin;
import vooga.scroller.test_sprites.Koopa;
import vooga.scroller.test_sprites.Mario;
import vooga.scroller.test_sprites.Platform;
import vooga.scroller.test_sprites.Turtle;
import vooga.scroller.util.Direction;
import vooga.scroller.util.Sprite;
import vooga.scroller.view.View;

/**
 * Currently, we are handling all collisions through CollisionManager. 
 * CollisionManager uses reflection to figure out which visit() method needs to 
 * be called for the Sprites that have just intersected. This is a much more elegant 
 * way of handling collisions than the Visitor method we were previously using. 
 * 
 * 
 * @author Jay Wang
 *
 */

public class CollisionManager {

    View myView; 
    private static final int COLLISION_GRANULARITY = 15;
    
    
    public CollisionManager (View view) {
        myView = view;
    }
    
    
    public void handleCollision (Sprite sprite1, Sprite sprite2) {

        Class[] classArray = {sprite1.getClass(), sprite2.getClass()};
        Object[] sprites = {sprite1, sprite2};

        try {
            Method method = this.getClass().getMethod("visit", classArray);
            method.invoke(this, sprites);
        }
        
        catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        /**
         * If there is No Suck Method, that means the game designer does not want 
         * anything to happen when this collision occurs. 
         */
        catch (NoSuchMethodException e) {
            return;
        }
        
        catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    
    }
    
    
    /**
     * Helper Methods for getting Collision Direction
     * @param Sprite sprite1
     * @param Sprite sprite2
     * @return one of four Direction enums
     */
    private Direction collisionDirection (Sprite sprite1, Sprite sprite2) {  
        if (checkTop(sprite1, sprite2)) return Direction.TOP;
        else if (checkBottom(sprite1, sprite2)) return Direction.BOTTOM;
        else if (checkLeft(sprite1, sprite2)) return Direction.LEFT;
        else if (checkRight(sprite1, sprite2)) return Direction.RIGHT;        
        return null;
    }
    
    private boolean checkTop(Sprite sprite1, Sprite sprite2) {
        return (sprite1.getBottom() >= sprite2.getTop() && sprite1.getBottom() <= sprite2.getTop() + COLLISION_GRANULARITY);
    }
    
    private boolean checkBottom(Sprite sprite1, Sprite sprite2) {
        return (sprite1.getTop() <= sprite2.getBottom() && sprite1.getTop() >= sprite2.getBottom() - COLLISION_GRANULARITY);
    }
    
    private boolean checkLeft(Sprite sprite1, Sprite sprite2) {
        return (sprite1.getRight() >= sprite2.getLeft() && sprite1.getRight() <= sprite2.getLeft() + COLLISION_GRANULARITY);
    }
    
    private boolean checkRight(Sprite sprite1, Sprite sprite2) {
        return (sprite1.getLeft() <= sprite2.getRight() && sprite1.getLeft() >= sprite2.getRight() - COLLISION_GRANULARITY);
    }
    
    
    
    /**
     * Begin the long slew of visit() methods... 
     * Thinking about ways to refactor/repackage this.
     * 
     */
    
    public void visit (Mario mario, Mario mario2) {
        System.out.println("Mario has just collided with Mario!");
        
    }
    
    public void visit (Mario mario, Coin coin) {
        System.out.println("Mario has just collided with Coin!");
        
    }

    public void visit (Mario mario, Koopa koopa) {
        System.out.println("Mario has just collided with Koopa!");
        
    }

    public void visit (Mario mario, Platform platform) {
        
        Direction collisionType = collisionDirection(mario, platform);

        if (collisionType == null) return;
        
        switch (collisionType) {
            case TOP:
                mario.setCenter(mario.getX(), platform.getTop() - (mario.getHeight() / 2));
                break;
            case BOTTOM:
                mario.setCenter(mario.getX(), platform.getBottom() + (mario.getHeight() / 2));
                break;
            case LEFT:
                mario.setCenter(platform.getLeft() - (mario.getWidth() / 2), mario.getY());
                break;
            case RIGHT:
                mario.setCenter(platform.getRight() + (mario.getWidth() / 2), mario.getY());
                break;
            default: 
                break;
        }
        
        System.out.println("Mario has just collided with Platform!");
        
    }
    
    public void visit (Mario mario, Turtle turtle) {
        endGame();
        System.out.println("Mario has just collided with Turtle!");
        
    }
    
    public void visit (Coin coin, Mario mario) {
        System.out.println("Coin has just collided with Mario!");
    }

    public void visit (Coin coin, Coin coin2) {
        System.out.println("Coin has just collided with Coin!");
        
    }

    public void visit (Coin coin, Koopa koopa) {
        System.out.println("Coin has just collided with Koopa!");
        
    }

    public void visit (Coin coin, Platform platform) {
        System.out.println("Coin has just collided with Platform!");
        
    }

    public void visit (Coin coin, Turtle turtle) {
        System.out.println("Coin has just collided with Turtle!");
    }

    public void visit (Koopa koopa, Mario mario) {
        System.out.println("Koopa has just collided with Mario!");
        
    }

    public void visit (Koopa koopa, Coin coin) {
        System.out.println("Koopa has just collided with Coin!");
        
    }

    public void visit (Koopa koopa, Koopa koopa2) {
        System.out.println("Koopa has just collided with Koopa!");
        
    }

    public void visit (Koopa koopa, Platform platform) {
        System.out.println("Koopa has just collided with Platform!");
        
    }

    public void visit (Koopa koopa, Turtle turtle) {
        System.out.println("Koopa has just collided with Turtle!");
        
    }
    
    public void visit (Platform platform, Mario mario) {
        //System.out.println("Platform has just collided with Mario!");
        
    }

    public void visit (Platform platform, Coin coin) {
        System.out.println("Platform has just collided with Coin!");
        
    }

    public void visit (Platform platform, Koopa koopa) {
        System.out.println("Platform has just collided with Koopa!");
        
    }

    public void visit (Platform platform, Platform platform2) {
        System.out.println("Platform has just collided with Platform!");
        
    }

    public void visit (Platform platform, Turtle turtle) {
        System.out.println("Platform has just collided with Turtle!");
        
    }
    
    public void visit (Turtle turtle, Mario mario) {
        System.out.println("Turtle has just collided with Mario!");
        
    }

    public void visit (Turtle turtle, Coin coin) {
        System.out.println("Turtle has just collided with Coin!");
        
    }

    public void visit (Turtle turtle, Koopa koopa) {
        System.out.println("Turtle has just collided with Koopa!");
        
    }

    public void visit (Turtle turtle, Platform platform) {
        System.out.println("Turtle has just collided with Platform!");
        
    }

    public void visit (Turtle turtle, Turtle turtle2) {
        System.out.println("Turtle has just collided with Turtle!");
        
    }
    
    private void endGame () {
        myView.win();        
    }
    
    
}
