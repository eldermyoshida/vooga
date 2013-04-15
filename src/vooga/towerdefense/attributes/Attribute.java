package vooga.towerdefense.attributes;

/**
 * Shell of an attribute class
 * 
 * @author Matthew Roy
 * 
 */
public abstract class Attribute {
    private String myName;
    private Object myValue;

    public Attribute (String statName, Object statValue) {
        myName = statName;
        myValue = statValue;
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
    public Object getValue () {
        return myValue;
    }

}
