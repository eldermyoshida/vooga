package vooga.fighter.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import vooga.fighter.game.Mode;
import javax.swing.Timer;

/**
 * 
 * @author Jerry Li
 *
 */
public class LevelController extends Controller {
    
    public static final int FRAMES_PER_SECOND = 25;
    // better way to think about timed events (in milliseconds)
    public static final int ONE_SECOND = 1000;
    public static final int DEFAULT_DELAY = ONE_SECOND / FRAMES_PER_SECOND;
    private Controller myNextController;
    private ResourceBundle myLevelNames;
    
    private static String DEFAULT_RESOURCE = "vooga.fighter.config.LevelConfig";
    
    public LevelController (Mode model, String id, ManagerDelegate manager) {
        super(model, id, manager);
        myLevelNames = ResourceBundle.getBundle(DEFAULT_RESOURCE);
        
        //The reason why I'm not calling loadGame is because I feel like GameManager should call loadgame.
        //For whatever reason I don't like having controller calling its own loadgame. A game manager can
        //initiate the controller and tell it when to load game i feel. This makes things more flexible imo. 
        //Also, this is for logic/practical reasons. The menu button will send its data string to the gamemanager,
        //and the game manager loads the game with the string as the parameter.
    }
    
    public void loadGame(String levelName) {
        String filePath = myLevelNames.getString(levelName);
        myGame = new Mode(levelName, filePath, this);
        start();
    }
    
    
    public void start () {
        final int stepTime = DEFAULT_DELAY;
        // create a timer to animate the canvas
        Timer timer = new Timer(stepTime, 
            new ActionListener() {
                public void actionPerformed (ActionEvent e) {
                    myGame.update((double) stepTime / ONE_SECOND, DEFAULT_BOUNDS);
                }
            });
        // start animation
        timer.start();
    }
    
    
    
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
