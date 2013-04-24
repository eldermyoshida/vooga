package vooga.rts.networking.communications;

public class LobbyCarrierMessage extends Message {

    /**
     * 
     */
    private static final long serialVersionUID = 2236743508999818641L;
    private LobbyInfo myLobbyInfo;
    
    LobbyCarrierMessage(LobbyInfo lobbyInfo) {
        myLobbyInfo = lobbyInfo;
    }
    
    protected LobbyInfo getLobbyInfo() {
        return myLobbyInfo;
    }
}
