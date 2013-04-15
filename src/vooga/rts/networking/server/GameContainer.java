package vooga.rts.networking.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import vooga.rts.networking.communications.Message;
import vooga.rts.networking.communications.SystemMessage;
import vooga.rts.networking.factory.Command;
import vooga.rts.networking.factory.CommandFactory;

public class GameContainer implements IMessageReceiver, IThreadContainer {

    private Map<Integer, ConnectionThread> myConnectionThreads = new HashMap<Integer, ConnectionThread>();
    private Map<String, LobbyContainer> myLobbies = new HashMap<String, LobbyContainer>();
    private List<GameServer> myGameServers = new ArrayList<GameServer>();
    private CommandFactory myFactory;
    private int myGameNumber = 0;
    
    public GameContainer (CommandFactory factory) {
        myFactory = factory;
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
        if(message instanceof SystemMessage) {
            SystemMessage systemMessage = (SystemMessage) message;
            Command command = myFactory.getCommand(systemMessage.getMessage());
            command.execute(thread, this, systemMessage.getParameters());
        } else {
            
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
            lobby = new LobbyContainer(myFactory, this);
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