package vooga.towerdefense.gameeditor;

import java.awt.Dimension;
import java.awt.event.MouseEvent;

/**
 * ViewEditorScreen is responsible for helping
 *      the game developer make the view.
 *
 * @author Angelica Schwartz
 */
public class ViewEditorScreen extends GameEditorScreen {

    /**
     * default serialized id.
     */
    private static final long serialVersionUID = 1L;
    /**
     * next screen constant.
     */
    private static final String NEXT_SCREEN_NAME = "MapEditorScreen";
    /**
     * title constant.
     */
    private static final String TITLE_NAME = "VIEW ";
    
    /**
     * Constructor.
     * @param size
     * @param controller
     */
    public ViewEditorScreen(Dimension size, GameEditorController controller) {
        super(size, controller, TITLE_NAME, NEXT_SCREEN_NAME);
    }

    /**
     * adds this level to the game.
     */
    @Override
    public void addElementToGame () {
        // TODO Auto-generated method stub
        // TODO: get rid of this magic number 
        getController().setMapSize(new Dimension (500, 600));
        getController().addViewToGame();
    }

    /**
     * adds additional mouse behavior specific
     *          to the ViewEditorScreen.
     * @param e is the MouseEvent
     */
    @Override
    public void addAdditionalMouseBehavior (MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
}
