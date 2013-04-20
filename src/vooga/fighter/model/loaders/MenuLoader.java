package vooga.fighter.model.loaders;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import util.Pixmap;
import vooga.fighter.model.objects.MenuObject;
import vooga.fighter.model.utils.State;

public class MenuLoader extends ObjectLoader {

	private static final String MENU_PATH = "src/vooga/fighter/config/menu.xml";
	
	MenuObject myMenuObject;
	public MenuLoader(String menuobjectname, MenuObject menuobject) {
		super(MENU_PATH);
		myMenuObject = menuobject;
		load(menuobjectname);
	}

	public void load(String menuobjectname) {
		Document doc = getDocument();
		NodeList menuNodes = doc.getElementsByTagName("menuobject");
		for (int i = 0; i < menuNodes.getLength(); i++) {
			Element node = (Element) menuNodes.item(i);
			String name = getAttributeValue(node, "menuobjectname");
			if (name.equals(menuobjectname)) {
				NodeList states = node.getElementsByTagName("state");
				for(int j = 0; j < states.getLength(); j++){
				Element state = (Element) states.item(j);
				String  stateName = getAttributeValue(state, "name");
				myMenuObject.setValue(stateName);
				String nextStateName = getAttributeValue(state, "nextState");
				myMenuObject.setNext(nextStateName);
				System.out.println("<menuloader>: " + nextStateName);
				NodeList frames = node.getElementsByTagName("frame");
				State newState = new State(myMenuObject, frames.getLength());
				for(int k = 0; k < frames.getLength(); k++){
					Element node1 = (Element) frames.item(k);
					String imagepathway = getAttributeValue(node1, "image");
					newState.populateImage(new Pixmap(imagepathway), k);
				}
				myMenuObject.addState(stateName, newState);
				if(j == 0) myMenuObject.setCurrentState(stateName);
				}
			}

		}
	}
	
	
	@Deprecated
	public void load(int id) {
		// TODO Auto-generated method stub

	}

}
