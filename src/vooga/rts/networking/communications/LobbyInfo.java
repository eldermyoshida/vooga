package vooga.rts.networking.communications;

import java.io.Serializable;
import vooga.rts.networking.client.lobby.Player;

public class LobbyInfo implements Serializable {

    private static final long serialVersionUID = 8433220026468566119L;
    private String myLobbyName;
    private int myMaxPlayers;
    private String myMapName;
    private int myPlayersCount;
    private int myPlayersPerTeam; 
    //[team][playerSlot]
    private Player[][] myPlayers;
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
    public LobbyInfo (String lobbyName, String mapName, int maxPlayers, int playersPerTeam, int ID) {
        myLobbyName = lobbyName;
        myMaxPlayers = maxPlayers;
        myMapName = mapName;
        myPlayersPerTeam = playersPerTeam;
        myNumTeams = maxPlayers/ playersPerTeam;
        myPlayers = new Player[myNumTeams][playersPerTeam];
    }
    /**
     * Returns the name of the lobby
     * @return
     */
    public String getLobbyName () {
        return myLobbyName;
    }
    /**
     * Returns the maximum number of players this lobby can hold.
     * @return
     */
    public int getMaxPlayers () {
        return myMaxPlayers;
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
    
    /**
     * Returns name of the Map of the current lobby.
     * @return
     */
    public String getMapName () {
        return myMapName;
    }
    
    /**
     * Returns true if Lobby is full.
     * @return
     */
    public boolean isLobbyFull() {
        return (myPlayersCount == myMaxPlayers);
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
        myPlayers[team] [slot] = null;
        myPlayersCount--;
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
    
}
