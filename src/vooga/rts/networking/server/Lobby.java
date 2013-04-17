package vooga.rts.networking.server;

import vooga.rts.networking.communications.Message;
import vooga.rts.networking.communications.clientmessages.ClientInfoMessage;

/**
 * This class represents a Lobby where users can change information.
 * @author David Winegar
 *
 */
public class Lobby extends Room {
        
    public Lobby (GameContainer container) {
        super(container);
    }
    
    @Override
    public void receiveMessageFromClient (Message message, ConnectionThread thread) {
        if(message instanceof ClientInfoMessage) {
            ClientInfoMessage systemMessage = (ClientInfoMessage) message;
            systemMessage.execute(thread, this);
        }
    }
    
    @Override
    public void leaveLobby (ConnectionThread thread) {
        removeConnection(thread);
        getGameContainer().addConnection(thread);
        if (haveNoConnections()) {
            getGameContainer().removeRoom(this);
        }
    }
    
}
