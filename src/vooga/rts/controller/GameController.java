package vooga.rts.controller;

import vooga.rts.command.*;
import vooga.rts.player.Player;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class GameController extends AbstractController {

	private List<ICommand> myCommands;
	private Map<Integer, List<Player>> myTeams;
	private List<Player> myPlayers;
	
    public GameController () {
    	
    }

    public void addHumanPlayer (Player player, int teamID) {
        myPlayers.add(player);
        myTeams.get(teamID).add(player);
        myTeams.put(teamID, myTeams.get(teamID));
    }
    
    public void addTeam (int teamID) {
        myTeams.put(teamID, new ArrayList<Player>());
    }
    
    public void connect (/*NetworkGameInfo n*/) {
        
    }
    
    /**
    @Override
    public void receiveUserInput (Action a) {
        for (ICommand c : myCommands) {
        	if (c.getAction().equals(a)) {
        		c.executeCommand(a);
        	}
        		
        }
    }
    */

    @Override
    public void update (double elapsedTime) {
        // TODO Auto-generated method stub

    }

    @Override
    public void paint (Graphics2D pen) {
        // TODO Auto-generated method stub

    }

    @Override
    public void receiveUserInput () {
        // TODO Auto-generated method stub
        
    }


}
