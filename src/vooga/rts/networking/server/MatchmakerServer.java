package vooga.rts.networking.server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.Timer;
import vooga.rts.networking.communications.Message;
import vooga.rts.networking.communications.server.ServerSystemMessage;


/**
 * Object responsible for creating an instance of a game, and establishing
 * connections between clients and the game.
 * 
 * @author srwareham
 * @author David Winegar
 * 
 */
public class MatchmakerServer extends Thread implements IMessageReceiver, IThreadContainer {
    private Map<Integer, ConnectionThread> myConnectionThreads = new HashMap<Integer, ConnectionThread>();
    private Map<String, GameContainer> myGameContainers = new HashMap<String, GameContainer>();
    private ConnectionServer myConnectionServer = new ConnectionServer(this);
    private Timer myTimer;
    private static final int ONE_SECOND = 1000;
    private static final int DEFAULT_TIMER_DELAY = ONE_SECOND * 2;
    
    public MatchmakerServer () {
        myTimer = new Timer(DEFAULT_TIMER_DELAY, new ActionListener () {
            @Override
            public void actionPerformed (ActionEvent arg0) {
                // TODO Auto-generated method stub      
            }     
        });
    
    }
    
    @Override
    public void run () {
        myConnectionServer.start();
        myTimer.start();
        // need to load game containers - games.properties - may want to do this in constructor
    }
    
    @Override
    public void sendMessage (Message message, ConnectionThread thread) {
        if(message instanceof ServerSystemMessage) {
            ServerSystemMessage systemMessage = (ServerSystemMessage) message;
            systemMessage.execute(thread, this);
        }
    }
    
    protected void addConnection (ConnectionThread thread) {
        myConnectionThreads.put(thread.getID(), thread);
    }

    @Override
    public void removeConnection (ConnectionThread thread) {
        myConnectionThreads.remove(thread.getID());
    }

    @Override
    public void joinGame (ConnectionThread thread, String gameName) {
        if (myGameContainers.containsKey(gameName)) {
            myGameContainers.get(gameName).addConnection(thread);
            myConnectionThreads.remove(thread.getID());
        }
    }

    @Override
    public void joinLobby (ConnectionThread thread, String lobbyName) {        
    }

    @Override
    public void leaveLobby (ConnectionThread thread) {
    }

    @Override
    public void startGameServer () {
    }

}
