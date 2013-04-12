package vooga.rts.networking.client;

import vooga.rts.networking.communications.Message;


public interface IClient {
    public abstract void sendData (Message message);

    public abstract Message getData ();
}
