package vooga.rts.networking.server;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import vooga.rts.networking.communications.Message;
import vooga.rts.networking.communications.clientmessages.ClientInfoMessage;


/**
 * Object responsible for creating an instance of a game, and establishing
 * connections between clients and the game.
 * 
 * @author srwareham
 * @author David Winegar
 * 
 */
public class MatchmakerServer extends AbstractThreadContainer {
    private Map<String, GameContainer> myGameContainers = new HashMap<String, GameContainer>();
    private ConnectionServer myConnectionServer = new ConnectionServer(this);
    private static final String DEFAULT_RESOURCE_PACKAGE = "vooga.rts.networking.resources.";
    private ResourceBundle myGamesBundle;
    
    public MatchmakerServer () {       
        initializeGameContainers();
    }
    
    public void startAcceptingConnections () {
        myConnectionServer.start();
    }
    
    private void initializeGameContainers () {
        myGamesBundle = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "games");
        for(String game : myGamesBundle.keySet()) {
            myGameContainers.put(game, new GameContainer());
        }
    }
    
    @Override
    public void receiveMessageFromClient (Message message, ConnectionThread thread) {
        if(message instanceof ClientInfoMessage) {
            ClientInfoMessage systemMessage = (ClientInfoMessage) message;
            systemMessage.execute(thread, this);
        }
    }

    @Override
    public void joinGame (ConnectionThread thread, String gameName) {
        if (myGameContainers.containsKey(gameName)) {
            myGameContainers.get(gameName).addConnection(thread);
            removeConnection(thread);
        }
    }

}
