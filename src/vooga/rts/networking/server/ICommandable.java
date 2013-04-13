package vooga.rts.networking.server;

public interface ICommandable {

    public void removeConnection (ConnectionThread thread);
    
    public void joinGame (ConnectionThread thread, String gameName);
    
    public void joinLobby (ConnectionThread thread, String lobbyName);
    
    public void leaveLobby (ConnectionThread thread);
    
    public void startGameServer (ConnectionThread thread);
}
