package vooga.rts.gamedesign.factories;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class StrategyDecoder extends Decoder{

	public static final String ATTACK_TAG = "attacks";
	public static final String OCCUPY_TAG = "occupys";
	public static final String GATHER_TAG = "gathers";
	public static final String SOURCE = "src";
	
	
	Factory myFactory;
	
	public StrategyDecoder(Factory factory){
		myFactory = factory;
	}
	
	
	private void getSources(NodeList list){
		for(int j = 0 ; j < list.getLength() ; j++ ){
			Node Node = list.item(j);
			if(Node.getNodeType() == Node.ELEMENT_NODE){
				System.out.println("Name : " + Node.getNodeName());
				System.out.println("src : " + Node.getAttributes().item(0).getTextContent());
			}
		}
	}
	
	@Override
	public <T> T create(Document doc) {
		NodeList attackLst = doc.getElementsByTagName(ATTACK_TAG).item(0).getChildNodes();
		NodeList occupyLst = doc.getElementsByTagName(OCCUPY_TAG).item(0).getChildNodes();
		NodeList gatherLst = doc.getElementsByTagName(GATHER_TAG).item(0).getChildNodes();
			
		getSources(attackLst);
		getSources(occupyLst);
		getSources(gatherLst);
		
		return null;
	}

}
