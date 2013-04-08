package vooga.rts.networking;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextArea;

/**
 * Server that represents one instance of a in-play game.. It receives information from game clients and AI and 
 * sends pushes changes to all other clients
 * @author Henrique Moraes, Sean Wareham, David Winegar
 *
 */
public class GameServer extends Thread implements IMessageServer {
    private List<ConnectionThread> myClients;
    private int uniqueID;
    private boolean gameRunning = false;
    private JTextArea dummyText;
    
    public GameServer(){
        myClients = new ArrayList<ConnectionThread>();
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
        start();
    }
    
    public void start(){
        gameRunning = true;
        while(gameRunning){
            //TODO process message queue and generate messages back to the clients
            // using sendMessage method from ClientThread
        }
        
    }
    
    /**
     * Closes all streams of this server and related threads, clears the 
     * list of threads as well
     */
    private void disconnect() {
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
        // TODO Auto-generated method stub
        
    }

    @Override
    public void sendObject (Object object) {
        // TODO Auto-generated method stub
        
    }
    
}
