package vooga.rts.gamedesign.strategy.attackstrategy;

import vooga.rts.gamedesign.sprite.rtsprite.IAttackable;


/**
 * This class implements AttackStrategy and is used as an instance in 
 * interactives for objects that are able to attack.  The attack method in this
 * class will specify how the interactive will attack.
 * 
 * @author Ryan Fishel
 * @author Kevin Oh
 * @author Francesco Agosti
 * @author Wenshun Liu 
 *
 */
public class CanAttack implements AttackStrategy{



    public CanAttack(){
    }

    public boolean canAttack(IAttackable a) {
    	return true;
    }
    
    


}
