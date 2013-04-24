package vooga.scroller.level_management;

import java.awt.Dimension;
import java.awt.Image;
import util.Location;
import vooga.scroller.util.ISpriteView;
import vooga.scroller.util.Pixmap;
import vooga.scroller.util.Sprite;


public abstract class LevelPortal extends Sprite {

    private static final String DEFAULT_FILENAME = "portal.png";
    private static final String DEFAULT_PATH = "/vooga/scroller/images/";
    private static final Dimension DEFAULT_SIZE = new Dimension(50, 50);
    private static final Location DEFAULT_LOCATION = new Location(0, 0);

    private static final Pixmap DEFAULT_IMG = new Pixmap(DEFAULT_PATH, DEFAULT_FILENAME);

    public LevelPortal () {
        this(DEFAULT_LOCATION);
        setView(initView());
        setSize(initSize().width, initSize().height);
    }

    public LevelPortal (Location center) {
        super(DEFAULT_IMG, center, DEFAULT_SIZE);
    }

    @Override
    public Image getDefaultImg () {
        return initView().getImage();
    }

    public abstract ISpriteView initView ();

    public abstract Dimension initSize ();

}
