package vooga.scroller.level_editor;

import java.util.Map;
import vooga.scroller.util.Sprite;


/**
 * This interface ensures that the object passed is intended indeed to be a Sprite
 * Library.
 * @author Dagbedji Fagnisse
 *
 */
public interface ISpriteLibrary {

    Class<? extends Sprite>[] getSpritesClasses();
    
}
