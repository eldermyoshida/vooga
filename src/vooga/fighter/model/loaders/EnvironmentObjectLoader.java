package vooga.fighter.model.loaders;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import vooga.fighter.model.objects.EnvironmentObject;

/**
 * Loads data associated with a environment object to be passed to EnvironmentObject.
 * 
 * @author alanni, David Le
 *
 *
 */
public class EnvironmentObjectLoader extends ObjectLoader {

	private static final String ENVIRONMENT_OBJECT_PATH = "src/vooga/fighter/config/environmentobjects.xml";
	
	private EnvironmentObject myEnvironmentObject;

	/**
	 * Constructs the environment object loader with the id to be loaded and the environment object which the
	 * loader will modify.
	 */
	public EnvironmentObjectLoader (String enviroObjectName, EnvironmentObject enviroObject) {
		super(ENVIRONMENT_OBJECT_PATH);
		myEnvironmentObject = enviroObject;
		load(enviroObjectName); 
	}
	
	/**
	 * Loads the environment object associated with the id
	 */
	protected void load(String enviroObjectName) {
		Document doc = getDocument();
		NodeList enviroObjectNodes = doc.getElementsByTagName(getResourceBundle().getString("EnvironmentObject"));
		for (int i = 0; i < enviroObjectNodes.getLength(); i++) {
			Node enviroObjectNode = enviroObjectNodes.item(i);
			String name = getAttributeValue(enviroObjectNode, getResourceBundle().getString("EnvironmentObjectName"));
			if (enviroObjectName.equals(name)) {
				NodeList stateNodes = ((Element) enviroObjectNode).getElementsByTagName(getResourceBundle().getString("State"));
				addStates(stateNodes, myEnvironmentObject);
			}
		}
	}
}
