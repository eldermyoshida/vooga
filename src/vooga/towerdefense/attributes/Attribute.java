package vooga.towerdefense.attributes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;

import vooga.towerdefense.util.Location;

/**
 * Shell of an attribute class, allows for tracking and modification.
 * 
 * @author Matthew Roy
 * @author XuRui
 * @author Zhen Gou
 * 
 */
public class Attribute {
    private String myName;
    private double myOriginalValue;
    private double myCurrentValue;

    public Attribute (String attributeName, Double attributeValue) {
        myName = attributeName;
        myOriginalValue=attributeValue;
        myCurrentValue = myOriginalValue;
    }
    
    /**
     * Applies a new attribute to the current attribute.
     * This default behavior is defined by the attribute.
     * Default is to set value equal to attribute toApply's value
     * if they are of the same attribute type
     * @return the new value
     */
    public Object applyAttribute(Attribute toApply) {
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
    public String toString() {
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
    
    public void setValue(double newValue) {
        myCurrentValue = newValue;
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

	/**
	 * paints a bar representing this attribute
	 */
	public void paint (Graphics2D pen, Location where, Dimension size) {
		pen.setColor(Color.green);
		//THIS IS VERY SPECIFIC FOR TESTING, WE WILL FIGURE OUT BETTER WAY TO FIT THE BAR
		pen.fillRect((int)where.getX(), (int)where.getY()-size.height/2, (int)(size.getWidth()/2.5), (int)size.getHeight()/10);
	}

	/**
	 * check whether this stat is different from its original value
	 * 
	 * @return
	 */
	public boolean isChanged () {
		return myOriginalValue != myCurrentValue;
	}
	/**
	 * reset current value to original value;
	 */

	public void reset() {
		myCurrentValue=myOriginalValue;
		
	}
	

}
