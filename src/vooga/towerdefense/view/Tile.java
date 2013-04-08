package view;
import gameElements.Tower;

import util.Location;


public class Tile {
    private boolean myIsWalkable;
    private boolean myIsBuildable;
    private Location myCenter;
    private Tower myTower;
    
    public void update(double elapsedTime) {
        if (myTower != null) {
            myTower.update(elapsedTime);
        }        
    }
    
    public void setWalkable(boolean walkable) {
        myIsWalkable = walkable;
    }
    
    public boolean isWalkable() {
        return myIsWalkable;
    }
    
    public void setBuildable(boolean buildable) {
        myIsBuildable = buildable;
    }
    
    public boolean isBuildable() {
        return myIsBuildable;
    }
    
    public void setTower(Tower t) {
        myTower = t;
        setBuildable(false);
        setWalkable(false);
    }
    
    public void deleteTower() {
        myTower = null;
        setBuildable(true);
    }
     
}
