package vooga.rts.networking.factory;

import vooga.rts.networking.server.ConnectionThread;
import vooga.rts.networking.server.MatchmakerServer;

public class JoinLobby implements Command {

    @Override
    public void execute (ConnectionThread thread, MatchmakerServer server, Object[] parameters) {
        server.joinLobby(thread, thread.getGameName(), (String) parameters[0]);
    }

}
