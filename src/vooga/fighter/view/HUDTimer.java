package fighter.view;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.util.Observable;
import src.vooga.fighter.view.HUDElement;
import src.vooga.fighter.util.Text;

/**
 * Displays an integer number of seconds as a time in minutes and seconds.
 * 
 * @author Wayne You
 *
 */
public class HUDTimer extends HUDElement {
    Text myTimerDisplay = new Text("");

    @Override
    public void update (Observable o, Object arg) {
        Integer time = (Integer)this.getObservedValue(o);
        int minutes = time / 60;
        int seconds = time % 60;
        myTimerDisplay.setText(String.format("%03d", minutes) + ":" + String.format("%03d", seconds));
    }

    public void paint (Graphics2D pen, Point2D center, Dimension size) {
        myTimerDisplay.paint(pen, center, java.awt.Color.BLACK);
    }
    
}
