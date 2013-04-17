package vooga.rts.networking.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import vooga.rts.networking.communications.Message;
import vooga.rts.networking.communications.clientmessages.ClientInfoMessage;

public class GameContainer extends AbstractThreadContainer implements IMessageReceiver {

    private Map<Integer, ConnectionThread> myConnectionThreads = new HashMap<Integer, ConnectionThread>();
    private Map<String, Lobby> myLobbies = new HashMap<String, Lobby>();
    private List<GameServer> myGameServers = new ArrayList<GameServer>();
    private int myGameNumber = 0;
    
    public GameContainer () {
    }
    
    protected void addConnection (ConnectionThread thread) {
        myConnectionThreads.put(thread.getID(), thread);
        thread.switchMessageServer(this);
    }
    
    protected void addGameServer (GameServer server) {
        myGameServers.add(server);
    }
    
    protected void removeGameServer (GameServer server) {
        
    }
    
    @Override
    public void sendMessage (Message message, ConnectionThread thread) {
        if(message instanceof ClientInfoMessage) {
            ClientInfoMessage systemMessage = (ClientInfoMessage) message;
            systemMessage.execute(thread, this);
        }
    }
    
    @Override
    public void removeConnection (ConnectionThread thread) {
        myConnectionThreads.remove(thread);
    }

    @Override
    public void joinLobby (ConnectionThread thread, String lobbyName) {
        Lobby lobby;
        if(!myLobbies.containsKey(lobbyName)) {
            lobby = new Lobby(this);
            myLobbies.put(lobbyName, lobby);
        }
        myConnectionThreads.remove(thread.getID());
        lobby = myLobbies.get(lobbyName);
        lobby.addConnection(thread);
    }

}
