package vooga.rts.networking.factory;

import vooga.rts.networking.server.ConnectionThread;
import vooga.rts.networking.server.MatchmakerServer;

public class Logout implements Command {

    @Override
    public void execute (ConnectionThread thread, MatchmakerServer server) {
        int id = thread.getID();
        thread.close();
    }

}
