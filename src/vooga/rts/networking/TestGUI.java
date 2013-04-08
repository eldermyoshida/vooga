package vooga.rts.networking;

import java.awt.Dimension;
import javax.swing.JFrame;

public class TestGUI {

    public TestGUI () {
        JFrame frame = new JFrame () ;
        frame.pack();
    }
    
    public static void main(String[] args) {
        new MatchmakerServer();
        new TestGUI();
    }
}
