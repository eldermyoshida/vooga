package vooga.rts.networking.client.GUI;

package vooga.rts.networking.client.GUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.logging.Level;
import javax.swing.AbstractAction;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

import vooga.rts.networking.communications.LobbyInfo;
import vooga.rts.networking.communications.Message;
import vooga.rts.networking.communications.clientmessages.GUIMessage;
import vooga.rts.networking.communications.clientmessages.HostDescriptionMessage;
import vooga.rts.networking.communications.clientmessages.HostDisconnectedMessage;
import vooga.rts.networking.communications.clientmessages.TeamDescriptionMessage;
import vooga.rts.networking.logger.NetworkLogger;

/**
* This class manages the interface in which the user will join a game
* @author Henrique Moraes
*
*/
public class ServerBrowserGUI extends JFrame {
    
    private static final long serialVersionUID = -4494998676210936451L;
    private JTable myServerListTable;
    private static final int TEAM_PANEL_INDEX = 1;
    private String[] imageFileNames = { "Scroll.png", "Scroll1.jpg",
                                        "Scroll2.jpg", "Scroll3.jpg","Scroll.png", "Scroll1.jpg",
                                        "Scroll2.jpg", "Scroll3.jpg"};
    private JToolBar myBar = new JToolBar();
    private Map<JButton, JPanel> myCardMap;
    
    private JPanel myCards = new JPanel();
    private Queue<Message> myMessageQueue;
    NetworkLogger myLogger = NetworkLogger.getInstance();
    
    private int index = 0;
    
    
    /**
* Constructor for this class
*/
    public ServerBrowserGUI () {

        this.setPreferredSize(new Dimension(800,600));

        myCardMap = new HashMap<JButton, JPanel>();
        myMessageQueue = new LinkedList<Message>();
        createJoinPanel();
        
        myLogger.setLevel(Level.INFO);
        
        pack();
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

    }
    
    /**
* manages the settings of the toolbar and returns a panel that contains it
* @return Scrollable panel that wraps the toolbar
*/
    protected JComponent setToolBar(){
        myBar.add(Box.createGlue());
        myBar.add(Box.createGlue());
        myBar.setOpaque(false);
        myBar.setFloatable(false);
        myBar.setRollover(true);
        JScrollPane scroll = new JScrollPane(myBar);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        return scroll;
    }
    
    /**
* takes appropriate action according to the type of message
* Maybe use a better approach using reflection but I don't know how
* to do it
* @param message message with GUI information
*/
    public void addLobby(LobbyInfo lobby) {
        
    }
    
    /**
* Removes the visual attributes related to the given host
* @param message Disconnected host message containing name of the host
*/
    private void removeConnection(HostDisconnectedMessage host){
        String hostName = host.getHostName();
        CardLayout card = (CardLayout) myCards.getLayout();
        for (JButton button : myCardMap.keySet()){
            if (button.getActionCommand().equals(hostName)){
                myBar.remove(button);
                card.removeLayoutComponent(myCardMap.get(button));
                return;
            }
        }
    }

    /**
* Creates a new connection by asserting the properties in the message
* into the GUI
* @param message Message containing description of host
*/
    private void addConnection(LobbyInfo lobby) {
            ImageIcon icon;
            icon = ImageHelper.getImageIcon(lobby.getImagePath());
            ThumbnailAction thumbAction = null;
            ImageIcon thumbnailIcon = new ImageIcon(ImageHelper.getScaledImage(icon.getImage(),80));
            String hostName = host.getHostName();
            thumbAction = new ThumbnailAction(hostName, thumbnailIcon);

            JButton thumbButton = new JButton(thumbAction);
            thumbButton.setActionCommand(thumbAction.getAction());
            JPanel card = ServerGUIFactory.getInstance().createJoinPanel(host);
            myCards.add(hostName,card);
            myCardMap.put(thumbButton, card);

            myBar.add(thumbButton, myBar.getComponentCount() - 1);
            index++;
    }
    
    /**
* Updates the panel with the teams descriptions
* @param message Message containing description of teams
*/
    private void changeState(TeamDescriptionMessage message) {
        String hostName = message.getHostName();
        for (JButton button : myCardMap.keySet()){
            if (button.getActionCommand().equals(hostName)){
                JPanel card = myCardMap.get(button);
                ServerGUIFactory instance = ServerGUIFactory.getInstance();
                if (card.getComponentCount() > 1 )
                    card.remove(TEAM_PANEL_INDEX);
                card.add(instance.createTeamPanel(message), BorderLayout.CENTER);
            }
        }
    }
    
    private class ThumbnailAction extends AbstractAction{
        
        //private Icon
        private String myAction;
         
        /**
* @param action - The action descriptioon of the button.
* @param Icon - The thumbnail to show in the button.
*/
        public ThumbnailAction(String action, Icon thumb){
            myAction = action;
            putValue(LARGE_ICON_KEY, thumb);
        }
        
        /**
*
* @return Action command string associated with this action
*/
        public String getAction(){
            return myAction;
        }
         
        /**
* Shows the full image in the main area and sets the application title.
*/
        public void actionPerformed(ActionEvent e) {
            CardLayout layout = (CardLayout) myCards.getLayout();
            layout.show(myCards, e.getActionCommand());
        }
    }

    /**
* creates and sets the main panel of the GUI
*/
    private void createJoinPanel () {
        BackgroundPanel joinPanel = new BackgroundPanel();
        JPanel workingPanel = new JPanel();
        joinPanel.add(workingPanel);
        workingPanel.setLayout(new BorderLayout(10,10));
        
        workingPanel.add(setToolBar(),BorderLayout.SOUTH);
        myCards.setLayout(new CardLayout());
        myCards.setOpaque(false);
        workingPanel.add(myCards,BorderLayout.CENTER);
        workingPanel.setOpaque(false);
        getContentPane().add(joinPanel);
    }

}
