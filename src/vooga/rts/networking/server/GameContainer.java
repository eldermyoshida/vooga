package vooga.rts.networking.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import vooga.rts.networking.communications.Message;
import vooga.rts.networking.communications.server.ServerSystemMessage;

public class GameContainer implements IMessageReceiver, IThreadContainer {

    private Map<Integer, ConnectionThread> myConnectionThreads = new HashMap<Integer, ConnectionThread>();
    private Map<String, LobbyContainer> myLobbies = new HashMap<String, LobbyContainer>();
    private List<GameServer> myGameServers = new ArrayList<GameServer>();
    private int myGameNumber = 0;
    
    public GameContainer () {
    }
    
    protected void addConnection (ConnectionThread thread) {
        myConnectionThreads.put(thread.getID(), thread);
    }
    
    protected void addGameServer (GameServer server) {
        myGameServers.add(server);
    }
    
    protected void removeGameServer (GameServer server) {
        
    }
    
    @Override
    public void sendMessage (Message message, ConnectionThread thread) {
        if(message instanceof ServerSystemMessage) {
            ServerSystemMessage systemMessage = (ServerSystemMessage) message;
            systemMessage.execute(thread, this);
        }
    }
    
    @Override
    public void removeConnection (ConnectionThread thread) {
        myConnectionThreads.remove(thread);
    }

    @Override
    public void joinGame (ConnectionThread thread, String gameName) {
    }

    @Override
    public void joinLobby (ConnectionThread thread, String lobbyName) {
        LobbyContainer lobby;
        if(!myLobbies.containsKey(lobbyName)) {
            lobby = new LobbyContainer(this);
            myLobbies.put(lobbyName, lobby);
        }
        myConnectionThreads.remove(thread.getID());
        lobby = myLobbies.get(lobbyName);
        lobby.addConnection(thread);
    }

    @Override
    public void leaveLobby (ConnectionThread thread) {
    }

    @Override
    public void startGameServer () {
    }

}
