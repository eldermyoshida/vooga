package vooga.fighter.objects;

import java.awt.Dimension;
import java.io.File;
import java.util.ResourceBundle;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import vooga.fighter.input.Input;
import vooga.fighter.util.Location;
import vooga.fighter.util.Pixmap;

public class ObjectLoader {
	
	private static final String OBJECTS_PATH = "src/vooga/fighter/config/objects.xml";
	
	private int[] myMovespeeds;
	private Pixmap[] myImages;
	private Dimension[] myDimensions;
	private File myObjectFile;
	private Input myInput;
	
	public ObjectLoader (Input input) {
		myImages = new Pixmap[10];
		myMovespeeds = new int[10];
		myDimensions = new Dimension[10];
		myObjectFile = new File(OBJECTS_PATH);
		myInput = input;
		loadChar(1, new Location(100, 100));
	}

	public void loadChar(int charid, Location center) {
		try {

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(myObjectFile);
			doc.getDocumentElement().normalize();

			NodeList charNodes = doc.getElementsByTagName("character");

			for (int i = 0; i < charNodes.getLength(); i++) {
				Node node = charNodes.item(i);
				int id = Integer.parseInt(node.getAttributes().getNamedItem("charID").getTextContent());
				if (id == charid) {
					String charName = getAttributeValue(node, "charName");
					int maxHealth = Integer.parseInt(getAttributeValue(node, "maxHealth"));
					NodeList stateNodes = doc.getElementsByTagName("state");
					for (int j = 0; j < stateNodes.getLength(); j++) {
						Element state = (Element) stateNodes.item(i);
						
					}
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private String getAttributeValue(Node node, String tag) {
		return node.getAttributes().getNamedItem(tag).getTextContent();
	}
	
	private String getChildValue(String tag, Element element) {
		NodeList nodes = element.getElementsByTagName(tag).item(0).getChildNodes();
		Node node = (Node) nodes.item(0);
		return node.getNodeValue();
	}
	
	public static void main (String[] args) {
		ObjectLoader o = new ObjectLoader(null);
	}
}
