package gamedesign.sprite.rtsprite;


/**
 * 
 * @author Ryan Fishel
 * @author Kevin Oh
 * @author Francesco Agosti
 * @author Wenshun Liu 
 *
 */
public interface RTSpriteVisitor {

	/**
	 * 
	 * @param rtSprite
	 */
  public void visit(RTSprite rtSprite);

}