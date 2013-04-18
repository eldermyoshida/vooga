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
    	myGameMode = "Fighting Game";
    }
    
    /**
     * Test constructor, automatically adds character index and map index to load. 
     */
    public GameInfo (List<Integer> characterIndexes, int mapID) {
        this();
        myCharacters = characterIndexes;
        myMapID = mapID;
    }
    
    public String getGameInfo() {
        return myGameMode;
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
    public void setGameMode (String gameMode) {
        myGameMode = gameMode;
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
    public void setMapName (int mapID) {
        myMapID = mapID;
    }

    /**
     * 
     * @return
     */
    public List<Integer> getCharacters () {
        return myCharacters;
    }
    
    public void addCharacters(int character) {
        myCharacters.add(character);
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
    public void setCharacters (List<Integer> characters) {
        myCharacters = characters;
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
    public void setNumCharacters (int numCharacters) {
        myNumCharacters = numCharacters;
    }
    


}
