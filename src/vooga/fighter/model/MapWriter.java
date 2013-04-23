package vooga.fighter.model;

import java.util.ArrayList;
import java.util.List;

import vooga.fighter.model.objects.EnvironmentObject;
import vooga.fighter.model.objects.MapObject;
import vooga.fighter.model.utils.UpdatableLocation;


/**
 * Class used to write out map objects to the specific xml format used by the model team.
 * @author matthewparides
 *
 */
public class MapWriter {
	private static final String INPUT_PATHWAY = "vooga.fighter.config.maps";
	private MapObject myWriteSource;
	private ArrayList<String> myWriteOutLines;
	
	public MapWriter(MapObject map) {
		myWriteSource = map;
	}
	
	public void writeMap() {
		String name = myWriteSource.getName();
		List<UpdatableLocation> startingPos = myWriteSource.getStartPositions();
		List<EnvironmentObject> enviroObjects = myWriteSource.getEnviroObjects();
		//start writeout
		myWriteOutLines.add(writeMapHeader());
		for(UpdatableLocation loc: startingPos) {
			myWriteOutLines.add(writeStartPosString(loc));
		}
		//writing state information
		myWriteOutLines.add(writeStateHeader());
		myWriteOutLines.add("    " + writeBackgroundImage());
		myWriteOutLines.add("</state>");
		//finish state information
		for(EnvironmentObject enviro: enviroObjects) {
			myWriteOutLines.add(writeEnvironmentObjectString(enviro));
		}
		myWriteOutLines.add("</map>");
		
		
	}
	
	private String writeStartPosString(UpdatableLocation loc) {
		String str = "<startingPos xCoord=";
		str += "\"" + loc.getLocation().getX() + "\" yCoord=\"" + loc.getLocation().getY() + "\"/>";
		return str;
	}
	
	private String writeEnvironmentObjectString(EnvironmentObject enviro) {
		String str = "<environmentObject objectName=\"";
		str += enviro.getName() + "\" xCoord=\"" + enviro.getLocation().getLocation().getX() 
				+ "\" yCoord=\"" + enviro.getLocation().getLocation().getY() + "\" />";
		return str;
	}
	
	private String writeMapHeader() {
		String str = "<map mapName=\"";
		str += myWriteSource.getName() + "\" xSize=\"1024\" ySize=\"871\">";
		return str;
	}
	
	private String writeStateHeader() {
		return "<state stateName = \"background\">";
	}
	
	private String writeBackgroundImage() {
		String str = "<frame image = \"fighter/images/" + myWriteSource.getName() + ".jpeg\" />";
		return str;
	}
	
	private String writeBackgroundImage(String filePath) {
		String str = "<frame image = \"" + filePath + "\" />";
		return str;
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