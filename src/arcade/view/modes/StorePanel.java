package arcade.view.modes;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import arcade.model.Model;
import arcade.view.AllSnapShots;
import arcade.view.TextKeywords;
import arcade.view.forms.PublishView;

/**
 * The StorePanel is where SnapShots can be viewed for all games available
 * in the Game Store.  There is also the option to publish a new game here.
 * 
 * 
 * @author Ellango
 *
 */
@SuppressWarnings("serial")
public class StorePanel extends JPanel {
    private static final int PANEL_WIDTH = 590;
    private static final int PANEL_HEIGHT = 510;
    
    private Model myModel;
    private ResourceBundle myResources;
    
    /**
     * Creates a StorePanel with a Model and ResourceBundle.
     * 
     * @param model
     * @param resources
     */
    public StorePanel (Model model, ResourceBundle resources) {
        myModel = model;
        myResources = resources;
        
        setBackground(Color.WHITE);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        add(createSnapShots());
        add(createPublishButton());
    }

    /**
     * The SnapShots that can be clicked to buy games.
     * 
     * @return
     */
    private Component createSnapShots () {
        AllSnapShots allSnapShots = new AllSnapShots(myModel, 
                                                     myResources, 
                                                     new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        return new JScrollPane(allSnapShots);
    }

    /**
     * Create a button to publish a new game.
     * @return
     */
    private Component createPublishButton () {
        // button contained in a panel so BoxLayout behaves.
        JPanel panel = new JPanel();
        JButton button = new JButton(myResources.getString(TextKeywords.PUBLISH_BUTTON));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent arg0) {
                new PublishView(myModel, myResources);
            }
        });
        panel.add(button);
        return panel;
    }
}
