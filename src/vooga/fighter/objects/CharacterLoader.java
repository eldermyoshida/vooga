package vooga.fighter.objects;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class CharacterLoader extends ObjectLoader {
	
	private static final String CHARACTER_PATH = "src/vooga/fighter/config/objects.xml";

	public CharacterLoader (int charId) {
		super(CHARACTER_PATH);
		load(charId);
	}

	public void load(int charId) {
		Document doc = super.getDocument();
		NodeList charNodes = doc.getElementsByTagName("character");

		for (int i = 0; i < charNodes.getLength(); i++) {
			Node node = charNodes.item(i);
			int id = Integer.parseInt(node.getAttributes().getNamedItem("charID").getTextContent());
			if (id == charId) {
				String charName = getAttributeValue(node, "charName");
				int maxHealth = Integer.parseInt(getAttributeValue(node, "maxHealth"));
				NodeList stateNodes = doc.getElementsByTagName("state");
				for (int j = 0; j < stateNodes.getLength(); j++) {
					Element state = (Element) stateNodes.item(i);

				}

			}
		}
	}
}