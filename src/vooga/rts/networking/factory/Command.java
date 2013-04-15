package vooga.rts.networking.factory;

import vooga.rts.networking.server.ConnectionThread;
import vooga.rts.networking.server.ICommandable;

public interface Command {

    public void execute (ConnectionThread thread, ICommandable server, Object[] parameters);
}
