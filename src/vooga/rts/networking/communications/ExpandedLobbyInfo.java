package vooga.rts.networking.communications;

import java.util.ArrayList;
import java.util.List;
import vooga.rts.networking.client.lobby.Player;


/**
 * Expanded lobby information used by the lobby model and view. Passed back and forth between the
 * server and client.
 * 
 * @author Sean Wareham
 * @author David Winegar
 * 
 */
public class ExpandedLobbyInfo extends LobbyInfo {

    private static final long serialVersionUID = 8433220026468566119L;
    List<ArrayList<Player>> myPlayerMap = new ArrayList<ArrayList<Player>>();
    private int myMaxTeams;

    /**
     * Creates the expanded lobby info.
     * 
     * @param lobbyName
     * @param mapName
     * @param maxPlayers
     * @param ID
     */
    public ExpandedLobbyInfo (String lobbyName,
                              String mapName,
                              int maxPlayers,
                              int ID) {
        super(lobbyName, mapName, maxPlayers, ID);
        myMaxTeams = maxPlayers;
    }

    /**
     * Copies the existing lobbyInfo parameters to make the new lobbyInfo.
     * 
     * @param lobbyInfo info to copy
     */
    public ExpandedLobbyInfo (LobbyInfo lobbyInfo) {
        this(lobbyInfo.getLobbyName(), lobbyInfo.getMapName(), lobbyInfo.getMaxPlayers(), lobbyInfo
                .getID());
    }

    /**
     * Copies the existing lobbyInfo parameters to make the new lobbyInfo, except it changes the ID.
     * 
     * @param lobbyInfo info to copy
     * @param newID new ID to give
     */
    public ExpandedLobbyInfo (LobbyInfo lobbyInfo, int newID) {
        this(lobbyInfo.getLobbyName(), lobbyInfo.getMapName(), lobbyInfo.getMaxPlayers(), newID);
    }

    /**
     * This method is used to add a new player to the next available slot. It operates under the
     * assumption
     * that teams for game will not be astronomically large.
     * 
     * @param player player to add
     */
    public int addPlayer (Player player) {
        addPlayer();
        for (int i = 0; i < myMaxTeams; i++) {
            ArrayList<Player> team = myPlayerMap.get(i);
            if (team == null) {
                team = new ArrayList<Player>();
                team.add(player);
                myPlayerMap.add(i, team);
                return i + 1;
            }
        }
        // should never trigger
        myPlayerMap.get(0).add(player);
        return 1;
    }

    /**
     * Removes the given player from the lobby.
     * 
     * @param player to remove
     */
    public void removePlayer (Player player) {
        removePlayer();
        for (ArrayList<Player> team : myPlayerMap) {
            team.remove(player);
        }
    }

    /**
     * Moves the given player to the team number
     * 
     * @param player
     * @param team
     */
    public void movePlayer (Player player, int team) {
        if (team <= myMaxTeams) {
            removePlayer(player);
            // Keep the player count correct
            addPlayer();
            myPlayerMap.get(team - 1).add(player);
        }
    }

    /**
     * returns the max teams.
     * 
     * @return maximum number of teams
     */
    public int getMaxTeams () {
        return myMaxTeams;
    }

}
