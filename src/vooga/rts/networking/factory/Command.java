package vooga.rts.networking.factory;

import vooga.rts.networking.server.ConnectionThread;
import vooga.rts.networking.server.IThreadContainer;

public interface Command {

    public void execute (ConnectionThread thread, IThreadContainer server, Object[] parameters);
}
