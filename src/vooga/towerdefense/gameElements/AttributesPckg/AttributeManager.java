package vooga.towerdefense.gameElements.AttributesPckg;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


/**
 * Attributes object that helps to track all game element stats.
 * It also provides info requested by view through controller.
 * Used by Towers, Units, Weapons and any Asset-based object.
 * 
 * @author XuRui
 * @author Matthew Roy
 * 
 */
public abstract class AttributeManager {
    private HashSet<Attribute> myAttributes;

    public AttributeManager (HashSet<Attribute> attributes) {
        myAttributes = attributes;
    }

    /**
     * Returns stats information requested by View components.
     * 
     * @return
     */
    public List<String> getAttributesInfo () {
        List<String> info = new ArrayList<String>();
        for (Attribute stat : myAttributes) {
            info.add(stat.getDisplayableInfo());
        }
        return info;
    }

    /**
     * Updates a stat whenever they're changed in the game element.
     * 
     * @param updatedStat
     */
    @Deprecated //This doesn't really serve a purpose
    public abstract void updateAttribute (Attribute updatedStat);
    
    /**
     * Gets a specific stat based on name
     * @param name
     * @return stat if it exists, otherwise returns null
     */
    public Attribute getAttribute(String name) {
        for (Attribute s : myAttributes) {
            if (s.getName().equalsIgnoreCase(name)) {
                return s;
            }
        }
        return null;
    }

    /**
     * Add stats attribute to game element
     */
    public void addAttribute (Attribute newStat) {
        myAttributes.add(newStat);
    }

}
