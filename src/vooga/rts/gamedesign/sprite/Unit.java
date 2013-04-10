package vooga.rts.gamedesign.sprite;

import java.awt.Dimension;
import java.util.List;

import vooga.rts.ai.PathingHelper;
import vooga.rts.gamedesign.sprite.rtsprite.RTSprite;
import vooga.rts.gamedesign.sprite.rtsprite.interactive.IGatherable;
import vooga.rts.gamedesign.sprite.rtsprite.interactive.IOccupiable;
import vooga.rts.gamedesign.sprite.rtsprite.interactive.Interactive;
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
	
    private List<Interactive> myKills;
    // private boolean myIsLeftSelected; // TODO: also need the same thing for Projectiles
    // private boolean myIsRightSelected; // TODO: should be observing the mouse action instead!!
    private PathingHelper myPather;
    private Location myGoal;
    
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
    public Unit (Pixmap image, Location center, ThreeDimension size, Sound sound, int teamID) {
        super(image, center, size, sound, teamID);
        //myPather = new PathingHelper();
        myGoal = new Location(center);
        myGatherStrategy = new CannotGather();
        myOccupyStrategy = new CannotOccupy();
    }

    public void visit (RTSprite rtSprite) {
        // TODO Auto-generated method stub
    }

    /**
     * Moves the Unit only when it is selected. Updates first the angle
     * the Unit is facing, and then its location.
     */
    public void move (Location loc) {
        myGoal = new Location(loc);
    }

    public void update (double elapsedTime) {
        Vector diff = getCenter().difference(myGoal);
        if (diff.getMagnitude() > 5) {
            double angle = diff.getDirection();
            double magnitude = 100;            
            setVelocity(angle, magnitude);
        }
        else
        {
            setVelocity(0, 0);
        }
        super.update(elapsedTime);
    }
    
    public void gatherResources(IGatherable g) {
    	myGatherStrategy.gather(g);
    }
    
    public void occupyOther(IOccupiable o) {
    	myOccupyStrategy.occupy(o);
    }
    
    public void occupyOther(Unit units) {
    	myOccupyStrategy.occupy(units);
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
