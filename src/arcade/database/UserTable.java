package arcade.database;
import java.sql.*;

/**
 * Creates and updates user table
 * @author Natalia Carvalho
 */
public class UserTable extends Table{
    /**
     */
    public static final String USERNAME_COLUMN_FIELD = "username";  
    /**
     */
    public static final String PASSWORD_COLUMN_FIELD = "pw";
    /**
     */
    public static final String FIRSTNAME_COLUMN_FIELD  = "firstname";
    /**
     */
    public static final String LASTNAME_COLUMN_FIELD  = "lastname";
    /**
     */
    public static final String DOB_COLUMN_FIELD  = "DOB";
    /**
     */
    public static final String AVATAR_COLUMN_FIELD  = "avatarfilepath";

    public static final String USERID_COLUMN_FIELD = "userid";
    public static final int USERNAME_COLUMN_INDEX = 1;
    /**
     */
    public static final int PASSWORD_COLUMN_INDEX = 2;
    /**
     */
    public static final int FIRSTNAME_COLUMN_INDEX = 3;
    /**
     */
    public static final int LASTNAME_COLUMN_INDEX = 4;
    /**
     */
    public static final int DOB_COLUMN_INDEX = 5;
    public static final int AVATAR_COLUMN_INDEX = 6;
    public static final int USERID_COLUMN_INDEX = 7;
    
    public static final String TABLE_NAME = "users";

    private Connection myConnection;
    private PreparedStatement myPreparedStatement; 
    private ResultSet myResultSet;
    
    public UserTable() {
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

    void closeConnection() {
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

    /**
     * Authenticates entry when username and password are present in user table
     * @param username is the username
     * @param password is the password
     * @return true if valid username/password; false otherwise
     */
    public boolean authenticateUsernameAndPassword(String username, String password) {
        String stm = "SELECT username, pw FROM users WHERE username = '" + username + "'";
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
    
    public boolean usernameExists(String username) {
        String stm = "SELECT username FROM users WHERE username='" + username + "'";
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

    /**
     * Adds a user to user table based on information
     * @param user is the username
     * @param pw is the password
     * @param firstname is firstname
     * @param lastname is lastname
     * @param dateOfBirth is date of birth
     */
    public boolean addUser(String user, String pw, String firstname, 
                        String lastname, String dateOfBirth) {
        if (usernameExists(user)) {
            return false;
        }
        String stm = "INSERT INTO users(username, pw, firstname, lastname, DOB) VALUES(?, ?, ?, ?, ?)";
        try {
            myPreparedStatement = myConnection.prepareStatement(stm);
            myPreparedStatement.setString(USERNAME_COLUMN_INDEX, user);
            myPreparedStatement.setString(PASSWORD_COLUMN_INDEX, pw);
            myPreparedStatement.setString(FIRSTNAME_COLUMN_INDEX, firstname);
            myPreparedStatement.setString(LASTNAME_COLUMN_INDEX, lastname);
            myPreparedStatement.setString(DOB_COLUMN_INDEX, dateOfBirth);
            myPreparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    
    public String getUserid(String username) {
        String stm = "SELECT * FROM users WHERE username='" + username + "'";
        try {
            myPreparedStatement = myConnection.prepareStatement(stm);
            myResultSet  = myPreparedStatement.executeQuery();
            if (myResultSet.next()) {
                return myResultSet.getString(USERID_COLUMN_INDEX);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return "User doesn't exist";
    }

    /**
     * Given a username, deletes that user from table
     * @param username is user
     */
    public void deleteUser(String username) {
        String stm = "DELETE FROM users WHERE username='" + username + "'";
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
                System.out.print(myResultSet.getString(USERNAME_COLUMN_INDEX) + ": ");
                System.out.print(myResultSet.getString(PASSWORD_COLUMN_INDEX) + ": ");
                System.out.print(myResultSet.getString(FIRSTNAME_COLUMN_INDEX) + ": ");
                System.out.print(myResultSet.getString(LASTNAME_COLUMN_INDEX) + ": ");
                System.out.print(myResultSet.getString(DOB_COLUMN_INDEX) + ": ");
                System.out.print(myResultSet.getString(AVATAR_COLUMN_INDEX) + ": ");
                System.out.println(myResultSet.getString(USERID_COLUMN_INDEX));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

}