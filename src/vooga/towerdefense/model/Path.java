package vooga.towerdefense.model;
import java.util.Iterator;
import java.util.List;

import vooga.towerdefense.util.Location;


public class Path implements Iterator<Location> {    
    private List<Location> myPoints;

    public Path(List<Location> points) {
        myPoints = points;
    }
    
    @Override
    public boolean hasNext() {
        return myPoints.iterator().hasNext(); 
    }
    @Override
    public Location next () {
        return myPoints.iterator().next();
    }

    @Override
    public void remove () {
        myPoints.iterator().remove();
    }
}
