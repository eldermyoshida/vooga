
package vooga.scroller.scrollingmanager;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
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

    public int upperpaintbound() {
        if(myGame != null & myView != null) {
            int vertical = ((int) myGame.getLowerBoundary() + myView.getHeight()*1000) % myView.getHeight();
            return 0 - vertical;
        }
        return 0;
    }

    public int lowerpaintbound() { 
        if(myGame != null & myView != null) {
            int vertical = ((int) myGame.getLowerBoundary() + myView.getHeight()*1000) % myView.getHeight();
            return myView.getHeight() - vertical;
        }
        return 0;

    }

    public int leftpaintbound() {
        if(myGame != null & myView != null) {
            int horizontal = ((int) myGame.getRightBoundary() + myView.getWidth()*1000) % myView.getWidth();
            return 0 - horizontal;
        }
        return 0;
    }

    public int rightpaintbound() {
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

    public double levelRightBoundary () {
        myGame.getLevelBounds().getWidth();
        return 0;
    }

    public double levelLeftBoundary () {
        return 0;
    }

    public double levelUpperBoundary () {
        return 0;
    }

    public double levelLowerBoundary () {
        myGame.getLevelBounds().getHeight();
        return 0;
    }
    
    public Image getBackground() {
        return myGame.getBackground();
    }
    
    public void paint(Graphics pen) {
        Image img = getBackground();
        int imgwidth = img.getWidth(null);
        int imgheight = img.getHeight(null);
        int leftpaintbound = leftpaintbound();
        int upperpaintbound = upperpaintbound();
        int rightpaintbound = rightpaintbound();
        int lowerpaintbound = lowerpaintbound();
        
        System.out.println(myGame.getLeftBoundary());
        if(myGame.getLeftBoundary() < levelLeftBoundary()) {
            leftpaintbound = 0;
        }

        pen.drawImage(img, leftpaintbound, upperpaintbound, imgwidth, imgheight, null);
        pen.drawImage(img, rightpaintbound, upperpaintbound, imgwidth, imgheight, null);
        pen.drawImage(img, leftpaintbound, lowerpaintbound, imgwidth, imgheight, null);
        pen.drawImage(img, rightpaintbound, lowerpaintbound, imgwidth, imgheight, null);
        myGame.paint((Graphics2D) pen);
    }
}
