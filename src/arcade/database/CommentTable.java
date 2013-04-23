package arcade.database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Creates and updates user table
 * this clearly needs to be refactored because there is duplicate code
 * @author Natalia Carvalho
 */
public class CommentTable extends Table {

    private Connection myConnection;
    private PreparedStatement myPreparedStatement; 
    private ResultSet myResultSet;
    
    /**
     * Constructor but eventually I want to make this part of the abstract class
     */
    public CommentTable() {
        super();
        myConnection = getDatabaseConnection().getConnection();
        myPreparedStatement = getDatabaseConnection().getPreparedStatement();
        myResultSet = getDatabaseConnection().getResultSet();
    }
    
    /**
     * Add new comment to table
     * @param gameid is game id
     * @param userid is user id
     * @param comment is the comment to be added
     */
    public void addNewComment (String gameid, String userid, String comment) {
        
        String stm = "INSERT INTO scores(gameid, userid, comment) VALUES (?, ?, ?)";
        try {
            myPreparedStatement = myConnection.prepareStatement(stm);
            myPreparedStatement.setString(Keys.COM_GAMEID_COLUMN_INDEX, gameid);
            myPreparedStatement.setString(Keys.COM_USERID_COLUMN_INDEX, userid);
            myPreparedStatement.setString(Keys.COM_COMMENT_COLUMN_INDEX, comment);
            myPreparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            writeErrorMessage("Error adding new comment for this game in " +
                    "CommentTable.java @ Line 53");
        }
    }
    
    /**
     * Gets all comments for a given game
     * @param gameid is game id
     */
    public List<String> getAllCommentsForGame(String gameid) {
        String stm = "SELECT gameid FROM scores WHERE gameid='" + gameid + "'";
        List<String> comments = new ArrayList<String>();
        try {
            myPreparedStatement = myConnection.prepareStatement(stm);
            myResultSet  = myPreparedStatement.executeQuery();
            while (myResultSet.next()) {
                comments.add(myResultSet.getString(Keys.COM_COMMENT_COLUMN_INDEX));
            }
            return comments;
        }
        catch (SQLException e) {
            writeErrorMessage("Error getting all comments for this game in " +
                    "CommentTable.java @ Line 72");
        }
        return comments;
    }

    /**
     * Prints entire table
     */
    public void printEntireTable () {
        myResultSet = selectAllRecordsFromTable(Keys.COM_TABLE_NAME);
        try {
            while (myResultSet.next()) {
                System.out.print(myResultSet.getString(Keys.COM_GAMEID_COLUMN_INDEX) + 
                                 Keys.SEPARATOR);
                System.out.print(myResultSet.getString(Keys.COM_USERID_COLUMN_INDEX) + 
                                 Keys.SEPARATOR);                
                System.out.print(myResultSet.getString(Keys.COM_COMMENT_COLUMN_INDEX) + 
                                 Keys.SEPARATOR);
                System.out.println(myResultSet.getString(Keys.COM_COMMENTID_COLUMN_INDEX) + 
                                   Keys.SEPARATOR);
            }
        }
        catch (SQLException e) {
            writeErrorMessage("Error printing entire table in CommentTable.java @ Line 91");
        }
    }

  

}