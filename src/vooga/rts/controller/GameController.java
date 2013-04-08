package vooga.rts.controller;

import vooga.rts.input.*;
import vooga.rts.player.Player;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GameController extends AbstractController {

	private Map<Integer, List<Player>> myTeams;
	private List<Player> myPlayers;

	public GameController() {

	}

	public void addHumanPlayer(Player player, int teamID) {
		myPlayers.add(player);
		myTeams.get(teamID).add(player);
		myTeams.put(teamID, myTeams.get(teamID));
	}

	public void addTeam(int teamID) {
		myTeams.put(teamID, new ArrayList<Player>());
	}

	public void connect(/* NetworkGameInfo n */) {

	}


	@Override
	public void update(double elapsedTime) {
	}

	@Override
	public void paint(Graphics2D pen) {
		for (Player p : myPlayers) {
			p.paint(pen);
		}
	}
	
	@Override
	public void onLeftMouseDown(PositionObject o) {
		
	}
	
	@Override
	public void onLeftMouseUp(PositionObject o) {
		
	}
	
	@Override
	public void onRightMouseDown(PositionObject o) {
		
	}
	
	@Override
	public void onRightMouseUp(PositionObject o) {
		
	}

}
