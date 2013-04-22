package vooga.rts.networking.communications;

import java.io.Serializable;
<<<<<<< HEAD
import java.util.Observable;

import vooga.rts.networking.client.lobby.Player;

public class LobbyInfo extends Observable implements Serializable {
=======


/**
 * Basic lobby information used for sending across the network to the server browser. Lightweight so
 * we can send many of these very quickly.
 * 
 * @author David Winegar
 * @author Sean Wareham
 * 
 */
public class LobbyInfo implements Serializable {
>>>>>>> 8166fc9cb73f6ac9090a4407760269092e61d32b

    private static final long serialVersionUID = -1941237597305628081L;
    private String myLobbyName;
    private int myMaxPlayers;
    private String myMapName;
    private int myPlayersCount = 0;

    public LobbyInfo (String lobbyName, String mapName, int maxPlayers, int ID) {
        myLobbyName = lobbyName;
        myMaxPlayers = maxPlayers;
        myMapName = mapName;
    }

    /**
     * Returns the name of the lobby
     * 
     * @return
     */
    public String getLobbyName () {
        return myLobbyName;
    }

    /**
     * Returns the maximum number of players this lobby can hold.
     * 
     * @return
     */
    public int getMaxPlayers () {
        return myMaxPlayers;
    }

    /**
     * Returns name of the Map of the current lobby.
     * 
     * @return
     */
    public String getMapName () {
        return myMapName;
    }

    /**
     * Returns true if Lobby is full.
     * 
     * @return
     */
    public boolean isLobbyFull () {
        return (myPlayersCount == myMaxPlayers);
    }

    protected void removePlayer () {
        myPlayersCount--;
    }

}
