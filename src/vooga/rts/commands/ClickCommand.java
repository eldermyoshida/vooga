package vooga.rts.commands;

import util.input.PositionObject;
import vooga.rts.util.Location;


/**
 * This class and the position command are the same thing, so this one can be deleted to avoid confusion
 * @author Challen Herzberg-Brovold
 * 
 */
public class ClickCommand extends Command {

    public Location myPosition;

    /**
     * 
     * @param inputName
     * @param position the position of the click
     */
    public ClickCommand (String inputName, PositionObject position) {
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
