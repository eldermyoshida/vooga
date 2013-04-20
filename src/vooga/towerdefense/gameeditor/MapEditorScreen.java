package vooga.towerdefense.gameeditor;

import java.awt.Dimension;

/**
 * MapEditorScreen is responsible for helping
 *      the game developer make maps.
 *
 * @author Angelica Schwartz
 */
public class MapEditorScreen extends GameEditorScreen {

    private static final long serialVersionUID = 1L;
    /**
     * next screen constant.
     */
    private static final String NEXT_SCREEN_NAME = "ViewEditorScreen";
    /**
     * title constant.
     */
    private static final String TITLE_NAME = "MAP ";
    
    /**
     * Constructor.
     * @param size
     * @param controller
     */
    public MapEditorScreen(Dimension size, GameEditorController controller) {
        super(size, controller, TITLE_NAME, NEXT_SCREEN_NAME);
    }

    /**
     * adds this level to the game.
     */
    @Override
    public void addElementToGame () {
        // TODO Auto-generated method stub
        getController().addMapToGame();
    }
}
