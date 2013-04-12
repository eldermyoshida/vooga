package vooga.rts.gamedesign.factories;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/** 
 *  This class will be loading an xml file.
 *  
 * @author Ryan Fishel
 * @author Kevin Oh
 * @author Francesco Agosti
 * @author Wenshun Liu 
 */
public class Factory {
	Map<String, Decoder> myDecoders = new HashMap<String, Decoder>();
	
	public Factory() {
		//TODO: a better way to load the decoders to close the class!!!!
		myDecoders.put("Upgrade", new UpgradeDecoder(this));
	}
	
	private void loadDecoder() throws ClassNotFoundException, IllegalArgumentException, SecurityException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		
		String pathName = "vooga.rts.gamedesign.factories.UpgradeDecoder";
		
		Class<?> headClass =
				Class.forName(pathName);
		Decoder temp = (Decoder) headClass.getConstructor(Factory.class).newInstance(this);
	}
	
	public void loadXMLFile(String fileName) {
		try {
			File file = new File(fileName);
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(file);
			doc.getDocumentElement().normalize();
			System.out.println("Root element " + doc.getDocumentElement().getNodeName());
			myDecoders.get(doc.getDocumentElement().getNodeName()).create(doc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IllegalArgumentException, SecurityException, ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		Factory factory = new Factory();
		factory.loadDecoder();
	}

}