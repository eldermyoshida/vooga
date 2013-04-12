package vooga.rts.gamedesign.sprite;

import java.awt.Dimension;
import java.util.List;

import vooga.rts.ai.PathingHelper;
import vooga.rts.gamedesign.sprite.rtsprite.EntityVisitor;
import vooga.rts.gamedesign.sprite.rtsprite.RTSprite;
import vooga.rts.gamedesign.sprite.rtsprite.interactive.IGatherable;
import vooga.rts.gamedesign.sprite.rtsprite.interactive.IOccupiable;
import vooga.rts.gamedesign.strategy.gatherstrategy.CannotGather;
import vooga.rts.gamedesign.strategy.gatherstrategy.GatherStrategy;
import vooga.rts.gamedesign.strategy.occupystrategy.CannotOccupy;
import vooga.rts.gamedesign.strategy.occupystrategy.OccupyStrategy;
import vooga.rts.util.Location;
import vooga.rts.util.Pixmap;
import vooga.rts.util.Sound;
import vooga.rts.util.ThreeDimension;
import vooga.rts.util.Vector;

/**
 * This class is an extension of InteractiveEntity, and represents shapes that
 * have the potential to gather resources (contains GatherStrategy) and the
 * potential to be occupied (contains OccupyStrategy). The movement of Units
 * are defined by the AI Engine.
 * 
 * @author Ryan Fishel
 * @author Kevin Oh
 * @author Francesco Agosti
 * @author Wenshun Liu
 *
 */
public class Unit extends InteractiveEntity {
	
    private List<GameSprite> myKills; //TODO: WHAT TYPE SHOULD IT BE??
    // private boolean myIsLeftSelected; // TODO: also need the same thing for Projectiles
    // private boolean myIsRightSelected; // TODO: should be observing the mouse action instead!!
    private PathingHelper myPather;

    
    private GatherStrategy myGatherStrategy;
    private OccupyStrategy myOccupyStrategy;

    /**
     * Creates a new unit with an image, location, size, sound, teamID and health
     * 
     * @param image is the image of the unit
     * @param center is the position of the unit on the map
     * @param size is the size of the unit
     * @param sound is the sound the unit makes
     * @param teamID is the ID for the team that the unit is on
     * @param health is the max health of the unit
     */
    public Unit (Pixmap image, Location center, Dimension size, Sound sound, int teamID, int health) {
        super(image, center, size, sound, teamID, health);
        //myPather = new PathingHelper();
        myGatherStrategy = new CannotGather();
        myOccupyStrategy = new CannotOccupy();
    }

    public void visit (RTSprite rtSprite) {
        System.out.println("visit in Unit got called");
    }
    
    /**
     * Gathers a resource specified by gather strategy.
     * @param g
     */
    public void gather(IGatherable g) {
    	myGatherStrategy.gather(g);
    }
    
    /**
     * Occupies an IOccupiable object specified by occupy strategy.
     * @param o
     */
    public void occupy(IOccupiable o) {
    	myOccupyStrategy.occupy(o);
    }
    
    
    public void setGatherStrategy (GatherStrategy newStrategy) {
    	myGatherStrategy = newStrategy;
    }
    
    public void setOccupyStrategy (OccupyStrategy newStrategy) {
    	myOccupyStrategy = newStrategy;
    }

    public void setPath (Location location) {
        myPather.constructPath(getCenter(), location);
    }



}
