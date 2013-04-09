package vooga.rts.networking;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.swing.JTextArea;

/**
 * Server that represents one instance of a in-play game.. It receives information from game clients and AI and 
 * sends pushes changes to all other clients
 * @author Henrique Moraes, Sean Wareham, David Winegar
 *
 */
public class GameServer extends Thread implements IMessageServer {
    private List<ConnectionThread> myClients;
    private int myID;
    private boolean gameRunning = false;
    private Queue<Message> myMessageQueue;
       
    public GameServer(int ID){
        myClients = new ArrayList<ConnectionThread>();
        myID = ID;
        myMessageQueue = new LinkedList<Message>();
    }
    
    /**
     * Waits for a connection with a client and creates a new thread based on 
     * this connection
     * @param c
     */
    public void addClient(ConnectionThread thread){
        thread.switchMessageServer(this);
        myClients.add(thread);
    }
    
    @Override
    public void run () {
        gameRunning = true;
        while(gameRunning){
            while(!myMessageQueue.isEmpty()){
                Message message = myMessageQueue.poll();
                for(ConnectionThread ct : myClients) {
                    ct.sendMessage(message);
                }
            }
        }
    }
    
    /**
     * Closes all streams of this server and related threads, clears the 
     * list of threads as well
     */
    private void disconnect () {
        for(ConnectionThread ct : myClients) {
            ct.close();
        }
        myClients.clear();
    }
    
    private void haltGame(){
        //TODO implement pause screen on clients and wait for disconnected
        //clients to reestablish connection
        gameRunning = false;
    }

    @Override
    public void sendMessage (Message message) {
        myMessageQueue.add(message);
    }
    
    public int getID () {
        return myID;
    }

}
