<<<<<<< HEAD:src/vooga/fighter/util/ValueText.java
package vooga.fighter.util;
=======
<<<<<<< HEAD
package vooga.rts.util;
>>>>>>> 7362f1f68e473e33a6b1ac1ac75b1d10ad4db368:src/vooga/rts/util/ValueText.java
=======
package vooga.towerdefense.util;
>>>>>>> 7362f1f68e473e33a6b1ac1ac75b1d10ad4db368:src/vooga/towerdefense/util/ValueText.java
>>>>>>> d91774e3125c7e327839540ffd65a4d5a62eac1f


/**
 * This class represents text that is a labeled numeric value.
 * 
 * @author Robert C. Duvall
 */
public class ValueText extends Text {
    private String myLabel;
    private int myValue;
    private int myInitialValue;


    /**
     * Create with its label and an initial value.
     */
    public ValueText (String label, int initialValue) {
        super(label + " " + initialValue);
        myValue = myInitialValue = initialValue;
        myLabel = label;
    }

    /**
     * Returns displayed value.
     */
    public int getValue () {
        return myValue;
    }

    /**
     * Update displayed value.
     */
    public void updateValue (int value) {
        myValue += value;
        setText(myLabel + " " + myValue);
    }

    public void setValue (int value) {
        myValue = value;
        setText(myLabel + " " + myValue);
    }
    /**
     * Reset displayed value to its initial value
     */
    public void resetValue () {
        myValue = myInitialValue;
        setText(myLabel + " " + myValue);
    }
}
