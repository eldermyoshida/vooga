package vooga.rts.networking.server;

import vooga.rts.networking.communications.clientmessages.GUIMessage;

/**
 * Thread container that refers for updating of server GUIs
 * @author Henrique Moraes
 *
 */
public abstract class GUIThreadContainer extends ThreadAdapter {

    /**
     * 
     * @param message GUI message that contains information on how to 
     * update GUI
     */
    public abstract void readMessage(GUIMessage message);

}
