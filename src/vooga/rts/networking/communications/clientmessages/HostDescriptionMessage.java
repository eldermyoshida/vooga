package vooga.rts.networking.communications.clientmessages;

import vooga.rts.networking.communications.Message;

/**
 * 
 * @author Henrique Moraes, Ellango Jothimurugesan
 *
 */
public class HostDescriptionMessage extends Message {
    private String myHostName;
    private String myMapDescription;
    private String myServer;
    private String myImagePath;
    private String myMaxPlayers;

    /**
     * Constructor
     * @param args[0] username of host
     * @param args[1] Description of host map
     * @param args[2] Maximum number of players as a string
     * @param args[3] Server Name
     * @param args[4] File path to map image
     */
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
