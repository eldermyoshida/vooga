package vooga.fighter.objects;

import java.awt.Dimension;
import vooga.fighter.util.Location;
import vooga.fighter.util.Pixmap;
import vooga.fighter.util.Vector; 
public class CharacterObject extends GameObject implements Damageable, Knockable {
	private static final int DEFAULT_HEALTH=10; 
	private static final int DEFAULT_ATTACK_POWER=2;
	private static final int DEFAULT_SPECIAL_ATTACK_POWER=2; 
	private int myHealth=DEFAULT_HEALTH;
	private int myAttackPower=DEFAULT_ATTACK_POWER;
	private int mySpecialAttackPower=DEFAULT_SPECIAL_ATTACK_POWER;
	public CharacterObject(Pixmap image, Location center, Dimension size) {
		super(image, center, size);
	}
	
	public CharacterObject(Pixmap image, Location center, Dimension size, int health, int attack, int specialAttack) {
		super(image, center, size);
		myHealth= health; 
		myAttackPower=attack;
		mySpecialAttackPower=specialAttack; 
	}

    
	@Override
	public boolean isDestroyed() {
		return myHealth<=0;
		
	}

	@Override
	public void applyImpact(Vector v) {
		translate(v);
	}

	public void attack(){
		
	}
}
