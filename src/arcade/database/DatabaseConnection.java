package arcade.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnection {
    
    private Connection myConnection;
    private PreparedStatement myPreparedStatement; 
    private ResultSet myResultSet;
    
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

        String url = "jdbc:postgresql://cgi.cs.duke.edu/nrc10";
        String user = "nrc10";
        String password = "aUsg5xj2f";
        myConnection = null;
        try {
           myConnection = DriverManager.getConnection(url, user, password);
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
    
    public Connection getConnection() {
        return myConnection;
    }
    
    public ResultSet getResultSet() {
        return myResultSet;
    }
    
    public PreparedStatement getPreparedStatement() {
        return myPreparedStatement;
    }

}
