package vooga.rts.networking.communications.servermessages;

import vooga.rts.networking.client.IClientModel;
import vooga.rts.networking.communications.ExpandedLobbyInfo;

/**
 * Tells the client to switch to a lobby.
 * @author David Winegar
 *
 */
public class SwitchToLobbyMessage extends AbstractLobbyInfoMessage {
    
    private static final long serialVersionUID = 8524506463613939449L;

    /**
     * Instantiates the message
     * @param lobbyInfo info to store
     */
    public SwitchToLobbyMessage (ExpandedLobbyInfo lobbyInfo) {
        super(lobbyInfo);
    }


    @Override
    public void affectClient (IClientModel model) {
        model.switchToLobby((ExpandedLobbyInfo) getLobbyInfo());
    }

}
