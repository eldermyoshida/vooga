package vooga.rts.gamedesign.sprite.rtsprite.interactive.units;

import java.util.List;
import java.awt.Dimension;
import java.awt.Graphics2D;
import vooga.rts.gamedesign.Action;
import vooga.rts.gamedesign.Weapon;
import vooga.rts.gamedesign.sprite.rtsprite.IAttackable;
import vooga.rts.gamedesign.sprite.rtsprite.Projectile;
import vooga.rts.gamedesign.sprite.rtsprite.interactive.IOccupiable;
import vooga.rts.gamedesign.strategy.attackstrategy.AttackStrategy;
import vooga.rts.gamedesign.strategy.attackstrategy.CanAttack;
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

    // private int myHealth; //TESTING PURPOSE

    public Soldier(Pixmap image, Location center, Dimension size, Sound sound, int teamID, int health) {
        super(image, center, size, sound, teamID, health);
        addActions();
    }
    
    public void upgradeHealth (int armor) { // TESTING PURPOSE
        setHealth(getHealth() + armor);
    }
    private void addActions(){
        getActions().add(new Action("AttackUpgrade1", null, "This is a new action specific for soldier"){
            @Override
            public void apply(){
                //what will the action be? 
            }
        });
    }

}
