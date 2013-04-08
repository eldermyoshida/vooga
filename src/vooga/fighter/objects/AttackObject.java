package vooga.fighter.objects;
import java.awt.Dimension;
import java.util.Timer;

import vooga.fighter.objects.interfaces.CanAttack;
import vooga.fighter.objects.interfaces.Perishable;
import vooga.fighter.util.Location;
import vooga.fighter.util.Pixmap;
import vooga.fighter.util.Vector;
public class AttackObject extends GameObject implements CanAttack, Perishable{
	
	private int myAttackPriority; 
	private int myAttackPower;
	private Pixmap myImage; 
	private Location myCenter;
	private Vector myVelocity;
	private Timer myTimer; 
	private Dimension mySize; 

	public AttackObject(Pixmap image, Location center, Dimension size, int attackPriority, int attackPower, Vector v){
		 // make copies just to be sure no one else has access
		super(image, center, size);
		myImage= image;
		myCenter= center; 
		myVelocity= v; 
		mySize=size; 
		
	}
	
	@Override 
	public void update (double elapsedTime, Dimension bounds) {
        
		// do not change original velocity
        Vector v = new Vector(myVelocity);
        v.scale(elapsedTime);
        translate(v);
    }	
	@Override
	public boolean timedOut() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void stopTime() {
		
		
	}

	@Override
	public void addTime(int amount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inflictDamage(GameObject o, int amount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hasPriority(GameObject o) {
		// TODO Auto-generated method stub
		
	}
	
	public int getPriority(){
		return myAttackPriority; 
	}

}
