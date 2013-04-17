package vooga.rts.networking.server;

import java.util.HashMap;
import java.util.Map;
import vooga.rts.networking.communications.Message;
import vooga.rts.networking.communications.clientmessages.ClientInfoMessage;

public class Lobby extends AbstractThreadContainer implements IMessageReceiver {
    
    private Map<Integer, ConnectionThread> myConnectionThreads = new HashMap<Integer, ConnectionThread>();
    private GameContainer myGameContainer;
    
    public Lobby (GameContainer container) {
        myGameContainer = container;
    }
    
    protected void addConnection (ConnectionThread thread) {
        myConnectionThreads.put(thread.getID(), thread);
        thread.switchMessageServer(this);
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
        myConnectionThreads.remove(thread.getID());
    }
    
    @Override
    public void leaveLobby (ConnectionThread thread) {
        removeConnection(thread);
        myGameContainer.addConnection(thread);
    }
    
}
