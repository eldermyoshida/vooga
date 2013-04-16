
package vooga.scroller.scrollingmanager;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import util.Location;
import vooga.scroller.model.Model;
import vooga.scroller.sprites.superclasses.Player;
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
        if(myGame != null && myView != null) {
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
        return myGame.getLevelBounds().getWidth();
    }

    public double levelLeftBoundary () {
        return 0;
    }

    public double levelUpperBoundary () {
        return 0;
    }

    public double levelLowerBoundary () {        
        return myGame.getLevelBounds().getHeight();
    }
    
    public Image getBackground() {
        return myGame.getBackground();
    }
    
    public void viewPaint(Graphics pen) {
        Image img = getBackground();
        int imgwidth = img.getWidth(null);
        int imgheight = img.getHeight(null);
        int leftpaintbound = leftpaintbound();
        int upperpaintbound = upperpaintbound();
        int rightpaintbound = rightpaintbound();
        int lowerpaintbound = lowerpaintbound();
        
        if(myGame.getLeftBoundary() < levelLeftBoundary()) {
            leftpaintbound = (int) levelLeftBoundary();
            rightpaintbound = (int) levelRightBoundary();
        }
        
        if(myGame.getRightBoundary() > levelRightBoundary()) {
            leftpaintbound =  - ((int) levelRightBoundary() % myGame.getBackground().getWidth(null));
            rightpaintbound = myView.getWidth()  - ((int) levelRightBoundary() % myGame.getBackground().getWidth(null));
            
        }
        if(myGame.getLowerBoundary() > levelLowerBoundary()) {
            upperpaintbound = - ((int) levelLowerBoundary() % myGame.getBackground().getHeight(null));
            lowerpaintbound = myView.getHeight()  - ((int) levelLowerBoundary() % myGame.getBackground().getHeight(null));
        }
        if(myGame.getUpperBoundary() < levelUpperBoundary()) {
            upperpaintbound = (int) levelUpperBoundary();
            lowerpaintbound = (int) levelLowerBoundary();
        }
        pen.drawImage(img, leftpaintbound, upperpaintbound, imgwidth, imgheight, null);
        pen.drawImage(img, rightpaintbound, upperpaintbound, imgwidth, imgheight, null);
        pen.drawImage(img, leftpaintbound, lowerpaintbound, imgwidth, imgheight, null);
        pen.drawImage(img, rightpaintbound, lowerpaintbound, imgwidth, imgheight, null);
        myGame.paint((Graphics2D) pen);
    }

    public Location playerPaintLocation (Player p) {
        double halfwidth = myView.getWidth() / 2;
        double halfheight = myView.getHeight() / 2;
        double x = halfwidth;
        double y = halfheight;
        double playerlocx = p.getX();
        double playerlocy = p.getY();
        if(playerlocx > (levelRightBoundary() - halfwidth)) {
            x =  halfwidth + (halfwidth - (levelRightBoundary() - playerlocx));
        }
        if(playerlocx < (levelLeftBoundary() + halfwidth)) {
            x =  halfwidth - (halfwidth - (levelLeftBoundary() + playerlocx));
        }
        if(playerlocy > (levelLowerBoundary() - halfheight)) {
            y =  halfheight + (halfheight - (levelLowerBoundary() - playerlocy));
        }
        if(playerlocy < (levelUpperBoundary() + halfheight)) {
            y =  halfheight - (halfheight - (levelUpperBoundary() + playerlocy));
        }        
        return new Location(x, y);
        
    }
}
