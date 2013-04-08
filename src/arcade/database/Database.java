package arcade.database;

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
    
    public boolean addUser(String username, String pw, String firstname, String lastname, String dataOfBirth) {
        return myUserTable.addUser(username, pw, firstname, lastname, dataOfBirth);
    }
    
    public boolean authenticateUsernameAndPassword(String username, String password) {
        return myUserTable.authenticateUsernameAndPassword(username, password);
    }
    
    public boolean registerGame(String gameName) {
        return myGameTable.addGame(gameName);
    }
    
    public void deleteUser(String username) {
        myUserGameDataTable.deleteUser(myUserTable.getUserid(username));
        myUserTable.deleteUser(username);
    }
    
    public void printUserTable() {
        myUserTable.printEntireTable();
    }
    
    public void printUserGameDataTable() {
        myUserGameDataTable.printEntireTable();
    }
    
    public void addGameFilePath(String filePath) {
        //TODO implement method
    }
    
    public void getGameFilePath(String filePath) {
        //TODO implement method
    }
    
    public String getGameID(String gameName) {
        return myGameTable.getGameID(gameName);
    }
    
    public void userPlaysGameFirst(String user, String gameName) {
        String gameid = getGameID(gameName);
        String userid = myUserTable.getUserid(user);
        myUserGameDataTable.addNewUserGameData(gameid, userid);
    }
    
    public void printGameTable() {
        myGameTable.printEntireTable();
    }
}