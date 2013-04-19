package vooga.rts.networking.communications.clientmessages;

import vooga.rts.networking.communications.Message;
import vooga.rts.networking.server.ConnectionThread;
import vooga.rts.networking.server.GUIThreadContainer;
import vooga.rts.networking.server.IThreadContainer;

/**
 * Represents a disconnected user from the GUI
 * @author Henrique Moraes
 *
 */
public class HostDisconnectedMessage extends GUIMessage {
    
    public HostDisconnectedMessage(String host){
        super(host);
    }
    
    @Override
    public void affectServer (ConnectionThread thread, IThreadContainer server) {
        GUIThreadContainer gui = (GUIThreadContainer) server;
        gui.readMessage(this);    
    }
}
