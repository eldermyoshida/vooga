package vooga.rts.networking.server;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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
public class GameServer extends Thread implements IMessageReceiver {
    private List<ConnectionThread> myClients = new ArrayList<ConnectionThread>();;
    private int myID;
    private boolean gameRunning = true;
    private Queue<Message> myMessageQueue= new LinkedList<Message>();
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

    @Override
    public void run () {
        while (isGameRunning()) {
            sendMessages();
            // Sleep in order to cut CPU usage and go to another thread
            // TODO not sure if this is actually a good idea - review
            try {
                Thread.sleep(1);
            }
            catch (InterruptedException e) {
                // TODO add logger
                e.printStackTrace();
            }
        }
    }
    
    protected void sendMessages () {
        while (!getMessageQueue().isEmpty()) {
            Message message = getMessageQueue().poll();
            for (ConnectionThread ct : myClients) {
                ct.sendMessage(message);
            }
        }
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
    
    protected Queue<Message> getMessageQueue() {
        return myMessageQueue;
    }

    @Override
    public void sendMessage (Message message, ConnectionThread thread) {
        myMessageQueue.add(message);
    }

    public int getID () {
        return myID;
    }

}
