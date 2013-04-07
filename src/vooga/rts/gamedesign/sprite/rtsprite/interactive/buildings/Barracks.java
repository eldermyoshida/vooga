package vooga.rts.gamedesign.sprite.rtsprite.interactive.buildings;

import vooga.rts.gamedesign.sprite.rtsprite.RTSprite;
import vooga.rts.gamedesign.sprite.rtsprite.RTSpriteVisitor;
import vooga.rts.gamedesign.strategy.production.Producer;

/**
 * 
 * @author Ryan Fishel
 * @author Kevin Oh
 * @author Francesco Agosti
 * @author Wenshun Liu 
 *
 */
public class Barracks extends Building {

  public Producer myProducer;

  /** 
   *  call new RTSprite where the RTSprite can be specified based on the type. For Barracks, produce() can create a new instance of Soldier. 
   */
  public void produce() {
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
public void getAttacked(RTSpriteVisitor visitor) {
	// TODO Auto-generated method stub
	
}

@Override
public void visit(RTSprite rtSprite) {
	// TODO Auto-generated method stub
	
}

}