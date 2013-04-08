package vooga.rts.gamedesign.strategy.attackstrategy;

import vooga.rts.gamedesign.sprite.rtsprite.IAttackable;

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
    
   /**
    * Implements the attack method and does nothing, because this is the CannotAttack strategy.
    */
    public void attack(IAttackable a) { 
        
        
    }
}
