package vooga.rts.gamedesign.factories;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import vooga.rts.gamedesign.upgrades.UpgradeTree;

/**
 * This class is an extension of Decoder class that is in charge of the creation
 * of UpgradeTree for upgrade package.
 * 
 * @author Ryan Fishel
 * @author Kevin Oh
 * @author Francesco Agosti
 * @author Wenshun Liu
 *
 */
public class UpgradeDecoder extends Decoder {
	Factory myFactory;
	
	public UpgradeDecoder(Factory factory){
		System.out.println("hahahahahaha");
		myFactory = factory;
	}
	
	/**
	 * Creates the UpgradeTree by receiving Document passed in from
	 * the Factory, containing necessary information related to the
	 * UpgradeTree
	 * 
	 * @param doc the Document passed in from Factory
	 * 
	 */
	public void create(Document doc) {
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
	}
}
