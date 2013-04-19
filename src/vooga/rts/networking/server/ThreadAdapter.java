package vooga.rts.networking.server;

/**
 * Adapter for I ThreadContainier, does not implement functionality on classes
 * @author Henrique Moraes
 *
 */
public class ThreadAdapter  implements IThreadContainer{

    public ThreadAdapter () {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void removeConnection (ConnectionThread thread) {
        
    }

    @Override
    public void joinGameContainer (ConnectionThread thread, String gameName) {
        
    }

    @Override
    public void joinLobby (ConnectionThread thread, int lobbyNumber) {
        
    }

    @Override
    public void leaveLobby (ConnectionThread thread) {
        
    }

    @Override
    public void startGameServer (ConnectionThread thread) {
        
    }

    @Override
    public void requestLobbies (ConnectionThread thread, int startNumber, int endNumber) {
        
    }

}
