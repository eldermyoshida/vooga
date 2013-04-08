package vooga.rts.gamedesign.strategy.attackstrategy;

import vooga.rts.gamedesign.sprite.rtsprite.IAttackable;
import vooga.rts.gamedesign.sprite.rtsprite.interactive.Interactive;
import vooga.rts.gamedesign.sprite.rtsprite.interactive.buildings.Building;
import vooga.rts.gamedesign.sprite.rtsprite.interactive.units.Soldier;
import vooga.rts.gamedesign.sprite.rtsprite.interactive.units.Units;
/**
 * 
 * This class implements AttackStrategy and is used as an instance in 
 * interactives for objects that are not able to attack.
 * 
 * @author Ryan Fishel
 * @author Kevin Oh
 * @author Francesco Agosti
 * @author Wenshun Liu 
 *
 */
public class CannotAttack implements AttackStrategy{



    @Override
    public void attack(Building building, Interactive i) {
        System.out.println("attacked building");
    }

    @Override
    public void attack(Units units, Interactive i) {
        System.out.println("attacked unit");
    }

    @Override
    public void attack(IAttackable a, Interactive i) {
        // TODO Auto-generated method stub
        
            System.out.println("I am nothing");
        
    }
}
