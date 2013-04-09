package vooga.rts.networking;

import vooga.rts.networking.server.Message;

public interface IClient {
    public abstract void sendData(Message message);
    public abstract Message getData();
}
