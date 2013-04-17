package vooga.rts.networking.client.GUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
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
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.border.EmptyBorder;
import vooga.rts.networking.communications.Message;
import vooga.rts.networking.communications.clientmessages.HostDescriptionMessage;
import vooga.rts.networking.logger.NetworkLogger;


public class ServerBrowser extends JFrame {
    
    private static final long serialVersionUID = -4494998676210936451L;
    private JTable myServerListTable;
    private String[] imageFileNames = { "Scroll.png", "Scroll1.jpg",
                                        "Scroll2.jpg", "Scroll3.jpg","Scroll.png", "Scroll1.jpg",
                                        "Scroll2.jpg", "Scroll3.jpg"};
    private JToolBar myBar = new JToolBar();
    private Map<JButton, JPanel> myCardMap;
    
    private JPanel myCards = new JPanel();
    private Queue<Message> myMessageQueue;
    
    private int index = 0;
    
    
    /**
     * Create the panel.
     */
    public ServerBrowser () {

        this.setPreferredSize(new Dimension(800,600));

        myCardMap = new HashMap<JButton, JPanel>();
        myMessageQueue = new LinkedList<Message>();
        createJoinPanel();
        
        pack();
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

    }
    
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
    
    public void removeConnection(String hostName){
        CardLayout card = (CardLayout) myCards.getLayout();
        for (JButton button : myCardMap.keySet()){        
            if (button.getActionCommand().equals(hostName)){
                myBar.remove(button);
                card.removeLayoutComponent(myCardMap.get(button));
                return;
            }
        } 
        NetworkLogger n = NetworkLogger.getInstance();
        n.addHandler(NetworkLogger.FORMAT_CONSOLE);
        n.logMessage(Level.SEVERE,"Host does not exist");
    }
    
    public void addConnection(Message m) {
        HostDescriptionMessage host = (HostDescriptionMessage) m;
        ImageIcon icon;
        icon = ImageHelper.getImageIcon(host.getImagePath());
        ThumbnailAction thumbAction = null;      
        ImageIcon thumbnailIcon = new ImageIcon(ImageHelper.getScaledImage(icon.getImage(),80));
        String hostName = host.getHost();
        thumbAction = new ThumbnailAction(hostName, thumbnailIcon);
        
        JButton thumbButton = new JButton(thumbAction);
        thumbButton.setActionCommand(thumbAction.getAction());
        JPanel card = DescriptionCardFactory.getInstance().createCard(host);
        myCards.add(hostName,card);
        myCardMap.put(thumbButton, card);

        myBar.add(thumbButton, myBar.getComponentCount() - 1); 
        index++;
    }
    
    private class ThumbnailAction extends AbstractAction{
        
        //private Icon
        private String myAction;
         
        /**
         * @param Icon - The thumbnail to show in the button.
         * @param String - The descriptioon of the icon.
         */
        public ThumbnailAction(String action, Icon thumb){
            myAction = action;
            putValue(LARGE_ICON_KEY, thumb);
        }
        
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

    private void createJoinPanel () {
        BackgroundPanel joinPanel = new BackgroundPanel();
        JPanel workingPanel = new JPanel();
        joinPanel.add(workingPanel);
        workingPanel.setLayout(new BorderLayout(10,10));
        
        workingPanel.add(setToolBar(),BorderLayout.SOUTH);

        // TODO get the name of the game and display it here
        myCards.setLayout(new CardLayout());
        myCards.setOpaque(false);
        workingPanel.add(myCards,BorderLayout.CENTER);
        workingPanel.setOpaque(false);
        getContentPane().add(joinPanel);
    }

}
