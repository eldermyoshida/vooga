package vooga.towerdefense.factories.actionfactories;

import vooga.towerdefense.action.Action;
import vooga.towerdefense.action.FilterTargets;
import vooga.towerdefense.gameElements.GameElement;

/**
 * factory for creating filter targets action
 * @author Zhen Gou
 *
 */
public class FilterTargetsFactory extends ActionFactory{
    private String myAffiliationReference;
    private String myNumTargetsReference;
    /**
     * 
     * @param affiliationReference
     * @param numTargetsReference
     */
	public FilterTargetsFactory(String affiliationReference, String numTargetsReference){
		myAffiliationReference=affiliationReference;
		myNumTargetsReference=numTargetsReference;
		
	}

	@Override
	protected Action buildAction(GameElement e) {
		return new FilterTargets(e.getAttributeManager().getAttribute(myAffiliationReference), e.getAttributeManager().getAttribute(myNumTargetsReference));
	}
	

}
