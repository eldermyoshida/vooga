package arcade.model;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import arcade.games.GameInfo;
import arcade.games.UserGameData;
import arcade.util.Pixmap;
import arcade.view.LoginView;
import arcade.view.MainView;

public class Model {
    public static final String DEFAULT_LOGIN_MESSAGE = "";
    private ResourceBundle myResources;
    private LoginView myLoginView;
    
    private List<GameInfo> mySnapshots;
    
    
    public Model(ResourceBundle rb) {
        myResources = rb;
    }
    
    
    public void setLoginView(LoginView login) {
        myLoginView = login;
    }

    public void authenticate (String username, String password) {
        if (username.equals("ellango") && password.equals("password")) {
            myLoginView.destroy();
            getGameList();
            organizeSnapshots();
            new MainView(this, myResources);
        }
        else {
            myLoginView.sendMessage("The username or password you entered is incorrect");
        }
    }
    
    /**
     * Create a new user profile by entering user-specific information. 
     * This information is eventually stored in the database.
     */
    public void createNewUserProfile() {
    	
    }
    
    /**
     * Rate a specific game, store in user-game database
     */
    public void rateGame(GameInfo g, int rating){
    	
    }
    /**TODO: 
     * Get the list of games from the database.
     * @return
     */
    public List<GameInfo> getGameList(){
        return mySnapshots;
    }
    
    private void organizeSnapshots() {
    	mySnapshots = new ArrayList<GameInfo>();
    	GameInfo myGameInfo = new GameInfo("example");
    	mySnapshots.add(myGameInfo);
    }
    
    
    

    /**
     * GameDetailPanel must call this method to get game-specific info.
     * @param gameName: name of the chosen game (String)
     * @return
     */
    public GameInfo getGameDetail(String gameName) {
    	for (GameInfo g : mySnapshots) {
    		if (g.getName().equals(gameName)) {
    			return g;
    		}
    	}
    	return null;
    }
    
    
    /**
     * TODO: Must add user-game specific detail
     * @param user ,game (whatever that identifies the user and the game)
     * @return
     */
    public UserGameData getUserGameData(String user, String game) {
    	// Query database to get info specific to the user and the game (e.g. scores)
    	return null;
    }
    
}
