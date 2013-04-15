package vooga.towerdefense.gameElements;

import java.awt.Graphics2D;
import vooga.towerdefense.util.Location;


/**
 * Game stat object that can be added to a game element's collection of attributes.
 * Can be health, lives, damage level depending on nature of game element.
 * 
 * @author XuRui
 * 
 */

public class Stat {
    private final double myOriginalValue;
    private String myName;
    private double myCurrentValue;
    private double regenRate;
    private double myMaxValue;

    public Stat (String statName, double statValue) {
        myName = statName;
        myOriginalValue = statValue;
        myCurrentValue = myOriginalValue;
    }

    public void updateStat (double value) {
        myCurrentValue = value;
    }

    public void increment (double value) {
        myCurrentValue += value;
    }

    public void decrement (double value) {
        myCurrentValue -= value;
    }

    public String getDisplayableInfo () {
        String info = myName + " : " + String.valueOf(myCurrentValue);
        return info;
    }

    public double getValue () {
        return myCurrentValue;
    }

    public String getName () {
        return myName;
    }

    /**
     * 
     * paints a bar representing this stat
     */
    public void paint (Graphics2D pen, Location where) {
        // paints a bar representing this stat
    }

    /**
     * check whether this stat is different from its original value
     * 
     * @return
     */
    public boolean isChanged () {
        return myOriginalValue != myCurrentValue;
    }

}
