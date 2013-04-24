package vooga.fighter.model;

import java.util.ResourceBundle;

/**
 * Stores the constants relevant to the model.
 * 
 * @author James Wei
 *
 */
public class ModelConstants {
    
    // resource bundle setup
    private static final String RESOURCE_PATH = "vooga.fighter.config.objects";
    private static final String RESOURCE_DEFAULT_VALUES_PATH="vooga.fighter.config.defaultvalues";
    private static ResourceBundle myDefaults;  
    private static ResourceBundle myResources;  

    static {
        myResources = ResourceBundle.getBundle(RESOURCE_PATH);
        myDefaults= ResourceBundle.getBundle(RESOURCE_DEFAULT_VALUES_PATH);
    }
    
    // strings used to identify attack object properties
    public static final String ATTACK_PROPERTY_DAMAGE = myResources.getString("Damage");
    public static final String ATTACK_PROPERTY_SPEED = myResources.getString("Movespeed");
    public static final String ATTACK_PROPERTY_DIRECTION = myResources.getString("Direction");
    public static final String ATTACK_PROPERTY_DURATION = myResources.getString("Duration");
    
    // attack object constants
    public static final int ATTACK_COUNTER_ZERO = 0;
    
    // strings used to identify effect properties
    public static final String EFFECT_PROPERTY_DURATION = myResources.getString("Duration");
    
    // effect properties
    public static final String EFFECT_PROPERTY_BURN_DAMAGE = myResources.getString("Damage");
    
}
