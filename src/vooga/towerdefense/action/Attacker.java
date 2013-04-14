package vooga.towerdefense.action;

/**
 * Interface implemented by any object that can attack a Targetable object
 * @author XuRui, Zhen Gou
 *
 */
public interface Attacker {

	double getAttackRadius();

	/**
	 * returns number of targets to attack
	 * @return
	 */
	int getNumberOfTargets();

	double getAttackDamage();
	
	Targetable getTarget();
	
	void addTarget();
	

}
