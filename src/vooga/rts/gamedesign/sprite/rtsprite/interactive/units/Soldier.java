package vooga.rts.gamedesign.sprite.rtsprite.interactive.units;

import vooga.rts.gamedesign.Weapon;
import vooga.rts.gamedesign.sprite.rtsprite.IAttackable;
import vooga.rts.gamedesign.sprite.rtsprite.RTSprite;
import vooga.rts.gamedesign.sprite.rtsprite.RTSpriteVisitor;
import vooga.rts.gamedesign.sprite.rtsprite.interactive.IOccupiable;
import vooga.rts.util.Location;
/**
 * 
 * @author Ryan Fishel
 * @author Kevin Oh
 * @author Francesco Agosti
 * @author Wenshun Liu 
 *
 */
public class Soldier extends Units {

  public Weapon myWeapon;

  /** 
   *  for this implementation of visit where the soldier visits a IOccupiable,
   *  the soldier occupies the IOccupiable RTSprite. 
   *  Code: would call myOccupyStrategy.occupy(RTSprite); 
   */
  public void visit(IOccupiable occupiable) {
  }

  public void visit(IAttackable attackable) {
  }



@Override
public void move(Location loc) {
	// TODO Auto-generated method stub
	
}

@Override
public void getAttacked(RTSpriteVisitor visitor) {
	// TODO Auto-generated method stub
	
}

@Override
public int calculateDamage() {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public void changeHealth() {
	// TODO Auto-generated method stub
	
}

@Override
public void visit(RTSprite rtSprite) {
	// TODO Auto-generated method stub
	
}}