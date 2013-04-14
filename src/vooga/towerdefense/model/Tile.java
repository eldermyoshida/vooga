package vooga.towerdefense.model;

import java.awt.Point;
import vooga.towerdefense.gameElements.GameElement;
import vooga.towerdefense.util.Location;
import vooga.towerdefense.view.TDView;


public class Tile {
    private TDView myView;
    private boolean myIsWalkable;
    private boolean myIsBuildable;
    private Point myCenter;
    private GameElement myTower;

    public Tile (Point center, boolean walkable, boolean buildable) {
        myIsWalkable = walkable;
        myIsBuildable = buildable;
        myCenter = center;
    }

    public void update (double elapsedTime) {
        if (myTower != null) {
            myTower.update(elapsedTime);
        }
    }
    
    public Point getCenter() {
        return myCenter;
    }

    public void setWalkable (boolean walkable) {
        myIsWalkable = walkable;
    }

    public boolean isWalkable () {
        return myIsWalkable;
    }

    public void setBuildable (boolean buildable) {
        myIsBuildable = buildable;
    }

    public boolean isBuildable () {
        return myIsBuildable;
    }

    public void setTower (GameElement t) {
        myTower = t;
        setBuildable(false);
        setWalkable(false);
    }

    public void deleteTower () {
        myTower = null;
        setBuildable(true);
    }
    
    public String toString() {
        return "(" + myCenter.getX() + ", " + myCenter.getY() + ")";
    }

}
