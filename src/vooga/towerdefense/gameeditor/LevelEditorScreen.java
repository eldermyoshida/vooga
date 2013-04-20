package vooga.towerdefense.gameeditor;

import java.awt.Dimension;

/**
 * LevelEditorScreen is responsible for helping
 *      the game developer make levels.
 *
 * @author Angelica Schwartz
 */
public class LevelEditorScreen extends GameEditorScreen {

    /**
     * default serialized id.
     */
    private static final long serialVersionUID = 1L;
    /**
     * next screen constant.
     */
    private static final String NEXT_SCREEN_NAME = "vooga.towerdefense.gameeditor.FinishedScreen";
    /**
     * title constant.
     */
    private static final String TITLE_NAME = "LEVEL ";
    
    /**
     * Constructor.
     * @param size
     * @param controller
     */
    public LevelEditorScreen(Dimension size, GameEditorController controller) {
        super(size, controller, TITLE_NAME, NEXT_SCREEN_NAME);
    }

    /**
     * adds this level to the game.
     */
    @Override
    public void addElementToGame () {
        // TODO Auto-generated method stub
        getController().addLevelToGame();
    }
}
