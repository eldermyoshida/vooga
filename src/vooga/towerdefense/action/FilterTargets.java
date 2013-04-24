/**
 * 
 */
package vooga.towerdefense.action;

import java.util.ArrayList;
import java.util.List;
import vooga.towerdefense.attributes.Attribute;
import vooga.towerdefense.gameElements.GameElement;
import vooga.towerdefense.model.GameMap;
import vooga.towerdefense.util.Location;

/**
 * Filters targets using an affiliation system
 * 
 * @author Matthew Roy
 * @author XuRui
 *
 */
public class FilterTargets extends TargetedAction{
    
    Attribute myTargetAffil;
    Attribute myNumTargets;

	public FilterTargets(Attribute targetAffiliation) {
		super();
		myTargetAffil = targetAffiliation;
	}
	
	public FilterTargets(Attribute targetAffiliation, Attribute numTargets) {
            super();
            myTargetAffil = targetAffiliation;
            myNumTargets = numTargets;
    }

    /**
     * 
     * @param elapsedTime 
     */
    @Override
    public void executeAction (double elapsedTime) {
        List<GameElement> filteredTargets = new ArrayList<GameElement>();
        for (GameElement e : getTargets()) {
            Attribute affiliation = e.getAttributeManager().getAttribute("Affiliation")
            if (affiliation != null && affiliation.getName()) {
                
            }
        }
        
    }
	

}
