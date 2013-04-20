package vooga.scroller.scrollingmanager;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import util.Location;
import vooga.scroller.sprites.superclasses.Player;
import vooga.scroller.util.Direction;
import vooga.scroller.view.View;
import vooga.scroller.model.Model;

/**
 * Abstract class for all ScrollingManagers to extend
 * @author Ross
 *
 */

public abstract class ScrollingManager {
    
    /**
     * Used to initialize the a reference to the Model the ScrollingManager 
     * will be using.
     * @param game The instance of the M
     */

    public abstract void initModel(Model game);

    public abstract void initView(View view);

    public abstract int upperpaintbound();

    public abstract int lowerpaintbound();

    public abstract int leftpaintbound();

    public abstract int rightpaintbound();
    
    public abstract double getRightBoundary(Dimension frame, Location center);
    
    public abstract double getLeftBoundary(Dimension frame, Location center);
    
    public abstract double getUpperBoundary(Dimension frame, Location center);
    
    public abstract double getLowerBoundary(Dimension frame, Location center);
    
    public abstract double levelRightBoundary();
    
    public abstract double levelLeftBoundary();
    
    public abstract double levelUpperBoundary();
    
    public abstract double levelLowerBoundary();
    
    public abstract Image getBackground();
    
    public abstract void viewPaint(Graphics pen);
    
    public abstract Location playerPaintLocation(Player player);

    public double getHardBoundary (Direction d, double levelBounds) {
        return levelBounds;
    }
    
    
}
