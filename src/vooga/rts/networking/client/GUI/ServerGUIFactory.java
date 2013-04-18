package vooga.rts.networking.client.GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import vooga.rts.networking.communications.Message;
import vooga.rts.networking.communications.clientmessages.HostDescriptionMessage;
import vooga.rts.networking.communications.clientmessages.TeamDescriptionMessage;

/**
 * Class that is responsible for creating some panels for the GUI
 * Singleton
 * @author Henrique Moraes, Ellango Jothimurugesan
 *
 */
public class ServerGUIFactory{
    private static final Font DEFAULT_FONT = new Font("Century Gothic", Font.PLAIN,18);
    private static final Font DEFAULT_TEAM_FONT = new Font("Century Gothic", Font.PLAIN,14);
    private Font myFont = DEFAULT_FONT;
    private static ServerGUIFactory instance;
    
    /**
     * dulcao do cana?
     * private constructor of this class
     */
    private ServerGUIFactory(){
    }
    
    /**
     * 
     * @return instance of this class
     */
    public static ServerGUIFactory getInstance(){
        if (instance == null) {
            instance = new ServerGUIFactory();
        }
        return instance;
    }
    
    /**
     * 
     * @param message host description for this host
     * @return Panel containing host information
     */
    public JPanel createJoinPanel(HostDescriptionMessage message){
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10,10));
        
        JPanel generalInfo = new JPanel();
        generalInfo.setLayout(new GridLayout(2,1,0,20));
        generalInfo.setOpaque(false);
        
        Image scaled = ImageHelper.getScaledImage(message.getImagePath(), 150);

        JLabel mapLabel = makeLabel(message.getMapDescription());
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
        description.add(makeLabel(message.getServerName()));
        description.add(makeLabel(message.getHostName()));
        description.add(makeLabel(message.getMaxPlayers()+""));
        
        mainPanel.add(generalInfo, BorderLayout.WEST);
        mainPanel.setOpaque(false);
        return mainPanel;
    }
    
    /**
     * 
     * @param desc description of the label
     * @return a label set with this factory's font
     */
    private JLabel makeLabel(String desc) {
        JLabel label = new JLabel(desc);
        label.setFont(myFont);
        return label;
    }
    
    /**
     * 
     * @param desc description of the label
     * @param font to be used on the label
     * @return a label set with this factory's font
     */
    private JLabel makeLabel(String desc, Font font) {
        JLabel label = new JLabel(desc);
        label.setFont(font);
        return label;
    }
    
    /**
     * Sets the font for this factory's labels
     * @param font the font to be used
     */
    public void setFont(Font font){
        myFont = font;
    }
    
    /**
     * 
     * @return panel with team player names
     */
    public JPanel createTeamPanel(TeamDescriptionMessage message){
        JPanel teamPanel = new JPanel();
        int index = 1;
        String[][] teams = message.getAllTeams();
        teamPanel.setLayout(new GridLayout(0,2));
         
        for(int i = 0 ; i < teams.length ; i++){
            JPanel names = new JPanel();
            names.setOpaque(false);
            names.setLayout(new BoxLayout(names,BoxLayout.PAGE_AXIS));
            
            names.add(makeLabel("Team "+index));
            names.add(Box.createVerticalGlue());
 
            for (int j = 0 ; j < teams[i].length; j++) {
                names.add(makeLabel(teams[i][j],DEFAULT_TEAM_FONT));
            }
            names.add(Box.createVerticalGlue());
            teamPanel.add(names);
            index ++;
        }
        teamPanel.setOpaque(false);
        teamPanel.setBorder(BorderFactory.createTitledBorder
                            (BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Teams"));
        return teamPanel;
    }
}
