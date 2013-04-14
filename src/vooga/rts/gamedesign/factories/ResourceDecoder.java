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
	
	private static final String HEAD_TAG = "resources";
	private static final String TYPE_TAG = "resource";
	private static final String NAME_TAG = "name";
	private static final String IMAGE_TAG = "img";
	private static final String SOURCE_TAG = "src";
	
	private Factory myFactory;
	
	
	public ResourceDecoder(Factory factory){
		myFactory = factory;
	}
		
	@Override
	public void create(Document doc) {
		String path = doc.getElementsByTagName(HEAD_TAG).item(0).getAttributes().getNamedItem(SOURCE_TAG).getTextContent();
		NodeList nodeLst = doc.getElementsByTagName(TYPE_TAG);
		
		for(int i = 0 ; i < nodeLst.getLength() ; i++){
			Node nNode = nodeLst.item(i);
			
			NodeList children = nNode.getChildNodes();
			for(int j = 0 ; j < children.getLength() ; j++){
				Node current = children.item(j);
				if(current.getNodeType() == Node.ELEMENT_NODE){
					System.out.println(current.getNodeName() + " : " + current.getTextContent());
				}
			}	
		}
		
		
	}
	
	

}
