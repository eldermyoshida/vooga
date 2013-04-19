package vooga.rts.networking.server;

/**
 * This is the superclass for Lobby and GameServer. It represents a small 
 * @author David Winegar
 *
 */
public class Room extends AbstractThreadContainer {
    private GameContainer myGameContainer;
    private int myID;

    public Room (int id, GameContainer container) {
        setIDandContainer(id, container);
    }
    
    public Room (int id, GameContainer container, Room room) {
        super(room);
        setIDandContainer(id, container);
        room.removeAllConnections();
        container.removeRoom(room);
        container.addRoom(this);
    }
    
    private void setIDandContainer (int id, GameContainer container) {
        myID = id;
        myGameContainer = container;
    }
    
    protected GameContainer getGameContainer () {
        return myGameContainer;
    }
    
    protected int getID () {
        return myID;
    }
    
}
