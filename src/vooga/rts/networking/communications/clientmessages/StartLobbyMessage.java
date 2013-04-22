package vooga.rts.networking.communications.clientmessages;

import vooga.rts.networking.server.ConnectionThread;
import vooga.rts.networking.server.IThreadContainer;

public class StartLobbyMessage extends ClientInfoMessage {

    private static final long serialVersionUID = -6507449287521383418L;
    private String myMapName;
    private String myLobbyName;
    private int myMaxPlayers;
    private int myPlayersPerTeam;
    
    public StartLobbyMessage (String lobbyName, String mapName, int maxPlayers, int playersPerTeam) {
        myMapName = mapName;
        myLobbyName = lobbyName;
        myMaxPlayers = maxPlayers;
        myPlayersPerTeam = playersPerTeam;
    }

    @Override
    public void affectServer (ConnectionThread thread, IThreadContainer server) {
        server.startLobby(thread, myLobbyName, myMapName, myMaxPlayers, myPlayersPerTeam);
    }

}
