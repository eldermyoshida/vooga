package vooga.rts.controller;

import vooga.rts.input.*;
import vooga.rts.player.AIPlayer;
import vooga.rts.player.HumanPlayer;
import vooga.rts.player.Player;
import vooga.rts.player.Team;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GameController extends AbstractController {

    private Map<Integer, Team> myTeams;
    private List<Player> myPlayers;

    public GameController () {
        myTeams = new HashMap<Integer, Team>();
        myPlayers = new ArrayList<Player>();
    }

    public void addPlayer (Player player, int teamID) {
        myPlayers.add(player);
        if (myTeams.get(teamID) == null) {
            addTeam(teamID);
        }
        myTeams.get(teamID).addPlayer(player);
    }

    public void addTeam (int teamID) {
        myTeams.put(teamID, new Team(teamID));
    }

    public void connect (/* NetworkGameInfo n */) {

    }

    @Override
    public void update (double elapsedTime) {
        for (Player f : myPlayers) {
            f.update(elapsedTime);
        }
    }

    @Override
    public void paint (Graphics2D pen) {
        for (Player p : myPlayers) {
            p.paint(pen);
        }
    }

    @Override
    public void onLeftMouseDown (PositionObject o) {

    }

    @Override
    public void onLeftMouseUp (PositionObject o) {
        // if it's not a gui thing
        HumanPlayer human = (HumanPlayer) myPlayers.get(0);
        human.handleLeftClick((int) o.getX(), (int) o.getY());
    }

    @Override
    public void onRightMouseDown (PositionObject o) {

    }

    @Override
    public void onRightMouseUp (PositionObject o) {
        // If it's not a GUI thing

        HumanPlayer human = (HumanPlayer) myPlayers.get(0);
        human.handleRightClick((int) o.getX(), (int) o.getY());
    }

    @Override
    public void activate (MainState gameState) {
        setupGame();
    }

    private void setupGame () {
        Player p1 = new HumanPlayer();
        p1.getUnits().addUnit(null);
        Player p2 = new HumanPlayer();
        p2.getUnits().addUnit(null);
    }
}
