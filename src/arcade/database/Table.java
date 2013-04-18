package arcade.database;

/**
 * Creates and updates table
 * @author Natalia Carvalho
 */
public abstract class Table {
    
    abstract void createDatabase();
    
    abstract void closeConnection();
    
    abstract void printEntireTable();

}
