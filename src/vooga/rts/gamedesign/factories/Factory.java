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
 *  This class is in charge of the loading of input XML files for different
 *  class types. It will figure out the class type this given file is in charge
 *  of, and pass the information to the corresponding decoder. All the decoders
 *  are loaded through an input file.
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
	
	/**
	 * Creates decoders by loading the input file that specifies the path of
	 * each Decoder and the type of class it is in charge of. Puts the decoders
	 * and their corresponding types into a map.
	 * 
	 * This method will be called when the Factory class is created.
	 * 
	 * @param fileName the name of the XML file that specifies decoder paths.
	 * @throws ClassNotFoundException
	 * @throws IllegalArgumentException
	 * @throws SecurityException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
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
	
	/**
	 * Loads the XML file passed in and determines the type of class it provides
	 * information for. Then passes the input file to the corresponding decoder
	 * in charge of that type of class.
	 * 
	 * @param fileName the name of the XML file that provides class information
	 * and to be loaded
	 */
	public void loadXMLFile(String fileName) {
		try {
			File file = new File(fileName);
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(file);
			doc.getDocumentElement().normalize();
			System.out.println("Root element " + doc.getDocumentElement().getNodeName());
			
			NodeList head = doc.getChildNodes();
			Node childNode = head.item(0);
			NodeList children = childNode.getChildNodes();
			for(int i = 0 ; i < children.getLength() ; i++){
				Node tempNode = children.item(i);
				
				if(tempNode.getNodeType() == Node.ELEMENT_NODE){
					myDecoders.get(tempNode.getNodeName()).create(doc);
				}
				
				
				
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * TESTING PURPOSE
	 */
	public static void main(String[] args) throws IllegalArgumentException, SecurityException, ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, ParserConfigurationException, SAXException, IOException {
		Factory factory = new Factory();
		factory.loadXMLFile("src/vooga/rts/gamedesign/factories/Factory.xml");
	}

}