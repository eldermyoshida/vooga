package vooga.rts.networking.factory;

import vooga.rts.networking.server.ConnectionThread;
import vooga.rts.networking.server.IThreadContainer;

public class JoinLobby implements Command {

    @Override
    public void execute (ConnectionThread thread, IThreadContainer server, Object[] parameters) {
        server.joinLobby(thread, (String) parameters[0]);
    }

}
