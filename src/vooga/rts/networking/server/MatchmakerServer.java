package vooga.rts.networking.server;

import java.util.HashMap;
import java.util.Map;
import vooga.rts.networking.communications.Message;
import vooga.rts.networking.communications.SystemMessage;
import vooga.rts.networking.factory.Command;
import vooga.rts.networking.factory.CommandFactory;


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
    private CommandFactory myFactory = new CommandFactory();

    @Override
    public void run () {
        myConnectionServer.start();
        // need to load game containers - games.properties - may want to do this in constructor
    }
    
    @Override
    public void sendMessage (Message message, ConnectionThread thread) {
        if(message instanceof SystemMessage) {
            SystemMessage systemMessage = (SystemMessage) message;
            Command command = myFactory.getCommand(systemMessage.getMessage());
            command.execute(thread, this, systemMessage.getParameters());
        } else {
            
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
