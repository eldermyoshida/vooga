package vooga.rts.gui.menus;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.Observable;
import javax.swing.JFrame;
import vooga.rts.gui.Menu;
import vooga.rts.gui.Window;
import vooga.rts.networking.client.ClientModel;
import vooga.rts.networking.server.MatchmakerServer;


public class MultiMenu extends Menu {

    private JFrame myFrame;
    private ClientModel myClientModel;

    public MultiMenu (JFrame f) {
        myFrame = f;
        MatchmakerServer server = new MatchmakerServer();
        server.startAcceptingConnections();
        myClientModel = new ClientModel("Test Game", "User 1", new String[] { "protoss", "zerg" },
                                        new String[] { "map1", "map2" },
                                        new Integer[][] { { 2, 3, 4 }, { 2, 3, 4, 5, 6 } });
        myFrame.add(myClientModel.getPanel());
    }

    @Override
    public void paint (Graphics2D pen) {

        super.paint(pen);

        pen.setFont(new Font("Helvetica", Font.BOLD, 50));
        pen.setColor(Color.red);
        pen.drawString("This is the Multiplayer page. Click to start game.", 150, 150);

    }

    public void handleMouseDown (int x, int y) {
        myFrame.remove(myClientModel.getPanel());
        setChanged();
        notifyObservers();
    }

    @Override
    public void update (Observable o, Object a) {
        setChanged();
        notifyObservers();
    }
}
