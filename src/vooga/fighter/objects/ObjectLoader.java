package vooga.fighter.objects;

import java.awt.Rectangle;
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import util.Pixmap;
import vooga.fighter.objects.utils.State;

/**
 * 
 * @author Dayvid, alanni
 *
 */
public abstract class ObjectLoader {
		
	private File myObjectFile;
	private Document myDocument;
	
	public ObjectLoader (String objectPath) {
		myObjectFile = new File(objectPath);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			myDocument = dBuilder.parse(myObjectFile);
			myDocument.getDocumentElement().normalize();
		} catch (Exception e) {
			myDocument = null;
			e.printStackTrace();
		}
	}

	public abstract void load(int id);
	
	public Document getDocument() {
		return myDocument;
	}
	
	public String getAttributeValue(Node node, String tag) {
		return node.getAttributes().getNamedItem(tag).getTextContent();
	}
	
	public String getChildValue(String tag, Element element) {
		NodeList nodes = element.getElementsByTagName(tag).item(0).getChildNodes();
		Node node = (Node) nodes.item(0);
		return node.getNodeValue();
	}
	
	public void addStates(NodeList stateNodes, GameObject myObject) {
		for (int i = 0; i < stateNodes.getLength(); i++) {
			Element state = (Element) stateNodes.item(i);
			String stateName = getAttributeValue(stateNodes.item(i), "stateName");
			NodeList frameNodes = state.getElementsByTagName("frame");
			for (int j = 0; j < frameNodes.getLength(); j++) {
				State newState = new State(myObject, frameNodes.getLength());
				newState.populateImage(new Pixmap(getAttributeValue(frameNodes.item(j), "image")), j);
				Element frame = (Element) frameNodes.item(j);
				Node hitboxNode = frame.getElementsByTagName("hitbox").item(0);
				newState.populateRectangle(new Rectangle(Integer.parseInt(getAttributeValue(hitboxNode, "cornerX")),
						Integer.parseInt(getAttributeValue(hitboxNode, "cornerY")), Integer.parseInt(getAttributeValue(hitboxNode, "rectX")),
						Integer.parseInt(getAttributeValue(hitboxNode, "rectY"))), j);
				myObject.addState(stateName, newState);
			}
		}
	}
}
