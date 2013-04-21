package vooga.fighter.controller;
import java.awt.Dimension;
import java.util.List;
import java.util.ArrayList;
import java.util.Observable;
import util.Location;
import vooga.fighter.model.LevelMode;
import vooga.fighter.model.Mode;
import vooga.fighter.model.utils.Health;
import vooga.fighter.model.utils.ImageDataObject;
import vooga.fighter.util.HUDVariable;
import vooga.fighter.util.Paintable;
import util.*;


/**     
 * Contains all information required by the view about game objects in a game loop.
 * List indices line up between lists (i.e. index 0 of all lists is player 1 information,
 * index 1 is player 2 info)
 * @author matthewparides
 *
 */

public class ScoreInfo implements ViewDataSource{

    @Override
    public int ObjectNumber () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Paintable getPaintable (int index) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Location getLocation (int index) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Dimension getSize (int index) {
        // TODO Auto-generated method stub
        return null;
    }

  
}