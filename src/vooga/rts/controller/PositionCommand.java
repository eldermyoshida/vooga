package vooga.rts.controller;

import vooga.rts.commands.Command;
import vooga.rts.input.PositionObject;
import vooga.rts.util.Location;

/**
 * A ClickCommand is different from a Command in that in addition the name of 
 * the action (right or left click) it also holds the position of the click
 * 
 * @author Challen Herzberg-Brovold
 *
 */
public class PositionCommand extends Command {
    
    public Location myPosition;
    
    /**
     * 
     * @param inputName 
     * @param position the position of the click
     */
    public PositionCommand (String inputName, PositionObject position) {
        super(inputName);
        myPosition = new Location(position.getX(), position.getY());
    }
    
    /**
     * 
     * @return the position of the click.
     */
    public Location getPosition () {
        return myPosition;
    }
}
