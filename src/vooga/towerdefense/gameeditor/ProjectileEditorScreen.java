package vooga.towerdefense.gameeditor;

import java.awt.Dimension;

/**
 * ProjectileEditorScreen is responsible for helping
 *      the game developer make projectiles.
 *
 * @author Angelica Schwartz
 */
public class ProjectileEditorScreen extends GameEditorScreen {

    /**
     * default serialized id.
     */
    private static final long serialVersionUID = 1L;
    /**
     * next screen constant.
     */
    private static final String NEXT_SCREEN_NAME = "TowerEditorScreen";
    /**
     * title constant.
     */
    private static final String TITLE_NAME = "PROJECTILE ";
    
    /**
     * Constructor.
     * @param size
     * @param controller
     */
    public ProjectileEditorScreen(Dimension size, GameEditorController controller) {
        super(size, controller, TITLE_NAME, NEXT_SCREEN_NAME);
    }

    /**
     * adds this level to the game.
     */
    @Override
    public void addElementToGame () {
        // TODO Auto-generated method stub
        getController().addProjectileToGame();
    }
}
