package vooga.scroller.model;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import javax.swing.JFrame;
import arcade.games.ArcadeInteraction;
import arcade.games.Game;
import arcade.games.GameData;
import arcade.games.UserGameData;
import util.Location;
import vooga.scroller.scrollingmanager.OmniScrollingManager;
import vooga.scroller.scrollingmanager.ScrollingManager;
import vooga.scroller.scrollingmanager.UniScrollingManager;
import vooga.scroller.sprites.superclasses.Player;
import vooga.scroller.sprites.test_sprites.mario.Mario;
import vooga.scroller.util.Direction;
import vooga.scroller.util.PlatformerConstants;
import vooga.scroller.view.GameView;


/**
 * A sample scroller game. By implementing the methods required by ScrollerGame,
 * the designer defines the components of the game. Most important, is the get LevelFileNames
 * method.
 */
public class ScrollerDemo extends ScrollerGame {
    // constants
    public static final String TITLE = "Scroller Demo";

    public ScrollerDemo (ArcadeInteraction arcade) {
        super(arcade);
    }

    /**
     * main --- where the program starts
     * 
     * @param args
     */
    public static void main (String args[]) {
        // view of user's content
        ScrollerGame test = new ScrollerDemo(null);
        test.run();
    }

    @Override
    protected String[] setLevelFileNames () {
        String[] levelsFiles = { "verySimpleLevel.level", "new.level" };
        return levelsFiles;
    }

    @Override
    protected String setTitle () {
        return TITLE;
    }

    @Override
    protected Player setPlayer () {
        return new Mario(new Location(), new Dimension(32, 32), getDisplay(), getScrollingManager());
    }

    @Override
    protected ScrollingManager setScrollingManager () {
        return new OmniScrollingManager();
    }

    @Override
    public UserGameData generateNewProfile () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public GameData generateNewGameProfile () {
        // TODO Auto-generated method stub
        return null;
    }
}
