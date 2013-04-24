package vooga.fighter.model;

import java.util.ArrayList; 
import java.util.List;

import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import util.XMLTool;
import vooga.fighter.model.loaders.MapLoader;
import vooga.fighter.model.objects.EnvironmentObject;
import vooga.fighter.model.objects.MapObject;
import vooga.fighter.model.utils.UpdatableLocation;


/**
 * Class used to write out all essential map information to an xml file
 * @author matthewparides
 *
 */
public class MapWriter {
	private static final String INPUT_PATHWAY = "vooga.fighter.config.maps";
	private MapObject myWriteSource;
	private ArrayList<String> myWriteOutLines;
	private XMLTool myXMLWriter;
	private Element myFakeRoot; 
	private Element myRoot;
	private String mySoundFilePath;
	private List<String> myBackgroundFilePaths;
	
	/**
	 * constructor
	 * @param map
	 * @param soundFilePath
	 * @param backgroundFilePaths
	 */
	public MapWriter(MapObject map, String soundFilePath, List<String> backgroundFilePaths) {
		myWriteSource = map;
		myXMLWriter = new XMLTool();
		myBackgroundFilePaths = backgroundFilePaths;
	}
	
	/**
	 * writes the data in the myWriteSource map to an xml file
	 */
	public void writeMap() {
		myXMLWriter.makeDoc();
		String name = myWriteSource.getName();
		List<UpdatableLocation> startingPos = myWriteSource.getStartPositions();
		List<EnvironmentObject> enviroObjects = myWriteSource.getEnviroObjects();
		//start writeout
		writeMapHeader();
		for(UpdatableLocation loc: startingPos) {
			writeStartPos(loc);
		}
		writeStates();
		for(EnvironmentObject enviro: enviroObjects) {
			writeEnvironmentObject(enviro);
		}
		writeToFile();
	}
	
	/**
	 * writes the starting positions of the map to xml nodes
	 * includes coordinates.
	 * @param loc
	 */
	private void writeStartPos(UpdatableLocation loc) {
		Element elem = myXMLWriter.makeElement("startingPos");
		elem.setAttribute("yCoord", "" + loc.getLocation().getY());
		elem.setAttribute("xCoord", "" + loc.getLocation().getX());
		myXMLWriter.addChild(myRoot, elem);
		
	}
	
	/**
	 * writes the environment objects to xml nodes
	 * environment nodes include coordinate data and the object name
	 * @param enviro - the environmentobject to write
	 */
	private void writeEnvironmentObject(EnvironmentObject enviro) {
		Element elem = myXMLWriter.makeElement("environtmentObject");
		elem.setAttribute("yCoord", "" + enviro.getLocation().getLocation().getY());
		elem.setAttribute("xCoord", "" + enviro.getLocation().getLocation().getX());
		elem.setAttribute("objectName", enviro.getName());
		myXMLWriter.addChild(myRoot, elem);
	}
	
	/**
	 * writes the map header info to an xml node
	 * the map header includes the map name and the dimensions.
	 */
	private void writeMapHeader() {
		myRoot = myXMLWriter.makeRoot("map");
		myRoot.setAttribute("ySize", "871");
		myRoot.setAttribute("xSize", "1024");
		myRoot.setAttribute("mapName", myWriteSource.getName());
	}
	
	/**
	 * writes the image states data to xml nodes
	 */
	private void writeStates() {
		Element stateHead = myXMLWriter.makeElement("state");
		stateHead.setAttribute("stateName", "background");
		myXMLWriter.addChild(myRoot, stateHead);
		for(String str: myBackgroundFilePaths) {
			Element background = myXMLWriter.makeElement("frame");
			background.setAttribute("image", str);
			myXMLWriter.addChild(stateHead, background);
		}
	}
	
	/**
	 * writes the map's generated xml nodes to the map.xml file.
	 * If the map already exists, overwrites that data, if not, adds a new map.
	 */
	private void writeToFile() {
		MapLoader loader = new MapLoader();
		boolean overwrote = false;
		Document doc = loader.getDocument();
		Element root = doc.getDocumentElement();
		NodeList mapNodes = doc.getElementsByTagName("map");
		for (int i = 0; i < mapNodes.getLength(); i++) {
			Element node = (Element) mapNodes.item(i);
			String name = loader.getAttributeValue(node, "mapName");
			if(name.equals(myWriteSource.getName())) {
				node.getParentNode().removeChild(node);
			}
		}
		root.appendChild(myRoot);
	}
}