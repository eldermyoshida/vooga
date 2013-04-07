package gamedesign.sprite.rtsprite.interactive.buildings;

import gamedesign.sprite.rtsprite.RTSprite;
import gamedesign.sprite.rtsprite.RTSpriteVisitor;
import gamedesign.sprite.rtsprite.interactive.IOccupiable;
import gamedesign.strategy.occupystrategy.OccupyStrategy;

import java.util.List;

/**
 * 
 * @author Ryan Fishel
 * @author Kevin Oh
 * @author Francesco Agosti
 * @author Wenshun Liu 
 *
 */
public class Garrison extends Building implements IOccupiable {

  public List<OccupyStrategy> myOccupiers;

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