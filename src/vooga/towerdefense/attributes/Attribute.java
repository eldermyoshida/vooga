package vooga.towerdefense.attributes;

import java.awt.Graphics2D;
import vooga.towerdefense.util.Location;


/**
 * Shell of an attribute class
 * 
 * @author Matthew Roy
 * 
 */
public abstract class Attribute {
    private String myName;
    private double myOriginalValue;
    private double myCurrentValue;

    public Attribute (String attributeName, Double attributeValue) {
        myName = attributeName;
        myOriginalValue = attributeValue;
        myCurrentValue = attributeValue;
    }

    /**
     * Applies a new attribute to the current attribute.
     * This default behavior is defined by the attribute.
     * Default is to set value equal to attribute toApply's value
     * if they are of the same attribute type
     * 
     * @return the new value
     */
    public Object applyAttribute (Attribute toApply) {
        if (toApply.getClass().equals(this)) {
            myCurrentValue = toApply.getValue();
        }
        return myCurrentValue;
    }

    /**
     * Formats a string for displaying the value.
     * Set to a formatted toString as default
     * 
     * @return
     */
    public String getDisplayableInfo () {
        return toString();
    }

    /**
     * Sets toString to be formatted nicely for attributes
     */
    @Override
    public String toString () {
        String info = myName + ": " + String.valueOf(myCurrentValue);
        return info;
    }

    /**
     * Returns name of the stat
     * 
     * @return
     */
    public String getName () {
        return myName;
    }

    /**
     * Returns value of the stat
     * 
     * @return
     */
    public double getValue () {
        return myCurrentValue;
    }

    public void setValue (double newValue) {
        myCurrentValue = newValue;
    }

    /**
     * Replaces stat value with new value
     * 
     * @param value
     */
    public void updateStat (double value) {
        myCurrentValue = value;
    }

    /**
     * Adds the given parameter to the value.
     * Negative values subtract
     * 
     * @param valueToAdd
     */
    public void modifyValue (double valueToAdd) {
        myCurrentValue += valueToAdd;
    }

    /**
     * Multiplies the current value. Values over 1 increase it.
     * Values < 1 decrease
     * 
     * @param multiplierToApply
     */
    public void applyMultiplier (double multiplierToApply) {
        myCurrentValue *= multiplierToApply;
    }

    public void increment (double value) {
        myCurrentValue += value;
    }

    public void decrement (double value) {
        myCurrentValue -= value;
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
     * @return true if current value is different from the original value
     */
    public boolean isChanged () {
        return myOriginalValue != myCurrentValue;
    }

}
