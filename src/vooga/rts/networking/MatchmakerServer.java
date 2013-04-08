package vooga.rts.networking;

import java.util.ArrayList;
import java.util.List;

/**
 * Object responsible for creating an instance of a game, and establishing 
 * connections between clients and the game.
 * @author srwareham
 *
 */
public class MatchmakerServer extends Thread {
    private List<ConnectionThread> myConnectionThreads;
    private List<GameServer> myGameServers;
    
    public MatchmakerServer() {
        myConnectionThreads = new ArrayList<ConnectionThread>();
        myGameServers = new ArrayList<GameServer>();
    }
    
    @Override
    public void run () {
        
    }
    
    private void initializeGame() {
        
    }
    
    
}
