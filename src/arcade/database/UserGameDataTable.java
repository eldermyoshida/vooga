package arcade.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Creates and updates game table
 * @author Natalia Carvalho
 */
public class UserGameDataTable extends Table {

    private static final String TABLE_SEPARATOR = ": ";
    private static final String GAMEID_COLUMN_FIELD = "gameid";  
    private static final String USERID_COLUMN_FIELD = "userid";
    private static final String USERGAMEFILEPATH_COLUMN_FIELD = "usergamefilepath";
    private static final String HIGHSCORE_COLUMN_FIELD = "highscore";
    private static final String USERGAMEID_COLUMN_FIELD = "usergameid";  

    
    private static final int GAMEID_COLUMN_INDEX = 1;
    private static final int USERID_COLUMN_INDEX = 2;
    private static final int HIGHSCORE_COLUMN_INDEX = 3;
    private static final int USERGAMEFILEPATH_COLUMN_INDEX = 4;
    private static final int USERGAMEID_COLUMN_INDEX = 5;

    
    private static final String TABLE_NAME = "usergamedata";  


    private Connection myConnection;
    private PreparedStatement myPreparedStatement; 
    private ResultSet myResultSet;
    
    /**
     * Constructor, eventually want this to be in superclass
     */
    public UserGameDataTable() {
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

    /**
     * Closes Connection, ResultSet, and PreparedStatements once done with database
     */
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
    
    /**
     * Add new user game data to table 
     * @param gameid is game id
     * @param userid is user id
<<<<<<< HEAD
     * @param highscore of the game
=======
>>>>>>> db33675460551d990c9a9f53b90108bfded60ff7
     */
    public void createNewUserGameData (String gameid, String userid, String highscore) {
        
        String stm = "INSERT INTO usergamedata(gameid, userid, highscore) VALUES (?, ?, ?)";
        //String stm = "INSERT INTO " + TABLE_NAME + "(" + GAMEID_COLUMN_FIELD + ", " + USERID_COLUMN_FIELD + ", " + HIGHSCORE_COLUMN_FIELD + ") VALUES(?, ?, ?)";
        try {
            myPreparedStatement = myConnection.prepareStatement(stm);
            myPreparedStatement.setString(GAMEID_COLUMN_INDEX, gameid);
            myPreparedStatement.setString(USERID_COLUMN_INDEX, userid);
            myPreparedStatement.setString(HIGHSCORE_COLUMN_INDEX, highscore);
            myPreparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
<<<<<<< HEAD
    /**
     * Updates a high score given userid and gameid
     * @param gameid is game id
     * @param userid is user id
     * @param highscore of the game
     */
=======
>>>>>>> db33675460551d990c9a9f53b90108bfded60ff7
    public void updateHighScore(String userid, String gameid, String highscore) {
        String stm = "UPDATE usergamedata SET highscore = '" + highscore + "' WHERE userid = '" + userid + "' AND gameid = '" + gameid + "'" ;
        try {
            myPreparedStatement = myConnection.prepareStatement(stm);
            myPreparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
    /**
     * Given userid, delete the user from the table
     * @param userid is user id
     */
    public void deleteUser(String userid) {
        String stm = "DELETE FROM " + TABLE_NAME + " WHERE "+ USERID_COLUMN_FIELD + "='" + userid + "'";
        try {
            myPreparedStatement = myConnection.prepareStatement(stm);
            myPreparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    void printEntireTable () {
        System.out.println();
        try {
            myPreparedStatement = myConnection.prepareStatement("SELECT * FROM " + TABLE_NAME);
            myResultSet = myPreparedStatement.executeQuery();
            while (myResultSet.next()) {
                System.out.print(myResultSet.getString(GAMEID_COLUMN_INDEX) + TABLE_SEPARATOR);
                System.out.print(myResultSet.getString(USERID_COLUMN_INDEX) + TABLE_SEPARATOR);                
                System.out.print(myResultSet.getString(HIGHSCORE_COLUMN_INDEX) + TABLE_SEPARATOR);
                System.out.print(myResultSet.getString(USERGAMEFILEPATH_COLUMN_INDEX) + TABLE_SEPARATOR);
                System.out.println(myResultSet.getString(USERGAMEID_COLUMN_INDEX) + TABLE_SEPARATOR);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}