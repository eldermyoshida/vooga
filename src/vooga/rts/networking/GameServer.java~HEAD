package vooga.rts.networking;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.swing.JTextArea;

/**
 * Main server of the game. It receives information from clients and AI and 
 * sends appropriate responses back to them
 * @author Henrique Moraes
 *
 */
public class GameServer {
    private List<GameThread> myClients;
    private int uniqueID = 0;
    private int myPort;
    private boolean gameRunning = false;
    private JTextArea dummyText;
    private List<Message> myMessages;
    
    public GameServer(int port){
        myPort = port;
        myClients = new LinkedList<GameThread>();
        myMessages = new LinkedList<Message>();
    }
    
    /**
     * Waits for a connection with a client and creates a new thread based on 
     * this connection
     * @param c
     */
    public void addClient(ClientInfo ci){
        //TODO implement in such a way that the server extracts the 
        // information from ClientInfo
        try {
            ServerSocket serverSocket = new ServerSocket(myPort);
            Socket socket = serverSocket.accept();
            myClients.add(new GameThread(socket));
        }
        catch (IOException e) {
            dummyText.append("Problem in creating input and output streams\n");
        }     
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
        for(GameThread ct : myClients) {
            ct.close();
        }
        myClients.clear();
    }
    
    private void haltGame(){
        //TODO implement pause screen on clients and wait for disconnected
        //clients to reestablish connection
    }
    
    
    private class GameThread extends NetworkThread{
        private String myUsername;
        private int myID;
          
        /**
         * Represents a thread that communicates to a client
         * @param socket socket used for establishing the connection
         */
        GameThread(Socket socket){
            super(socket);
            myID = ++uniqueID;
            
        }
        
        /**
         * Keeps listening for messages and adds to the server's message queue
         */
        @Override
        public void run(){
            while(gameRunning){
                try {
                    Message message = (Message) mySInput.readObject();
                    myMessages.add(message);
                }
                catch (IOException e) {
                    dummyText.append("Problem in reading Message input stream\n");
                }
                catch (ClassNotFoundException e) {
                }
            }
            close();
        } 

        @Override
        protected void socketDisconnected () {
            // TODO Handle this exception    
        }
    }
}
