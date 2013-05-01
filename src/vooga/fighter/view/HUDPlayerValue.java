package vooga.fighter.view;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.util.Observable;

import util.Text;

/**
 * Displays a specific player's statistic. Displays one statistic given the Name
 * and observes a HUDPlayerValue.Stats field.
 * 
 * @author Wayne You
 * 
 */
public class HUDPlayerValue extends HUDElement {
    public class Stats {
        public String myName;
        public int    myValue;
        
        public Stats(String name, int value, int lives) {
            myName = name;
            myValue = value;
        }
    }
    
    protected Text myPlayerNameText = new Text("");
    protected Text myPlayerValue    = new Text("");
    
    @Override
    public void update(Observable o, Object arg) {
        Stats newStats = null;
        try {
            newStats = (Stats) getObservedValue(o);
        }
        catch (SecurityException e) {}
        catch (IllegalArgumentException e) {
            System.err
                    .println("Expected HUDPlayerValue.Stats for HUDPlayervalue");
        }
        catch (NoSuchFieldException e) {
            System.err.println(myFieldName
                    + " is not a member of the class observed.");
        }
        catch (IllegalAccessException e) {
            System.err.println("Illegal access in HUDPlayerValue.");
        }
        
        if (newStats == null)
            return;
        
        myPlayerNameText.setText(newStats.myName);
        myPlayerValue.setText(myName + ": " + newStats.myValue);
    }
    
    @Override
    public void paint(Graphics2D pen, Point2D center, Dimension size) {
        myPlayerNameText.paint(pen, center, java.awt.Color.BLACK);
        center.setLocation(center.getX(), center.getY()
                + HUDElement.DEFAULT_TEXT_HEIGHT);
        myPlayerValue.paint(pen, center, java.awt.Color.RED);
    }
}
