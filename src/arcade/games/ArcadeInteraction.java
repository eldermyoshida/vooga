package arcade.games;

/**
 * Arcade Model will implement ArcadeDataSource
 * 
 * Represents all the information and functionality that a Game should need 
 * from the Arcade.
 * 
 * @author ArcadeTeam
 */
public interface ArcadeInteraction {
    
    /**
     * Gets the user currently logged into the arcade.
     */
    public User getUser();
        
    /**
     * Gets the top n high scores.
     * 
     * @param n is the number of high scores the game wants
     */
    public Score getHighScores(int n);

    /**
     * Closes the window containing the game
     */
    void killGame();
    
    /**
     * Get data associated with a specific game and a user
     * @return UserGameData
     */
    public UserGameData getUserGameData(String gameName);
    
    public GameData getGameData(String gameName);

    public String getCurrentGame();
        
}
