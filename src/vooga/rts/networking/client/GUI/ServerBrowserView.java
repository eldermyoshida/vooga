package vooga.rts.networking.client.GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


/**
 * View for the server browser.
 * 
 * @author David Winegar
 * 
 */
public class ServerBrowserView extends JPanel {

    private static final long serialVersionUID = 5915312995153741263L;
    JTable myTable;

    /**
     * Initialize view.
     * 
     * @param adapter adapter for server browser table
     * @param gameName name of the game
     */
    public ServerBrowserView (ServerBrowserTableAdapter adapter, String gameName) {
        setLayout(new BorderLayout(0, 0));
        myTable = new JTable(adapter);
        myTable.setPreferredScrollableViewportSize(new Dimension(500, 70));
        myTable.setFillsViewportHeight(true);
        JScrollPane pane = new JScrollPane(myTable);

        add(pane, BorderLayout.CENTER);
        add(createTopPanel(gameName), BorderLayout.NORTH);
    }

    /**
     * Creates the top panel, containing the JButton to host a game and the JLabel containing the
     * game name.
     */
    private JPanel createTopPanel (String gameName) {
        JPanel panel = new JPanel();
        BorderLayout layout = new BorderLayout();
        panel.setLayout(layout);

        JPanel innerPanel = new JPanel();
        FlowLayout innerLayout = new FlowLayout();
        innerPanel.setLayout(innerLayout);
        //TODO resources file
        innerPanel.add(new JLabel(gameName + " Lobby Browser"));

        panel.add(innerPanel, BorderLayout.CENTER);

        //TODO resources file
        JButton hostGame = new JButton("Host Game");
        hostGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent arg0) {
                // TODO connect with switching view
            }
        });

        panel.add(hostGame, BorderLayout.WEST);

        return panel;
    }

}
