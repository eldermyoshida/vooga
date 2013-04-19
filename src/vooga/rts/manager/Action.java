package vooga.rts.manager;

import java.util.List;
import vooga.rts.controller.Command;
import vooga.rts.gamedesign.sprite.gamesprites.interactive.InteractiveEntity;
import vooga.rts.gamedesign.sprite.gamesprites.interactive.units.Unit;
import vooga.rts.util.Location;
import vooga.rts.util.Location3D;

public class Action {
    
    // Example class
    private List<Unit> myUnits;
    private Location3D myLocation;
    
    public Action () {
        myLocation = new Location3D(100, 100, 0);
    }
    
    public void execute () {
        for (InteractiveEntity u: myUnits) {
            u.move(myLocation);
        }
    }
    
    public void update (Command command, List<Unit> units) {
        myLocation = new Location3D(100, 100, 0);
        myUnits = units;
    }
}
