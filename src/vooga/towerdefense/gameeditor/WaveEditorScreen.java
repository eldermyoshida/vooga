package vooga.towerdefense.gameeditor;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;
import javax.swing.JComboBox;


/**
 * WaceEditorScreen is responsible for helping
 * the game developer make waves.
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
     * path for the wave factories.
     */
    private static final String WAVE_PACKAGE_PATH = "vooga.towerdefense.factories.waveactionfactories";
    /**
     * constant for the action selector button.
     */
    private static final String ACTION_ADD_BUTTON_TEXT = "Add action";
    /**
     * constant for follow up action button. 
     */
    private static final String FOLLOW_UP_ACTION_TEXT = "Add follow up action";
    /**
     * constant for the action delete button.
     */
    private static final String ACTION_DELETE_BUTTON_TEXT = "Clear selected action";
    /**
     * drop down box for possible wave actions.
     */
    private JComboBox myAvailableWaveActions;
    /**
     * unit catalog for this screen.
     */
    private Catalog myUnitCatalog;

    /**
     * Constructor.
     * 
     * @param size
     * @param controller
     */
    public WaveEditorScreen (Dimension size, GameEditorController controller) {
        super(size, controller, TITLE_NAME, NEXT_SCREEN_NAME);
        myUnitCatalog = new Catalog(new Dimension(300, 300),
                                    getController().getIconsForUnits());
        add(myUnitCatalog);
        try {
            populateDropDownBox();
            add(myAvailableWaveActions);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * gets the available wave actions and populates the box.
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private void populateDropDownBox() throws IOException, ClassNotFoundException {
        myAvailableWaveActions = new JComboBox();
        List<String> waveActions = getController().getAvailableActions(WAVE_PACKAGE_PATH);
        for (String action: waveActions) {
            myAvailableWaveActions.addItem(action);
        }
    }

    /**
     * adds this level to the game.
     */
    @Override
    public void addElementToGame () {
        // TODO Auto-generated method stub
        getController().addWaveToGame();
    }

    /**
     * adds additional mouse behavior specific
     * to the WaveEditorScreen.
     */
    @Override
    public void addAdditionalMouseBehavior (MouseEvent e) {
        // TODO Auto-generated method stub

    }
}
