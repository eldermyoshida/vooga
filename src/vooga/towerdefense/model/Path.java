package vooga.towerdefense.model;
import java.util.Iterator;
import java.util.List;

import vooga.towerdefense.util.Location;


public class Path implements Iterator<Location> {    
	private List<Location> myLocations;

	public Path(List<Location> locations) {
		myLocations = locations;
    }
    
	public void add(Location location) {
		myLocations.add(location);
	}

	@Override
    public boolean hasNext() {
		return myLocations.iterator().hasNext();
    }
    @Override
    public Location next () {
    	Location next = myLocations.iterator().next();
		myLocations.remove(0);
    	return next;
    }

    @Override
    public void remove () {
		myLocations.iterator().remove();
    }
    
    public void paint () {
		for (Location loc : myLocations) {
            
        }
    }
}
