package vooga.rts.networking.client.GUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import vooga.rts.networking.communications.Message;
import vooga.rts.networking.communications.clientmessages.HostDescriptionMessage;

public class ServerGUIFactory{
    private static final Font DEFAULT_FONT = new Font("Century Gothic", Font.PLAIN,18);
    private Font myFont = DEFAULT_FONT;
    private static ServerGUIFactory instance;
    
    private ServerGUIFactory(){
    }
    
    public static ServerGUIFactory getInstance(){
        if (instance == null) {
            instance = new ServerGUIFactory();
        }
        return instance;
    }
    
    public JPanel createJoinPanel(Message message){
        HostDescriptionMessage host = (HostDescriptionMessage) message;
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10,10));
        
        JPanel generalInfo = new JPanel();
        generalInfo.setLayout(new GridLayout(2,1,0,20));
        generalInfo.setOpaque(false);
        
        Image scaled = ImageHelper.getScaledImage(host.getImagePath(), 150);

        JLabel mapLabel = makeLabel(host.getMapDescription());
        mapLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        mapLabel.setVerticalTextPosition(SwingConstants.TOP);
        mapLabel.setAlignmentX(SwingConstants.TOP);
        mapLabel.setIcon(new ImageIcon(scaled));
        mapLabel.setFont(myFont);
        
        generalInfo.add(mapLabel);
        JPanel description = new JPanel();
        description.setOpaque(false);
        generalInfo.add(description);
        description.setLayout(new GridLayout(0,1));
        description.add(makeLabel(host.getServerName()));
        description.add(makeLabel(host.getHost()));
        description.add(makeLabel(host.getMaxPlayers()+""));
        
        mainPanel.add(generalInfo, BorderLayout.WEST);
        mainPanel.add(createSpecificPanel(), BorderLayout.CENTER);
        mainPanel.setOpaque(false);
        return mainPanel;
    }
    
    private JLabel makeLabel(String desc) {
        JLabel label = new JLabel(desc);
        label.setFont(myFont);
        return label;
    }
    
    public void setFont(Font font){
        myFont = font;
    }
    
    private JPanel createSpecificPanel(){
        JPanel specific = new JPanel();
        int numLabels = 6;
        specific.setLayout(new GridLayout(0,1));
        for(int i = 0 ; i<numLabels; i++){
            JLabel label = makeLabel("label number "+i);
            label.setHorizontalAlignment(SwingConstants.CENTER);
            specific.add(label);
        }
        specific.setOpaque(false);
        return specific;
    }
}
