package vooga.fighter.model.loaders;


import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import vooga.fighter.model.objects.EnvironmentObject;
import vooga.fighter.model.objects.MapObject;
import vooga.fighter.model.utils.UpdatableLocation;


/**
 * 
 * @author alanni, David Le
 * Loads the data to the map object
 */

public class MapLoader extends ObjectLoader {


	private static final String MAP_PATH = "src/vooga/fighter/config/maps.xml";

	private MapObject myMap;
	
	/**
	 * Dummy Constructor only to be used when getting map count
	 */
	public MapLoader(){
		super(MAP_PATH);
	}

	/**
	 * Constructs MapLoader, sets file path using the super constructor, and loads map
	 * @param mapName to be loaded
	 * @param map object which is loaded into
	 */
	public MapLoader (String mapName, MapObject map) {
		super(MAP_PATH);
		myMap = map;
		load(mapName);
	}

	/**
	 * Loads map from xml data
	 * @param mapName to be loaded
	 */
	public void load(String mapName) {
		Document doc = getDocument();
		NodeList mapNodes = doc.getElementsByTagName(getResourceBundle().getString("Map"));
		
		for (int i = 0; i < mapNodes.getLength(); i++) {
			Element node = (Element) mapNodes.item(i);
			String name = getAttributeValue(node, getResourceBundle().getString("MapName"));
			if (mapName.equals(name)) {
				NodeList stateNodes = ((Element) node).getElementsByTagName(getResourceBundle().getString("State"));
				addStates(stateNodes, myMap);
				myMap.setLocation(new UpdatableLocation(Integer.parseInt(getAttributeValue(node, getResourceBundle().getString("XSize")))/2,
						Integer.parseInt(getAttributeValue(node, getResourceBundle().getString("YSize")))/2));
				NodeList startingPosNodes= node.getElementsByTagName(getResourceBundle().getString("StartingPosition"));
				addStartingPositions(startingPosNodes);
				NodeList enviroObjectNodes = node.getElementsByTagName(getResourceBundle().getString("EnvironmentObject"));
				addEnviroObjects(enviroObjectNodes);
			}
		}
	}
	
	
	public List<String> getMapNames(){
		List<String> maps = new ArrayList<String>();
		Document doc = getDocument();
		NodeList mapNodes = doc.getElementsByTagName(getResourceBundle().getString("Map"));
		for (int i = 0; i < mapNodes.getLength(); i++) {
			Element node = (Element) mapNodes.item(i);
			maps.add(getAttributeValue(node, getResourceBundle().getString("MapName")));
		}
		return maps;		
	}

	/**
	 * 
	 * Adds starting position for the characters
	 * @param startingPosNodes NodeList of all starting positions available on a map
	 */
	private void addStartingPositions(NodeList startingPosNodes) {
		for (int i=0; i<startingPosNodes.getLength(); i++){
			Node startingPosition= startingPosNodes.item(i);
			int xCoord= Integer.parseInt(getAttributeValue(startingPosition, getResourceBundle().getString("XCoordinate")));
			int yCoord= Integer.parseInt(getAttributeValue(startingPosition, getResourceBundle().getString("YCoordinate")));
			myMap.addStartPosition(new UpdatableLocation(xCoord,yCoord));
		}
	}

	/**
	 * Creates environment objects based on XML data
	 */
	private void addEnviroObjects(NodeList enviroObjectNodes) {
		for (int i = 0; i < enviroObjectNodes.getLength(); i++) {
			Node enviroObjectNode = enviroObjectNodes.item(i);
			int xCoord= Integer.parseInt(getAttributeValue(enviroObjectNode, getResourceBundle().getString("XCoordinate")));
			int yCoord= Integer.parseInt(getAttributeValue(enviroObjectNode, getResourceBundle().getString("YCoordinate")));
			EnvironmentObject newEnvironmentObject= new EnvironmentObject(getAttributeValue(enviroObjectNode,
					getResourceBundle().getString("EnvironmentObjectName")), new UpdatableLocation(xCoord, yCoord));
			myMap.addEnviroObject(newEnvironmentObject);
		}
	}
}