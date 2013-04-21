package arcade.view.forms.payment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import javax.swing.JComponent;
import javax.swing.JFrame;
import arcade.games.GameInfo;
import arcade.model.Model;
import arcade.view.TextKeywords;
import arcade.view.forms.Form;


/**
 * The view where a user can enter his/her payment information to buy a game.
 * 
 * Different types of payment systems should subclass this view to tailor 
 * which fields they need.
 * 
 * @author Ellango
 * 
 */
@SuppressWarnings("serial")
public abstract class PaymentView extends Form {
    private GameInfo myGameInfo;

    /**
     * Constructs the PaymentView with a Model, ResourceBundle, and a GameInfo
     * for the game to be bought.
     * 
     * @param model
     * @param resources
     * @param info
     */
    public PaymentView (Model model, ResourceBundle resources, GameInfo game) {
        super(model, resources);
        myGameInfo = game;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    /**
     * Creates the button to perform the transaction
     * 
     * @return
     */
    protected JComponent createBuyButton () {
        return createButton(TextKeywords.BUY,
                            new ActionListener() {
                                @Override
                                public void actionPerformed (ActionEvent e) {
                                    performTransaction();
                                }
                            });
    }

    /**
     * Submits the required payment information fields to be processed.
     */
    protected abstract void performTransaction ();
    
    /**
     * Access to GameInfo for subclasses.
     * @return
     */
    protected GameInfo getGame() {
        return myGameInfo;
    }


}
