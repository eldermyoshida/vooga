package vooga.fighter.controller;

import java.util.ArrayList;
import java.util.List;

import arcade.games.UserGameData;

/**
 * Information about the broader game state. includes game mode, selected map and characters.
 * @author matthewparides
 * 
 */
public class GameInfo extends UserGameData{
    private String myGameMode;
    private int myMapID;
    private List<Integer> myCharacters;
    private Integer myNumCharacters;
    private List<Integer> myScores;
    

    /**
     * Constructor
     */
    public GameInfo () {
    	myCharacters = new ArrayList<Integer>();
    	myScores = new ArrayList<Integer>();
    }
    
    /**
     * Test constructor, automatically adds character index and map index to load. 
     */
    public GameInfo (int characterIndex, int mapID) {
        myCharacters = new ArrayList<Integer>();
        myScores = new ArrayList<Integer>();
        myCharacters.add(characterIndex);
        myMapID = mapID;
    }

    /**
     * 
     */
    public void setScores(List<Integer> scores) {
    	myScores = scores;
    }
    
    /**
     * 
     */
    public int getScore(int index) {
    	return myScores.get(index);
    }
    
    /**
     * 
     */
    public void setScore(int index, int score) {
    	myScores.set(index, score);
    }
    
    /**
     * 
     * @return
     */
    @Override
    public List<Double> getScores() {
    	List<Double> myArcadeScores = new ArrayList<Double>();
    	for(Integer i : myScores){
    		myArcadeScores.add((double) i);
    	}
    	return myArcadeScores;
    }
    
    /**
     * 
     * @return
     */
    public List<Integer> getIntScores() {
    	return myScores;
    }
   
    
    /**
     * 
     * @return
     */
    public String getGameMode () {
        return myGameMode;
    }

    /**
     * 
     * @param myGameMode
     */
    public void setGameMode (String myGameMode) {
        myGameMode = myGameMode;
    }

    /**
     * 
     * @return
     */
    public int getMapName () {
        return myMapID;
    }

    /**
     * 
     * @param myMapName
     */
    public void setMapName (String myMapName) {
        myMapName = myMapName;
    }

    /**
     * 
     * @return
     */
    public List<Integer> getCharacters () {
        return myCharacters;
    }

    /**
     * 
     * @param index
     * @param characterName
     */
    public void setCharacter (int index, int characterID) {
        myCharacters.set(index, characterID);
    }

    /**
     * 
     * @param myCharacters
     */
    public void setCharacters (List<String> myCharacters) {
        myCharacters = myCharacters;
    }

    /**
     * 
     * @return
     */
    public int getNumCharacters () {
        return myNumCharacters;
    }

    /**
     * 
     * @param myNumCharacters
     */
    public void setNumCharacters (int myNumCharacters) {
        myNumCharacters = myNumCharacters;
    }

}
