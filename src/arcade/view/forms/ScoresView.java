package arcade.view.forms;

import java.awt.Desktop;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.util.ResourceBundle;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import twitter4j.TwitterException;
import util.ImageHelper;
import arcade.controller.Controller;
import arcade.model.Model;
import arcade.view.TextKeywords;


/**
 * The view that shows up at the end of the game. Shows the user's score here,
 * high scores, and the option to tweet his/her score.
 * 
 * @author Ellango
 * 
 */
@SuppressWarnings({ "serial", "unused" })
public class ScoresView extends Form {
    private static final String IMAGES_DIRECTORY = System.getProperty("user.dir")
                                                   + "/src/arcade/resources/images/";
    private static final String BUTTON_IMAGE = "Twitter.gif";
    private static final int WINDOW_WIDTH = 250;
    private static final int WINDOW_HEIGHT = 220;

    private JPanel myPinPanel;
    private JTextField myPinTextField;
    private String myGame;
    private Double myScore;

    /**
     * Creates a ScoresView with a Controller and ResourceBundle
     * 
     * @param controller
     * @param resources
     */
    public ScoresView (Controller controller, ResourceBundle resources, String gameName, double score) {
        super(controller, resources);
        myGame = gameName;
        myScore = score;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    /**
     * Creates the button to start the tweet request.
     * 
     * @return
     */
    private JComponent createTweetButton () {
        JPanel panel = new JPanel();
        ImageIcon icon = new ImageIcon(IMAGES_DIRECTORY + BUTTON_IMAGE);
        final JButton button = new JButton(icon);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent arg0) {
                startTwitterRequest();
                button.setEnabled(false);
            }
        });
        panel.add(button);
        return panel;
    }
    
    /**
     * Starts the Twitter request.  Opens up a browser for the user to 
     * authorize the twitter request.  Sets the panel visible for the user
     * to enter the pin after they finish authorizing.
     */
    private void startTwitterRequest() {
        try {
            String urlToAuthorize = getController().setUpTwitterRequest();
            Desktop.getDesktop().browse(URI.create(urlToAuthorize));
            setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
            setLocationRelativeTo(null);
            myPinPanel.setVisible(true);
        }
        catch (TwitterException e) {
            sendMessage(getResources().getString(TextKeywords.TWITTER_ERROR));
        }
        catch (IOException e) {
            sendMessage(getResources().getString(TextKeywords.TWITTER_ERROR));
        }
    }

    /**
     * Creates the panel where the user can enter the pin for the twitter
     * authorization.
     * 
     * Initially set as invisible until startTwitterRequest() called.
     * @return
     */
    private JComponent createPinEntry () {
        myPinPanel = new JPanel();
        myPinPanel.setLayout(new BoxLayout(myPinPanel, BoxLayout.Y_AXIS));
        myPinTextField = new JTextField();
        JComponent textPane = createTextPanel(TextKeywords.PIN_INSTRUCTION, myPinTextField);
        textPane.setOpaque(false);
        myPinPanel.add(textPane);
        JComponent submitButton = createButton(TextKeywords.SUBMIT,
                                      new ActionListener() {
                                          @Override
                                          public void actionPerformed (ActionEvent e) {
                                              sendTweet();
                                          }
                                      });
        submitButton.setOpaque(false);
        myPinPanel.add(submitButton);
        myPinPanel.setVisible(false);
        return myPinPanel;
    }
    
    /**
     * After clicking the submit button for the pin, send the tweet
     * message for the game and score.
     */
    private void sendTweet() {
        String pin = myPinTextField.getText();
        try {
            getController().sendTweet(pin, generateTweetMessage());
        }
        catch (TwitterException e) {
            sendMessage(getResources().getString(TextKeywords.TWITTER_ERROR));
        }
    }
    
    /**
     * Returns the string to be tweeted.
     * @return
     */
    private String generateTweetMessage() {
        return getResources().getString(TextKeywords.MY_SCORE) 
               + " " + myScore + " " 
               + getResources().getString(TextKeywords.IN) + " " + myGame + " " 
               + getResources().getString(TextKeywords.VOOGA_HASHTAG);
    }

}
