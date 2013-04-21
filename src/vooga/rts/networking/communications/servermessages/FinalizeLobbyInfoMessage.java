package vooga.rts.networking.communications.servermessages;

import vooga.rts.networking.client.IClientModel;
import vooga.rts.networking.communications.LobbyInfo;

/**
 * This sends the 
 * @author David Winegar
 *
 */
public class FinalizeLobbyInfoMessage extends ServerInfoMessage {

    private LobbyInfo myLobbyInfo;
    
    public FinalizeLobbyInfoMessage (LobbyInfo info) {
        myLobbyInfo = info;
    }

    @Override
    public void affectClient (IClientModel model) {
        // TODO
    }

}
