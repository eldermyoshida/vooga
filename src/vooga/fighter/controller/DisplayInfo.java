package vooga.fighter.controller;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import util.Location;
import vooga.fighter.util.Paintable;


/**
 * 
 * @author Jack Matteucci
 * @author Jerry Li
 * @author Wayne You
 *
 */
public class DisplayInfo extends Observable implements ViewDataSource{
    
    

    private List<Location> myLocations;
    private List<Paintable> myGamePaintables;
    private List<Paintable> myHUDPaintables;
    private List<Dimension> myImageSizes;

    public DisplayInfo() {
        myLocations = new ArrayList<Location>();
        myGamePaintables = new ArrayList<Paintable>();
        myHUDPaintables = new ArrayList<Paintable>();
        myImageSizes = new ArrayList<Dimension>();
    }
	
    /**
     * @return object location at list index
     */

    public Paintable getPaintable (int index) {
        if (index >= myGamePaintables.size()) {
            return myHUDPaintables.get(index - myGamePaintables.size());
        }
        return myGamePaintables.get(index);
    }

    public Location getLocation(int index) {
        if (index >= myGamePaintables.size()) {
            return new Location(0,0);
        }
        return myLocations.get(index);
    }

    /**
     * @return size of sprite at list index
     */
    public Dimension getSize (int index) {
        if (index >= myGamePaintables.size()) {
            return new Dimension(0,0);
        }
        return myImageSizes.get(index);
    }
    
    /**
     * @param myLocations the mySpriteLocations to set
     */
    public void setGameObjectLocations(List<Location> spriteLocations) {
        myLocations = spriteLocations;
    }

    /**
     * 
     * @param index
     */
    public void setGameObjectLocation(int index, Location loc) {
        myLocations.set(index, loc);
    }

    /**
     * @return the mySprites
     */
    public List<Paintable> getGameObjects() {
        return myGamePaintables;
    }

    /**
     * @param myGamePaintables the mySprites to set
     */
    public void setGamePaintables(List<Paintable> gamePaintables) {
        myGamePaintables = gamePaintables;
    }

    public void setGamePaintable(int index, Paintable p) {
        myGamePaintables.set(index, p);
    }
    
    public List<Dimension> getImageSizes() {
        return myImageSizes;
    }

    /**
     * @param myImageSizes the myImageSizes to set
     */
    public void setSizes(List<Dimension> sizes) {
        myImageSizes = sizes;
    }

    /**
     * 
     */
    public void setSize(int index, Dimension dim) {
        myImageSizes.set(index, dim);
    }

    /**
     * @return the mySpriteLocations
     */
    protected List<Location> getLocations() {
        return myLocations;
    }
    
    public void clear(){
        myGamePaintables.clear();
        myImageSizes.clear();
        myLocations.clear();
    }
    
    public int ObjectNumber (){
    	return myGamePaintables.size() + myHUDPaintables.size();
    }
    
    public void update(){
    }
   

    public void addHUDDisplay (Paintable element) {
        myHUDPaintables.add(element);
    }
    
    public void clearHUD () {
        myHUDPaintables.clear();
    }

   

}
