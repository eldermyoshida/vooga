package vooga.rts.networking.communications.servermessages;

import vooga.rts.networking.client.IClientModel;
import vooga.rts.networking.communications.ExpandedLobbyInfo;
import vooga.rts.networking.communications.LobbyInfo;


/**
 * Sends ExpandedLobbyInfo to the client.
 * 
 * @author David Winegar
 * 
 */
public class UpdateLobbyInfoMessage extends AbstractLobbyInfoMessage {

    private static final long serialVersionUID = 6729477946727355957L;

    /**
     * Instantiates the messsage.
     * 
     * @param info to send
     */
    public UpdateLobbyInfoMessage (LobbyInfo info) {
        super(info);
    }

    @Override
    public void affectClient (IClientModel model) {
        // TODO Auto-generated method stub
    }

}
