package vooga.rts.action;

import java.lang.reflect.InvocationTargetException;

import vooga.rts.commands.Command;
import vooga.rts.util.Pixmap;
/*
 * This is the abstract super class for Actions
 * @author Ryan Fishel
 * @author Kevin Oh
 * @author Francesco Agosti
 * @author Wenshun Liu
 */

public interface Action {
   
    public void apply();
    
    public void update(Command command);
}
