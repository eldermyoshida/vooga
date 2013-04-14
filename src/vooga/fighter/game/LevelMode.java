package vooga.fighter.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import vooga.fighter.controller.ControllerDelegate;
import vooga.fighter.controller.ModelDelegate;
import vooga.fighter.objects.CharacterObject;
import vooga.fighter.objects.GameObject;
import vooga.fighter.objects.utils.UpdatableLocation;

/**
 * Represents one level in the game, i.e. one matchup of two or more characters.
 * 
 * @author james
 *
 */
public class LevelMode extends Mode {

//    private CollisionManager myCollisionManager;
    private List<UpdatableLocation> myStartLocations;
    private List<Integer> myCharacterIds;
    private int myMapId;    
    
    public LevelMode(ModelDelegate cd, List<Integer> charIds, int mapId) {
        super(cd);
        myStartLocations = new ArrayList<UpdatableLocation>();
        myCharacterIds = charIds;
        myMapId = mapId;
    }    

    /**
    * Overrides superclass initialize method by creating all objects in the level.
    */
    public void initializeMode() {
            loadMap(myMapId);
            loadCharacters(myCharacterIds);
    }

    /**
    * Updates level mode by calling update in all of its objects.
    */
    public void update() {
            Set<GameObject> myObjects = getMyObjects();
            handleCollisions();
            for (GameObject object : myObjects) {
                    object.update();
            }
            if (true) {
                    super.signalTermination();
            }
    }

    /**
    * Loads the environment objects for a map using the ObjectLoader.
    */
    public void loadMap(int mapId) {
        
    }

    /**
    * Loads the character objects for the selected characters using the ObjectLoader.
    */
    public void loadCharacters(List<Integer> characterIds) {
        for (int charId : characterIds) {
//            addObject(new CharacterObject(charId));
        }
    }
                    
    /**
    * Detects and handles collisions between game objects.
    */      
    public void handleCollisions()  {
            // pass in our list of objects to collisionManager
    }
    
}
