package fighter.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.util.Observable;
import src.vooga.fighter.view.HUDElement;
import src.vooga.fighter.util.Text;

/**
 * Displays a specific player's statistic. Displays one statistic given the Name
 *  and observes a HUDPlayerValue.Stats field.
 * 
 * @author Wayne You
 *
 */
public class HUDPlayerValue extends HUDElement {
    public class Stats {
        public String myName;
        public int myValue;
        public int myLivesLeft;
        
        public Stats (String name, int value, int lives) {
            myName = name;
            myValue = value;
            myLivesLeft = lives;
        }
    }
    
    Text myPlayerNameText = new Text("");
    Text myPlayerValue = new Text("");
    Text myPlayerLives = new Text("");
    
    @Override
    public void update (Observable o, Object arg) {
        Stats newStats = (Stats)this.getObservedValue(o);
        
        myPlayerNameText.setText(newStats.myName);
        myPlayerValue.setText(myName + ": " + newStats.myValue);
        myPlayerLives.setText("Lives: " + newStats.myLivesLeft);
    }
    
    public void paint (Graphics2D pen, Point2D center, Dimension size) {
        myPlayerNameText.paint(pen, center, java.awt.Color.BLACK);
        center.setLocation(center.getX(), center.getY() + HUDElement.DEFAULT_TEXT_HEIGHT);
        myPlayerNameText.paint(pen, center, java.awt.Color.BLACK);
        center.setLocation(center.getX(), center.getY() + HUDElement.DEFAULT_TEXT_HEIGHT);
        myPlayerNameText.paint(pen, center, java.awt.Color.BLACK);
    }
}
