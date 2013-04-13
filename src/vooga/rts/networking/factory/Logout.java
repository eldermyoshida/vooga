package vooga.rts.networking.factory;

import vooga.rts.networking.server.ConnectionThread;
import vooga.rts.networking.server.MatchmakerServer;

public class Logout implements Command {

    @Override
    public void execute (ConnectionThread thread, MatchmakerServer server, Object[] parameters) {
        int id = thread.getID();
    }

}
