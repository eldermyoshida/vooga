package vooga.scroller.collision_manager;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import vooga.scroller.level_editor.Level;
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
        visit = new VisitMethods();
    }
        
    public void handleCollision (Sprite sprite1, Sprite sprite2) {

        @SuppressWarnings("rawtypes")
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
            e.printStackTrace();
        }
        
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
