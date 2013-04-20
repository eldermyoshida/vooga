package vooga.towerdefense.gameeditor;

import java.awt.Dimension;

public class ViewEditorScreen extends GameEditorScreen {

    /**
     * default serialized id.
     */
    private static final long serialVersionUID = 1L;
    private static final String NEXT_SCREEN_NAME = "vooga.towerdefense.gameeditor.ProjectileEditorScreen";
    private static final String TITLE_NAME = "VIEW ";
    
    public ViewEditorScreen(Dimension size, GameEditorController controller) {
        super(size, controller, TITLE_NAME, NEXT_SCREEN_NAME);
    }

    @Override
    public void addElementToGame () {
        // TODO Auto-generated method stub
        getController().addViewToGame();
    }
}
