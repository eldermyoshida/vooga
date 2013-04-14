package vooga.fighter.controller;

import java.util.ArrayList;
import java.util.List;

/**
 * Information about the broader game state. includes game mode, selected map and characters.
 * @author matthewparides
 * 
 */
public class GameInfo {
    private String myGameMode;
    private String myMapName;
    private List<String> myCharacters;
    private int myNumCharacters;
    

    public GameInfo () {
    	myCharacters = new ArrayList<String>();
    }

    public String getGameMode () {
        return myGameMode;
    }

    public void setGameMode (String myGameMode) {
        myGameMode = myGameMode;
    }

    public String getMapName () {
        return myMapName;
    }

    public void setMapName (String myMapName) {
        myMapName = myMapName;
    }

    public List<String> getCharacters () {
        return myCharacters;
    }

    public void setCharacter (int index, String characterName) {
        myCharacters.set(index, characterName);
    }

    public void setCharacters (List<String> myCharacters) {
        myCharacters = myCharacters;
    }

    public int getNumCharacters () {
        return myNumCharacters;
    }

    public void setNumCharacters (int myNumCharacters) {
        myNumCharacters = myNumCharacters;
    }

}
