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

    public Attribute (String attributeName, Object attributeValue) {
        myName = attributeName;
        myValue = attributeValue;
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
            myValue = toApply.getValue();
        }
        return myValue;
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
    
    public void setValue(Object newValue) {
        myValue = newValue;
    }

}
