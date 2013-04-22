package vooga.fighter.model.loaders;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import vooga.fighter.model.ModelConstants;
import vooga.fighter.model.objects.AttackObject;
import vooga.fighter.model.objects.CharacterObject;
import vooga.fighter.model.utils.State;

/**
 * Loads data associated with a character object to be passed to CharacterObject.
 * 
 * @author David Le, alanni
 *
 */
public class CharacterLoader extends ObjectLoader {
	
	private static final String CHARACTER_PATH = "src/vooga/fighter/config/characters.xml";
	
	private CharacterObject myChar;

	/**
	 * Constructs the character loader with the id to be loaded and the character which the
	 * loader will modify.
	 * @param charId
	 * @param character
	 */
	public CharacterLoader (String charName, CharacterObject character) {
		super(CHARACTER_PATH);
		myChar = character;
		load(charName);
	}

	/**
	 * Loads the character associated with the id
	 * @param charId is the id of the character to be loaded
	 */
	protected void load(String charName) {
		Document doc = getDocument();
		NodeList charNodes = doc.getElementsByTagName("character");

		for (int i = 0; i < charNodes.getLength(); i++) {
			Node node = charNodes.item(i);
			String name = getAttributeValue(node, "charID");
			if (charName.equals(name)) {
				int maxHealth = Integer.parseInt(getAttributeValue(node, "maxHealth"));
				int speed= Integer.parseInt(getAttributeValue(node, "movespeed"));
				myChar.addProperty("speed", speed);
				myChar.setHealth(maxHealth);
				NodeList stateNodes = ((Element) node).getElementsByTagName("state");
				addStates(stateNodes, myChar);
				NodeList attackNodes = ((Element) node).getElementsByTagName("attack");
				addAttacks(attackNodes);
			}
		}
	}
	
	/**
	 * Loads and adds attacks to the list of attacks that a character can perform
	 * @param attackNodes
	 */
	private void addAttacks(NodeList attackNodes) {
		for (int i = 0; i < attackNodes.getLength(); i++) {
			Element attack = (Element) attackNodes.item(i);
			String attackName = getAttributeValue(attackNodes.item(i), "attackName");
			int attackDmg = Integer.parseInt(getAttributeValue(attackNodes.item(i), "damage"));
			int attackDuration = Integer.parseInt(getAttributeValue(attackNodes.item(i), "duration"));
			int attackSpeed = Integer.parseInt(getAttributeValue(attackNodes.item(i), "speed"));
			NodeList frameNodes = attack.getElementsByTagName("frame");
			AttackObject newAttack = new AttackObject();
			State newState = new State(myChar, frameNodes.getLength());
			newAttack.addProperty(ModelConstants.ATTACK_PROPERTY_SPEED, attackSpeed);
			newAttack.addProperty(ModelConstants.ATTACK_PROPERTY_POWER, attackDmg);
			newAttack.addProperty(ModelConstants.ATTACK_PROPERTY_DURATION, attackDuration);
			getImageAndHitboxProperties(frameNodes, newState);
			newAttack.addState(attackName, newState);
			newAttack.setCurrentState(attackName);
			myChar.addAttack(attackName, newAttack);
		}
	}
}