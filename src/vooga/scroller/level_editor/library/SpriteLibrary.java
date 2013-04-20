package vooga.scroller.level_editor.library;

import java.awt.Image;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import vooga.scroller.util.Sprite;


public class SpriteLibrary implements CreatableLib, ReadableLib {

    private Map<Integer, Sprite> mySprites;
    private Map<Integer, Image> myBackgrounds;

    public SpriteLibrary () {
        mySprites = new HashMap<Integer, Sprite>();
        myBackgrounds = new HashMap<Integer, Image>();
    }

    @Override
    public Sprite getSprite (int key) {
        return mySprites.get(key);
    }

    @Override
    public Image getBackground (int key) {
        return myBackgrounds.get(key);
    }

    @Override
    public void add (Sprite s) {
        mySprites.put(mySprites.size(), s);
    }

    @Override
    public void add (Image b) {
        myBackgrounds.put(myBackgrounds.size(), b);
    }

    @Override
    public <E> void addAll (Collection<E> sprites) {
        //TODO
    }
}
