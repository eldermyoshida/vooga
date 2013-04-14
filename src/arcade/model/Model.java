
package arcade.model;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import arcade.games.GameInfo;
import arcade.games.UserGameData;
import util.Pixmap;
import arcade.view.LoginView;
import arcade.view.MainView;

public class Model {
	public static final String DEFAULT_LOGIN_MESSAGE = "";
	private static final String LOGIN_FAILURE_MESSAGE = "The username or password you entered is incorrect";
	private static final String REGISTER_FAILURE_MESSAGE = "That username is already taken.";
	private ResourceBundle myResources;
	private LoginView myLoginView;
	private String myLanguage;

	private List<GameInfo> mySnapshots;


	public Model(ResourceBundle rb, String language) {
		myResources = rb;
		myLanguage = language;
	}


	public void setLoginView(LoginView login) {
		myLoginView = login;
	}

	public void authenticate (String username, String password) {
	   // myLoginView.sendMessage(LOGIN_FAILURE_MESSAGE);
		myLoginView.destroy();
		getGameList();
		organizeSnapshots();
		new MainView(this, myResources);

		//        if (username.equals("ellango") && password.equals("password")) {
		//            myLoginView.destroy();
		//            getGameList();
		//            organizeSnapshots();
		//            new MainView(this, myResources);
		//        }
		//        else {
		//            myLoginView.sendMessage(LOGIN_FAILURE_MESSAGE);
		//        }
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
		GameInfo myGameInfo = new GameInfo("example", myLanguage);
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
