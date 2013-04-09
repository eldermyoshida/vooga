package vooga.rts.networking.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * Unused at this point, but can be added as a pure connection server
 * 
 * @author David Winegar
 * 
 */
public class ConnectionServer extends Thread {

    private static final int PORT = 2233;
    private int myConnectionID = 0;
    private MatchmakerServer myMatchServer;
    private boolean myServerAcceptingConnections = false;

    public ConnectionServer (MatchmakerServer matchServer) {
        myMatchServer = matchServer;
    }

    @Override
    public void run () {
        myServerAcceptingConnections = true;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(PORT);
        }
        catch (IOException e1) {
            // TODO log file
            e1.printStackTrace();
        }

        while (myServerAcceptingConnections) {
            try {
                // DEBUGGING - can only use ports once on localhost, so use this to test multiple
                // connections
                serverSocket = new ServerSocket(PORT + myConnectionID);
                Socket socket = serverSocket.accept();
                ConnectionThread thread =
                        new ConnectionThread(socket, myMatchServer, myConnectionID);
                myConnectionID++;
                thread.start();
                myMatchServer.addConnection(thread);
                serverSocket.close();
            }
            catch (IOException e) {
                // TODO log file
                e.printStackTrace();
            }
        }
    }

}
