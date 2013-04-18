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
    private int myMapCount;
    private List<Integer> myCharacters;
    private Integer myNumCharacters;
    private List<Integer> myScores;
    private List<Integer> myMapsPlayed;
    

    /**
     * Constructor
     */
    public GameInfo (int mapcount) {
    	myCharacters = new ArrayList<Integer>();
    	myScores = new ArrayList<Integer>();
    	myGameMode = "Fighting Game";
    	myMapCount = mapcount;
    }
    
    /**
     * Test constructor, automatically adds character index and map index to load. 
     */
    public GameInfo (int mapcount, List<Integer> characterIndexes, int mapID) {
        this(mapcount);
        myCharacters = characterIndexes;
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
    

    public int getMapCount(){
    	return myMapCount;
    }

    public List<Integer> getMapsPlayed(){
    	return myMapsPlayed;
    }
}
