package vooga.rts.gamedesign.factories;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import vooga.rts.gamedesign.upgrades.UpgradeTree;

/**
 * This class is an extension of Factory class that reads from an XML file to
 * create UpgradeTree.
 * 
 * @author Ryan Fishel
 * @author Kevin Oh
 * @author Francesco Agosti
 * @author Wenshun Liu
 *
 */
public class UpgradeFactory extends Factory {
	
	public UpgradeFactory() throws IllegalArgumentException, SecurityException,
			ClassNotFoundException, InstantiationException,
			IllegalAccessException, InvocationTargetException,
			NoSuchMethodException, ParserConfigurationException, SAXException,
			IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Creates the UpgradeTree by loadig the XML file.
	 */
	public void create() {
		UpgradeTree upgradeTree = new UpgradeTree();
	}
	
	/**
	 * Loads the XML file. Creates and adds UpgradeNode into the tree
	 */
	public void load(String fileName){
		//TODO: need to refactor!!!! DUPLICATED CODE!!!!
		//TODO: XML can take even simpler format
		try {
			File file = new File(fileName);
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(file);
			doc.getDocumentElement().normalize();
			System.out.println("Root element " + doc.getDocumentElement().getNodeName());
			NodeList nodeLst = doc.getElementsByTagName("type");
			System.out.println("Information of all upgrades");

			for (int i = 0; i < nodeLst.getLength(); i++) {

				Element typeElmnt = (Element) nodeLst.item(i);
				NodeList nameElmntLst = typeElmnt.getElementsByTagName("name");
				Element nameElmnt = (Element) nameElmntLst.item(0);
				NodeList name = nameElmnt.getChildNodes();
				System.out.println("name : "  + ((Node) name.item(0)).getNodeValue());
				NodeList upgradeNodeList = typeElmnt.getElementsByTagName("upgradeNode");
				for (int j=0; j<upgradeNodeList.getLength(); ++j) {
					Element upgradeNodeElement = (Element) upgradeNodeList.item(j);
					
					NodeList idNodeElmntLst = upgradeNodeElement.getElementsByTagName("id");
					Element idNodeElmnt = (Element) idNodeElmntLst.item(0);
					NodeList id = idNodeElmnt.getChildNodes();
					System.out.println("id : " + ((Node) id.item(0)).getNodeValue());
					
					NodeList nodeNameElmntLst = upgradeNodeElement.getElementsByTagName("nodeName");
					Element nodeNameElmnt = (Element) nodeNameElmntLst.item(0);
					NodeList nodeName = nodeNameElmnt.getChildNodes();
					System.out.println("upgrade name : " + ((Node) nodeName.item(0)).getNodeValue());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		UpgradeFactory upgradeFactory = null;
		try {
			upgradeFactory = new UpgradeFactory();
		} catch (IllegalArgumentException | SecurityException
				| ClassNotFoundException | InstantiationException
				| IllegalAccessException | InvocationTargetException
				| NoSuchMethodException | ParserConfigurationException
				| SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		upgradeFactory.load("src/vooga/rts/gamedesign/factories/XML_Sample");
	}
}
