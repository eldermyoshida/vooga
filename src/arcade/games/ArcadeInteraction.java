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
    User getUser();
        
    /**
     * Gets the top n high scores.
     * 
     * @param n is the number of high scores the game wants
     */
    HighScores aggregateHighScores(int n);

    /**
     * Closes the window containing the game
     */
    void killGame();
    
    /**
     * Make the game full screen if not full screen, or not full screen if it is.
     */
    void toggleFullScreen();
}
