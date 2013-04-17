package vooga.rts.networking.communications.client;

import vooga.rts.networking.communications.Message;

public class HostDescriptionMessage extends Message {
    String myUsername = "Anonymous";
    String myMapDescription = "No Description";
    String myHostName = "Anonymous";
    String myServer = "No Name";

    /**
     * Constructor
     * @param args[0] username of host
     * @param args[1] Description of host map
     * @param args[2] Name of host
     * @param args[3] Name associated with the server
     * 
     */
    public HostDescriptionMessage(String...args) {
        super();
        myUsername = args[0];
        myMapDescription = args[1];
        myHostName = args[2];
        myServer = args[3];
    }
    
    public String getUsername(){
        return myUsername;
    }
    
    public String getMapDescriptione(){
        return myUsername;
    }
    
    public String getUsername(){
        return myUsername;
    }
    
    public String getUsername(){
        return myUsername;
    }
    

}
