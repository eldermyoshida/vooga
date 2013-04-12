package vooga.rts.networking.server;

import java.util.ArrayList;
import java.util.List;
import vooga.rts.networking.communications.Message;


/**
 * Object responsible for creating an instance of a game, and establishing
 * connections between clients and the game.
 * 
 * @author srwareham
 * @author David Winegar
 * 
 */
public class MatchmakerServer extends Thread implements IMessageReceiver {
    private List<ConnectionThread> myConnectionThreads;
    private List<ConnectionThread> myPotentialConnections;
    private List<GameServer> myGameServers;
    private List<GameContainer> myGameContainers;
    private int myGameServerID = 0;
    private ConnectionServer myConnectionServer;

    public MatchmakerServer () {
        myConnectionThreads = new ArrayList<ConnectionThread>();
        myGameServers = new ArrayList<GameServer>();
        myPotentialConnections = new ArrayList<ConnectionThread>();
        myConnectionServer = new ConnectionServer(this);
    }

    @Override
    public void run () {
        myConnectionServer.start();
    }

    protected void addConnection (ConnectionThread thread) {
        myConnectionThreads.add(thread);
        myPotentialConnections.add(thread);
        // TODO only for example client, remove later
        if (myPotentialConnections.size() > 1) {
            initializeGame();
        }
    }

    private void initializeGame () {
        GameServer gameServer = new GameServer(myGameServerID++);
        myGameServers.add(gameServer);
        for (ConnectionThread ct : myPotentialConnections) {
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
