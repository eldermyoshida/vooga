package vooga.rts.networking.server;

/**
 * An interface for adding ability to interact with Connectionthread.
 * Permits sending messages or objects to parent server.
 * 
 * @author srwareham
 * 
 */
public interface IMessageServer {

    public void sendMessage (Message message);

}
