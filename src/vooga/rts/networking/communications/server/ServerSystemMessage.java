package vooga.rts.networking.communications.server;

import vooga.rts.networking.communications.Message;
import vooga.rts.networking.server.ConnectionThread;
import vooga.rts.networking.server.IThreadContainer;

/**
 * Represents a message from client to server.
 * 
 * @author David Winegar
 *
 */
public abstract class ServerSystemMessage extends Message {

    private static final long serialVersionUID = -978972998594019845L;
    
    public abstract void execute (ConnectionThread thread, IThreadContainer server);
    
}
