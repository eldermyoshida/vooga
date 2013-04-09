package vooga.rts.networking.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Object responsible for creating an instance of a game, and establishing 
 * connections between clients and the game.
 * @author srwareham
 * @author David Winegar
 *
 */
public class MatchmakerServer extends Thread implements IMessageServer {
    private List<ConnectionThread> myConnectionThreads;
    private List<ConnectionThread> myPotentialConnections;
    private List<GameServer> myGameServers;
    private int myGameServerID = 0;
    private int myConnectionID = 0;
    private boolean myServerRunning = false;
    private static final int PORT = 2233;
    
    public MatchmakerServer() {
        myConnectionThreads = new ArrayList<ConnectionThread>();
        myGameServers = new ArrayList<GameServer>();
        myPotentialConnections = new ArrayList<ConnectionThread>();
    }
    
    @Override
    public void run () {
        myServerRunning = true;
        ServerSocket serverSocket = null;
       /* try {
            
        }
        catch (IOException e) {
            // TODO log file
            e.printStackTrace();
            System.exit(0);
        }*/
        while(myServerRunning) {
            try {
                //serverSocket = new ServerSocket(PORT);
                // DEBUGGING - can only use ports once on localhost, so use this to test multiple connections
                serverSocket = new ServerSocket(PORT + myConnectionID);
                Socket socket = serverSocket.accept();
                ConnectionThread thread = new ConnectionThread(socket, this, myConnectionID);
                myConnectionThreads.add(thread);
                myPotentialConnections.add(thread);
                myConnectionID++;
                thread.start();
                if(myPotentialConnections.size() > 1 ){
                    initializeGame();
                }
            }
            catch (IOException e) {
                // TODO log file
                e.printStackTrace();
            }
        }
    }
    
    private void initializeGame() {
        GameServer gameServer = new GameServer(myGameServerID++);
        myGameServers.add(gameServer);
        for(ConnectionThread ct : myPotentialConnections) {
            gameServer.addClient(ct);
        }
        myPotentialConnections.clear();
        gameServer.start();
        myGameServerID++;
    }

    @Override
    public void sendMessage (Message message) {
        // TODO Auto-generated method stub
        
    }
    
}
