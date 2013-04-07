package arcade.model;

import java.util.List;
import java.util.ResourceBundle;
import arcade.games.GameInfo;
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
            new MainView(this, myResources);
        }
        else {
            myLoginView.sendMessage("The username or password you entered is incorrect");
        }
    }
    
    /**TODO: 
     * Get the list of games from the database.
     * @return
     */
    public List<GameInfo> getGameList(){
        return null;
    }
}
