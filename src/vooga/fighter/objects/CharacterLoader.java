package vooga.fighter.objects;

import java.awt.Rectangle;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import vooga.fighter.objects.utils.State;
import vooga.fighter.objects.utils.UpdatableLocation;
import util.Pixmap;
/**
 * 
 * @author Dayvid, Alan
 *
 */
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
				myChar.setHealth(maxHealth);
				NodeList stateNodes = ((Element) node).getElementsByTagName("state");
				addStates(stateNodes, myChar);
			}
		}
	}
	
}