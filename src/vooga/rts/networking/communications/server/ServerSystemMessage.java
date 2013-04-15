package vooga.rts.networking.communications.server;

import vooga.rts.networking.communications.Message;
import vooga.rts.networking.server.ConnectionThread;
import vooga.rts.networking.server.IThreadContainer;


/**
 * Represents a message from the client to the server. Takes a thread and an IThreadContainer in
 * it's execute command and uses those to change the state on the server.
 * 
 * @author David Winegar
 * 
 */
public abstract class ServerSystemMessage extends Message {

    private static final long serialVersionUID = -978972998594019845L;

    public abstract void execute (ConnectionThread thread, IThreadContainer server);

}
