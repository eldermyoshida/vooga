package vooga.rts.gamedesign.factories;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/** 
 *  This class will be loading an xml file.
 *  
 * @author Ryan Fishel
 * @author Kevin Oh
 * @author Francesco Agosti
 * @author Wenshun Liu 
 */
public class Factory {
	public static final String DECODER_MATCHING_FILE = "src/vooga/rts/gamedesign/factories/DecodeMatchUp";
	
	Map<String, Decoder> myDecoders = new HashMap<String, Decoder>();
	
	public Factory() throws IllegalArgumentException, SecurityException, ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, ParserConfigurationException, SAXException, IOException {
		myDecoders = new HashMap<String, Decoder>();
		loadDecoder(DECODER_MATCHING_FILE);
	}
	
	private void loadDecoder(String fileName) throws ClassNotFoundException, IllegalArgumentException, SecurityException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, ParserConfigurationException, SAXException, IOException {
		File file = new File(fileName);
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(file);
		doc.getDocumentElement().normalize();
		
		NodeList nodeLst = doc.getElementsByTagName("pair");
		
		for (int i = 0; i < nodeLst.getLength(); i++) {
			Element pairElmnt = (Element) nodeLst.item(i);
			
			Element typeElmnt = (Element)pairElmnt.getElementsByTagName("type").item(0);
			NodeList typeList = typeElmnt.getChildNodes();
			String type = ((Node) typeList.item(0)).getNodeValue();
			
			Element pathElmnt = (Element)pairElmnt.getElementsByTagName("decoderPath").item(0);
			NodeList pathList = pathElmnt.getChildNodes();
			String path = ((Node) pathList.item(0)).getNodeValue();
			
			Class<?> headClass =
					Class.forName(path);
			Decoder decoder = (Decoder) headClass.getConstructor(Factory.class).newInstance(this);
			myDecoders.put(type, decoder);
		}
		
		System.out.println(myDecoders);
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
	
	public static void main(String[] args) throws IllegalArgumentException, SecurityException, ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, ParserConfigurationException, SAXException, IOException {
		Factory factory = new Factory();
		factory.loadXMLFile("src/vooga/rts/gamedesign/factories/XML_Sample");
	}

}