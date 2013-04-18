package vooga.fighter.model;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import vooga.fighter.controller.ModelDelegate;
import vooga.fighter.model.loaders.MapLoader;
import vooga.fighter.model.objects.CharacterObject;
import vooga.fighter.model.objects.EnvironmentObject;
import vooga.fighter.model.objects.GameObject;
import vooga.fighter.model.objects.MapObject;
import vooga.fighter.model.utils.ImageDataObject;
import vooga.fighter.model.utils.State;
import vooga.fighter.model.utils.UpdatableLocation;


/**
 * Represents one level in the game, i.e. one matchup of two or more characters.
 * 
 * @author James Wei
 * 
 */
public class LevelMode extends Mode {

    private List<UpdatableLocation> myStartLocations;
    private List<String> myCharacterNames;
    private List<CharacterObject> myCharacterObjects;
    private String myMapName;
    private MapObject myMap;

    public LevelMode(ModelDelegate cd, List<String> charNames, String mapName) {
        super(cd);
        myStartLocations = new ArrayList<UpdatableLocation>();
        myCharacterObjects = new ArrayList<CharacterObject>();
        myCharacterNames = charNames;
        myMapName = mapName;
        myMap = null;
    }

    /**
     * Overrides superclass initialize method by creating all objects in the level.
     */
    public void initializeMode() {
        loadMap(myMapName);
        loadCharacters(myCharacterNames, myStartLocations);
    }

    /**
     * Updates level mode by calling update in all of its objects.
     */
    public void update(double stepTime, Dimension bounds) {
        List<GameObject> myObjects = getMyObjects();
        handleCollisions();
        for (int i=0; i<myObjects.size(); i++) {
            GameObject object = myObjects.get(i);
            object.update();
            if (object.shouldBeRemoved()) {
                myObjects.remove(object);
                i--;
            }
        }

        for (int i=0; i<myObjects.size(); i++) {
            GameObject object = myObjects.get(i);
            object.updateState();
        }
        
        if (shouldModeEnd()) {
            signalTermination();
        }
    }

    /**
     * Loads the environment objects for a map using the ObjectLoader.
     */
    public void loadMap(String mapName) {
        myMap = new MapObject(mapName);
    	myStartLocations = myMap.getStartPositions();
    	addObject(myMap);
    	List<EnvironmentObject> mapObjects = myMap.getEnviroObjects();
    	for (EnvironmentObject object : mapObjects) {
    	    addObject(object);
    	}    	
    }

    /**
     * Loads the character objects for the selected characters using the ObjectLoader.
     */
    public void loadCharacters(List<String> characterNames, List<UpdatableLocation> startingPos) {
        for (int i=0; i<characterNames.size(); i++) {
            String charName = characterNames.get(i);
            UpdatableLocation start = startingPos.get(i);
            CharacterObject newCharacter = new CharacterObject(charName, start);
            addObject(newCharacter);
            myCharacterObjects.add(newCharacter);
        }
    }
    
    /**
     * Checks if the level has ended. Does so by checking if any player has no health
     * remaining.
     */
    public boolean shouldModeEnd() {
        for (GameObject object : getMyObjects()) {
            if (object instanceof CharacterObject) {
                CharacterObject currentChar = (CharacterObject) object;
                if (!currentChar.hasHealthRemaining()) {
                    System.out.println("LevelMode shouldModeEnd : character has no health");
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Returns the list of CharacterObjects.
     */
    public List<CharacterObject> getMyCharacterObjects() {
        return myCharacterObjects;
    }
    
    /**
     * Creates the list of image data objects and returns it.
     */
    public List<ImageDataObject> getImageData() {
        List<ImageDataObject> result = new ArrayList<ImageDataObject>();
        for (GameObject object : getMyObjects()) {
            result.add(object.getImageData());
        }
        return result;
    }
    
}
