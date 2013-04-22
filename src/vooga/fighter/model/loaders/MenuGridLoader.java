package vooga.fighter.model.loaders;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import util.Location;
import vooga.fighter.controller.GameManager;
import vooga.fighter.model.MenuGrid;
import vooga.fighter.model.MenuMode;
import vooga.fighter.model.objects.MenuObject;
import vooga.fighter.model.utils.State;
import vooga.fighter.model.utils.UpdatableLocation;

public class MenuGridLoader extends ObjectLoader {


	private static final String MENUGRID_PATH = "src/vooga/fighter/config/menugrid.xml";
	private static final int FOUR_TICKS = 4;

	private List<MenuObject> myMenuObjects;
	private MenuMode myDelegate;
	private MenuObject myObject;

	public MenuGridLoader (String menuname, MenuGrid grid, MenuMode delegate) {
		super(MENUGRID_PATH);
		myDelegate = delegate;
		myMenuObjects = new ArrayList<MenuObject>();
		load(menuname);
		System.out.println("<menugridloader.java><menugridloader> "+ myMenuObjects);
	}

	/**
	 * Loads map from xml data
	 */
	protected void load(String menuname) {
		Document doc = getDocument();
		NodeList menugridNodes = doc.getElementsByTagName("menumode");
		for (int i = 0; i < menugridNodes.getLength(); i++) {
			Element node = (Element) menugridNodes.item(i);
			String name = getAttributeValue(node, "menuname");
			if (name.equals(menuname)) {
				NodeList menuobjects = node.getElementsByTagName("menuobject");
				for(int j = 0; j < menuobjects.getLength(); j++){
					Element node1 = (Element) menuobjects.item(j);
					String MenuObjectName = getAttributeValue(node1, "menuobjectname");
					MenuObject menuobject = new MenuObject(MenuObjectName, myDelegate);
					if(j==0) myObject = menuobject;
					int xCoord = Integer.parseInt(getAttributeValue(node1, "xCoord"));
					int yCoord = Integer.parseInt(getAttributeValue(node1, "yCoord"));
					menuobject.setLocation(new UpdatableLocation(xCoord, yCoord));
					String nextStateName = getAttributeValue(node1, "nextState");
					menuobject.setNext(nextStateName);
					int xSize = Integer.parseInt(getAttributeValue(node1, "xSize"));
					int ySize = Integer.parseInt(getAttributeValue(node1, "ySize"));
					for(Object s : menuobject.getStates().values()){
						State state = (State) s;
						for(int k =0; k< state.getNumFrames(); k++){
						Dimension size = new Dimension(xSize,ySize);
						state.populateSize(size, k);
						Rectangle rect = new Rectangle(xSize,ySize);
						state.populateRectangle(rect, k);
						state.resetBounds(new Location(xCoord,yCoord));
						state.populateAllDelays(FOUR_TICKS);
						}
					}
					int gridnum = Integer.parseInt(getAttributeValue(node1, "gridnum"));
					menuobject.setNum(gridnum);
					int up = Integer.parseInt(getAttributeValue(node1, "up"));
					menuobject.setUp(up);
					int down = Integer.parseInt(getAttributeValue(node1, "down"));
					menuobject.setDown(down);
					int left = Integer.parseInt(getAttributeValue(node1, "left"));
					menuobject.setLeft(left);
					int right = Integer.parseInt(getAttributeValue(node1, "right"));
					menuobject.setRight(right);
					myMenuObjects.add(menuobject);
				}
		}
	}
	
	}
	
	public List<MenuObject> getMenuObjects(){
		return myMenuObjects;
	}
	
	public MenuObject getFirstMenuObject(){
		return myObject;
	}

	@Deprecated
	public void load(int id) {
		// Using a String	
	}
	
	
}

