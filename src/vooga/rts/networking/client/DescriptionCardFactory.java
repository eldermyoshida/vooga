package vooga.rts.networking.client;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class DescriptionCardFactory{
    public DescriptionCardFactory(){
        
    }
    
    public JPanel createCard(){
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10,10));
        
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
        
        mainPanel.add(generalInfo, BorderLayout.WEST);
        mainPanel.add(createSpecificPanel(), BorderLayout.CENTER);
        mainPanel.setOpaque(false);
        return mainPanel;
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
}
