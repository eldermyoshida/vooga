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
    private GameElement myElement;

    public Tile (Point center, boolean walkable, boolean buildable) {
        myIsWalkable = walkable;
        myIsBuildable = buildable;
        myCenter = center;
    }

    public void update (double elapsedTime) {
        if (myElement != null) {
            myElement.update(elapsedTime);
        }
    }
    
    public Point getCenter() {
        return myCenter;
    }
    
    public boolean containsElement() {
        return myElement != null;
    }
    
    public GameElement getElement() {
        return myElement;
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
        myElement = t;
        setBuildable(false);
        setWalkable(false);
    }

    public void deleteTower () {
        myElement = null;
        setBuildable(true);
    }
    
    public String toString() {
        return "(" + myCenter.getX() + ", " + myCenter.getY() + ")";
    }

}
