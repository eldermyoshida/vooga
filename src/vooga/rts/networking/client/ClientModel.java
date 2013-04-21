package vooga.rts.networking.client;

import vooga.rts.networking.communications.Message;
import vooga.rts.networking.communications.clientmessages.InitialConnectionMessage;
import vooga.rts.networking.communications.servermessages.ServerInfoMessage;

public class ClientModel implements IMessageReceiver, IClientModel {

    private IClient myClient = new Client(this); 
    
    public ClientModel () {
        // TODO get info from arcade
        Message initialConnection = new InitialConnectionMessage ("game", "user");
        myClient.sendData(initialConnection);
        
        
    }

    @Override
    public void getMessage (Message message) {
        if (message instanceof ServerInfoMessage) {
            ((ServerInfoMessage) message).affectClient(this);
        }
    }

    @Override
    public void closeConnection () {
        
    }
    
}
