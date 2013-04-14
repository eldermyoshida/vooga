package vooga.fighter.objects;

import java.awt.Rectangle;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import vooga.fighter.objects.utils.State;
import vooga.fighter.util.Pixmap;

public class CharacterLoader extends ObjectLoader {
	
	private static final String CHARACTER_PATH = "src/vooga/fighter/config/objects.xml";
	
	private CharacterObject myChar;

	public CharacterLoader (int charId, CharacterObject character) {
		super(CHARACTER_PATH);
		myChar = character;
		load(charId);
	}

	public void load(int charId) {
		Document doc = getDocument();
		NodeList charNodes = doc.getElementsByTagName("character");

		for (int i = 0; i < charNodes.getLength(); i++) {
			Node node = charNodes.item(i);
			int id = Integer.parseInt(node.getAttributes().getNamedItem("charID").getTextContent());
			if (id == charId) {
				String charName = getAttributeValue(node, "charName");
				int maxHealth = Integer.parseInt(getAttributeValue(node, "maxHealth"));
				NodeList stateNodes = doc.getElementsByTagName("state");
				addStates(stateNodes);

			}
		}
	}
	
	public void addStates(NodeList stateNodes) {
		for (int i = 0; i < stateNodes.getLength(); i++) {
			Element state = (Element) stateNodes.item(i);
			NodeList frameNodes = getDocument().getElementsByTagName("frame");
			for (int j = 0; j < frameNodes.getLength(); j++) {
				State newState = new State(myChar, frameNodes.getLength());
				newState.populateImage(new Pixmap(getAttributeValue(frameNodes.item(j), "image")), j);
				Node hitboxNode = frameNodes.item(j).getFirstChild();
				newState.populateRectangle(new Rectangle(Integer.parseInt(getAttributeValue(hitboxNode, "cornerX")),
						Integer.parseInt(getAttributeValue(hitboxNode, "cornerY")), Integer.parseInt(getAttributeValue(hitboxNode, "rectX")),
						Integer.parseInt(getAttributeValue(hitboxNode, "rectY"))), j);
			}
		}
	}
}