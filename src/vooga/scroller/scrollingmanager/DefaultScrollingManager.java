
package vooga.scroller.scrollingmanager;

import java.awt.Dimension;
import vooga.scroller.model.Model;
import vooga.scroller.util.Location;
import vooga.scroller.view.View;
/**
 * The default scrolling manager
 * @author Ross
 *
 */
public class DefaultScrollingManager extends ScrollingManager {
    private Model myGame;
    private View myView;
    
    public void initGame(Model game) {
        myGame = game;
        
    }

    public void initView(View view) {
        myView = view;
    }

    public int upper() {
        if(myGame != null & myView != null) {
            int vertical = ((int) myGame.getLowerBoundary() + myView.getHeight()*1000) % myView.getHeight();
            return 0 - vertical;
        }
        return 0;
    }

    public int lower() { 
        if(myGame != null & myView != null) {
            int vertical = ((int) myGame.getLowerBoundary() + myView.getHeight()*1000) % myView.getHeight();
            return myView.getHeight() - vertical;
        }
        return 0;

    }

    public int left() {
        if(myGame != null & myView != null) {
            int horizontal = ((int) myGame.getRightBoundary() + myView.getWidth()*1000) % myView.getWidth();
            return 0 - horizontal;
        }
        return 0;
    }

    public int right() {
        if(myGame != null & myView != null) {
            int horizontal = ((int) myGame.getRightBoundary() + myView.getWidth()*1000) % myView.getWidth();
            return myView.getWidth() - horizontal;
        }
        return 0;
    }
    
    public double getRightBoundary(Dimension frame, Location center) {
        return (center.getX() + frame.getWidth() / 2);
    }
    
    public double getLeftBoundary(Dimension frame, Location center) {
        return (center.getX() - frame.getWidth() / 2);
    }
    
    public double getUpperBoundary(Dimension frame, Location center) {
        return (center.getY() - frame.getHeight() / 2);
    }
    
    public double getLowerBoundary(Dimension frame, Location center) { 
        return (center.getY() + frame.getHeight() / 2);
    }
}
