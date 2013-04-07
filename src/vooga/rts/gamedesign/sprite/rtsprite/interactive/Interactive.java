package gamedesign.sprite.rtsprite.interactive;

import gamedesign.sprite.rtsprite.RTSprite;
import gamedesign.strategy.attackstrategy.AttackStrategy;
import gamedesign.strategy.productionstrategy.ProductionStrategy;
import gamedesign.strategy.skillstrategy.SkillStrategy;
import gamedesign.upgrades.Upgrade;
import gamedesign.upgrades.UpgradeTree;

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