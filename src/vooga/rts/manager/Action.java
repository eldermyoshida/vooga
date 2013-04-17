package vooga.rts.manager;

import java.util.List;
import vooga.rts.gamedesign.sprite.InteractiveEntity;
import vooga.rts.util.Location;

public class Action {
    
    private List<InteractiveEntity> myUnits;
    private Location myLocation;
    
    public Action (List<InteractiveEntity> units, Location location) {
        myUnits = units;
        myLocation = location;
    }
    
    public void execute () {
        for (InteractiveEntity u: myUnits) {
            u.move(myLocation);
        }
    }
}
