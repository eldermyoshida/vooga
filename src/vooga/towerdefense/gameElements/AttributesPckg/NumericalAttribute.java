package vooga.towerdefense.gameElements.AttributesPckg;


/**
 * Game stat object that can be added to a game element's collection of attributes.
 * Can be health, lives, damage level depending on nature of game element.
 * 
 * @author XuRui
 * @author Matthew Roy
 * 
 */
public class NumericalAttribute extends Attribute {

    private String myName;
    private Double myValue;

    /**
     * Creates stat with name and double value
     * @param statName
     * @param statValue
     */
    public NumericalAttribute (String statName, Double statValue) {
        super(statName, statValue);
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

    /**
     * Formats a string for displaying the value
     * 
     * @return
     */
    public String getDisplayableInfo () {
        String info = myName + ": " + String.valueOf(myValue);
        return info;
    }

    @Override
    public Double getValue () {
        return myValue;
    }

    @Override
    public String getName () {
        return myName;
    }

}
