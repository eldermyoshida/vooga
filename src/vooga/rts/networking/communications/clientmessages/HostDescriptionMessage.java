package vooga.rts.networking.communications.clientmessages;

import vooga.rts.networking.communications.Message;

public class HostDescriptionMessage extends Message {
    private String myHostName;
    private String myMapDescription;
    private String myServer;
    private String myImagePath;
    private String myMaxPlayers;

    public HostDescriptionMessage(String...args) {
        super();
        myHostName = args[0];
        myMapDescription = args[1];
        myMaxPlayers = args[2];
        myServer = args[3];
        myImagePath = args[4];   
    }
    
    public String getHost(){
        return myHostName;
    }
    
    public String getMapDescription(){
        return myMapDescription;
    }
    
    public String getServerName(){
        return myServer;
    }
    
    public String getImagePath(){
        return myImagePath;
    }
    
    public int getMaxPlayers(){
        return Integer.parseInt(myMaxPlayers);
    }

}
