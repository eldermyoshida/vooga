package vooga.rts.networking.client;

import java.awt.Dimension;
import javax.swing.JFrame;

public class TestMain {

    /**
     * @param args
     */
    public static void main (String[] args) {
        ClientModel model =
                new ClientModel("Test Game", "User 1", new String[] { "protoss", "zerg" },
                                new String[] { "map1", "map2" },
                                new Integer[][] { { 2, 3, 4 }, { 2, 3, 4, 5, 6 } });

        JFrame frame = new JFrame();
        frame.add(model.getView());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(600, 500));
        frame.setVisible(true);
        frame.pack();
    }

}
