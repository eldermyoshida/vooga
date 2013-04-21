package arcade.view.forms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import arcade.games.GameInfo;
import arcade.model.Model;
import arcade.view.TextKeywords;


/**
 * The view where a user can enter his/her payment information to buy a game.
 * 
 * @author Ellango
 * 
 */
@SuppressWarnings("serial")
public class PaymentView extends Form {
    private GameInfo myGameInfo;

    /**
     * Constructs the PaymentView with a Model, ResourceBundle, and a GameInfo
     * for the game to be bought.
     * 
     * @param model
     * @param resources
     * @param info
     */
    public PaymentView (Model model, ResourceBundle resources, GameInfo info) {
        super(model, resources);
        myGameInfo = info;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    @Override
    protected List<JComponent> makeComponents () {
        List<JComponent> components = new ArrayList<JComponent>();

        return components;
    }
    
    private JComponent createBuyButton() {
        JPanel panel = new JPanel();
        JButton publish = new JButton(getResources().getString(TextKeywords.BUY));
        publish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent arg0) {
                System.out.println("here");
                //getModel().performTransaction();
                dispose();
            }
        });
        panel.add(publish);
        return panel;
    }

    public static void main (String[] args) {
        new PaymentView(null, ResourceBundle.getBundle("arcade.resources.English"), null);
    }

}
