package vooga.rts.networking.factory;

import vooga.rts.networking.server.ConnectionThread;
import vooga.rts.networking.server.ICommandable;

public class InitialConnection implements Command {

    @Override
    public void execute (ConnectionThread thread, ICommandable server, Object[] parameters) {
        thread.setUserName((String) parameters[0]);
        thread.setGameName((String) parameters[1]);
        server.joinGame(thread, (String) parameters[1]);
    }

}
