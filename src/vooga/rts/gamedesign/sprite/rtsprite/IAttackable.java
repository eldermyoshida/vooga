package gamedesign.sprite.rtsprite;


/**
 * 
 * @author Ryan Fishel
 * @author Kevin Oh
 * @author Francesco Agosti
 * @author Wenshun Liu 
 *
 */
public interface IAttackable {

  public void getAttacked(RTSpriteVisitor visitor);

  public int calculateDamage();

  public void changeHealth();

}