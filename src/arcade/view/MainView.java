package arcade.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.util.Collection;
import java.util.ResourceBundle;
import javax.swing.JFrame;
import javax.swing.JPanel;
import arcade.games.GameInfo;
import arcade.model.Model;
import arcade.view.modes.ArcadeMode;
import arcade.view.modes.GameCenterPanel;
import arcade.view.modes.SocialCenterPanel;
import arcade.view.modes.StorePanel;


/**
 * The main view of the arcade. From here, buttons in its ButtonPanel can be clicked
 * to switch which mode is currently visible.
 * 
 * @author David Liu, Ellango Jothimurugesan
 * 
 */
@SuppressWarnings("serial")
public class MainView extends JFrame {
    private static final int BUTTON_WIDTH = 140;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 620;
    private JPanel myViewPanel;
    private Model myModel;
    private ResourceBundle myResources;

    /**
     * Creates the MainView with the provided Model and ResourceBundle
     * 
     * @param model
     * @param rb
     */
    public MainView (Model model, ResourceBundle rb) {
        myModel = model;
        myResources = rb;

        JPanel contentPane = (JPanel) getContentPane();
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(null);
        contentPane.add(makeButtonPanel());
        contentPane.add(makeViewPanel());

        setTitle(rb.getString(TextKeywords.TITLE));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Makes the panel of buttons that switch which mode is currently showing.
     * 
     * @return
     */
    private JPanel makeButtonPanel () {
        JPanel buttonPanel = new ButtonPanel(this);
        buttonPanel.setBounds(0, 0, BUTTON_WIDTH, WINDOW_HEIGHT);
        return buttonPanel;
    }

    /**
     * Makes the panel where the mode will be showing.
     */
    private JPanel makeViewPanel () {
        myViewPanel = new JPanel(new CardLayout());
        myViewPanel.setBounds(150, 0, 650, 600);
        
        myViewPanel.add(new GameCenterPanel(this, myModel, myResources), ArcadeMode.GAMECENTER.name());
        myViewPanel.add(new SocialCenterPanel(), ArcadeMode.SOCIALCENTER.name());
        myViewPanel.add(new StorePanel(myModel, myResources, this), ArcadeMode.STORE.name());
        
        changeViewPanel(ArcadeMode.GAMECENTER);
        return myViewPanel;
    }

    /**
     * Change which mode is currently showing in myViewPanel
     */
    public void changeViewPanel (ArcadeMode mode) {
        CardLayout cards = (CardLayout) (myViewPanel.getLayout());
        cards.show(myViewPanel, mode.name());
    }

    /**
     * Gets the list of games from the model.  This is here for access by 
     * other views who have an instance of this but not the model.
     * 
     * @return
     */
    public Collection<GameInfo> getGameList () {
        return myModel.getGameList();
    }

    /**
     * When a game is done being played, pop up a dialog box with their score,
     * high scores, and an option to share on social networks.
     * 
     */
    public void showEndGameView () {
        
    }

}
