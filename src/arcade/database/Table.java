package arcade.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Creates and updates table
 * @author Natalia Carvalho
 */
public abstract class Table {
    
    private PreparedStatement myPreparedStatement;
    private Connection myConnection;
    private ResultSet myResultSet;
    private DatabaseConnection myDatabaseConnection;
    
    public Table() {
        myDatabaseConnection = new DatabaseConnection();
        myPreparedStatement = myDatabaseConnection.getPreparedStatement();
        myConnection = myDatabaseConnection.getConnection();
        myResultSet = myDatabaseConnection.getResultSet();
    }  
    
    public void closeConnection() {
        myDatabaseConnection.closeConnection();
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
    
    abstract void printEntireTable();

}
