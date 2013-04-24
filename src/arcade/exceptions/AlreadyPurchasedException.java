package arcade.exceptions;

import arcade.view.TextKeywords;

/**
 * This exception is thrown when a user tries to purchase a game that is already
 * in his/her game center.
 * 
 * @author Ellango
 *
 */
@SuppressWarnings("serial")
public class AlreadyPurchasedException extends Exception {
    @Override
    public String getLocalizedMessage () {
        return TextKeywords.ALREADY_PURCHASED;
    }
}
