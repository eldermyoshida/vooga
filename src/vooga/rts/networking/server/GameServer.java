package vooga.rts.networking.server;

import java.util.ArrayList;
import java.util.List;
import vooga.rts.networking.communications.Message;


/**
 * Server that represents one instance of a in-play game.. It receives information from game clients
 * and AI and
 * sends pushes changes to all other clients
 * 
 * @author Henrique Moraes
 * @author Sean Wareham
 * @author David Winegar
 * 
 */
public class GameServer extends AbstractThreadContainer implements IMessageReceiver {
    private List<ConnectionThread> myClients = new ArrayList<ConnectionThread>();
    private int myID;
    private boolean gameRunning = true;
    private GameContainer myGameContainer;

    public GameServer (int ID, GameContainer container) {
        myID = ID;
        myGameContainer = container;
    }

    /**
     * Waits for a connection with a client and creates a new thread based on
     * this connection
     * 
     * @param c
     */
    public void addConnection (ConnectionThread thread) {
        myClients.add(thread);
        thread.switchMessageServer(this);
    }

    /**
     * Closes all streams of this server and related threads, clears the
     * list of threads as well
     */
    protected void disconnect () {
        for (ConnectionThread ct : myClients) {
            ct.close();
        }
        myClients.clear();
        gameRunning = false;
        myGameContainer.removeGameServer(this);
    }
    
    protected boolean isGameRunning () {
        return gameRunning;
    }

    @Override
    public void sendMessage (Message message, ConnectionThread thread) {
        for (ConnectionThread ct : myClients) {
            ct.sendMessage(message);
        }
    }

    public int getID () {
        return myID;
    }

}
