package vooga.rts.networking.client.GUI;

import javax.swing.JFrame;
import vooga.rts.networking.communications.clientmessages.HostDescriptionMessage;

public class TestMain {

    private String[] imageFileNames = { "Scroll.png", "Scroll1.jpg",
                                        "Scroll2.jpg", "Scroll3.jpg","Scroll.png", "Scroll1.jpg",
                                        "Scroll2.jpg", "Scroll3.jpg"};

    public static void main(String[] args) {
        String[] imageFileNames = { "Scroll.png", "Scroll1.jpg",
                                            "Scroll2.jpg", "Scroll3.jpg","Scroll.png", "Scroll1.jpg",
                                            "Scroll2.jpg", "Scroll3.jpg"};
        ServerBrowser s = new ServerBrowser();
        for ( int i = 0 ; i < imageFileNames.length ; i++){
            HostDescriptionMessage m = new HostDescriptionMessage("user "+i,"map "+i,""+i,"server "+i,
                                                                  "../../resources/" +imageFileNames[i]);
            s.addConnection(m);
        }
        s.removeConnection("user 10");
        s.removeConnection("user 5");
    }
}
