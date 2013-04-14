package vooga.fighter.objects;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

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
}
