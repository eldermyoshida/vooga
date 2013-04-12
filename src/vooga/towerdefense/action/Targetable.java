package vooga.towerdefense.action;

import java.util.jar.Attributes;

/**
 * Interface implemented to render a game element targetable. 
 * Target may be defined to take damage only from a specific attack action. 
 * 
 * @author XuRui
 *
 */
public interface Targetable {
	
	/**
	 * Tracks damage taken by updating target's Attributes only if isRightAttacker returns true.
	 * @param attack
	 */
	public void takeDamage(double attack);
	
	/**
	 * Option to define attacker type.
	 * @param attack
	 */
	public void setAttackerType(ComboAttackAction attack);
	
	public void getAttackerType();
	
	/**
	 * Returns true only if attack is applicable to target. 
	 * @param attack
	 * @return
	 */
	public boolean isRightAttacker(ComboAttackAction attack);
			
	/**
	 * Checks to see if target is alive.
	 * @return
	 */
	public boolean isAlive();

}
