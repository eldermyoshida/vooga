package arcade.view.modes;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import arcade.controller.Controller;
import arcade.view.TextKeywords;
import arcade.view.forms.PublishView;


@SuppressWarnings("serial")
public class StorePanel extends JPanel {
    private Controller myModel;
    private ResourceBundle myResources;
    
    public StorePanel (Controller model, ResourceBundle resources) {
        myModel = model;
        myResources = resources;
        
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.WHITE);
        //add(new GameCenterPanel(upperLevel, myModel, myResources));
        add(createPublishButton());
    }

    /**
     * Create a button to publish a new game.
     * @return
     */
    private Component createPublishButton () {
        JButton button = new JButton(myResources.getString(TextKeywords.PUBLISH_BUTTON));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent arg0) {
                new PublishView(myModel, myResources);
            }
        });
        return button;
    }
}
