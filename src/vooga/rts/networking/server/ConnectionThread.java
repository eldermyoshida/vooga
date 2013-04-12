package vooga.rts.networking.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


/**
 * Represents a server-side connection between the client and the server.
 * 
 * @author David Winegar
 * @author Henrique Morales
 * 
 */
public class ConnectionThread extends Thread {
    private Socket mySocket;
    private ObjectInputStream myInput;
    private ObjectOutputStream myOutput;
    private int myID;
    private IMessageReceiver myMessageServer;
    private boolean myConnectionActive = false;

    /**
     * Represents a thread that communicates to a client
     * 
     * @param socket socket used for establishing the connection
     */
    ConnectionThread (Socket socket, IMessageReceiver server, int ID) {
        mySocket = socket;
        myMessageServer = server;

        try {
            myInput = new ObjectInputStream(mySocket.getInputStream());
            myOutput = new ObjectOutputStream(mySocket.getOutputStream());
        }
        catch (IOException e) {
            // TODO add logger
            e.printStackTrace();

        }
    }

    public void switchMessageServer (IMessageReceiver server) {
        myMessageServer = server;
    }

    /**
     * Keeps listening for messages and adds to the server's message queue
     */
    @Override
    public void run () {
        myConnectionActive = true;
        while (myConnectionActive) {
            try {
                Object obj;
                if ((obj = myInput.readObject()) != null && obj instanceof Message) {
                    Message message = (Message) obj;
                    myMessageServer.sendMessage(message);
                }
            }
            catch (IOException e) {
                // TODO add logger
                e.printStackTrace();
                close();
            }
            catch (ClassNotFoundException e) {
                // TODO add logger
                e.printStackTrace();
                close();
            }
        }
    }

    /**
     * Closes streams and socket of this thread
     * TODO catch exceptions
     */
    public void close () {
        myConnectionActive = false;
        try {
            if (myOutput != null) {
                myOutput.close();
            }
        }
        catch (Exception e) {
        }
        try {
            if (myInput != null) {
                myInput.close();
            }
        }
        catch (Exception e) {
        }
        ;
        try {
            if (mySocket != null) {
                mySocket.close();
            }
        }
        catch (Exception e) {
        }
    }

    /**
     * Broadcasts a Message object to the client
     * 
     * @param m Message object to be sent
     */
    public void sendMessage (Message m) {
        if (!mySocket.isConnected()) {
            close();
        }
        try {
            myOutput.writeObject(m);
        }
        catch (IOException e) {
            // TODO add logger
            e.printStackTrace();

        }
    }

    public int getID () {
        return myID;
    }

}
