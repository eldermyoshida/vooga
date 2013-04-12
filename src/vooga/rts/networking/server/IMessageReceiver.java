package vooga.rts.networking.server;

import vooga.rts.networking.communications.Message;

/**
 * An interface for adding ability to interact with Connectionthread.
 * Permits sending messages or objects to parent server.
 * 
 * @author srwareham
 * @Author David Winegar
 * 
 */
public interface IMessageReceiver {

    public void sendMessage (Message message);

}

