package vooga.scroller.collision_manager;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import vooga.scroller.level_editor.Level;
import vooga.scroller.marioGame.spritesDefinitions.collisions.VisitMethods;
import vooga.scroller.util.Sprite;


/**
 * Currently, we are handling all collisions through CollisionManager.
 * CollisionManager uses reflection to figure out which visit() method needs to
 * be called for the Sprites that have just intersected. This is a much more elegant
 * way of handling collisions than the Visitor method we were previously using. 
 * <br>
 * <br>
 * Collisions can occur on two levels. The recommended level is when the two sprites 
 * have an interface implementation. For example, rather than have a Mario/Koopa collision,
 * we would much prefer the more general IPlayer/IEnemy collision. This allows us to 
 * condense the number of visit() methods needed. However, sometimes you need a specific 
 * collision between a sprite that doesn't fit in any interface. In that case, you can 
 * define the collision on a sprite level. For example, you could have a Mario/Star collision. 
 * You would need to have a visit method that looks like "visit(Mario mario, Star star)" to handle 
 * that kind of collision. 
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

    /**
     * When two sprites intersect, handleCollision() is the method you want to call. This method takes 
     * two sprites and IF you have defined a collision for these two sprites, handleCollision() will 
     * pull the correct visit method and invoke it on your sprites. This is done through Java's reflection 
     * feature. Specifically, what it is doing is matching method signatures. 
     * 
     * @param sprite1
     * @param sprite2
     */
    public void handleCollision (Sprite sprite1, Sprite sprite2) {

        Class<? extends Sprite> clazz1 = sprite1.getClass();
        Class<? extends Sprite> clazz2 = sprite2.getClass();
        if (checkForInterfaces(clazz1) == null ||
            checkForInterfaces(clazz2) == null) {
            @SuppressWarnings("rawtypes")
            Class[] classArray = { clazz1, clazz2 };
            Object[] sprites = { sprite1, sprite2 };
            invokeVisit(classArray, sprites);
        }

        else {
            @SuppressWarnings("rawtypes")
            Class[] classArray =
                    { checkForInterfaces(clazz1)[0], checkForInterfaces(clazz2)[0] };
            Object[] sprites = { sprite1, sprite2 };
            invokeVisit(classArray, sprites);
        }

    }
    
    @SuppressWarnings("rawtypes")
    public Class[] checkForInterfaces(Class clazz) {
        if(clazz.getInterfaces().length != 0)
            return clazz.getInterfaces();
        if(clazz.getSuperclass() == null)
            return null;
        return checkForInterfaces(clazz.getSuperclass());
        
    }

    private void invokeVisit (@SuppressWarnings("rawtypes") Class[] classArray, Object[] sprites) {
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
