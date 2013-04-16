package vooga.rts.networking.client;

import java.awt.BorderLayout;
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
    private JLabel myMapLabel = new JLabel();
    private String[] imageFileNames = { "Scroll.png", "Scroll1.jpg",
                                        "Scroll2.jpg", "Scroll3.jpg","Scroll.png", "Scroll1.jpg",
                                        "Scroll2.jpg", "Scroll3.jpg"};
    private JToolBar myBar = new JToolBar();
    private static final Font DEFAULT_FONT = new Font("Helvetica", Font.PLAIN,20);

    /**
     * Create the panel.
     */
    public ServerBrowserView () {
        //setLayout(new BorderLayout(0, 0));
        //JTabbedPane tabPanel = new JTabbedPane();
        //tabPanel.setPreferredSize(new Dimension(800,550));
        this.setPreferredSize(new Dimension(800,600));
        //this.setLayout(new GridLayout(2,1));
        setToolBar();
        
        
        //add(createJoinPanel(),"Join a Game");
        createJoinPanel();
        //tabPanel.add(createHostPanel(),"Host a Game");
        //add(tabPanel);
        
        
        //myBar.setPreferredSize(new Dimension(700,110));
        //myBar.s
        //add(myServerListTable, BorderLayout.CENTER);
        pack();
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

    }
    
    private void setToolBar(){
        myBar.add(Box.createGlue());
        myBar.add(Box.createGlue());
        imageLoader.execute();
        myBar.setFloatable(false);
        myBar.setRollover(true);
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
                     
                    thumbAction = new ThumbnailAction(icon, thumbnailIcon);
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
        
        /**
         *The icon if the full image we want to display.
         */
        private Icon displayPhoto;
         
        /**
         * @param Icon - The full size photo to show in the button.
         * @param Icon - The thumbnail to show in the button.
         * @param String - The descriptioon of the icon.
         */
        public ThumbnailAction(Icon photo, Icon thumb){
            displayPhoto = photo;
             
            // The short description becomes the tooltip of a button.
            //putValue(SHORT_DESCRIPTION, desc);
             
            // The LARGE_ICON_KEY is the key for setting the
            // icon when an Action is applied to a button.
            putValue(LARGE_ICON_KEY, thumb);
        }
         
        /**
         * Shows the full image in the main area and sets the application title.
         */
        public void actionPerformed(ActionEvent e) {
            myMapLabel.setIcon(displayPhoto);
        }
    }

    private void createJoinPanel () {
        ServerBrowserPanel joinPanel = new ServerBrowserPanel();
        joinPanel.setLayout(new BorderLayout(0, 0));
        //JPanel joinPanel = new JPanel();
        //joinPanel.setPreferredSize(this.getSize());
        JPanel workingPanel = new JPanel();
        joinPanel.add(workingPanel);
        //workingPanel.setPreferredSize(this.getSize());
        workingPanel.setLayout(new BorderLayout(10,10));
        //joinPanel.repaint();
        //repaint();
        joinPanel.setBorder(new EmptyBorder(50, 110, 50, 110) );
        //joinPanel.setLayout(new BoxLayout(joinPanel,BoxLayout.X_AXIS));
        JScrollPane scroll = new JScrollPane(myBar);
        //scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        workingPanel.add(scroll,BorderLayout.SOUTH);
        //myBar.setOpaque(false);
        
        
        List<String> s = new ArrayList<String>();
        for (int i = 0; i<100; i++){
            s.add("server #"+i);
        }
        // TODO get the name of the game and display it here
       
        //JList serverList = new JList(s.toArray());
        //serverList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //serverList.setLayoutOrientation(JList.VERTICAL);
        //JScrollPane scrollPane = new JScrollPane(serverList);
        //scrollPane.setPreferredSize(new Dimension(200,350));
        //serverList.setBackground(new Color(0xF5DEB3));
        //joinPanel.add(scrollPane,BorderLayout.WEST);
        
        
        workingPanel.add(createGeneralPanel(),BorderLayout.WEST);
        workingPanel.add(createSpecificPanel(),BorderLayout.CENTER);
        workingPanel.setOpaque(false);
        getContentPane().add(joinPanel);
        
        
        //return joinPanel;
    }
    
    private JPanel createGeneralPanel(){
        
        JPanel generalInfo = new JPanel();
        generalInfo.setLayout(new GridLayout(2,1,0,20));
        generalInfo.setOpaque(false);
        ImageIcon icon = new ImageIcon(this.getClass().getResource("../resources/Scroll.png"));
        Image img = icon.getImage();
        Image scaled = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        JLabel c = new JLabel("Map info: ososososso");
        c.setHorizontalTextPosition(SwingConstants.CENTER);
        c.setVerticalTextPosition(SwingConstants.TOP);
        c.setAlignmentX(SwingConstants.TOP);
        c.setIcon(new ImageIcon(scaled));
        //new JLabel("Map: ",new ImageIcon(scaled),JLabel.TRAILING)
        generalInfo.add(c);
        JPanel description = new JPanel();
        description.setOpaque(false);
        generalInfo.add(description);
        description.setLayout(new GridLayout(3,1));
        description.add(new JLabel("Server: "),BorderLayout.SOUTH);
        description.add(new JLabel("Host: "),BorderLayout.SOUTH);
        description.add(new JLabel("Max Players: "),BorderLayout.SOUTH);

        return generalInfo;
    }
    
    private JPanel createSpecificPanel(){
        JPanel specific = new JPanel();
        int numLabels = 10;
        specific.setLayout(new GridLayout(0,1));
        for(int i = 0 ; i<numLabels; i++){
            JLabel label = new JLabel("label number "+i);
            label.setHorizontalAlignment(SwingConstants.CENTER);
            specific.add(label);
        }
        specific.setOpaque(false);
        return specific;
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
