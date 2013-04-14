package vooga.rts.networking.factory;

import vooga.rts.networking.server.ConnectionThread;
import vooga.rts.networking.server.ICommandable;

public class Logout implements Command {

    @Override
    public void execute (ConnectionThread thread, ICommandable server, Object[] parameters) {
        server.removeConnection(thread);
        thread.close();
    }

}
