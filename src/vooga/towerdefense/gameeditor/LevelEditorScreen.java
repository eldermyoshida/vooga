package vooga.towerdefense.gameeditor;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;
import javax.swing.JComboBox;


/**
 * LevelEditorScreen is responsible for helping
 * the game developer make levels.
 * 
 * @author Angelica Schwartz
 */
public class LevelEditorScreen extends ElementWithActionEditorScreen {

    /**
     * default serialized id.
     */
    private static final long serialVersionUID = 1L;
    /**
     * next screen constant.
     */
    private static final String NEXT_SCREEN_NAME = "FinishScreen";
    /**
     * package for the wave action factories.
     */
    private static final String WAVE_ACTION_PACKAGE_PATH = "vooga.towerdefense.factories.waveactionfactories";
    /**
     * package for the rules.
     */
    private static final String RULE_PACKAGE_PATH = "vooga.towerdefense.model.rules";
    /**
     * title constant.
     */
    private static final String TITLE_NAME = "LEVEL ";
    /**
     * the box that displays the available units.
     */
    private JComboBox myAvailableUnits;

    /**
     * Constructor.
     * 
     * @param size
     * @param controller
     * @throws ClassNotFoundException 
     * @throws IOException 
     */
    public LevelEditorScreen (Dimension size, GameEditorController controller) throws ClassNotFoundException, IOException {
        super(size, controller, TITLE_NAME, NEXT_SCREEN_NAME);
        setActionPath(WAVE_ACTION_PACKAGE_PATH);
        makeAttributesSection(getRules());
        makeActionsSection(WAVE_ACTION_PACKAGE_PATH);
        populateUnits();
    }
    
    /**
     * helper method that gets the rules available for this game.
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private List<String> getRules() throws IOException, ClassNotFoundException {
        return getController().getClassNamesInPackage(RULE_PACKAGE_PATH);
    }
    
    /**
     * helper method to get ths units created.
     */
    private void populateUnits() {
        List<String> units = getController().getUnits();
        for (String unit : units) {
            myAvailableUnits.addItem(unit);
        }
        add(myAvailableUnits);
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
