package vooga.rts.networking.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameContainer implements ICommandable {

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
    
    public void removeConnection (ConnectionThread thread) {
        myConnectionThreads.remove(thread);
    }
    
    public ConnectionThread getConnectionThread (int id) {
        return myConnectionThreads.get(id);
    }

    @Override
    public void joinGame (ConnectionThread thread, String gameName) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void joinLobby (ConnectionThread thread, String lobbyName) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void leaveLobby (ConnectionThread thread) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void startGameServer (ConnectionThread thread) {
        // TODO Auto-generated method stub
        
    }

}
