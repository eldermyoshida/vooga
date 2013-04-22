
package arcade.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import arcade.view.modes.ArcadeMode;

/**
 * 
 * @author David Liu
 *
 */
public class ButtonPanel extends JPanel {
    /**
     * Constants.
     */
    private static final long serialVersionUID = 7307619822247104115L;
    private static final int WINDOW_HEIGHT = 600;
    private static final int BUTTON_WIDTH = 150;
    private static final int BUTTON_HEIGHT = 150;
    private static final int ORIGIN = 0;

    /**
         * 
         */
    private MainView myUpperLevelPanel;

    /**
     * Constructor
     */
    public ButtonPanel (MainView upperLevel) {
        myUpperLevelPanel = upperLevel;
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBackground(Color.lightGray);
        // Buttons
        String localDirectory = System.getProperty("user.dir");
        ImageIcon gameCenterIcon = new ImageIcon(localDirectory+"/src/arcade/resources/images/GameCenterIcon.jpg");
        ImageIcon socialCenterIcon = new ImageIcon(localDirectory+"/src/arcade/resources/images/SocialCenterIcon.jpg");
        ImageIcon storeIcon = new ImageIcon(localDirectory+"/src/arcade/resources/images/StoreIcon.jpg");
        
        JButton gameCenterButton = new JButton(gameCenterIcon);
        JButton socialCenterButton = new JButton(socialCenterIcon);
        JButton storeButton = new JButton(storeIcon);
        
        gameCenterButton.setBounds(ORIGIN, ORIGIN, BUTTON_WIDTH+20, BUTTON_HEIGHT);
        socialCenterButton.setBounds(ORIGIN, WINDOW_HEIGHT / 2 - BUTTON_HEIGHT / 2, BUTTON_WIDTH+20,
                                     BUTTON_HEIGHT);
        storeButton.setBounds(ORIGIN, WINDOW_HEIGHT - BUTTON_HEIGHT, BUTTON_WIDTH+20, BUTTON_HEIGHT);
        
        JLabel gameCenterLabel = new JLabel("<html><b><font size = 5><font face = champion>Game Center");
        JLabel socialCenterLabel = new JLabel("<html><b><font size = 5><font face = champion>Social Center");
        JLabel storeLabel = new JLabel("<html><b><font size = 5><font face = champion>Game Store");
        
        
        add(gameCenterButton);
        add(gameCenterLabel);
        add(socialCenterButton);
        add(socialCenterLabel);
        add(storeButton);
        add(storeLabel);

        // Set-up Action Listener
        gameCenterButton.addActionListener(actionListenerConstructor(ArcadeMode.GAMECENTER));
        socialCenterButton.addActionListener(actionListenerConstructor(ArcadeMode.SOCIALCENTER));
        storeButton.addActionListener(actionListenerConstructor(ArcadeMode.STORE));
    }

    private ActionListener actionListenerConstructor (final ArcadeMode mode) {
        ActionListener output = new ActionListener() {

            @Override
            public void actionPerformed (ActionEvent e) {
                myUpperLevelPanel.changeViewPanel(mode);
            }
        };
        return output;
    }
}

