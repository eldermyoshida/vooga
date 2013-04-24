package vooga.towerdefense.factories.actionfactories;
/**
 * factory for remove element action
 * @author Zhen Gou
 *
 */
public class RemoveElementFactory extends ActionFactory {
	public RemoveElementFactory(){
		
	}
	
	public Action buildAction(GameElement element){
		return new RemoveElement(getMap(),element);
	}
	

}
