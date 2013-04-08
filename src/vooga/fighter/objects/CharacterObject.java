package vooga.fighter.objects;

import java.awt.Dimension;
import vooga.fighter.util.Location;
import vooga.fighter.util.Pixmap;
import vooga.fighter.util.Vector; 

public class CharacterObject extends MoveableGameObject implements Damageable, Knockable {
	private static final int DEFAULT_HEALTH=10; 
	private static final int DEFAULT_ATTACK_POWER=2;
	private static final int DEFAULT_SPECIAL_ATTACK_POWER=2; 
	private static final int DEFAULT_ATTACK_SPEED=2; 
	private static final Dimension DEFAULT_ATTACK_SIZE=new Dimension(20,20);
	private int myHealth=DEFAULT_HEALTH;
	private int myAttackSpeed=DEFAULT_ATTACK_SPEED; 
	private int myAttackPower=DEFAULT_ATTACK_POWER;
	private int mySpecialAttackPower=DEFAULT_SPECIAL_ATTACK_POWER;
	private AttackObject myAttack; 
	public CharacterObject(Pixmap image, Location center, Dimension size) {
		super(image, center, size);
	}
	
	public CharacterObject(Pixmap image, Location center, Dimension size, int health, int attack, int specialAttack, int attackSpeed) {
		super(image, center, size);
		myHealth= health; 
		myAttackPower=attack;
		mySpecialAttackPower=specialAttack; 
		myAttackSpeed= attackSpeed; 
	}

    @Override
    public void update (double elapsedTime, Dimension bounds) {
    }
	@Override
	public boolean isDestroyed() {
		return myHealth<=0;
		
	}

	@Override
	public void applyImpact(Vector v) {
		translate(v);
	}

	public void normalAttack(int direction){
		myAttack= new AttackObject(null, new Location(getX(), getY()), DEFAULT_ATTACK_SIZE, myAttackPower, 1, new Vector(direction, myAttackSpeed));
	}
	
	public void specialAttack(int direction){
		myAttack= new AttackObject(null, new Location(getX(), getY()), DEFAULT_ATTACK_SIZE, mySpecialAttackPower, 2, new Vector(direction, myAttackSpeed));
	}
	
	public AttackObject getMyAttack(){
		if (myAttack==null){
			return null;
		}
		return myAttack;
	}
}
