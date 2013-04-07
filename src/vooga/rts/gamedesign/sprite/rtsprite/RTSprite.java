package vooga.rts.gamedesign.sprite.rtsprite;

import java.awt.Dimension;
import vooga.rts.gamedesign.sprite.Sprite;
import vooga.rts.gamedesign.strategy.attackstrategy.AttackStrategy;
import vooga.rts.gamedesign.strategy.occupystrategy.OccupyStrategy;
import vooga.rts.util.Location;
import vooga.rts.util.Pixmap;
import vooga.rts.util.Sound;

/**
 * This class represents a sprite that can be attacked and that can visit
 * other sprites of its type.  Because these sprites can be attacked, they
 * have a current health and a max health.  These sprites are also specific 
 * to a taem so they know the ID of their team.  These sprites will also
 * have the ability to have occupy strategies and attack strategies.  Examples
 * of RTSsprites are projectiles, resources, and interactives (such as units
 * and buildings).
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
    

    public RTSprite (Pixmap image, Location center, Dimension size, Sound sound, int teamID, int health) {
        super(image, center, size);
        maxHealth = health;
        curHealth = maxHealth;
        mySound = sound;
        TeamID = teamID;
    }
    
    /** 
     *  This would accept RTSpriteVisitors and behave according to the 
     *  visitor's visit method. This code will always run 
     *  RTSpriteVisitor.visit(this). "this" being the subclass of RTSprite. 
     */
    public void accept(RTSpriteVisitor visitor) {
        visitor.visit(this);
    }
    
    /**
     * This would determine if two RTSprites collide.
     * @param rtSprite is an RTSprite that is being checked to see if it 
     * collides with the current RTSprite
     * @return true if the two RTsprites collided and false if the RTSprites
     * did not collide.
     */
    public boolean interactsWith(RTSprite rtSprite) {
        return getBounds().intersects(rtSprite.getBounds());
    }
    
    /**
     * Checks to see if an RTSprite is dead.
     * @return true if the RTSprite has been killed and true if the RTSprite 
     * is still alive.
     */
    public boolean isDead() {
    	return curHealth <= 0;
    }


}