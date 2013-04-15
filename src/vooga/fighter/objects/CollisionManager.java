package vooga.fighter.objects;

import java.util.List;

/**
 * Detects collisions between all the game objects
 * 
 * @author alanni
 * 
 */
public class CollisionManager {

    /**
     * Checks for collisions between the game objects.
     */
    public static void checkCollisions(List<GameObject> myObjects) {
        for (int i = 0; i < myObjects.size() - 1; i++) {
            for (int j = i + 1; j < myObjects.size(); j++) {
                GameObject o1 = myObjects.get(i);
                GameObject o2 = myObjects.get(j);
                if (o1.getCurrentState().getCurrentRectangle()
                        .intersects(o2.getCurrentState().getCurrentRectangle())) {
                    handleCollisions(o1, o2);
                }
            }
        }
    }

    /**
     * Applies collisions between collided game objects.
     */
    public static void handleCollisions (GameObject o1, GameObject o2) {
        o1.applyCollideEffect(o2);
        o2.applyCollideEffect(o2);
    }

}
