package vooga.scroller.collision_handlers;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import vooga.scroller.test_sprites.Coin;
import vooga.scroller.test_sprites.Koopa;
import vooga.scroller.test_sprites.Mario;
import vooga.scroller.test_sprites.Platform;
import vooga.scroller.test_sprites.Turtle;
import vooga.scroller.util.Sprite;
import vooga.scroller.view.View;


public class CollisionManager {

    View myView; 
    
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
        catch (NoSuchMethodException e) {

            //e.printStackTrace();
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
        endGame();
        System.out.println("Mario has just collided with Platform!");
        
    }

    public void visit (Mario mario, Turtle turtle) {
        System.out.println("Mario has just collided with Turtle!");
        
    }
    
    public void visit (Platform platform, Mario mario) {
        System.out.println("Platform has just collided with Mario!");
        
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
