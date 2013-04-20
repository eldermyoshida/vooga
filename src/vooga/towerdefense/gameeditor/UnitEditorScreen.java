package vooga.towerdefense.gameeditor;

import java.awt.Dimension;

/**
 * UnitEditorScreen is responsible for helping
 *      the game developer make units.
 *
 * @author Angelica Schwartz
 */
public class UnitEditorScreen extends GameEditorScreen {

    /**
     * default serialized id.
     */
    private static final long serialVersionUID = 1L;
    /**
     * next screen constant.
     */
    private static final String NEXT_SCREEN_NAME = "WaveEditorScreen";
    /**
     * title constant.
     */
    private static final String TITLE_NAME = "UNIT ";
    
    /**
     * Constructor.
     * @param size
     * @param controller
     */
    public UnitEditorScreen(Dimension size, GameEditorController controller) {
        super(size, controller, TITLE_NAME, NEXT_SCREEN_NAME);
    }

    /**
     * adds this level to the game.
     */
    @Override
    public void addElementToGame () {
        // TODO Auto-generated method stub
        getController().addUnitToGame();
    }
}
