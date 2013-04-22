package vooga.rts.networking.communications;

import vooga.rts.networking.client.lobby.Player;

/**
 * Expanded lobby information used by the lobby model and view.
 * @author Sean Wareham
 *
 */
public class ExpandedLobbyInfo extends LobbyInfo {

    private static final long serialVersionUID = 8433220026468566119L;
    private int myPlayersPerTeam; 
    //[team][playerSlot]
    Player[][] myPlayers;
    //This variable exists in case we decide to switch the constructor parameters.
    private int myNumTeams;
    /**
     * 
     * @param lobbyName
     * @param mapName
     * @param maxPlayers
     * @param playersPerTeam
     * @param ID
     */

    public ExpandedLobbyInfo (String lobbyName, String mapName, int maxPlayers, int playersPerTeam, int ID) {
        super(lobbyName, mapName, maxPlayers, ID);
        myNumTeams = maxPlayers/ playersPerTeam;
        myPlayers = new Player[myNumTeams][playersPerTeam];
    }
    /**
 * This method is used to add a new player to the next available slot.  It operates under the assumption
 * that teams for game will not be astronomically large.
 * @param player player to add
 */
    public void addPlayer (Player player) {
        for (int team =0; team <myNumTeams; team++) {
            for (int slot = 0; slot< myPlayersPerTeam; slot++) {
                Player p = myPlayers[team][slot];
                if (p == null) {
                    p = player;
                    break;
                }
            }
        }
        //TODO: possibly add error message that all teams are full, probably not necessary as this should
        //only be called when such is not the case.
    }
    
    /**
     * Method to remove a player from assortment of players.  May end up a private method
     * called by a prettier public one that takes in a player object.
     * @param team
     * @param slot
     */
    public void removePlayer(int team, int slot) {
        super.removePlayer();
        myPlayers[team] [slot] = null;
    }
    
    /**
     * Method to move what team a player is in. Does support moving a player into an empty slot
     * and swapping in a new player with an existing player.  An empty player slot is represented by the null object.
     * @param prevTeam
     * @param prevSlot
     * @param newTeam
     * @param newSlot
     */
    public void movePlayer(int prevTeam, int prevSlot, int newTeam, int newSlot) {
        Player player = myPlayers[prevTeam][prevSlot];
        Player targetPlayer = myPlayers[newTeam] [newSlot];
            myPlayers[newTeam] [newSlot] = player;
            myPlayers[prevTeam] [prevSlot] = targetPlayer;
    }
    
    /**
     * Returns a 2d array consisting of all players.  Sorted such in the manner [team number] [player slot]
     * where the first index represents what team a player is in and the second corresponds
     * to the slot number (of its team) a player.
     * @return Player[][] 
     */
    public Player[][] getCurrentPlayers () {
        return myPlayers;
    }
    
}
