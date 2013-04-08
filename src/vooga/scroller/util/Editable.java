
package vooga.scroller.util;



/**
 * Interface specifies an object that can be edited by the LevelEditor. Implemented by Level.
 * LevelEditor will only see those methods pertaining to editing the Level, not those necessary
 * to run the Level.
 * 
 * @author Danny Goodman
 * 
 */
public interface Editable {

    public void changeBackground ();

    public void addNewSprite (Sprite s);

    public void deleteSprite (Location deleteAtLocation);
}
