package vooga.rts.gamedesign.sprite;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import vooga.rts.util.Location;
import vooga.rts.util.Pixmap;

/**
 * 
 * @author Ryan Fishel
 * @author Kevin Oh
 * @author Francesco Agosti
 * @author Wenshun Liu 
 *
 */
public abstract class Sprite {

  public Pixmap image;

  public Location location;

  public Rectangle size;

  public Integer uniqueID;

  /** 
   *  This method is to update the sprite either by repainting the picture or animating
   */
  public void update(Dimension bounds, int elapsedTime) {
  }
  
  /**
   * This method will paint all of the sprites that are visible onto the canvas
   * @param pen is used to draw the sprites
   */
  public void paint(Graphics2D pen) {
  }

}