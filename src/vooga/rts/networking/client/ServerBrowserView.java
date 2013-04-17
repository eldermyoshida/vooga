package vooga.rts.networking.client;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListSelectionModel;
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


public class ServerBrowserView extends JFrame {
    
    private static final long serialVersionUID = -4494998676210936451L;
    private JTable myServerListTable;
    private String[] imageFileNames = { "Scroll.png", "Scroll1.jpg",
                                        "Scroll2.jpg", "Scroll3.jpg","Scroll.png", "Scroll1.jpg",
                                        "Scroll2.jpg", "Scroll3.jpg"};
    private JToolBar myBar = new JToolBar();
    private static final Font DEFAULT_FONT = new Font("Helvetica", Font.PLAIN,20);
    private JPanel myCards = new JPanel();

    /**
     * Create the panel.
     */
    public ServerBrowserView () {

        this.setPreferredSize(new Dimension(800,600));

        createJoinPanel();

        pack();
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

    }
    
    private JComponent setToolBar(){
        myBar.add(Box.createGlue());
        myBar.add(Box.createGlue());
        myBar.setOpaque(false);
        imageLoader.execute();
        myBar.setFloatable(false);
        myBar.setRollover(true);
        JScrollPane scroll = new JScrollPane(myBar);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        return scroll;
    }
    
    private SwingWorker<Void,ThumbnailAction> imageLoader = new SwingWorker<Void,ThumbnailAction>() {
        
        @Override
        protected Void doInBackground () throws Exception {
            for (int i = 0; i < imageFileNames.length; i++) {
                ImageIcon icon;
                icon = new ImageIcon(this.getClass().getResource("../resources/" + imageFileNames[i]));
                 
                ThumbnailAction thumbAction = null;
                if(icon != null){
                     
                    ImageIcon thumbnailIcon = new ImageIcon(getScaledImage(icon.getImage(),80));
                    thumbAction = new ThumbnailAction("panel "+i, thumbnailIcon);
                    myCards.add("panel "+i,DescriptionCardFactory.createCard("../resources/" + imageFileNames[i]));
                    
                } 
//                }else{
//                     the image failed to load for some reason
//                     so load a placeholder instead
//                    thumbAction = new ThumbnailAction(placeholderIcon, placeholderIcon);
//                }
                publish(thumbAction);
            }
            return null;
        }
        
        @Override
        protected void process(List<ThumbnailAction> chunks) {
            for (ThumbnailAction thumbAction : chunks) {
                JButton thumbButton = new JButton(thumbAction);
                thumbButton.setActionCommand(thumbAction.getAction());
                // add the new button BEFORE the last glue
                // this centers the buttons in the toolbar
                myBar.add(thumbButton, myBar.getComponentCount() - 1);
            }
        }
        
        
    };
    
    public Image getScaledImage(Image image,int size){
        BufferedImage buffer = new BufferedImage(size,size,BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = buffer.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(image, 0, 0, size, size, null);
        g2.dispose();
        return buffer;
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
        joinPanel.setLayout(new BorderLayout(0, 0));
        JPanel workingPanel = new JPanel();
        joinPanel.add(workingPanel);
        workingPanel.setLayout(new BorderLayout(10,10));
        joinPanel.setBorder(new EmptyBorder(50, 110, 50, 110) );
        //joinPanel.setLayout(new BoxLayout(joinPanel,BoxLayout.X_AXIS));
        
        workingPanel.add(setToolBar(),BorderLayout.SOUTH);

        // TODO get the name of the game and display it here
        DescriptionCardFactory fac = new DescriptionCardFactory();
        myCards.setLayout(new CardLayout());
        myCards.setOpaque(false);
        //myCards.add(fac.createCard(),"panel 1");
        workingPanel.add(myCards,BorderLayout.CENTER);
        //workingPanel.add(createSpecificPanel(),BorderLayout.CENTER);
        workingPanel.setOpaque(false);
        getContentPane().add(joinPanel);
        
        
        //return joinPanel;
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
