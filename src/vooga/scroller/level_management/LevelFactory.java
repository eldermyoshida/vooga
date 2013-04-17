package vooga.scroller.level_management;

import java.awt.Dimension;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import util.Location;
import vooga.scroller.level_editor.LEGrid;
import vooga.scroller.level_editor.Level;
import vooga.scroller.level_editor.LevelParser;
import vooga.scroller.level_editor.ToolsManager;
import vooga.scroller.scrollingmanager.ScrollingManager;
import vooga.scroller.sprites.test_sprites.MarioLib;
import vooga.scroller.sprites.test_sprites.MarioLib.MovingPlatformOne;
import vooga.scroller.util.Pixmap;
import vooga.scroller.util.PlatformerConstants;
import vooga.scroller.view.View;


/**
 * Instantiates all of the levels for gameplay.
 * 
 * @author Scott Valentine
 * 
 */
public class LevelFactory {

    private LevelManager myLevelManager;
    private LevelParser myLevelReader;
    private ScrollingManager mySM;
    private View myView;

    public LevelFactory (LevelManager lm, ScrollingManager sm, View view) {
        myLevelManager = lm;
        myLevelReader = new LevelParser();
        mySM = sm;
        myView = view;
    }
    
    private Level buildLevel(int id, LEGrid grid) {
        Level result = new Level(id, mySM, myView, grid);
        return result;
    }

    /**
     * Generates levels to be displayed by the view and played by the model.
     * 
     * @param view is the view used for level information.
     * @return a List of all levels that will be played in the game.
     */
    public Map<Integer, Level> generateLevels () {
        
        SplashPage splash = new SplashPage(new Pixmap("MARIO SPLASH.png"),0,myView, mySM);
        // TODO: fix this
        splash.addManager(myLevelManager);

        //TODO needs to be refactored. Design needs to be improved
//        Level level1 = hardcodeLevel1(view, mySM, 1);
        // TODO: this will ideally read in levels from file and create instances of each level
        // This works for demo
        Level level1 = buildLevel(1, loadGridFromFile("createdLevelupg.level"));
        
        
        Level level2 = new Level(2, mySM, myView);
        for(int i = 0; i < 20; ++ i){
            level2.addSprite(new MarioLib.Platform(
                                                        new Location(50*i, 160)
                    ));
        }

     // adding levelportal --> acts as portal between levels.
        StartPoint level2Start = new StaticStartPoint(
                                     level2, new Location(100, 140));

        LevelPortal level1End = new LevelPortal(
                                new Pixmap("portal.png"), new Location(1540, 75),
                                new Dimension(50, 50), level2Start, myLevelManager);

        StartPoint finalSplashStart = new StaticStartPoint(
                                          splash, new Location(100, 140));

        LevelPortal level2End = new LevelPortal(
                              new Pixmap("portal.png"), new Location(1000, 140),
                              new Dimension(50, 50), finalSplashStart, myLevelManager);
        
        level1.addSprite(level1End);
        level2.addSprite(level2End);

        Map<Integer, Level> l = new HashMap<Integer, Level>();
        l.put(level1.getID(), level1);
        l.put(level2.getID(), level2);
        l.put(splash.getID(), splash);
        return l;
    }

    private LEGrid loadGridFromFile (String filename) {
        String pre = "src/vooga/scroller/level_management/";
        File f = (new File(pre+filename)).getAbsoluteFile();
        LEGrid result = myLevelReader.makeGridFromFile(f);
        return result;
    }

    private Level hardcodeLevel1 (View view, ScrollingManager sm, int id) {
        Level myCurrLevel = new Level(id, sm, view);
        myCurrLevel.addSprite(new MarioLib.Coin(
                                                new Location(view.getWidth() - 400, view
                                                        .getHeight() - 250)
                ));

        myCurrLevel.addSprite(new MarioLib.Coin(
                                                new Location(view.getWidth() - 400, view
                                                        .getHeight() - 350)
                ));

        myCurrLevel.addSprite(new MarioLib.Koopa(
                                                 new Location(view.getWidth() - 300, view
                                                         .getHeight() - 275)
                ));

        myCurrLevel.addSprite(new MarioLib.Koopa(
                                                 new Location(view.getWidth() - 200, view
                                                         .getHeight() - 350)
                ));

        myCurrLevel.addSprite(new MarioLib.Platform(
                                                    new Location(500, 600)
                ));
        myCurrLevel.addSprite(new MarioLib.Platform(
                                                    new Location(700, 600)
                ));

        // myCurrLevel.addSprite(new MarioLib.Platform(
        // new Location(900, 500)
        // ));
        myCurrLevel.addSprite(new MarioLib.Platform(
                                                    new Location(1100, 500)
                ));

        myCurrLevel.addSprite(new MarioLib.Platform(
                                                    new Location(1300, 400)
                ));
        myCurrLevel.addSprite(new MarioLib.Platform(
                                                    new Location(1500, 400)
                ));

        myCurrLevel.addSprite(new MarioLib.Plant(
                                                 new Location(500, 400)
                ));

        myCurrLevel.addSprite(new MarioLib.MovingPlatformTwo(
                                                             new Location(900, 500)
                ));
        myCurrLevel.setBackground(new ImageIcon(getClass()
                .getResource("/vooga/scroller/images/background_small.png")).getImage());

        myCurrLevel.addSprite(new MarioLib.LevelTwoBlockOne(
                                                            new Location(64, 252)
                ));

        for (int i = 0; i < 32; ++i) {
            myCurrLevel.addSprite(new MarioLib.Coin(new Location(i * 50, 75)));
        }

        myCurrLevel.addSprite(new MarioLib.LevelTwoBlockTwo(
                                                            new Location(272, 220)
                ));
        myCurrLevel.addSprite(new MarioLib.LevelTwoBlockTwo(
                                                            new Location(464, 220)
                ));
        myCurrLevel.addSprite(new MarioLib.LevelTwoBlockTwo(
                                                            new Location(656, 220)
                ));

        myCurrLevel.addSprite(new MarioLib.LevelTwoBlockThree(
                                                              new Location(1216, 204)
                ));
        return myCurrLevel;
    }

}
