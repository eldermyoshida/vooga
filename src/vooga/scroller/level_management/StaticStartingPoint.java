package vooga.scroller.level_management;

import util.Location;
import vooga.scroller.level_editor.Level;

public class StaticStartingPoint implements StartPoint {

    private Level myLevel;
    private Location myLocation;
    
    public StaticStartingPoint (Level level, Location location) {
        myLevel = level;
        myLocation = location;
    }

    @Override
    public int getLevelId () {
        return myLevel.getID();
    }

    @Override
    public Location getStartLocation () {       
        return myLocation;
    }

}
