package vooga.rts.networking.client;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;


public class ServerBrowserView extends JPanel {
    
    private static final long serialVersionUID = -4494998676210936451L;
    private JTable myServerListTable;

    /**
     * Create the panel.
     */
    public ServerBrowserView () {
        setLayout(new BorderLayout(0, 0));

        createBottomPanel();
        createLabelPanel();

        myServerListTable = new JTable();
        add(myServerListTable, BorderLayout.CENTER);
       

    }

    private void createLabelPanel () {
        JPanel labelPanel = new JPanel();
        add(labelPanel, BorderLayout.NORTH);

        // TODO get the name of the game and display it here
        JLabel gameNameLabel = new JLabel("New label");
        labelPanel.add(gameNameLabel);
    }

    private void createBottomPanel () {
        JPanel panel = new JPanel();
        add(panel, BorderLayout.SOUTH);
        panel.setLayout(new BorderLayout(0, 0));

        JButton btnCreateNewServer = new JButton("Create New Server");
        btnCreateNewServer.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent arg0) {
            }
        });
        panel.add(btnCreateNewServer, BorderLayout.WEST);
        
        JButton btnJoinServer = new JButton("Join Server");

        btnJoinServer.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent arg0) {
            }
        });
        panel.add(btnJoinServer, BorderLayout.EAST);
    }

}
