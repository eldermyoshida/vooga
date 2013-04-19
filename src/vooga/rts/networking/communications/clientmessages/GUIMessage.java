package vooga.rts.networking.communications.clientmessages;

/**
 * Superclass of messages that contain important information for the GUI 
 * @author Henrique Moraes
 *
 */
public abstract class GUIMessage extends ClientInfoMessage{
    private String myHostName;
    
    public GUIMessage (String host) {
        myHostName = host;
    }
    
    /**
     * 
     * @return Host name of the associated message
     */
    public String getHostName(){
        return myHostName;
    }

}
