package arcade.view.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import arcade.view.MainView;


public class ButtonPanel extends JPanel {
    /**
     * Constants.
     */
    private static final long serialVersionUID = 7307619822247104115L;
    private static final int WINDOW_HEIGHT = 600;
    private static final int BUTTON_WIDTH = 120;
    private static final int BUTTON_HEIGHT = 200;
    private static final int ORIGIN = 0;
    private static final int GAMECENTER_INDEX = 0;
    private static final int SOCIALCENTER_INDEX = 1;
    private static final int STORE_INDEX = 2;

    /**
         * 
         */
    private MainView myUpperLevelPanel;

    /**
     * Constructor
     */
    public ButtonPanel (MainView upperLevel) {
        myUpperLevelPanel = upperLevel;
        setLayout(null);
        // Buttons
        JButton gameCenterButton = new JButton("Game Center");
        JButton socialCenterButton = new JButton("Social Center");
        JButton storeButton = new JButton("Store");
        gameCenterButton.setBounds(ORIGIN, ORIGIN, BUTTON_WIDTH, BUTTON_HEIGHT);
        socialCenterButton.setBounds(ORIGIN, WINDOW_HEIGHT / 2 - BUTTON_HEIGHT / 2, BUTTON_WIDTH,
                                     BUTTON_HEIGHT);
        storeButton.setBounds(ORIGIN, WINDOW_HEIGHT - BUTTON_HEIGHT, BUTTON_WIDTH, BUTTON_HEIGHT);
        add(gameCenterButton);
        add(socialCenterButton);
        add(storeButton);

        // Set-up Action Listener
        gameCenterButton.addActionListener(actionListenerConstructor(GAMECENTER_INDEX));
        socialCenterButton.addActionListener(actionListenerConstructor(SOCIALCENTER_INDEX));
        storeButton.addActionListener(actionListenerConstructor(STORE_INDEX));
    }

    private ActionListener actionListenerConstructor (final int index) {
        ActionListener output = new ActionListener() {

            @Override
            public void actionPerformed (ActionEvent e) {
                myUpperLevelPanel.changeViewPanel(index);
                System.out.println("pushed " + index + " to MainView");
            }
        };
        return output;
    }
}
