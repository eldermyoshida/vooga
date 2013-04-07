package vooga.rts.gamedesign.sprite.rtsprite.interactive;

import vooga.rts.gamedesign.sprite.rtsprite.RTSprite;
import vooga.rts.gamedesign.strategy.attackstrategy.AttackStrategy;
import vooga.rts.gamedesign.strategy.productionstrategy.ProductionStrategy;
import vooga.rts.gamedesign.strategy.skillstrategy.SkillStrategy;
import vooga.rts.gamedesign.upgrades.Upgrade;
import vooga.rts.gamedesign.upgrades.UpgradeTree;

/**
 * 
 * @author Ryan Fishel
 * @author Kevin Oh
 * @author Francesco Agosti
 * @author Wenshun Liu 
 *
 */
public abstract class Interactive extends RTSprite {

  /** 
   *  the data structure for storing progress of upgrades can be changed? 
   */
  public AttackStrategy myAttackStrategy;

  public ProductionStrategy myProductionStrategy;

  public UpgradeTree myUpgradeTree;

  public Integer buildTime;

  public SkillStrategy mySkillStrategy;

  public void upgrade(Upgrade upgrade) {
  }

  public void die() {
  }

}