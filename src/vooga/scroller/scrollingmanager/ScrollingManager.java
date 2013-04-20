package vooga.scroller.scrollingmanager;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import util.Location;
import vooga.scroller.model.Model;
import vooga.scroller.sprites.superclasses.Player;
import vooga.scroller.util.Direction;
import vooga.scroller.view.View;

/**
 * Abstract class for all ScrollingManagers to extend
 * @author Ross
 *
 */

public abstract class ScrollingManager {
    
    /**
     * Used to initialize the a reference to the Model the ScrollingManager will be using.
     * @param model The instance of the Model that the ScrollingManager will be controlling
     */
    public abstract void initModel(Model model);
        
    /**
     * Used to initialize the a reference to the View the ScrollingManager 
     * will be using.
     * @param view The instance of the View that the ScrollingManager will be controlling
     */
    public abstract void initView(View view);

    protected abstract int upperpaintbound();

    protected abstract int lowerpaintbound();

    protected abstract int leftpaintbound();

    protected abstract int rightpaintbound();
    
    /**
     * Given a frame, gives the right boundary around the specified center point
     * @param frame The frame being considered.
     * @param center The center of the frame.
     * @return The right boundary
     */
    public abstract double getRightBoundary(Dimension frame, Location center);
    
    /**
     * Given a frame, gives the left boundary around the specified center point
     * @param frame The frame being considered.
     * @param center The center of the frame.
     * @return The left boundary
     */
    public abstract double getLeftBoundary(Dimension frame, Location center);
    
    /**
     * Given a frame, gives the upper boundary around the specified center point
     * @param frame The frame being considered.
     * @param center The center of the frame.
     * @return The upper boundary
     */
    public abstract double getUpperBoundary(Dimension frame, Location center);
    
    /**
     * Given a frame, gives the lower boundary around the specified center point
     * @param frame The frame being considered.
     * @param center The center of the frame.
     * @return The lower boundary
     */
    public abstract double getLowerBoundary(Dimension frame, Location center);
    
    protected abstract double levelRightBoundary();
    
    protected abstract double levelLeftBoundary();
    
    protected abstract double levelUpperBoundary();
    
    protected abstract double levelLowerBoundary();
    
    protected abstract Image getBackground();
    
    /**
     * Paints the View for the game, given the constraints of the ScrollingManger.
     * @param pen The Graphics object that will be doing the painting.
     */
    public abstract void viewPaint(Graphics pen);
    
    /**
     * Given a player, returns the Location given the current state of the Model 
     * that the Player needs to be painted. 
     * @param player The Player for which the paint Location is being updated.
     * @return The Location that the player should be painted.
     */    
    public abstract Location playerPaintLocation(Player player);

    /**
     * Returns the double that corresponds to a hard boundary for the game. 
     * A hard boundary is a line that can't be crossed by the Player
     * @param d The direction for which you are inquiring about a boundary
     * @param levelBounds The bounds for the Level in that direction, 
     * assuming there are no other hard boundaries in that direction.
     * @return The double that corresponds to the hard boundary
     */
    public double getHardBoundary (Direction d, double levelBounds) {
        return levelBounds;
    }
    
    
}
