package vooga.fighter.game;

import java.util.ArrayList;
import java.util.List;
import vooga.fighter.controller.ModelDelegate;
import vooga.fighter.objects.CharacterObject;
import vooga.fighter.objects.CollisionManager;
import vooga.fighter.objects.GameObject;
import vooga.fighter.objects.utils.UpdatableLocation;


/**
 * Represents one level in the game, i.e. one matchup of two or more characters.
 * 
 * @author james
 * 
 */
public class LevelMode extends Mode {

    private List<UpdatableLocation> myStartLocations;
    private List<Integer> myCharacterIds;
    private int myMapId;

    public LevelMode (ModelDelegate cd, List<Integer> charIds, int mapId) {
        super(cd);
        myStartLocations = new ArrayList<UpdatableLocation>();
        myCharacterIds = charIds;
        myMapId = mapId;
    }

    /**
     * Overrides superclass initialize method by creating all objects in the level.
     */
    public void initializeMode () {
        loadMap(myMapId);
        loadCharacters(myCharacterIds, myStartLocations);
    }

    /**
     * Updates level mode by calling update in all of its objects.
     */
    public void update () {
        List<GameObject> myObjects = getMyObjects();
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
    public void loadMap (int mapId) {        
        // create a map object and add it to myObjects
        // call map.getStartingPositions() and save to myStartingPositions        
    }

    /**
     * Loads the character objects for the selected characters using the ObjectLoader.
     */
    public void loadCharacters (List<Integer> characterIds, List<UpdatableLocation> startingPos) {
        for (int i=0; i<characterIds.size(); i++) {
            int charId = characterIds.get(i);
            UpdatableLocation start = startingPos.get(i);
            addObject(new CharacterObject(charId, start));
        }
    }

    /**
     * Detects and handles collisions between game objects.
     */
    public void handleCollisions () {
        CollisionManager.checkCollisions(getMyObjects());
    }

}
