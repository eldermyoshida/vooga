package vooga.fighter.controller;

/**
 * 
 * @author matthewparides
 * 
 */
public class GameInfo {
    private String myGameMode;
    private String myMapName;
    private String[] myCharacters;
    private int myNumCharacters;

    public GameInfo () {
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

    public String[] getCharacters () {
        return myCharacters;
    }

    public void setCharacter (int index, String characterName) {
        myCharacters[index] = characterName;
    }

    public void setCharacters (String[] myCharacters) {
        myCharacters = myCharacters;
    }

    public int getNumCharacters () {
        return myNumCharacters;
    }

    public void setNumCharacters (int myNumCharacters) {
        myNumCharacters = myNumCharacters;
    }

}
