package vooga.towerdefense.gameeditor;

import java.awt.Dimension;

public class WaveEditorScreen extends GameEditorScreen {

    /**
     * default serialized id.
     */
    private static final long serialVersionUID = 1L;
    private static final String NEXT_SCREEN_NAME = "vooga.towerdefense.gameeditor.LevelEditorScreen";
    
    public WaveEditorScreen(Dimension size, GameEditorController controller) {
        super(size, controller, NEXT_SCREEN_NAME);
    }

    @Override
    public void addElementToGame () {
        // TODO Auto-generated method stub
        
    }
}
