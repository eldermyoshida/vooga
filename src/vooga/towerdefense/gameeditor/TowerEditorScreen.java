package vooga.towerdefense.gameeditor;

import java.awt.Dimension;

/**
 * TowerEditorScreen is responsible for helping
 *      the game developer make towers.
 *
 * @author Angelica Schwartz
 */
public class TowerEditorScreen extends GameEditorScreen {

    /**
     * default serialized id.
     */
    private static final long serialVersionUID = 1L;
    /**
     * next screen constant.
     */
    private static final String NEXT_SCREEN_NAME = "vooga.towerdefense.gameeditor.UnitEditorScreen";
    /**
     * title constant.
     */
    private static final String TITLE_NAME = "TOWER ";
    
    /**
     * Constructor.
     * @param size
     * @param controller
     */
    public TowerEditorScreen(Dimension size, GameEditorController controller) {
        super(size, controller, TITLE_NAME, NEXT_SCREEN_NAME);
    }

    /**
     * adds this level to the game.
     */
    @Override
    public void addElementToGame () {
        // TODO Auto-generated method stub
        getController().addTowerToGame();
    }
}
