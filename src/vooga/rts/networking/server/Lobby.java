package vooga.rts.networking.server;

import vooga.rts.networking.communications.LobbyInfo;

/**
 * This class represents a Lobby where users can change information.
 * @author David Winegar
 *
 */
public class Lobby extends Room {
    
    private LobbyInfo myLobbyModel;
        
    /**
     * Instantiates a lobby.
     * @param id id of lobby
     * @param container gamecontainer of lobby
     */
    public Lobby (int id, GameContainer container, String mapName, String serverName) {
        super(id, container);
    }
    
    @Override
    public void leaveLobby (ConnectionThread thread) {
        removeConnection(thread);
        getGameContainer().addConnection(thread);
        if (haveNoConnections()) {
            getGameContainer().removeRoom(this);
        }
    }
    
    @Override
    public void startGameServer (ConnectionThread thread) {
        new GameServer(getID(), getGameContainer(), this);
    }
    
    @Override
    public void addConnection (ConnectionThread thread) {
        super.addConnection(thread);
        
    }
}
