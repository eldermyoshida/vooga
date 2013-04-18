package vooga.rts.networking.server;

/**
 * Provides an interface between ClientInfoMessages coming in and the various thread container
 * classses.
 * 
 * @author David Winegar
 * 
 */
public interface IThreadContainer {

    /**
     * Removes the connection.
     * @param thread to remove
     */
    public void removeConnection (ConnectionThread thread);

    /**
     * Joins the specified GameContainer. 
     * @param thread that is joining
     * @param gameName name of game to join
     */
    public void joinGameContainer (ConnectionThread thread, String gameName);

    /**
     * Joins the specified lobby.
     * @param thread that is joining
     * @param lobbyNumber number of lobby
     */
    public void joinLobby (ConnectionThread thread, int lobbyNumber);

    /**
     * Leaves the current lobby.
     * @param thread that is leaving
     */
    public void leaveLobby (ConnectionThread thread);

    public void startGameServer (ConnectionThread thread);

    public void requestLobbies (ConnectionThread thread, int startNumber, int endNumber);

}
