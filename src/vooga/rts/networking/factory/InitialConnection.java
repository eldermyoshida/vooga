package vooga.rts.networking.factory;

import vooga.rts.networking.server.ConnectionThread;
import vooga.rts.networking.server.MatchmakerServer;

public class InitialConnection implements Command {

    @Override
    public void execute (ConnectionThread thread, MatchmakerServer server, Object[] parameters) {
        thread.setUserName((String) parameters[0]);
        thread.setGameName((String) parameters[1]);
        server.addConnectionToGame(thread, (String) parameters[1]);
    }

}
