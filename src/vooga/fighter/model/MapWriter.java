package vooga.fighter.model;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;

import vooga.fighter.model.objects.EnvironmentObject;
import vooga.fighter.model.objects.MapObject;
import vooga.fighter.model.utils.UpdatableLocation;
import vooga.towerdefense.util.XMLTool;


/**
 * Class used to write out map objects to the specific xml format used by the model team.
 * @author matthewparides
 *
 */
public class MapWriter {
	private static final String INPUT_PATHWAY = "vooga.fighter.config.maps";
	private MapObject myWriteSource;
	private ArrayList<String> myWriteOutLines;
	private XMLTool myXMLWriter;
	private Element myRoot;
	private String mySoundFilePath;
	private String myBackgroundFilePath;
	
	public MapWriter(MapObject map, String soundFilePath, String backgroundFilePath) {
		myWriteSource = map;
		myXMLWriter = new XMLTool();
	}
	
	public void writeMap() {
		myXMLWriter.makeDoc();
		myRoot = myXMLWriter.makeRoot("mapStart");
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
		//myWriteOutLines.add("</map>");
		String writeOut = myXMLWriter.translateToXMLString(myXMLWriter.getDoc());
		
		
	}
	
	private void writeStartPos(UpdatableLocation loc) {
		myXMLWriter.addChild(myRoot, "startingPos", "xCoord=\"" + 
				loc.getLocation().getX() + "\" yCoord=\"" + loc.getLocation().getY() + "\"");
	}
	
	private void writeEnvironmentObject(EnvironmentObject enviro) {
		myXMLWriter.addChild(myRoot, "environmentObject", "objectName=\"" + 
				enviro.getName() + "\" xCoord=\"" + enviro.getLocation().getLocation().getX() 
				+ "\" yCoord=\"" + enviro.getLocation().getLocation().getY() + "\"");
	}
	
	private void writeMapHeader() {
		myXMLWriter.addChild(myRoot, myXMLWriter.makeElement("map", "mapName=\"" + myWriteSource.getName() + "\" " +
				"xSize=\"1024\" ySize=\"871\""));
	}
	
	private String writeStates() {
		Element stateHead = myXMLWriter.makeElement("state","stateName = \"background\"");
		myXMLWriter.addChild(myRoot, stateHead);
		Element background = myXMLWriter.makeElement("frame", "image = \"" + 
				myBackgroundFilePath + "\"");
		myXMLWriter.addChild(stateHead, background);
		return "<state stateName = \"background\">";
	}

}
/*
<map mapName="RainbowBackground" xSize="1024" ySize="871">
<startingPos xCoord="140" yCoord="300"/>
<startingPos xCoord="200" yCoord="300"/>
<state stateName = "background">
    <frame image = "fighter/images/RainbowBackground.jpeg" />
</state>
<environmentObject objectName="platform" xCoord="300" yCoord="300" />
</map>
*/