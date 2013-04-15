package vooga.rts.xmlparser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Parser {

	public Parser () throws ParserConfigurationException, IOException, SAXException {
	File fXmlFile = new File("src/vooga/rts/resources/testXML.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);
	
	doc.getDocumentElement().normalize();
	ArrayList<String> myData = new ArrayList<String>();

	Node mapNode = doc.getElementsByTagName("map").item(0);
	String name = doc.getElementsByTagName("name").item(0).getTextContent();
	String desc = doc.getElementsByTagName("desc").item(0).getTextContent();
	String numPlayers = doc.getElementsByTagName("players").item(0).getAttributes().getNamedItem("number").getTextContent();
	NodeList nList = doc.getElementsByTagName("players").item(0).getChildNodes();
	for (int i=0;i<nList.getLength();i++) {
		String playerInfo = "";
		playerInfo += nList.item(i).getAttributes().getNamedItem("ID").getTextContent();
		playerInfo += " "+nList.item(i).getAttributes().getNamedItem("X").getTextContent();
		playerInfo += " "+nList.item(i).getAttributes().getNamedItem("ID").getTextContent();
	}



	
	}
	
	public static void main (String[] args) throws ParserConfigurationException, SAXException, IOException {
		Parser p = new Parser();
	}

}
