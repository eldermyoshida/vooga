package vooga.fighter.controller;

import java.util.List;
import vooga.fighter.game.*;
import vooga.fighter.objects.*;
import java.util.ResourceBundle;

public class MenuController extends Controller {
    
    private Controller myNextController;
    private ResourceBundle myLevelNames;
    
    private static String DEFAULT_RESOURCE = "vooga.fighter.config.LevelConfig";
    
    public MenuController (GameInstance model) {
        super(model);
        myLevelNames = ResourceBundle.getBundle(DEFAULT_RESOURCE);
    }
    
    public MenuController (GameInstance model, String id) {
        super(model, id);
    }
    
    public MenuController (String id) {
        super(id);
    }
    
    public void createMenu(String menuName) {
        String filePath = myLevelNames.getString(menuName);
        GameInstance menu = new GameInstance(menuName, filePath);
    }
    
    /**
     * Sets next mode
     * @param controller
     */
    public void setNextMode(Controller controller) {
        myNextController = controller;
    }
    
    /**
     * Returns next mode
     */
    public Controller switchMode(Controller controller) {
        setNextMode(controller);
        return myNextController;
    }
    
    /**
     * Checks special occurences of game state. 
     */
    public void checkConditions() {
        //Couple of reasons for this method as opposed to just one switchMode()
        //button is selected, switch mode
        //If player is knocked out, flash sign
        //If player health is very low, change display
        //If player controller disconnected, flash splash/message 
        //etc......
        
        //checkLowPlayerHealth()
        //checkDisconnect()
        //checkSpecial()      etc. 
        
        //Essentially check conditions is different than update in that
        //it checks special occurences in games. Update will check for bounds,
        //interactions, and all that, but as far as significant changes to game state goes we should
        //use check conditions
    }
    
    /**
     * Exits program. 
     */
    public void exit() {
        System.exit(0);
    }

}
