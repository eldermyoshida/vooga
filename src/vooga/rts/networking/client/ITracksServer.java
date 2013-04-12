package vooga.rts.networking.client;

import vooga.rts.networking.communications.Message;

/**
 * This interface mandates that any clients that extend it must be able to
 * accept communications from a parent server- and also have a specific implementation
 * for processing said communications.
 * @author srwareham
 *
 */
public interface ITracksServer {
    public abstract Message getMessage();
    
    public abstract void processMessage(Message message);
}
