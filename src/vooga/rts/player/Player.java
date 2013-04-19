package vooga.rts.player;

import vooga.rts.controller.Command;
import vooga.rts.controller.Controllable;
import vooga.rts.controller.Controller;
import vooga.rts.manager.Manager;
import vooga.rts.manager.ResourceManager;

public class Player implements Controller {

    private Controllable myManager;
    private ResourceManager myResources;
    private int myTeamID;
    
    public Player (int id) {
        myManager = new Manager();
        myResources = new ResourceManager();
        myTeamID = id;
    }
    
    @Override
    public void sendCommand (Command command) {
        // TODO Auto-generated method stub

    }
    
    public Controllable getManager () {
        return myManager;
    }

}
