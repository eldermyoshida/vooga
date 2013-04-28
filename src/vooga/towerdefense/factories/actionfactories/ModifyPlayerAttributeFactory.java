package vooga.towerdefense.factories.actionfactories;

import vooga.towerdefense.action.Action;
import vooga.towerdefense.attributes.Attribute;
import vooga.towerdefense.gameelements.GameElement;

/**
 * @author Matthew Roy
 *
 */
public class ModifyPlayerAttributeFactory extends ActionFactory {

    
    public ModifyPlayerAttributeFactory(Attribute toModify, String targetAttribute) {
    	super();
        
    }
    
    /**
     * 
     * @param e
     * @return 
     */
    @Override
    protected Action buildAction (GameElement e) {
        // TODO Auto-generated method stub
        return null;
    }

}
