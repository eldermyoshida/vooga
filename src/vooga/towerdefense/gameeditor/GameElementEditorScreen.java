package vooga.towerdefense.gameeditor;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.io.IOException;


/**
 * LevelEditorScreen is responsible for helping
 * the game developer make levels.
 * 
 * @author Angelica Schwartz
 */
public class GameElementEditorScreen extends ElementWithActionEditorScreen {

    /**
     * default serialized id.
     */
    private static final long serialVersionUID = 1L;
    /**
     * next screen constant.
     */
    private static final String NEXT_SCREEN_NAME = "LevelEditorScreen";
    /**
     * package for the wave action factories.
     */
    private static final String ACTION_PACKAGE_PATH = "vooga.towerdefense.factories.actionfactories";
    /**
     * package for the attributes.
     */
    private static final String ATTRIBUTE_CLASS_PATH = "vooga.towerdefense.attributes.AttributeConstants";
    /**
     * title constant.
     */
    private static final String TITLE_NAME = "LEVEL ";

    /**
     * Constructor.
     * 
     * @param size
     * @param controller
     * @throws ClassNotFoundException 
     * @throws IOException 
     */
    public GameElementEditorScreen (Dimension size, GameEditorController controller) throws ClassNotFoundException, IOException {
        super(size, controller, TITLE_NAME, NEXT_SCREEN_NAME);
        setActionPath(ACTION_PACKAGE_PATH);
        makeAttributesSection(ATTRIBUTE_CLASS_PATH);
        makeActionsSection(ACTION_PACKAGE_PATH);
        makeScreen();
    }

    /**
     * adds this level to the game.
     */
    public void addElementToGame () {
        // TODO Auto-generated method stub
        getController().addLevelToGame();
    }

    /**
     * adds additional mouse behavior specific
     * to the LevelEditorScreen.
     * 
     * @param e is the MouseEvent
     */
    @Override
    public void addAdditionalMouseBehavior (MouseEvent e) {
        // fill in with appropriate mouse behavior
    }
}
