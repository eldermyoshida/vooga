package vooga.rts.networking.server;

import vooga.rts.networking.communications.Message;

public class InitialConnectionMessage extends Message {

    private static final long serialVersionUID = -6750642234836246976L;
    private String myUsername;
    private String myGameName;

    public InitialConnectionMessage (TimeStamp timeSent, String username, String gameName) {
        super(timeSent);
        myUsername = username;
    }

    public String getUsername () {
        return myUsername;
    }

    public String getGameName () {
        return myGameName;
    }

}
