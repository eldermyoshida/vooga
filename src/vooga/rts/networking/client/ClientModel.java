package vooga.rts.networking.client;

import vooga.rts.networking.client.GUI.ViewContainerPanel;
import vooga.rts.networking.communications.Message;
import vooga.rts.networking.communications.clientmessages.InitialConnectionMessage;
import vooga.rts.networking.communications.servermessages.ServerInfoMessage;

public class ClientModel implements IMessageReceiver, IClientModel {

    private IClient myClient = new Client(this);
    private ViewContainerPanel myContainerPanel;
    
    public ClientModel (String gameName) {
        // TODO get username from arcade
        Message initialConnection = new InitialConnectionMessage (gameName, "user");
        myClient.sendData(initialConnection);
        myContainerPanel = new ViewContainerPanel(gameName);
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
