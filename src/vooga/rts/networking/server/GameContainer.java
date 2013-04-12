package vooga.rts.networking.server;

import java.util.ArrayList;
import java.util.List;

public class GameContainer {

    private String myGameName;
    private List<ConnectionThread> threads = new ArrayList<ConnectionThread>();
    private List<GameServer> myGameServers = new ArrayList<GameServer>();
    
    public GameContainer(String gameName) {
        myGameName = gameName;
    }
    
    public String getName() {
        return myGameName;
    }
    
    public void addConnection (ConnectionThread thread) {
        threads.add(thread);
    }
    
    private void initializeGame (int id) {
        GameServer gameServer = new GameServer(id);
        myGameServers.add(gameServer);
    }
    
    public void closeConnection (ConnectionThread thread) {
        threads.remove(thread);
        thread.close();
    }
    
    public ConnectionThread getConnectionThread (int id) {
        for(ConnectionThread thread : threads) {
            if(thread.getID() == id) {
                return thread;
            }
        }
        return null;
    }

}
