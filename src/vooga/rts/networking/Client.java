package vooga.rts.networking;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client {
    private ObjectInputStream mySInput;
    private ObjectOutputStream mySOutput;
    private Socket mySocket;
    private String myHost, myUsername;
    private int myPort;
    
    public Client(String host, int port){
        myPort = port;
        
    }
    
    /**
     * Creates the sockets and streams for this client 
     */
    public void start(){
        try {
            mySocket = new Socket(myHost,myPort);
            mySInput = new ObjectInputStream(mySocket.getInputStream());
            mySOutput = new ObjectOutputStream(mySocket.getOutputStream());
        }
        catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }      
    }
    
    private void processMessage(Message m){
        //TODO Client reads server's message and handles it accordingly
    }
    
    void sendMessage(Message msg) {
        try {
                mySOutput.writeObject(msg);
        }
        catch(IOException e) {
                System.out.println("Exception writing to server: " + e);
        }
}
    
    /**
     * Keeps listening for incoming messages from the server
     * @author Henrique Moraes
     *
     */
    private class MessageReceiver extends Thread{
        public void run(){
            while(true){
                try {
                    Message message = (Message) mySInput.readObject();
                }
                catch (IOException e) {
                    System.out.print("Server has ceased connection" );
                }
                catch (ClassNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}
