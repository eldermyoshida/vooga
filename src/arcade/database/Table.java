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
    private static final String APOSTROPHE = "'";
    private static final String EQUALS = "='";
    
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
    
    /**
     * Selects all records from a table given a tablename
     * @param tableName is name of table
     */
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
     * @param columnField is the name of the column
     * @param parameter is parameter we are interested in
     * @param columnIndex is the index that we want the information for
     */
    public int retrieveEntryInt(String tableName, String columnField, String parameter, 
                                int columnIndex) {
        String stm = SELECT_FROM + tableName + WHERE_KEYWORD + columnField + 
                EQUALS + parameter + APOSTROPHE;
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
     * @param columnField is the name of the column
     * @param parameter is parameter we are interested in
     * @param columnIndex is the index that we want the information for
     */
    public String retrieveEntryString(String tableName, String columnField, 
                                      String parameter, int columnIndex) {
        String stm = SELECT_FROM + tableName + WHERE_KEYWORD + columnField + 
                EQUALS + parameter + APOSTROPHE;
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
    
    /**
     * Given parameter and a columnIndex, returns that entire row entry for a table
     * @param tableName is name of table
     * @param columnField is the name of the column
     * @param parameter is parameter we are interested in
     * @param columnIndex is the index that we want the information for
     */
    public boolean retrieveEntryBoolean(String tableName, String columnField, 
                                        String parameter, int columnIndex) {
        String stm = SELECT_FROM + tableName + WHERE_KEYWORD + columnField + 
                EQUALS + parameter + APOSTROPHE;
        boolean entry = false;
        try {
            myPreparedStatement = myConnection.prepareStatement(stm);
            myResultSet = myPreparedStatement.executeQuery();
            if (myResultSet.next()) {
                entry = myResultSet.getBoolean(columnIndex);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return entry;
    }
    
    /**
     * Executes a statement for a table
     * @param stm is the statement
     */
    public void executeStatement (String stm) {
        try {
            myPreparedStatement = myConnection.prepareStatement(stm);
            myPreparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
