package vooga.rts.networking.server;

public class InitialConnectionMessage extends Message {

    private static final long serialVersionUID = -6750642234836246976L;
    private String myUsername;
    private String myGameName;

    public InitialConnectionMessage (int timeSent, String username, String gameName) {
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
