package vooga.rts.networking.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameContainer {

    private String myGameName;
    private Map<Integer, ConnectionThread> myConnectionThreads = new HashMap<Integer, ConnectionThread>();
    private List<GameServer> myGameServers = new ArrayList<GameServer>();
    private Map<String, List<ConnectionThread>> myServerLobbies = new HashMap<String, List<ConnectionThread>>();
    
    public GameContainer(String gameName) {
        myGameName = gameName;
    }
    
    public String getName() {
        return myGameName;
    }
    
    public void addConnection (ConnectionThread thread) {
        myConnectionThreads.put(thread.getID(), thread);
    }
    
    private void initializeGame (int id) {
        GameServer gameServer = new GameServer(id);
        myGameServers.add(gameServer);
    }
    
    public void removeConnection (ConnectionThread thread) {
        myConnectionThreads.remove(thread);
    }
    
    public ConnectionThread getConnectionThread (int id) {
        return myConnectionThreads.get(id);
    }
    
    public void addConnectionToLobby (ConnectionThread thread, String lobbyName) {
        
    }
    
    public void startGame (String lobbyName) {
        
    }

}
