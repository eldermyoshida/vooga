package arcade.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Creates and updates game table
 * @author Natalia Carvalho
 */
public class GameTable extends Table {

    private static final String TABLE_SEPARATOR = ": ";
    private static final String GAMENAME_COLUMN_FIELD = "gamename";  
    private static final String GAMEFILEPATH_COLUMN_FIELD = "gamefilepath";
    private static final String GAMEID_COLUMN_FIELD = "gameid";  
    
    private static final int GAMENAME_COLUMN_INDEX = 1;
    private static final int GAMEFILEPATH_COLUMN_INDEX = 2;
    private static final int GAMEID_COLUMN_INDEX = 3;
    
    private static final String TABLE_NAME = "games";  


    private Connection myConnection;
    private PreparedStatement myPreparedStatement; 
    private ResultSet myResultSet;
    
    public GameTable() {
        createDatabase();
    }

    void createDatabase() {

        try {
            Class.forName("org.postgresql.Driver");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:postgresql:mynewdatabase";
        String user = "user1";
        String password = "1234";

        try {
            myConnection = DriverManager.getConnection(url, user, password);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        myPreparedStatement = null; 
        myResultSet = null;

    }

    public void closeConnection() {
        try {
            if (myPreparedStatement != null) {
                myPreparedStatement.close();
            }
            if (myResultSet != null) {
                myResultSet.close();
            }
            if (myConnection != null) {
                myConnection.close();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public boolean gameNameExists(String gameName) {
        String stm = "SELECT gamename FROM games WHERE gamename='" + gameName + "'";
        try {
            myPreparedStatement = myConnection.prepareStatement(stm);
            myResultSet  = myPreparedStatement.executeQuery();
            if (myResultSet.next()) {
                return true;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public String retrieveGameId(String gameName) {
        String stm = "SELECT * FROM " + TABLE_NAME + " WHERE " + GAMENAME_COLUMN_FIELD + "='" + gameName + "'";
        String gameid = "";
        try {
            myPreparedStatement = myConnection.prepareStatement(stm);
            myResultSet  = myPreparedStatement.executeQuery();
            if (myResultSet.next()) {
                gameid = myResultSet.getString(GAMEID_COLUMN_INDEX);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return gameid;
    }
    
    /**
     * Adds a user to user table based on information
     * @param user is the username
     * @param pw is the password
     * @param firstname is firstname
     * @param lastname is lastname
     * @param dateOfBirth is date of birth
     */
    public boolean createGame(String gameName) {
        if (gameNameExists(gameName)) {
            return false;
        }
        String stm = "INSERT INTO " + TABLE_NAME + "(" + GAMENAME_COLUMN_FIELD + ") VALUES(?)";
        try {
            myPreparedStatement = myConnection.prepareStatement(stm);
            myPreparedStatement.setString(GAMENAME_COLUMN_INDEX, gameName);
            myPreparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    
    public List<String> retrieveGameList() {
        String stm = "SELECT " + GAMENAME_COLUMN_FIELD + " FROM "  + TABLE_NAME;
        List<String> myGameNames = new ArrayList<String>();
        try {
            myPreparedStatement = myConnection.prepareStatement(stm);
            myResultSet = myPreparedStatement.executeQuery();
            while (myResultSet.next()) {
                myGameNames.add(myResultSet.getString(GAMENAME_COLUMN_INDEX));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return myGameNames;
        
    }
    
    void printEntireTable () {
        System.out.println();
        try {
            myPreparedStatement = myConnection.prepareStatement("SELECT * FROM " + TABLE_NAME);
            myResultSet = myPreparedStatement.executeQuery();
            while (myResultSet.next()) {
                System.out.print(myResultSet.getString(GAMENAME_COLUMN_INDEX) + TABLE_SEPARATOR);
                System.out.print(myResultSet.getString(GAMEFILEPATH_COLUMN_INDEX) + TABLE_SEPARATOR);
                System.out.println(myResultSet.getString(GAMEID_COLUMN_INDEX));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}