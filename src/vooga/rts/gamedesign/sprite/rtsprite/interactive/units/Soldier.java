package vooga.rts.gamedesign.sprite.rtsprite.interactive.units;

import java.util.List;

import java.awt.Dimension;


import vooga.rts.gamedesign.Weapon;
import vooga.rts.gamedesign.sprite.rtsprite.IAttackable;
import vooga.rts.gamedesign.sprite.rtsprite.IGatherable;
import vooga.rts.gamedesign.sprite.rtsprite.RTSprite;
import vooga.rts.gamedesign.sprite.rtsprite.RTSpriteVisitor;
import vooga.rts.gamedesign.sprite.rtsprite.interactive.IOccupiable;
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
public class Soldier extends Units {

    private Weapon myWeapon;

    /** 
     *  for this implementation of visit where the soldier visits a IOccupiable,
     *  the soldier occupies the IOccupiable RTSprite. 
     *  Code: would call myOccupyStrategy.occupy(RTSprite); 
     */

    public Soldier(Pixmap image, Location center, Dimension size, Sound sound, int teamID, int health) {
        super(image, center, size, sound, teamID, health);


    }


    @Override
    public void move(Location loc) {
        // TODO Auto-generated method stub

    }

    public void visit(IAttackable a){
        getAttackstrategy().attack(a);
    }

    @Override
    public int calculateDamage() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void changeHealth() {
        // TODO Auto-generated method stub

    }


    @Override
    public void update(double elapsedTime) {
        // TODO Auto-generated method stub

    }


    @Override
    public void visit (IOccupiable o) {
        // TODO Auto-generated method stub
        
    }


    @Override
    public void visit (IGatherable g) { // duplicated with GatherStrategy???
        // TODO Auto-generated method stub
        
    }


}
