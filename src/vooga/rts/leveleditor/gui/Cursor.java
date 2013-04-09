package vooga.rts.leveleditor.gui;

import vooga.rts.leveleditor.components.EditableMap;
import vooga.rts.util.Location;



/**
 * this class is responsible for the communications between EditableMap and ResourceButtons
 * @author Ziqiang Huang
 *
 */
public class Cursor {
    
    private ResourceButton myCurrentResourceButton;
    private Location myCurrentLocation;
    private EditableMap myMap;
    
    
    
    public Cursor (EditableMap map) {
        
    }
    
    /**
     * get the index of a ResourceButton based the position of cursor
     * @return
     */
    
    public int getResourceButtonIndex() {
        return myCurrentResourceButton.getIndex();
    }
    
    /**
     * set the value of a tile based on the position of cursor
     * @param index
     */
    public void setTileValue(int index) {
        int x = (int) myCurrentLocation.getX();
        int y = (int) myCurrentLocation.getY();
        //myMap.myIndexMatrix[x][y] = index;
        
    }
    
    /**
     * clear the informations stored in cursor
     */
    public void clear() {
        
    }
}
