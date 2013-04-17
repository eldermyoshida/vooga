package vooga.scroller.collision_manager;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import util.Vector;
import vooga.scroller.level_editor.Level;
import vooga.scroller.level_management.LevelPortal;
import vooga.scroller.sprites.test_sprites.MarioLib;
import vooga.scroller.sprites.test_sprites.MarioLib.Koopa;
import vooga.scroller.sprites.test_sprites.MarioLib.Plant;
import vooga.scroller.sprites.test_sprites.mario.Mario;
import vooga.scroller.util.Direction;
import vooga.scroller.util.Sprite;

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

    Level myLevel;
    private VisitMethods visit; 
       
    public CollisionManager (Level level) {
        myLevel = level;
        visit = new VisitMethods(myLevel);
    }
        
    public void handleCollision (Sprite sprite1, Sprite sprite2) {

//        Class[] classArray = {sprite1.getClass(), sprite2.getClass()}; //old way of living 

        Class[] classArray = {sprite1.getClass().getInterfaces()[0], sprite2.getClass().getInterfaces()[0]};
        Object[] sprites = {sprite1, sprite2};

        try {
            Method method = visit.getClass().getMethod("visit", classArray);
            method.invoke(visit, sprites);
        }
        
        catch (SecurityException e) {
            e.printStackTrace();
        }
        
        /**
         * If there is No Such Method, that means the game designer does not want 
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
}
