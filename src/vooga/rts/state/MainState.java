package vooga.rts.state;

import java.util.Observer;
import vooga.rts.controller.Controller;
import vooga.rts.controller.LoadingController;
import vooga.rts.controller.MenuController;
import vooga.rts.controller.Player;
import vooga.rts.input.Input;
import vooga.rts.manager.Manager;
import vooga.rts.gui.Window;
import vooga.rts.util.FrameCounter;


public class MainState implements Observer {

    private final static String DEFAULT_INPUT_LOCATION = "vooga.rts.resources.properties.Input";
    private Controller myPlayer;
    private LoadingController myLoadingController;
    private MenuController myMenuController;
    private Window myWindow;
    private FrameCounter myFrames;
    private MainState myGameState;
    private Input myInput;
    
    public MainState () {
        myWindow = new Window();
        myInput = new Input(DEFAULT_INPUT_LOCATION, myWindow.getCanvas());
        myPlayer = new Player(new Manager()); //Might want to change the manager at some point
        
    }
}
