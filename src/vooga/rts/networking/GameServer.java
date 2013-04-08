package vooga.rts.networking;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextArea;

/**
 * Server that represents one instance of a in-play game.. It receives information from game clients and AI and 
 * sends pushes changes to all other clients
 * @author Henrique Moraes, Sean Wareham, David Winegar
 *
 */
public class GameServer implements IMessageServer {
    private List<ConnectionThread> myClients;
    private int uniqueID = 0;
    private int myPort;
    private boolean gameRunning = false;
    private JTextArea dummyText;
    
    public GameServer(int port){
        myPort = port;
        myClients = new ArrayList<ConnectionThread>();
    }
    
    /**
     * Waits for a connection with a client and creates a new thread based on 
     * this connection
     * @param c
     */
    public void addClient(Socket socket){
        myClients.add(new ConnectionThread(socket, this, 0));    
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
    }

    @Override
    public void addMessage (Message message) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void addObject (Object object) {
        // TODO Auto-generated method stub
        
    }
}
