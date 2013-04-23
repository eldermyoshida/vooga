package arcade.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Creates superclass table with variables other subclasses need
 * Establishes connection to database
 * @author Natalia Carvalho
 */
public abstract class Table {
    
    private PreparedStatement myPreparedStatement;
    private Connection myConnection;
    private ResultSet myResultSet;
    private DatabaseConnection myDatabaseConnection;
    
    /**
     * Establishes database connection and instantiates variables other subclasses 
     * need to access table
     */
    public Table() {
        myDatabaseConnection = new DatabaseConnection();
        myPreparedStatement = myDatabaseConnection.getPreparedStatement();
        myConnection = myDatabaseConnection.getConnection();
        myResultSet = myDatabaseConnection.getResultSet();
    }  
    
    /**
     * Closes connection to database
     */
    public void closeConnection() {
        myDatabaseConnection.closeConnection();
    }
    
    /**
     * Returns Connection
     */
    public Connection getConnection() {
        return myConnection;
    }
    
    /**
     * Returns ResultSet
     */
    public ResultSet getResultSet() {
        return myResultSet;
    }
    
    /**
     * Returns PreparedStatement
     */
    public PreparedStatement getPreparedStatement() {
        return myPreparedStatement;
    }
    
    public ResultSet selectAllRecordsFromTable(String tableName) {
        System.out.println();
        try {
            myPreparedStatement = myConnection.prepareStatement("SELECT * FROM " + tableName);
            myResultSet = myPreparedStatement.executeQuery();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return myResultSet;
    }

}
