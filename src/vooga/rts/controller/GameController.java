package vooga.rts.controller;

import vooga.rts.command.*;

import java.awt.Graphics2D;
import java.util.List;


public class GameController extends AbstractController {

	private List<ICommand> myCommands;
	
    public GameController () {

    }

    public void addPlayer (/*Player player, int teamID*/) {
        
    }
    
    public void addTeam (int teamID) {
        
    }
    
    public void connect (/*NetworkGameInfo n*/) {
        
    }
    
    @Override
    public void receiveUserInput (Action a) {
        for (ICommand c : myCommands) {
        	if (c.getAction().equals(a)) {
        		c.executeCommand(a);
        	}
        		
        }
    }

    @Override
    public void update (double elapsedTime) {
        // TODO Auto-generated method stub

    }

    @Override
    public void paint (Graphics2D pen) {
        // TODO Auto-generated method stub

    }


}
