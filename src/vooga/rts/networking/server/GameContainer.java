package vooga.rts.networking.server;

import java.util.ArrayList;
import java.util.List;

public class GameContainer implements IMessageReceiver {

    private String myGameName;
    private List<ConnectionThread> threads = new ArrayList<ConnectionThread>();
    
    public GameContainer(String gameName) {
        myGameName = gameName;
    }
    
    public String getName() {
        return myGameName;
    }
    
    public void addConnection (ConnectionThread thread) {
        threads.add(thread);
        
    }

    @Override
    public void sendMessage (Message message) {
        if (message instanceof SystemMessage) {
            
        }
    }
}
