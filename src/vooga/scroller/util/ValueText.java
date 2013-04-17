
package vooga.scroller.util;


/**
 * This class represents text that is a labeled numeric value.
 * 
 * @author Robert C. Duvall
 */
public class ValueText extends Text {
    private String myLabel;
    private int myValue;
    private int myInitialValue;
    private String myString;


    /**
     * Create with its label and an initial value.
     */
    public ValueText (String label, int initialValue) {
        super(label + " " + initialValue);
        myValue = myInitialValue = initialValue;
        myLabel = label;
    }

    
    public ValueText (String label, String initialValue) {
        super(label + " " + initialValue);
        myString = initialValue;
        myLabel = label;
    }
    
    /**
     * Returns displayed value.
     */
    public int getValue () {
        return myValue;
    }
    
    public String getString() {
    	return myString;
    }

    /**
     * Update displayed value.
     */
    public void updateValue (int value) {
        myValue += value;
        setText(myLabel + " " + myValue);
    }
    
    public void updateValue (String value) {
    	myString = value;
        setText(myLabel + " " + value);
    }

    /**
     * Reset displayed value to its initial value
     */
    public void resetValue () {
        myValue = myInitialValue;
        setText(myLabel + " " + myValue);
    }
}
