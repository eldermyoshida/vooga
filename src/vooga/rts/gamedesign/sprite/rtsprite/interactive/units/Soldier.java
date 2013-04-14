package vooga.rts.gamedesign.sprite.rtsprite.interactive.units;

import java.awt.Dimension;

import vooga.rts.gamedesign.upgrades.UpgradeTree;
import vooga.rts.util.Location;
import vooga.rts.util.Pixmap;
import vooga.rts.util.Sound;


/**
 * 
 * @author Ryan Fishel
 * @author Kevin Oh
 * @author Francesco Agosti
 * @author Wenshun Liu
 * 
 */
public class Soldier extends Unit {
    /**
     * for this implementation of visit where the soldier visits a IOccupiable,
     * the soldier occupies the IOccupiable RTSprite.
     * Code: would call myOccupyStrategy.occupy(RTSprite);
     */
    public Soldier(Pixmap image, Location center, Dimension size, Sound sound, int teamID, int health) {
        super(image, center, size, sound, teamID, health);
    }
    
    public void upgradeHealth (int armor) { // TESTING PURPOSE
        setHealth(getHealth() + armor);
    }

}
