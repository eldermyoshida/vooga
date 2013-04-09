package vooga.rts.networking.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Unused at this point, but can be added as a pure connection server
 * @author David Winegar
 *
 */
public class ConnectionServer extends Thread {

    private static final int PORT = 2233;
    private int myConnectionID = 0;
    private MatchmakerServer myMatchServer;
    
    public ConnectionServer (MatchmakerServer matchServer) {
        myMatchServer = matchServer;
    }
    
    @Override
    public void run () {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
        }
        catch (IOException e) {
            // TODO log file
            System.exit(0);
        }
        while(true) {
            try {
                Socket socket = serverSocket.accept();
                ConnectionThread thread = new ConnectionThread(socket, myMatchServer, myConnectionID);
                //myMatchServer.addThread(thread);
                thread.run();
            }
            catch (IOException e) {
                // TODO log file
                e.printStackTrace();
            }
        }
    }
}
