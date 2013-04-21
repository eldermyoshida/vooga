package vooga.rts.networking.communications.clientmessages;

import vooga.rts.networking.server.ConnectionThread;
import vooga.rts.networking.server.IThreadContainer;

public class StartLobbyMessage extends ClientInfoMessage {

    private String myMapName;
    private String myServerName;
    private int myMaxPlayers;
    private int myPlayersPerTeam;
    
    public StartLobbyMessage (String mapName, String serverName, int maxPlayers, int playersPerTeam) {
        myMapName = mapName;
        myServerName = serverName;
        myMaxPlayers = maxPlayers;
        myPlayersPerTeam = playersPerTeam;
    }

    @Override
    public void affectServer (ConnectionThread thread, IThreadContainer server) {
        server.startLobby(thread, myMapName, myServerName, myMaxPlayers, myPlayersPerTeam);
    }

}
