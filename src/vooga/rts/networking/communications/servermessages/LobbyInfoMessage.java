package vooga.rts.networking.communications.servermessages;

import vooga.rts.networking.client.IClientModel;
import vooga.rts.networking.communications.LobbyInfo;

public class LobbyInfoMessage extends ServerInfoMessage {
    
    private static final long serialVersionUID = 6729477946727355957L;

    public LobbyInfoMessage (LobbyInfo info) {
        
    }

    @Override
    public void affectClient (IClientModel model) {
        // TODO Auto-generated method stub

    }

}
