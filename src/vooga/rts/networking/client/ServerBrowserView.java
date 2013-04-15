package vooga.rts.networking.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.DefaultListSelectionModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;


public class ServerBrowserView extends JPanel {
    
    private static final long serialVersionUID = -4494998676210936451L;
    /**
     * Create the panel.
     */
    public ServerBrowserView () {
        
        //setLayout(new BorderLayout(0, 0));
        JTabbedPane tabPanel = new JTabbedPane();
        tabPanel.setPreferredSize(new Dimension(800,550));
        tabPanel.add(createJoinPanel(),"Join a Game");
        tabPanel.add(createHostPanel(),"Host a Game");
        add(tabPanel);
       

    }

    private JPanel createJoinPanel () {
        ServerBrowserPanel joinPanel = new ServerBrowserPanel();
        joinPanel.repaint();
        joinPanel.setBorder(new EmptyBorder(70, 110, 70, 110) );
        //joinPanel.setLayout(new BoxLayout(joinPanel,BoxLayout.X_AXIS));
        
        List<String> s = new ArrayList<String>();
        for (int i = 0; i<100; i++){
            s.add("server #"+i);
        }
        // TODO get the name of the game and display it here
       
        JList serverList = new JList(s.toArray());
        serverList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        serverList.setLayoutOrientation(JList.VERTICAL);
        JScrollPane scrollPane = new JScrollPane(serverList);
        scrollPane.setPreferredSize(new Dimension(200,350));
        serverList.setBackground(new Color(0xF5DEB3));
        joinPanel.add(scrollPane,BorderLayout.WEST);
        
        JPanel displayPanel = new JPanel(new GridLayout(1,2));
        
        JPanel generalInfo = new JPanel();
        generalInfo.setLayout(new BoxLayout(generalInfo, BoxLayout.Y_AXIS));
        ImageIcon icon = new ImageIcon(this.getClass().getResource("../resources/Scroll.png"));
        Image img = icon.getImage();
        img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        //generalInfo.add(new JLabel("Map: ",new ImageIcon(img),JLabel.CENTER));
        generalInfo.add(new JLabel("Server: "),BorderLayout.SOUTH);
        generalInfo.add(new JLabel("Host: "),BorderLayout.SOUTH);
        generalInfo.add(new JLabel("Max Players: "),BorderLayout.SOUTH);
        displayPanel.add(generalInfo);
        joinPanel.add(displayPanel,BorderLayout.CENTER);
        
        
        return joinPanel;
    }

    private JPanel createHostPanel () {
        JPanel hostPanel = new JPanel();
        //add(hostPanel, BorderLayout.SOUTH);
        hostPanel.setLayout(new BorderLayout(0, 0));

        JButton btnCreateNewServer = new JButton("Create New Server");
        btnCreateNewServer.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent arg0) {
            }
        });
        hostPanel.add(btnCreateNewServer, BorderLayout.WEST);
        
        JButton btnJoinServer = new JButton("Join Server");

        btnJoinServer.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent arg0) {
            }
        });
        hostPanel.add(btnJoinServer, BorderLayout.EAST);
        return hostPanel;
    }

}
