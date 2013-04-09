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
    private ObjectInputStream mySInput;
    private ObjectOutputStream mySOutput;
    private int myID;
    private IMessageServer myMessageServer;

    /**
     * Represents a thread that communicates to a client
     * 
     * @param socket socket used for establishing the connection
     */
    ConnectionThread (Socket socket, IMessageServer server, int ID) {
        mySocket = socket;
        myMessageServer = server;

        try {
            mySInput = new ObjectInputStream(mySocket.getInputStream());
            mySOutput = new ObjectOutputStream(mySocket.getOutputStream());
        }
        catch (IOException e) {
            // TODO add logger
            e.printStackTrace();

        }
    }

    public void switchMessageServer (IMessageServer server) {
        myMessageServer = server;
    }

    /**
     * Keeps listening for messages and adds to the server's message queue
     */
    @Override
    public void run () {
        while (true) {
            try {
                Object obj;
                if ((obj = mySInput.readObject()) != null && obj instanceof Message) {
                    Message message = (Message) obj;
                    myMessageServer.sendMessage(message);
                }
            }
            catch (IOException e) {
                // TODO add logger
                e.printStackTrace();

            }
            catch (ClassNotFoundException e) {
                // TODO add logger
                e.printStackTrace();

            }
        }
    }

    /**
     * Closes streams and socket of this thread
     * TODO catch exceptions
     */
    public void close () {
        try {
            if (mySOutput != null) {
                mySOutput.close();
            }
        }
        catch (Exception e) {
        }
        try {
            if (mySInput != null) {
                mySInput.close();
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
            mySOutput.writeObject(m);
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
