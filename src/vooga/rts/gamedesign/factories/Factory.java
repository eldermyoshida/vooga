package vooga.rts.gamedesign.factories;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/** 
 *  This class will be an abstract class for factories that will be able to
 *  read in from an xml file or some input.  There will be an instance of 
 *  the Facotry in the producer class.  The factories will use reflection to 
 *  load in the information needed.
 *  
 * @author Ryan Fishel
 * @author Kevin Oh
 * @author Francesco Agosti
 * @author Wenshun Liu 
 */
public abstract class Factory {

	public static void main(String[] args) {
		try {
			File file = new File("src/vooga/rts/gamedesign/factories/XML_Sample");
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

	public void create() {
	}

}