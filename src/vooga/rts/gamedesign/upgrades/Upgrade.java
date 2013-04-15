package vooga.rts.gamedesign.upgrades;

import vooga.rts.gamedesign.sprite.rtsprite.interactive.Interactive;

/**
 * This class specifies an upgrade and is used to apply the upgrade to the 
 * object that is being upgraded.
 * 
 * @author Ryan Fishel
 * @author Kevin Oh
 * @author Francesco Agosti
 * @author Wenshun Liu 
 *
 */
public abstract class Upgrade {

  public String upgradeType;

  public int value;

  public void apply(Interactive interactive) {
  }

}