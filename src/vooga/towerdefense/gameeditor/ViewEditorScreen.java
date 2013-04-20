package vooga.towerdefense.gameeditor;

import java.awt.Dimension;

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
    private static final String NEXT_SCREEN_NAME = "ProjectileEditorScreen";
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
        System.out.println("made view screen");
    }

    /**
     * adds this level to the game.
     */
    @Override
    public void addElementToGame () {
        // TODO Auto-generated method stub
        getController().addViewToGame();
    }
}
