package arcade.database;
import java.util.List;

/**
 * Creates overall database
 * @author Natalia Carvalho
 */
public class Database {
    
    private GameTable myGameTable;
    private UserTable myUserTable;
    private UserGameDataTable myUserGameDataTable;
    
    public Database() {
        myGameTable = new GameTable();
        myUserTable = new UserTable();
        myUserGameDataTable = new UserGameDataTable();
    }

    public void closeDatabaseConnection() {
        myGameTable.closeConnection();
        myUserTable.closeConnection();
        myUserGameDataTable.closeConnection();
    }
    
    public boolean createUser(String username, String pw, String firstname, String lastname, String dataOfBirth) {
        return myUserTable.createUser(username, pw, firstname, lastname, dataOfBirth);
    }
    
    public boolean createUser(String username, String pw, String firstname, String lastname, String dataOfBirth, String filepath) {
        return myUserTable.createUser(username, pw, firstname, lastname, dataOfBirth, filepath);
    }
    
    public boolean createGame(String gameName) {
        return myGameTable.createGame(gameName);
    }
    
    public void userPlaysGameFirst(String user, String gameName, String highscore) {
        myUserGameDataTable.createNewUserGameData(retrieveGameId(gameName), retrieveUserId(user), highscore);
    }
    
    public void updateAvatar(String user, String filepath) {
        myUserTable.updateAvatar(user, filepath);
    }
    
    public String retrieveAvatar(String username) {
        return myUserTable.retrieveAvatar(username);
    }
    
    public String retrieveDOB(String username) {
        return myUserTable.retrieveDOB(username);
    }
    
    public List<String> retrieveListOfGames() {
        return myGameTable.retrieveGameList();
    }
    
    public boolean authenticateUsernameAndPassword(String username, String password) {
        return myUserTable.authenticateUsernameAndPassword(username, password);
    }
    
    public void deleteUser(String username) {
        myUserGameDataTable.deleteUser(retrieveUserId(username));
        myUserTable.deleteUser(username);
    }
    
    public void printUserTable() {
        myUserTable.printEntireTable();
    }
    
    public void printUserGameDataTable() {
        myUserGameDataTable.printEntireTable();
    }
    
    public void updateHighScore(String username, String gameName, String newHighScore) {
        myUserGameDataTable.updateHighScore(retrieveUserId(username), retrieveGameId(gameName), newHighScore);
    }
    
    public void updateUserGameFilePath(String filepath) {
        //TODO implement method
    }
    
    public void retrieveGameFilePath(String filepath) {
        //TODO implement method
    }
    
    public void printGameTable() {
        myGameTable.printEntireTable();
    }
    
    private String retrieveGameId(String gameName) {
        return myGameTable.retrieveGameId(gameName);
    }
    
    private String retrieveUserId(String username) {
        return myUserTable.retrieveUserId(username);
    }
}