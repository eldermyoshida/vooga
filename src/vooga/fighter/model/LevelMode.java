package vooga.fighter.model;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import vooga.fighter.controller.ModeCondition;
import vooga.fighter.model.loaders.MapLoader;
import vooga.fighter.model.objects.AttackObject;
import vooga.fighter.model.objects.CharacterObject;
import vooga.fighter.model.objects.EnvironmentObject;
import vooga.fighter.model.objects.GameObject;
import vooga.fighter.model.objects.MapObject;
import vooga.fighter.model.utils.Health;
import vooga.fighter.model.utils.ImageDataObject;
import vooga.fighter.model.utils.State;
import vooga.fighter.model.utils.UpdatableLocation;


/**
 * Represents one level in the game, i.e. one matchup of two or more characters.
 * 
 * @author James Wei, alanni
 * 
 */
public class LevelMode extends Mode {

    private List<CharacterObject> myCharacterObjects;
    private List<Health> myHealthStats;
    private List<Double> myScores;
    private MapObject myMap;
    private List<ModeCondition> myModeConditions;

    public LevelMode(CollisionManager manager) {
        super(manager);
        myCharacterObjects = new ArrayList<CharacterObject>();
        myHealthStats = new ArrayList<Health>();
    }

    /**
     * Updates level mode by calling update in all of its objects.
     */
    public void update(double stepTime, Dimension bounds) {
        loadAttacks();
        removeAppropriateObjects();
        handleCollisions();
        updateHealth();
        List<GameObject> myObjects = getMyObjects();
        for (GameObject object : myObjects) {
            object.update();
            object.updateState();
        }
    }
    
    public void updateHealth() {
        for (int i =0; i < myCharacterObjects.size(); i++) {
            myHealthStats.set(i, myCharacterObjects.get(i).getHealth());
        }
    }



    /**
     * loads attacks from characters if they are new and aren't timed out
     */
    public void loadAttacks() {
        for (CharacterObject ch : myCharacterObjects) {
            for (AttackObject attack : ch.getAttackObjects()) {
                if (!(getMyObjects().contains(attack) || attack.shouldBeRemoved())) {
                    addObject(attack);
                }
            }
        }
    }
    
    public void setMap(MapObject map){
    	myMap = map;
    	addObject(map);
    }

    public MapObject getMap(){
    	return myMap;
    }
    /**
     * Returns the list of CharacterObjects.
     */
    public List<CharacterObject> getCharacterObjects() {
        return myCharacterObjects;
    }
    
    public void addCharacter(CharacterObject character){
    	myCharacterObjects.add(character);
    }


    public List<Health> getHealthStats() {
        return myHealthStats;
    }

}
