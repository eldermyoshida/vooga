package vooga.rts.networking.client.GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * Creates the view for the lobby.
 * 
 * @author David Winegar
 * 
 */
public class LobbyView extends JPanel {

    public LobbyView (String gameName) {
        setLayout(new BorderLayout(0, 0));
        add(createTopPanel(gameName));
    }

    // TODO remove repeated code by combining this method with others in other classes
    private JPanel createTopPanel (String gameName) {
        JPanel panel = new JPanel();
        BorderLayout layout = new BorderLayout();
        panel.setLayout(layout);

        JPanel innerPanel = new JPanel();
        FlowLayout innerLayout = new FlowLayout();
        innerPanel.setLayout(innerLayout);
        // TODO resources file
        innerPanel.add(new JLabel(gameName + " Lobby"));

        panel.add(innerPanel, BorderLayout.CENTER);

        // TODO resources file
        JButton leaveLobby = new JButton("Leave Lobby");
        leaveLobby.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent arg0) {
                // TODO connect with switching view
            }
        });

        panel.add(leaveLobby, BorderLayout.WEST);

        return panel;
    }
}
