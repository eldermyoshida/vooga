package vooga.rts.gamedesign.sprite.rtsprite;

import vooga.rts.gamedesign.strategy.attackstrategy.AttackStrategy;


/**
 * 
 * @author Ryan Fishel
 * @author Kevin Oh
 * @author Francesco Agosti
 * @author Wenshun Liu 
 *
 */
public interface IAttackable {


    public int calculateDamage();

    public void changeHealth(int change);

    public AttackStrategy getAttackStrategy ();

}