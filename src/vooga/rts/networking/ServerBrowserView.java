package vooga.rts.networking;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JLabel;

public class ServerBrowserView extends JPanel {
    private JTable serverListTable;

    /**
     * Create the panel.
     */
    public ServerBrowserView () {
        setLayout(new BorderLayout(0, 0));
        
        JPanel panel = new JPanel();
        add(panel, BorderLayout.SOUTH);
        panel.setLayout(new BorderLayout(0, 0));
        
        JButton btnCreateNewServer = new JButton("Create New Server");
        btnCreateNewServer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        panel.add(btnCreateNewServer, BorderLayout.WEST);
        
        
        
        JPanel panel_1 = new JPanel();
        add(panel_1, BorderLayout.NORTH);
        
        JLabel gameNameLabel = new JLabel("New label");
        panel_1.add(gameNameLabel);
        
        serverListTable = new JTable();
        add(serverListTable, BorderLayout.CENTER);
        JButton btnJoinServer = new JButton("Join Server");
        
        btnJoinServer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        panel.add(btnJoinServer, BorderLayout.EAST);

    }

}
