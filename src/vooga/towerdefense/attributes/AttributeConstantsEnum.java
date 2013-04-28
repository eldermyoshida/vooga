package vooga.towerdefense.attributes;

/**
 * Contains constants for use in defining attribute names
 * 
 * 
 * @author Matthew Roy
 * @author Zhen Gou
 * @author Jimmy Longley
 * @author Yoshida
 * 
 */
public enum AttributeConstantsEnum {
    NAME("Name"),
    HEALTH("Health"),
    MONEY("Money"),
    SCORE("Score"),
    SHAPE("Shape"),
    AFFILIATION("Affiliation"),
    
    /**
     * Affiliation value constants
     */
    AFFILIATION_PLAYER(0.0),
    AFFILIATION_WAVES(1.0),
    AFFILIATION_NEUTRAL(2.0),
    
    AFFILIATION_TOWER(0.1),
    AFFILIATION_UNIT(0.2),
    AFFILIATION_PROJECTILE(0.3),
    
    ATTACK_DAMAGE("Attack Damage"),
    ATTACK_RADIUS("Attack Range"),
    NUM_OF_TARGETS("Number of Targets"),
    TILES_WIDE("Tiles wide"),
    TILES_TALL("Tiles tall"),
    /**
     * Seconds between attacks
     */
    ATTACK_INTERVAL("Attack Speed"),
    ARMOR("Armor"),
    MOVE_SPEED("Move Speed"),
    DIRECTION("Direction"),
    UPGRADES("Upgrades"),
    COST("Cost"),
    
    PROJECTILE_FACTORY("projectile factory"),
    AURA_EFFECT("Aura");
    
    private String attributeConstant;
    private double attributeValue;
    
    AttributeConstantsEnum(String s) {
        attributeConstant = s;
    }
    
    AttributeConstantsEnum(double s) {
        attributeValue = s;
    }
    
    public String getStatusCode () {
        return attributeConstant;
    }
    
    public double getValue () {
        return attributeValue;
    }
}
