package vooga.rts.networking;

import vooga.rts.networking.server.MatchmakerServer;


public class Main {
    public static void main(String[] args) {
        
        MatchmakerServer server = new MatchmakerServer();
        server.run();
    }
}
