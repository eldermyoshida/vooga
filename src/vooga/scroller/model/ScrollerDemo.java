package vooga.scroller.model;
import java.awt.Dimension;
import util.Location;
import vooga.scroller.scrollingmanager.OmniScrollingManager;
import vooga.scroller.scrollingmanager.ScrollingManager;
import vooga.scroller.sprites.superclasses.Player;
import vooga.scroller.sprites.test_sprites.mario.Mario;
import vooga.scroller.view.GameView;


/**
 * A sample scroller game. By implementing the methods required by ScrollerGame,
 * the designer defines the components of the game. Most important, is the get LevelFileNames method.
 */
public class ScrollerDemo extends ScrollerGame
{


    // constants
    public static final String TITLE = "Scroller Demo";


    /**
     * main --- where the program starts
     * @param args
     */
    public static void main (String args[]) {
        // view of user's content
        ScrollerGame test = new ScrollerDemo();
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
}
