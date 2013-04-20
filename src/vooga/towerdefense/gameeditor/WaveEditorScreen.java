package vooga.towerdefense.gameeditor;

import java.awt.Dimension;

/**
 * WaceEditorScreen is responsible for helping
 *      the game developer make waves.
 *
 * @author Angelica Schwartz
 */
public class WaveEditorScreen extends GameEditorScreen {

    /**
     * default serialized id.
     */
    private static final long serialVersionUID = 1L;
    /**
     * next screen constant.
     */
    private static final String NEXT_SCREEN_NAME = "LevelEditorScreen";
    /**
     * title constant.
     */
    private static final String TITLE_NAME = "WAVE ";
    
    /**
     * Constructor.
     * @param size
     * @param controller
     */
    public WaveEditorScreen(Dimension size, GameEditorController controller) {
        super(size, controller, TITLE_NAME, NEXT_SCREEN_NAME);
    }

    /**
     * adds this level to the game.
     */
    @Override
    public void addElementToGame () {
        // TODO Auto-generated method stub
        getController().addWaveToGame();
    }
}
