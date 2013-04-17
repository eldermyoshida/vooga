package vooga.rts.networking.server;

import java.util.HashMap;
import java.util.Map;
import vooga.rts.networking.communications.Message;
import vooga.rts.networking.communications.clientmessages.ClientInfoMessage;


public class GameContainer extends AbstractThreadContainer {

    private Map<String, Room> myRooms = new HashMap<String, Room>();

    protected void addConnection (ConnectionThread thread) {
        addConnection(thread);
        thread.switchMessageServer(this);
    }

    protected void removeRoom (Room room) {
        myRooms.remove(room);
    }

    @Override
    public void receiveMessageFromClient (Message message, ConnectionThread thread) {
        if (message instanceof ClientInfoMessage) {
            ClientInfoMessage systemMessage = (ClientInfoMessage) message;
            systemMessage.execute(thread, this);
        }
    }

    @Override
    public void removeConnection (ConnectionThread thread) {
        removeConnection(thread);
    }

    @Override
    public void joinLobby (ConnectionThread thread, String lobbyName) {
        Room room;
        if (!myRooms.containsKey(lobbyName)) {
            room = new Lobby(this);
            myRooms.put(lobbyName, room);
        }
        removeConnection(thread);
        room = myRooms.get(lobbyName);
        room.addConnection(thread);
    }

}
