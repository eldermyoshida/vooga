package vooga.scroller.scrollingmanager;

import java.awt.Dimension;
import vooga.scroller.util.Location;
import vooga.scroller.view.View;
import vooga.scroller.model.Model;

/**
 * Abstract class for all ScrollingManagers to extend
 * @author Ross
 *
 */

public abstract class ScrollingManager {

    public abstract void initGame(Model game);

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
    
    
}
