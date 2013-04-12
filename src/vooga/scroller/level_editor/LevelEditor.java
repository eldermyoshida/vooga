
package vooga.scroller.level_editor;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import vooga.scroller.scrollingmanager.ScrollingManager;
import vooga.scroller.sprite_superclasses.Player;
import vooga.scroller.util.Location;
import vooga.scroller.level_editor.commands.Command;
import vooga.scroller.level_editor.commands.CommandLibrary;


/**
 * Level Editor creates and edits an Editable Level based on input from the
 * iLEView myView.
 * 
 * @author Danny Goodman
 *
 */

import vooga.scroller.util.Editable;
import vooga.scroller.viewUtil.IView;

public class LevelEditor implements ILevelEditor {

    private static final String SPACE = " ";
    private static final String NO_METHOD_COMMAND_ERROR = "Command does not exist";
    private static final String PARAM_COMMAND_ERROR = "Incorrect Parameters";
    private static final String DEFAULT_COMMAND_ERROR = "Incorrect Command";
    private Editable myLevel;
    private ScrollingManager myScrollingManager;
    private Editable mySpriteGrid;

    public LevelEditor (ISpriteLibrary lib) {
        myLevel = new Level(1, myScrollingManager); 
    }

    public LevelEditor (String language, ISpriteLibrary lib) {
        this(lib);
    }

    @Override
    public void processCommand (Editable m, String cmd) {
        // TODO Auto-generated method stub
        mySpriteGrid = m;
        processCommand(cmd);
    }

    @Command
    public void createSprite (int x, int y, int id) {
        
    }
    
    @Command
    public void deleteSprite (int x, int y) {
        mySpriteGrid.deleteSprite(x,y);
    }

    @Command
    public void changeBackground (int id) {
        //TODO change Background based on id
    }

    /**
     * Takes in the command name and parameters all as one String to be processed.
     * Splits the string by White Space and obtains name and parameters from String.
     * Calls @Command method through reflection.
     * 
     * @param command - the input from the LEView. 
     */
    
    private void processCommand (String command) {
        String[] splitCommand = command.split(SPACE);
        String name = splitCommand[0];
        Object[] params = getParams(splitCommand);
        try {
            Method m = CommandLibrary.get(name);
            m.invoke(this, params);
        }
        catch (NullPointerException e) {
          //TODO NO_METHOD_COMMAND_ERROR = "Command does not exist";
        }
        catch (IllegalAccessException e) {
          //TODO DEFAULT_COMMAND_ERROR = "Incorrect Command";
        }
        catch (IllegalArgumentException e) {
          //TODO PARAM_COMMAND_ERROR = "Incorrect Parameters";
        }
        catch (InvocationTargetException e) {
            //TODO DEFAULT_COMMAND_ERROR = "Incorrect Command";
        }
    }

    /**
     * Takes in the command as a Sting[] and returns the parameters as an Integer[].
     * The output is used by the processCommand method to invoke the command method.
     * @param splitCommand - command as a String[] with name followed by params.
     * @return Integer[] of parameters
     */
    private Integer[] getParams (String[] splitCommand) {
        Integer[] params = new Integer[splitCommand.length - 1];
        for (int i = 0; i < params.length; i++) {
            params[i] = Integer.parseInt(splitCommand[i + 1]);
        }
        return params;
    }

}
