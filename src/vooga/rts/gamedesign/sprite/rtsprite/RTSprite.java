package vooga.rts.gamedesign.sprite.rtsprite;

import vooga.rts.gamedesign.sprite.Sprite;
import vooga.rts.gamedesign.strategy.attackstrategy.AttackStrategy;
import vooga.rts.gamedesign.strategy.occupystrategy.OccupyStrategy;
import vooga.rts.util.Sound;

/**
 * 
 * @author Ryan Fishel
 * @author Kevin Oh
 * @author Francesco Agosti
 * @author Wenshun Liu 
 *
 */
public abstract class RTSprite extends Sprite implements IAttackable, RTSpriteVisitor {

  public Integer curHealth;

  public OccupyStrategy myOccupyStrategy;

  public AttackStrategy myAttackStrategy;

  public Integer maxHealth;

  public Integer TeamID;

  public Sound mySound;

  /** 
   *  This would accept RTSpriteVisitors and behave according to the visitor's visit method. This code will always run RTSpriteVisitor.visit(this). "this" being the subclass of RTSprite. 
 * @return 
   */
  public void accept(RTSpriteVisitor visitor) {
	  visitor.visit(this);
  }

  public boolean interactsWith(RTSprite rtSprite) {
	return false;
  }

}