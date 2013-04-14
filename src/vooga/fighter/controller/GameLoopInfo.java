package vooga.fighter.controller;
import java.awt.Dimension;
import java.util.List;
import java.util.ArrayList;

import vooga.fighter.objects.utils.Health;
import vooga.fighter.util.Location;
import vooga.fighter.util.Pixmap;

/**
 * 
 * @author matthewparides
 *
 */
public class GameLoopInfo {
	List<Location> mySpriteLocations;
	List<Pixmap> mySprites;
	List<Health> myHealthStats;
	List<Dimension> myImageSizes;
	List<Integer> myScores;
	
	public GameLoopInfo() {
		mySpriteLocations = new ArrayList<Location>();
		mySprites = new ArrayList<Pixmap>();
		myHealthStats = new ArrayList<Health>();
		myImageSizes = new ArrayList<Dimension>();
		myScores = new ArrayList<Integer>();
	}
	
	/**
	 * @return the mySpriteLocations
	 */
	public List<Location> getSpriteLocations() {
		return mySpriteLocations;
	}
	
	/**
	 * @param mySpriteLocations the mySpriteLocations to set
	 */
	public void setSpriteLocations(List<Location> mySpriteLocations) {
		mySpriteLocations = mySpriteLocations;
	}
	
	/**
	 * 
	 * @param index
	 */
	public void setSpriteLocation(int index, Location loc) {
		mySpriteLocations.set(index, loc);
	}
	
	/**
	 * @return the mySprites
	 */
	public List<Pixmap> getSprites() {
		return mySprites;
	}
	
	/**
	 * @param mySprites the mySprites to set
	 */
	public void setSprites(List<Pixmap> mySprites) {
		mySprites = mySprites;
	}
	
	public void setSprite(int index, Pixmap pix) {
		mySprites.set(index, pix);
	}
	
	/**
	 * @return the myHealthStats
	 */
	public List<Health> getHealthStats() {
		return myHealthStats;
	}
	
	/**
	 * @param myHealthStats the myHealthStats to set
	 */
	public void setHealthStats(List<Health> myHealthStats) {
		myHealthStats = myHealthStats;
	}
	
	public void setHealthStat(int index, Health heal) {
		myHealthStats.set(index, heal);
	}
	
	/**
	 * @return the myImageSizes
	 */
	public List<Dimension> getImageSizes() {
		return myImageSizes;
	}
	
	/**
	 * @param myImageSizes the myImageSizes to set
	 */
	public void setImageSizes(List<Dimension> myImageSizes) {
		myImageSizes = myImageSizes;
	}
	
	/**
	 * 
	 */
	public void setImageSize(int index, Dimension dim) {
		myImageSizes.set(index, dim);
	}
	
	/**
     * 
     */
    public void setScores(List<Integer> scores) {
    	myScores = scores;
    }
    
    /**
     * 
     */
    public int getScore(int index) {
    	return myScores.get(index);
    }
    
    /**
     * 
     */
    public void setScore(int index, int score) {
    	myScores.set(index, score);
    }
    
    /**
     * 
     * @return
     */
    public List<Integer> getScores() {
    	return myScores;
    }
	
	
}
