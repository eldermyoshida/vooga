package vooga.rts.gamedesign.factories;

import java.lang.reflect.InvocationTargetException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import vooga.rts.gamedesign.strategy.Strategy;
import vooga.rts.gamedesign.strategy.attackstrategy.AttackStrategy;
import vooga.rts.gamedesign.strategy.gatherstrategy.GatherStrategy;
import vooga.rts.gamedesign.strategy.occupystrategy.OccupyStrategy;

public class StrategyDecoder extends Decoder{

	public static final String ATTACK_TAG = "attacks";
	public static final String OCCUPY_TAG = "occupys";
	public static final String GATHER_TAG = "gathers";
	public static final String SOURCE = "src";
	
	
	Factory myFactory;
	
	public StrategyDecoder(Factory factory){
		myFactory = factory;
	}
	
	/**
	 * 
	 * @param list
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	private void getSources(NodeList list) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		for(int j = 0 ; j < list.getLength() ; j++ ){
			Node Node = list.item(j);
			if(Node.getNodeType() == Node.ELEMENT_NODE){
				String path = Node.getAttributes().item(0).getTextContent();
				String key = Node.getNodeName();
				Class<?> strategy = null;
				try {
					strategy = Class.forName(path);
					
				} catch (ClassNotFoundException e) {
					System.out.println("MERRR");
				}
				
				Strategy strat = (Strategy) strategy.getConstructor().newInstance();
				myFactory.put(key, strat);
				
			}
		}
	}
	
	/**
	 * 
	 */
	@Override
	public void create(Document doc) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		NodeList attackLst = doc.getElementsByTagName(ATTACK_TAG).item(0).getChildNodes();
		NodeList occupyLst = doc.getElementsByTagName(OCCUPY_TAG).item(0).getChildNodes();
		NodeList gatherLst = doc.getElementsByTagName(GATHER_TAG).item(0).getChildNodes();
			
		getSources(attackLst);
		getSources(occupyLst);
		getSources(gatherLst);
	
	}

}
