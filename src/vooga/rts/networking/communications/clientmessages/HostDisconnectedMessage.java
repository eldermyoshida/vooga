package vooga.rts.networking.communications.clientmessages;

import vooga.rts.networking.communications.Message;

/**
 * Represents a disconnected user from the GUI
 * @author Henrique Moraes
 *
 */
public class HostDisconnectedMessage extends GUIMessage {
    
    public HostDisconnectedMessage(String host){
        super(host);
    }
}
