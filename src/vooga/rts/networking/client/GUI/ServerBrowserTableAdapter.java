package vooga.rts.networking.client.GUI;

import javax.swing.table.AbstractTableModel;


/**
 * Adapter between the ServerBrowserView's table and the data from the server.
 * TODO connect with actual model
 * 
 * @author David Winegar
 * 
 */
public class ServerBrowserTableAdapter extends AbstractTableModel {
    private static final long serialVersionUID = -4753703508648678535L;

    private String[] myColumnNames = { "Server Name",
                                      "Map",
                                      "Players" };

    private int[][] myTest = { { 3, 3, 3 }, { 4, 4, 4 }, { 5, 5, 5 } };

    @Override
    public int getColumnCount () {
        return myColumnNames.length;
    }

    @Override
    public int getRowCount () {
        return myTest.length;
    }

    @Override
    public String getColumnName (int col) {
        return myColumnNames[col];
    }

    @Override
    public Object getValueAt (int arg0, int arg1) {
        return myTest[arg0][arg1];
    }

}
