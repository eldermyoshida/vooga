package vooga.fighter.objects;
import java.awt.Dimension;

import vooga.fighter.util.Location;
import vooga.fighter.util.Pixmap;
import vooga.fighter.util.Vector;
public class AttackObject implements Attackable, Perishable{
	
	private int myAttackPriority; 
	private int myAttackPower;
	private Pixmap myImage; 
	private Location myCenter;
	private Vector myVelocity;
	public AttackObject(Pixmap image, Location l, int attackPriority, int attackPower, Vector v){
		 // make copies just to be sure no one else has access
		myImage= image;
		myCenter= l; 
		myVelocity= v;
		
	}
	@Override
	public boolean timedOut() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void stopTime() {
		// TODO Auto-generated method stub
		
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
