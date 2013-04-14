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
 * Loads data associated with a character object to be passed to CharacterObject.
 * 
 * @author David Le
 *
 */
public class CharacterLoader extends ObjectLoader {
	
	private static final String CHARACTER_PATH = "src/vooga/fighter/config/characters.xml";
	
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
			int id = Integer.parseInt(getAttributeValue(node, "charID"));
			if (id == charId) {
				String charName = getAttributeValue(node, "charName");
				int maxHealth = Integer.parseInt(getAttributeValue(node, "maxHealth"));
				myChar.setHealth(maxHealth);
				NodeList stateNodes = doc.getElementsByTagName("state");
				NodeList attackNodes = doc.getElementsByTagName("attack");
				addStates(stateNodes);
				addAttacks(attackNodes);
			}
		}
	}
	
	public void addStates(NodeList stateNodes) {
		for (int i = 0; i < stateNodes.getLength(); i++) {
			Element state = (Element) stateNodes.item(i);
			String stateName = getAttributeValue(stateNodes.item(i), "stateName");
			NodeList frameNodes = state.getElementsByTagName("frame");
			State newState = new State(myChar, frameNodes.getLength());
			for (int j = 0; j < frameNodes.getLength(); j++) {
				newState.populateImage(new Pixmap(getAttributeValue(frameNodes.item(j), "image")), j);
				Element frame = (Element) frameNodes.item(j);
				Node hitboxNode = frame.getElementsByTagName("hitbox").item(0);
				newState.populateRectangle(new Rectangle(Integer.parseInt(getAttributeValue(hitboxNode, "cornerX")),
						Integer.parseInt(getAttributeValue(hitboxNode, "cornerY")), Integer.parseInt(getAttributeValue(hitboxNode, "rectX")),
						Integer.parseInt(getAttributeValue(hitboxNode, "rectY"))), j);
			}
			myChar.addState(stateName, newState);
		}
	}
	
	public void addAttacks(NodeList attackNodes) {
		for (int i = 0; i < attackNodes.getLength(); i++) {
			Element attack = (Element) attackNodes.item(i);
			String attackName = getAttributeValue(attackNodes.item(i), "attackName");
			int attackDmg = Integer.parseInt(getAttributeValue(attackNodes.item(i), "damage"));
			NodeList frameNodes = attack.getElementsByTagName("frame");
			AttackObject newAttack = new AttackObject();
			State newState = new State(myChar, frameNodes.getLength());
			newAttack.setPower(attackDmg);
			for (int j = 0; j < frameNodes.getLength(); j++) {
				if (frameNodes.item(j).getAttributes().getNamedItem("image") != null) {
					newState.populateImage(new Pixmap(getAttributeValue(frameNodes.item(j), "image")), j);
				}
				Element frame = (Element) frameNodes.item(j);
				Node attackboxNode = frame.getElementsByTagName("attackbox").item(0);
				newState.populateRectangle(new Rectangle(Integer.parseInt(getAttributeValue(attackboxNode, "cornerX")),
						Integer.parseInt(getAttributeValue(attackboxNode, "cornerY")), Integer.parseInt(getAttributeValue(attackboxNode, "rectX")),
						Integer.parseInt(getAttributeValue(attackboxNode, "rectY"))), j);
			}
			newAttack.addState(attackName, newState);
			myChar.addAttack(attackName, newAttack);
		}
	}
}