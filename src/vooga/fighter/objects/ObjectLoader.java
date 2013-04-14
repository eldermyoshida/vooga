package vooga.fighter.objects;

import java.awt.Dimension;
import java.io.File;
import java.util.ResourceBundle;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import vooga.fighter.input.Input;
import vooga.fighter.util.Location;
import vooga.fighter.util.Pixmap;

public abstract class ObjectLoader {
		
	private int[] myMovespeeds;
	private Pixmap[] myImages;
	private Dimension[] myDimensions;
	private File myObjectFile;
	private Document myDocument;
	private Input myInput;
	
	public ObjectLoader (String objectPath) {
		myObjectFile = new File(objectPath);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document myDocument = dBuilder.parse(myObjectFile);
			myDocument.getDocumentElement().normalize();
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
