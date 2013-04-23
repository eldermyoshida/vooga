/**
 * 
 */
package vooga.towerdefense.action;

import vooga.towerdefense.attributes.Attribute;
import vooga.towerdefense.model.GameMap;
import vooga.towerdefense.util.Location;

/**
 * Filters targets using an affiliation system
 * 
 * @author Matthew Roy
 * @author XuRui
 *
 */
public class FilterTargets extends FindTargets{

	public FilterTargets(GameMap map, Location source, Attribute attackRadius) {
		super(map, source, attackRadius);
		// TODO Auto-generated constructor stub
	}
	

}
