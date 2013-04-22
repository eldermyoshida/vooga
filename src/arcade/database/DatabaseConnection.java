package arcade.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Establishes connection to the database
 * @author Natalia Carvalho
 */
public class DatabaseConnection {

    private static final String URL = "jdbc:postgresql://cgi.cs.duke.edu/nrc10";
    private static final String USER = "nrc10";
    private static final String PASSWORD = "aUsg5xj2f";
    
    private Connection myConnection;
    private PreparedStatement myPreparedStatement; 
    private ResultSet myResultSet;

    /**
     * Constructor for DatabaseConnection that establishes connection to database
     */
    public DatabaseConnection() {
        establishConnectionToDatabase();
    }
    
    private void establishConnectionToDatabase() {
        try {
            Class.forName("org.postgresql.Driver");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        myConnection = null;
        try {
            myConnection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        myResultSet = null;
        myPreparedStatement = null;
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
     * Returns established connection
     */
    public Connection getConnection() {
        return myConnection;
    }
    
    /**
     * Returns established ResultSet
     */
    public ResultSet getResultSet() {
        return myResultSet;
    }
    
    /**
     * Returns established preparedstatement
     */
    public PreparedStatement getPreparedStatement() {
        return myPreparedStatement;
    }

}
