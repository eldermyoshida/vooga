package vooga.rts.gamedesign.sprite.rtsprite.interactive.buildings;

import java.awt.Dimension;
import vooga.rts.gamedesign.sprite.InteractiveEntity;
import vooga.rts.gamedesign.sprite.rtsprite.interactive.IOccupiable;
import vooga.rts.util.Location;
import vooga.rts.util.Pixmap;
import vooga.rts.util.Sound;
import vooga.towerdefense.gameElements.Unit;


/**
 * This is an abstract class that represents a building. It will be extended
 * by specific types of buildings such as AttackTower.
 * 
 * @author Ryan Fishel
 * @author Kevin Oh
 * @author Francesco Agosti
 * @author Wenshun Liu
 * 
 */
public abstract class Building extends InteractiveEntity implements IOccupiable {
    public static final int MAXHEALTH = 100;

    // building is lonely :(
    public Building (Pixmap image,
                     Location center,
                     Dimension size,
                     Sound sound,
                     int playerID,
                     int health) {
        super(image, center, size, sound, playerID, MAXHEALTH);

    }

    public void getOccupied (Unit u) {
        //u.occupy(this);
    }
}
