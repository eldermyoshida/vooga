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

	public void load() {
		try {
			File file = new File("src/vooga/rts/gamedesign/factory/XML_Sample");
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(file);
			doc.getDocumentElement().normalize();
			System.out.println("Root element " + doc.getDocumentElement().getNodeName());
			NodeList nodeLst = doc.getElementsByTagName("Upgrade");
			System.out.println("Information of all employees");

			for (int s = 0; s < nodeLst.getLength(); s++) {

				Node fstNode = nodeLst.item(s);

				if (fstNode.getNodeType() == Node.ELEMENT_NODE) {

					Element fstElmnt = (Element) fstNode;
					NodeList fstNmElmntLst = fstElmnt.getElementsByTagName("firstname");
					Element fstNmElmnt = (Element) fstNmElmntLst.item(0);
					NodeList fstNm = fstNmElmnt.getChildNodes();
					System.out.println("First Name : "  + ((Node) fstNm.item(0)).getNodeValue());
					NodeList lstNmElmntLst = fstElmnt.getElementsByTagName("lastname");
					Element lstNmElmnt = (Element) lstNmElmntLst.item(0);
					NodeList lstNm = lstNmElmnt.getChildNodes();
					System.out.println("Last Name : " + ((Node) lstNm.item(0)).getNodeValue());
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void create() {
	}

}