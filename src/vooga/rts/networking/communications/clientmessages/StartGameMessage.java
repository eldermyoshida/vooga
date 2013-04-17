package vooga.rts.networking.communications.clientmessages;

import vooga.rts.networking.server.ConnectionThread;
import vooga.rts.networking.server.IThreadContainer;

public class StartGameMessage extends ClientInfoMessage {

    @Override
    public void execute (ConnectionThread thread, IThreadContainer server) {
        server.startGameServer(thread);
    }

}
