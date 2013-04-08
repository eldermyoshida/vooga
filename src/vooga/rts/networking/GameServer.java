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
 * sends approprieate responses back to them
 * @author Henrique Moraes
 *
 */
public class GameServer {
    private List<ClientThread> myClients;
    private int uniqueID = 0;
    private int myPort;
    private boolean gameRunning = false;
    private JTextArea dummyText;
    
    public Server(int port){
        myPort = port;
        myClients = new LinkedList<ClientThread>();
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
            myClients.add(new ClientThread(socket));
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
        for(ClientThread ct : myClients) {
            ct.close();
        }
        myClients.clear();
    }
    
    private void haltGame(){
        //TODO implement pause screen on clients and wait for disconnected
        //clients to reestablish connection
    }
    
    
    private class ClientThread extends Thread{
        private Socket mySocket;
        private ObjectInputStream mySInput;
        private ObjectOutputStream mySOutput;
        private String myUsername;
        private int myID;
        private Queue<Message> myMessages;
          
        /**
         * Represents a thread that communicates to a client
         * @param socket socket used for establishing the connection
         */
        ClientThread(Socket socket){
            myID = ++uniqueID;
            mySocket = socket;
            myMessages = new LinkedList<Message>();
            
            try {
                mySInput = new ObjectInputStream(mySocket.getInputStream());
                mySOutput = new ObjectOutputStream(mySocket.getOutputStream());
            }
            catch (IOException e) {
                dummyText.append("Problem in creating input and output streams\n");
            }
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
        
        /**
         * Closes streams and socket of this thread
         */
        private void close() {
            try {
                    if(mySOutput != null) mySOutput.close();
            }
            catch(Exception e) {}
            try {
                if(mySInput != null) mySInput.close();
            }
            catch(Exception e) {};
            try {
                if(mySocket != null) mySocket.close();
            }
            catch (Exception e) {}
        }
        
        /**
         * Broadcasts a Message object to the client
         * @param m Message object to be sent
         */
        public void sendMessage(Message m){
            if(!mySocket.isConnected()){
                haltGame();
                return;
            }
            try {
                mySOutput.writeObject(m);
            }
            catch (IOException e) {
                dummyText.append("Problem in writing Message to client\n");
            }
        }
    }
}
