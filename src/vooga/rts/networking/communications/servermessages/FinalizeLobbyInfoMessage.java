package vooga.rts.networking.communications.servermessages;

import vooga.rts.networking.client.IClientModel;
import vooga.rts.networking.communications.ExpandedLobbyInfo;

/**
 * This sends the 
 * @author David Winegar
 *
 */
public class FinalizeLobbyInfoMessage extends ServerInfoMessage {

    private ExpandedLobbyInfo myLobbyInfo;
    
    public FinalizeLobbyInfoMessage (ExpandedLobbyInfo info) {
        myLobbyInfo = info;
    }

    @Override
    public void affectClient (IClientModel model) {
        // TODO
    }

}
