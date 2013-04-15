package vooga.rts.gamedesign.strategy.attackstrategy;

import vooga.rts.gamedesign.sprite.rtsprite.IAttackable;
import vooga.rts.gamedesign.strategy.Strategy;


/**
 * 
 * This interface is implemented by the classes CanAttack and CannotAttack that
 * are then used as instance variables in the classes that could possibly
 * attack. If the unit currently can attack, it will have an instance of
 * CanAttack, otherwise it will have an instance of CannotAttack. Using the
 * strategy pattern like this, units and buildings ability to attack can be
 * dynamically changed. For example, a worker may be implemented such that
 * it can not attack until an upgrade is bought. The worker will initially
 * have an instance of CannotAttack but once the upgrade is bought it will
 * switch to have an instance of CanAttack.
 * 
 * @author Ryan Fishel
 * @author Kevin Oh
 * @author Francesco Agosti
 * @author Wenshun Liu
 * 
 * 
 */
public interface AttackStrategy extends Strategy{

    public boolean canAttack (IAttackable a);

}
