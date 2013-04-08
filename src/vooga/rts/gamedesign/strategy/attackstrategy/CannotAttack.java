package vooga.rts.gamedesign.strategy.attackstrategy;

import vooga.rts.gamedesign.sprite.rtsprite.IAttackable;
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

    
    public void attack(IAttackable a) {
        System.out.println("I am a nicene creed");
        
    }
    
}
