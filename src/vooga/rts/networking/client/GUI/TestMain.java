package vooga.rts.networking.client.GUI;

import javax.swing.JFrame;
import vooga.rts.networking.communications.Message;
import vooga.rts.networking.communications.clientmessages.HostDescriptionMessage;
import vooga.rts.networking.communications.clientmessages.HostDisconnectedMessage;
import vooga.rts.networking.communications.clientmessages.TeamDescriptionMessage;

public class TestMain {

    private String[] imageFileNames = { "Scroll.png", "Scroll1.jpg",
                                        "Scroll2.jpg", "Scroll3.jpg","Scroll.png", "Scroll1.jpg",
                                        "Scroll2.jpg", "Scroll3.jpg"};

    public static void main(String[] args) {
        String[] imageFileNames = { "Scroll.png", "Scroll1.jpg",
                                            "Scroll2.jpg", "Scroll3.jpg","Scroll.png", "Scroll1.jpg",
                                            "Scroll2.jpg", "Scroll3.jpg"};
        String [][] teams = {{"alan","berto","ha"},{"rosa","pedro","jo"}, {"alex","david","po"}};
        
        JoinLobby s = new JoinLobby();
        for ( int i = 0 ; i < imageFileNames.length ; i++){
            HostDescriptionMessage m = new HostDescriptionMessage("user "+i,"map "+i,""+i,"server "+i,
                                                                  "../../resources/" +imageFileNames[i]);
            s.readMessage(m);
            TeamDescriptionMessage t = new TeamDescriptionMessage("user "+i, teams);
            s.readMessage(t);
        }
        String [][] teams2 = {{"alan","berto"},{"rosa","pedro"}, {"alex","david"}};
        TeamDescriptionMessage t = new TeamDescriptionMessage("user 1", teams2);
        s.readMessage(t);
        
    }
}
