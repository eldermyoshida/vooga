package vooga.rts.gamedesign.sprite.rtsprite;

import java.awt.Dimension;


import vooga.rts.gamedesign.sprite.GameEntity;
import vooga.rts.gamedesign.sprite.InteractiveEntity;
import vooga.rts.util.Location;
import vooga.rts.util.Pixmap;
import vooga.rts.util.Sound;
import vooga.rts.util.ThreeDimension;


/**
 * 
 * @author Ryan Fishel
 * @author Kevin Oh
 * @author Francesco Agosti
 * @author Wenshun Liu 
 *
 */
public class Projectile extends GameEntity implements Cloneable{

	private Integer myDamage;
	private InteractiveEntity myTarget;
	
	public Projectile(Pixmap pixmap, Location loc, Dimension size, int teamID, int damage, int health){
		super(pixmap, loc, size, teamID, health);
		myDamage = damage;
	}
	
	public Projectile clone() {
		return this.clone();
	}
	
	public void setTarget(InteractiveEntity target){
	    myTarget = target;
	}
	
	public void attack(InteractiveEntity ie){
	    ie.changeHealth(ie.calculateDamage(myDamage));
	}
	
	@Override
	public void update(double elapsedTime){
	    super.update(elapsedTime);
	    if(this.interactsWith(myTarget)){
	        System.out.println("projectile has hit");
	        myTarget.accept(this);
	        this.setHealth(0);
	    }
	}
}