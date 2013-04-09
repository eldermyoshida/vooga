package vooga.rts.networking;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import vooga.rts.networking.server.Message;

/**
 * Provides client-side methods for connecting to the multiplayer server. 
 * In this case the client is the Arcade and the Game.
 * 
 * 
 * @author srwareham
 * @author David Winegar
 *
 */
public class Client implements IClient {
    private static final int PORT = 2233;
    private static final String HOST = "localhost";
    private ObjectInputStream myInput;
    private ObjectOutputStream myOutput;
    private Socket mySocket;
    private String myHost = HOST;
    private int myPort = PORT;
 
    /**
     * Creates the sockets and streams for this client 
     */
    public void start(){
        try {
            mySocket = new Socket(myHost,myPort);
            myInput = new ObjectInputStream(mySocket.getInputStream());
            myOutput = new ObjectOutputStream(mySocket.getOutputStream());
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

    @Override
    public void sendData (Message message) {
        try {
            myOutput.writeObject(message);
        }
        catch(IOException e) {
                System.out.println("Exception writing to server: " + e);
        }
    }

    @Override
    public Message getData () {
        try {
            Object object;
            if((object = myInput.readObject()) != null && object instanceof Message){
                return (Message) object;
            }
        }
        catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
