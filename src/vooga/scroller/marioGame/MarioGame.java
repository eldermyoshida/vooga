
package vooga.scroller.marioGame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import javax.swing.JFrame;
import arcade.games.ArcadeInteraction;
import arcade.games.Game;
import arcade.games.GameData;
import arcade.games.UserGameData;
import util.Location;
import vooga.scroller.marioGame.spritesDefinitions.players.Mario;
import vooga.scroller.model.ScrollerGame;
import vooga.scroller.scrollingmanager.OmniScrollingManager;
import vooga.scroller.scrollingmanager.ScrollingManager;
import vooga.scroller.sprites.superclasses.Player;
import vooga.scroller.view.GameView;


/**
 * A sample scroller game. By implementing the methods required by ScrollerGame,
 * the designer defines the components of the game. Most important, is the get LevelFileNames method.
 */
public class MarioGame extends ScrollerGame
{


    // constants
    public static final String TITLE = "Mario Demo";
    public static final String LEVELS_DIR = "src/vooga/scroller/marioGame/sampleLevels/";


    /**
     * main --- where the program starts
     * @param args
     */
    public static void main (String args[]) {
        // view of user's content
        ScrollerGame test = new MarioGame();
        test.start();
    }



    @Override
    protected String[] setLevelFileNames () {
        String[] levelsFiles = {"verySimpleLevel.level", "new.level"};
        return levelsFiles;
    }



    @Override
    protected String setTitle () {
        return TITLE;
    }



    @Override
    protected ScrollingManager setScrollingManager () {
        return new OmniScrollingManager();
    }



    @Override
    protected Player setPlayer (ScrollingManager sm, GameView gameView) {
        return new Mario(new Location(), new Dimension(32, 32), gameView, sm);
    }



    @Override
    protected String setLevelsDirPath () {
        return LEVELS_DIR;
    }
}
