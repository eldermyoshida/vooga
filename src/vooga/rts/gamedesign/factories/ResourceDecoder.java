package vooga.rts.gamedesign.factories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import vooga.rts.gamedesign.sprite.rtsprite.*;;

public class ResourceDecoder extends Decoder{

	private static final String TYPE_TAG = "resource";
	private static final String NAME_TAG = "name";
	private static final String IMAGE_TAG = "img";
	
	private Factory myFactory;
	
	
	public ResourceDecoder(Factory factory){
		myFactory = factory;
	}
		
	@Override
	public Map<String,Resource> create(Document doc) {
		Map<String,Resource> resources = new HashMap<String,Resource>();
		
		NodeList nodeLst = doc.getElementsByTagName(TYPE_TAG);
		
		for(int i = 0 ; i < nodeLst.getLength() ; i++){
			Node nNode = nodeLst.item(i);
			
			Element eElement = (Element) nNode;
			System.out.println("Type:" + eElement.getNodeName());
			System.out.println("Name: " + eElement.getElementsByTagName(NAME_TAG).item(0).getTextContent());
			System.out.println("Img: " + eElement.getElementsByTagName(IMAGE_TAG).item(0).getTextContent());
			
			
		}
		
		
		
		
		
		return resources;
		
	}
	
	

}
