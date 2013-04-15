package vooga.rts.networking.client;

import vooga.rts.networking.communications.Message;


/**
 * Represents what is receiving messages on the client. In a game, implmented by a class that
 * receives all network input.
 * 
 * @author David Winegar
 * 
 */
public interface IMessageReceiver {

    public void getMessage (Message message);
}
