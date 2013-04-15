package vooga.rts.controller;

import vooga.rts.controller.Command;
import vooga.rts.input.PositionObject;
import vooga.rts.util.Location;

public class LeftClickCommand extends Command {
    
    public Location myPosition;
    
    public LeftClickCommand (String inputName, PositionObject position) {
        super(inputName);
        myPosition = new Location(position.getX(), position.getY());
    }
    
    public Location getPosition () {
        return myPosition;
    }
}
