package vooga.towerdefense.gameElements;

import java.awt.Graphics2D;

import vooga.towerdefense.attributes.Attribute;
import vooga.towerdefense.attributes.NumericalAttribute;
import vooga.towerdefense.util.Location;


/**
 * Game stat object that can be added to a game element's collection of attributes.
 * Can be health, lives, damage level depending on nature of game element.
 * 
 * @author XuRui
 * @author Mattew Roy
 * 
 * 
 */

public class Stat extends Attribute {
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

	public Double applyAttribute(NumericalAttribute toApply) {
		modifyValue(toApply.getValue());
		return myValue;
	}

	/**
	 * Replaces stat value with new value
	 * @param value 
	 */
	public void updateStat (double value) {
		myValue = value;
	}

	/**
	 * Adds the given parameter to the value.
	 * Negative values subtract
	 * 
	 * @param valueToAdd 
	 */
	public void modifyValue (double valueToAdd) {
		myValue += valueToAdd;
	}

	/**
	 * Multiplies the current value. Values over 1 increase it.
	 * Values < 1 decrease
	 * 
	 * @param multiplierToApply 
	 */
	public void applyMultiplier (double multiplierToApply) {
		myValue *= multiplierToApply;
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
	 * @return
	 */
	public boolean isChanged () {
		return myOriginalValue != myCurrentValue;
	}

}
