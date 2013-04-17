package vooga.rts.networking.server;

/**
 * This is the superclass for Lobby and GameServer. It represents a small 
 * @author David Winegar
 *
 */
public abstract class Room extends AbstractThreadContainer {
    private GameContainer myGameContainer;

    public Room (GameContainer container) {
        myGameContainer = container;
    }
    
    protected GameContainer getGameContainer () {
        return myGameContainer;
    }
    
}
