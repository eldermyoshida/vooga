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
public class UserGameDataTable extends Table {

    public static final String GAMEID_COLUMN_FIELD = "gameid";  
    public static final String USERID_COLUMN_FIELD = "userid";
    public static final String USERGAMEFILEPATH_COLUMN_FIELD = "usergamefilepath";  
    public static final String USERGAMEID_COLUMN_FIELD = "usergameid";  

    
    public static final int GAMEID_COLUMN_INDEX = 1;
    public static final int USERID_COLUMN_INDEX = 2;
    public static final int USERGAMEFILEPATH_COLUMN_INDEX = 3;
    public static final int USERGAMEID_COLUMN_INDEX = 4;

    
    public static final String TABLE_NAME = "usergamedata";  


    private Connection myConnection;
    private PreparedStatement myPreparedStatement; 
    private ResultSet myResultSet;
    
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

    public void closeConnection() {
        if (myPreparedStatement != null) {
            try {
                myPreparedStatement.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (myResultSet != null) {
            try {
                myResultSet.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (myConnection != null) {
            try {
                myConnection.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
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
    
    public void addNewUserGameData (String gameid, String userid) {
        String stm = "INSERT INTO usergamedata(gameid, userid) VALUES(?, ?)";
        try {
            myPreparedStatement = myConnection.prepareStatement(stm);
            myPreparedStatement.setString(GAMEID_COLUMN_INDEX, gameid);
            myPreparedStatement.setString(USERID_COLUMN_INDEX, userid);
            myPreparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteUser(String userid) {
        String stm = "DELETE FROM usergamedata WHERE userid='" + userid + "'";
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
                System.out.print(myResultSet.getString(GAMEID_COLUMN_INDEX) + ": ");
                System.out.print(myResultSet.getString(USERID_COLUMN_INDEX) + ": ");
                System.out.print(myResultSet.getString(USERGAMEFILEPATH_COLUMN_INDEX) + ": ");
                System.out.println(myResultSet.getString(USERGAMEID_COLUMN_INDEX) + ": ");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}