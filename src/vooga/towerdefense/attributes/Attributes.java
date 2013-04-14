package vooga.towerdefense.attributes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import vooga.towerdefense.gameElements.Stat;

/**
 * Attributes object that helps to track all game element stats.
 * It also provides info requested by view through controller.
 * Used by Towers, Units, Weapons and any Asset-based object.
 * 
 * @author XuRui
 *
 */
public abstract class Attributes{
	private Map<String,Stat> myAttributes;

	public Attributes(Map<String,Stat> attributes){
		myAttributes = attributes;	
	}
	
	/**
	 * Returns stats information requested by View components.
	 * @return
	 */
	public List<String> getAttributesInfo() {
		List<String> info = new ArrayList<String>();
		for (A stat: myAttributes){
			info.add(stat.getDisplayableInfo());
		}
		return info;
	}

	/**
	 * Updates a stat whenever they're changed in the game element.
	 * @param updatedStat
	 */
	public abstract void updateAttribute(Stat updatedStat);

	/**
	 * Add stats attribute to game element
	 */
	public void addAttribute(Stat newStat) {
		myAttributes.put(newStat.getName(), newStat);
		
	}
	

}
