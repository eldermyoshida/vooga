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
    
    /**
     * where keyword
     */
    public static final String WHERE_KEYWORD = " WHERE ";
    /**
     * select from keyword
     */
    public static final String SELECT_FROM = "SELECT * FROM ";
    
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
            myPreparedStatement = myConnection.prepareStatement(SELECT_FROM + tableName);
            myResultSet = myPreparedStatement.executeQuery();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return myResultSet;
    }
    
    /**
     * Given parameter and a columnIndex, returns that entire row entry for a table
     * @param tableName is name of table
     * @param parameter is parameter we are interested in
     * @param columnIndex is the index that we want the information for
     */
    public int retrieveEntryInt(String tableName, String parameter, int columnIndex) {
        String stm = SELECT_FROM + tableName + WHERE_KEYWORD + columnIndex + "='" + parameter + "'";
        int entry = 0;
        try {
            myPreparedStatement = myConnection.prepareStatement(stm);
            myResultSet = myPreparedStatement.executeQuery();
            if (myResultSet.next()) {
                entry = myResultSet.getInt(columnIndex);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return entry;
    }
    
    /**
     * Given parameter and a columnIndex, returns that entire row entry for a table
     * @param tableName is name of table
     * @param parameter is parameter we are interested in
     * @param columnIndex is the index that we want the information for
     */
    public String retrieveEntryString(String tableName, String parameter, int columnIndex) {
        String stm = SELECT_FROM + tableName + WHERE_KEYWORD + columnIndex + "='" + parameter + "'";
        String entry = "";
        try {
            myPreparedStatement = myConnection.prepareStatement(stm);
            myResultSet = myPreparedStatement.executeQuery();
            if (myResultSet.next()) {
                entry = myResultSet.getString(columnIndex);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return entry;
    }

}
