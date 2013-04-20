package vooga.rts.networking.client.GUI;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 * Test Main for GUI package.
 * @author David Winegar
 *
 */
public class TestMain {

    public static void main (String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(600, 600));
        frame.add(new ServerBrowserView(new ServerBrowserTableAdapter(), "Test"));
        frame.setVisible(true);
        frame.pack();
    }
}
