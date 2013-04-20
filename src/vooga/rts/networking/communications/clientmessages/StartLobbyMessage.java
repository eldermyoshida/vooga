package vooga.rts.networking.communications.clientmessages;

import vooga.rts.networking.server.ConnectionThread;
import vooga.rts.networking.server.IThreadContainer;

public class StartLobbyMessage extends ClientInfoMessage {

    private String myMapName;
    private String myServerName;
    
    public StartLobbyMessage (String mapName, String serverName) {
        myMapName = mapName;
        myServerName = serverName;
    }

    @Override
    public void affectServer (ConnectionThread thread, IThreadContainer server) {
        server.startLobby (myMapName, myServerName);
    }

}
