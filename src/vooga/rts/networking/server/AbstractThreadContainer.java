package vooga.rts.networking.server;

/**
 * Default class that does nothing with IThreadContainer. Used by classes with no behavior for these methods.
 * @author David Winegar
 *
 */
public abstract class AbstractThreadContainer implements IThreadContainer {

    @Override
    public void removeConnection (ConnectionThread thread) {
    }

    @Override
    public void joinGame (ConnectionThread thread, String gameName) {
    }

    @Override
    public void joinLobby (ConnectionThread thread, String lobbyName) {
    }

    @Override
    public void leaveLobby (ConnectionThread thread) {
    }

    @Override
    public void startGameServer () {
    }

}
