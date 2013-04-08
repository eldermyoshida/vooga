package arcade.model;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import arcade.games.GameInfo;
import arcade.util.Pixmap;
import arcade.view.LoginView;
import arcade.view.MainView;

public class Model {
    public static final String DEFAULT_LOGIN_MESSAGE = "";
    private ResourceBundle myResources;
    private LoginView myLoginView;
    
    
    public Model(ResourceBundle rb) {
        myResources = rb;
    }
    
    
    public void setLoginView(LoginView login) {
        myLoginView = login;
    }

    public void authenticate (String username, String password) {
        if (username.equals("a") && password.equals("b")) {
            myLoginView.destroy();
            getGameList();
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
        List<GameInfo> result = new ArrayList<GameInfo>();
    	GameInfo myGameInfo = new GameInfo("example");
    	result.add(myGameInfo);
        return result;
    }
}
