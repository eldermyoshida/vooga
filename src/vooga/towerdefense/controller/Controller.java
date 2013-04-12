package vooga.towerdefense.controller;

import vooga.towerdefense.util.Location;

public class Controller {
    private boolean onBuildMode;
    
    
    public Controller() {
        onBuildMode = false;
    }
    
    /**
     * handles a click to the map appropriately depending
     *          on the mode.
     * @param p is the location of the click
     */
    public void handleMapClick(Point p) {
        if (onBuildMode) {
            
        } 
        else {
            
        }
    }
    
    /**
     * paints the map on the view.
     */
    public void paintMap() {
        //TODO: paint the map to the view
    }
}