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
public class MatchmakerServer extends Thread implements IMessageReceiver {
    private Map<Integer, ConnectionThread> myConnectionThreads = new HashMap<Integer, ConnectionThread>();
    private Map<String, GameContainer> myGameContainers = new HashMap<String, GameContainer>();
    private int myGameServerID = 0;
    private ConnectionServer myConnectionServer = new ConnectionServer(this);
    private CommandFactory myFactory = new CommandFactory();

    @Override
    public void run () {
        myConnectionServer.start();
    }
    
    @Override
    public void sendMessage (Message message, ConnectionThread thread) {
        SystemMessage systemMessage = (SystemMessage) message;
        Command command = myFactory.getCommand(systemMessage.getMessage());
        command.execute(thread, this, systemMessage.getParameters());
    }
    
    protected void addConnection (ConnectionThread thread) {
        myConnectionThreads.put(thread.getID(), thread);
    }

    public void addConnectionToGame (ConnectionThread thread, String gameName) {
        if (myGameContainers.containsKey(gameName)) {
            myGameContainers.get(gameName).addConnection(thread);
            myConnectionThreads.remove(thread.getID());
        }
    }
    
    public void addConnectionToGame (int connectionID, String gameName) {
        if (myConnectionThreads.containsKey(connectionID)) {
            addConnectionToGame(myConnectionThreads.get(connectionID), gameName);
        }
    }
    
    public void removeConnection (ConnectionThread thread, String gameName) {
        myConnectionThreads.remove(thread.getID());
        if (myGameContainers.containsKey(gameName)) {
            myGameContainers.get(gameName).removeConnection(thread);
        }
    }

}
