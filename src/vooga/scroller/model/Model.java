
package vooga.scroller.model;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import vooga.scroller.sprite_superclasses.Player;
import vooga.scroller.sprites.Test_S_One;
import vooga.scroller.test_sprites.Coin;
import vooga.scroller.test_sprites.Koopa;
import vooga.scroller.test_sprites.Mario;
import vooga.scroller.test_sprites.Platform;
import vooga.scroller.test_sprites.Turtle;
import vooga.scroller.util.Location;
import vooga.scroller.util.Pixmap;
import vooga.scroller.util.PlatformerConstants;
import vooga.scroller.util.Sprite;
import vooga.scroller.view.View;
import vooga.scroller.collision_handlers.CollisionManager;
import vooga.scroller.level_editor.Level;
import vooga.scroller.scrollingmanager.ScrollingManager;


/**
 * Represents a scrolling platformer.
 * *
 * 
 * @author Ross Cahoon
 * @author Jay Wang
 */
public class Model {
    // private List<Level> myLevels;
    private Level myCurrLevel;
    private View myView;
    private List<Sprite> spriteList;

    /**
     * Create a game of the given size with the given display for its shapes.
     */
    public Model (View view, ScrollingManager sm) {
        setSpriteList(new ArrayList<Sprite>());

        myView = view;
        // ONLY USED FOR TESTING
        myCurrLevel = new Level(1, sm, view);
        myCurrLevel.setSize(PlatformerConstants.DEFAULT_LEVEL_SIZE);

        // spriteList.add(new Player(new Pixmap("brick9.gif"),
        // new Location(myView.getWidth() / 2, myView.getHeight() / 2),
        // new Dimension(25, 25),
        // myView));

        spriteList.add(new Test_S_One(new Pixmap("brick10.gif"),
                                      new Location(myView.getWidth() - 100,
                                                   myView.getHeight() - 100),
                                      new Dimension(25, 25)));

        spriteList.add(new Coin(new Pixmap("coin.gif"),
                                new Location(myView.getWidth() - 400, myView.getHeight() - 250),
                                new Dimension(30, 30)));

        spriteList.add(new Koopa(new Pixmap("koopa.gif"),
                                 new Location(myView.getWidth() - 300, myView.getHeight() - 275),
                                 new Dimension(30, 60)));

        spriteList.add(new Platform(new Pixmap("platform.gif"),
                                    new Location(myView.getWidth() - 80, myView.getHeight() - 150),
                                    new Dimension(110, 60)));

        spriteList.add(new Turtle(new Pixmap("turtle.gif"),
                                  new Location(myView.getWidth() - 500, myView.getHeight() - 75),
                                  new Dimension(30, 60)));

        spriteList.add(new Mario(new Pixmap("mario.gif"),
                                 new Location(myView.getWidth() / 2, myView.getHeight() / 2),
                                 new Dimension(30, 60),
                                 myView));

        for (Sprite sprite : spriteList) {
            if (sprite.getClass().equals(Mario.class)) {
                myCurrLevel.addPlayer((Player) sprite);
            }
            else {
                myCurrLevel.addSprite(sprite);
            }
        }

        // ONLY USED FOR TESTING
    }

    /**
     * Update game for this moment, given the time since the last moment.
     */
    public void update (double elapsedTime) {
        Dimension bounds = myView.getSize();
        intersectingSprites();
        myCurrLevel.update(elapsedTime, bounds, myView);
    }

    private void intersectingSprites () {
        Sprite obj1;
        Sprite obj2;
        CollisionManager CM = new CollisionManager(myView);

        for (int i = 0; i < spriteList.size(); i++) {
            for (int j = i + 1; j < spriteList.size(); j++) {     
                obj1 = spriteList.get(i);
                obj2 = spriteList.get(j);
                if (obj1.intersects(obj2)) {
                    CM.handleCollision(obj1, obj2);
                    CM.handleCollision(obj2, obj1);
                }

            }
        }
    }

    /**
     * Draw all elements of the game.
     */
    public void paint (Graphics2D pen) {
        myCurrLevel.paint(pen);
    }

    public double getRightBoundary () {
        return myCurrLevel.getRightBoundary();
    }

    public double getLeftBoundary () {
        return myCurrLevel.getLeftBoundary();
    }

    public double getUpperBoundary () {
        return myCurrLevel.getUpperBoundary();
    }

    public double getLowerBoundary () {
        return myCurrLevel.getLowerBoundary();
    }

    public Dimension getLevelBounds () {
        return myCurrLevel.getLevelBounds();
    }

    public List<Sprite> getSpriteList () {
        return spriteList;
    }

    public void setSpriteList (List<Sprite> spriteList) {
        this.spriteList = spriteList;
    }
}
