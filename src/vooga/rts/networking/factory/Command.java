package vooga.rts.networking.factory;

import vooga.rts.networking.server.ConnectionThread;
import vooga.rts.networking.server.MatchmakerServer;

public interface Command {

    public void execute (ConnectionThread thread, MatchmakerServer server, Object[] parameters);
}
