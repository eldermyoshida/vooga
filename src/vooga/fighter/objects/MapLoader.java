package vooga.fighter.objects;


import java.awt.Rectangle;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import vooga.fighter.game.Map;
import vooga.fighter.objects.utils.State;
import vooga.fighter.objects.utils.UpdatableLocation;
import util.Pixmap;

/**
 * 
 * @author alanni
 * Loads the data to the map
 */

public class MapLoader extends ObjectLoader {
	

	private static final String CHARACTER_PATH = "src/vooga/fighter/config/maps.xml";
	
	private Map myMap;

	public MapLoader (int mapId, Map map) {
		super(CHARACTER_PATH);
		myMap = map;
		myMap.initialize();
		load(mapId);
	}

	public void load(int mapId) {
		Document doc = getDocument();
		NodeList mapNodes = doc.getElementsByTagName("map");

		for (int i = 0; i < mapNodes.getLength(); i++) {
			Node node = mapNodes.item(i);
			int id = Integer.parseInt(getAttributeValue(node, "enviroId"));
			if (id == mapId) {
				String mapPath = getAttributeValue(node, "charBackground");
				myMap.setBackground(mapPath);
				NodeList enviroObjectNodes = doc.getElementsByTagName("enviroObject");
				addEnviroObjects(enviroObjectNodes);
			}
		}
	}
	
	public void addEnviroObjects(NodeList enviroObjectNodes) {
		for (int i = 0; i < enviroObjectNodes.getLength(); i++) {
			Node environmentObject = enviroObjectNodes.item(i);
			String imagePath= getAttributeValue(environmentObject, "image");
			int xCoord= Integer.parseInt(getAttributeValue(environmentObject, "xCoord"));
			int yCoord= Integer.parseInt(getAttributeValue(environmentObject, "yCoord"));
			EnvironmentObject toAdd= new EnvironmentObject();
			
		}
	}
}