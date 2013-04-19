package vooga.rts.leveleditor.components;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ResourceBundle;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import vooga.rts.util.Location;

public class BetterMapSaver {

    private static final String RESOURCE_PATH = "vooga.rts.leveleditor.resource.";
    
    
    private DocumentBuilderFactory myFactory ;
    private DocumentBuilder myBuilder;
    private Document myDocument;
    
    private EditableMap mySavingMap; 
    
    private ResourceBundle myTerrainResources;
    private ResourceBundle myTileResources;
    
    
    public BetterMapSaver(EditableMap map) throws ParserConfigurationException {
        myFactory = DocumentBuilderFactory.newInstance();
        myBuilder = myFactory.newDocumentBuilder();
        myDocument = myBuilder.newDocument();
        mySavingMap = map;
        myTerrainResources = ResourceBundle.getBundle(RESOURCE_PATH + "TerrainIndex" );
        myTileResources = ResourceBundle.getBundle(RESOURCE_PATH+"TileIndex");
    }
    
    public void generateMapFile(File objectiveFile) throws TransformerException, IOException {
        
        if(!objectiveFile.exists()) {
            objectiveFile.createNewFile();
        }
        
        Element root = myDocument.createElement("Map");
        myDocument.appendChild(root);
        
        
        appendInfo(root);
        appendResourceInfo(root);
        appendGraphic(root);
        appendTerrain(root);
        appendResource(root);
        
        
        
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT,"yes");
        //transformer.setOutputProperty("http://xml.apache.org/xslt}indent-amount", "2");
        
        FileOutputStream out = new FileOutputStream(objectiveFile);    
        
        
        StreamResult result = new StreamResult(out);
        transformer.transform( new DOMSource(myDocument), result);
        
    }

    private void appendInfo(Element root) {
        Element info = myDocument.createElement("Info");
        Element name = myDocument.createElement("Name");
        name.appendChild(myDocument.createTextNode(mySavingMap.getMyMapName()));
        info.appendChild(name);
        
        Element description = myDocument.createElement("Desc");
        description.appendChild(myDocument.createTextNode(mySavingMap.getMyDescription()));
        info.appendChild(description);
        
        Element players = myDocument.createElement("Players");
        players.setAttribute("number", mySavingMap.getAllPlayers().size()+"");
        for(Integer i : mySavingMap.getAllPlayers().keySet()) {
            Location loc = mySavingMap.getAllPlayers().get(i);
            int x = (int)loc.getX();
            int y = (int)loc.getY();
            Element myPlayer = myDocument.createElement("Player");
            myPlayer.setAttribute("ID", i+"");
            myPlayer.setAttribute("X", x+"" );
            myPlayer.setAttribute("Y", y+"" );
            players.appendChild(myPlayer);
        }
        info.appendChild(players);
        
        
        root.appendChild(info);
    }
    
    private void appendResourceInfo(Element root) {
        
    }
    
    private void appendGraphic(Element root) {
        
    }

    private void appendTerrain(Element root) {
        
    }
   
    private void appendResource(Element root) {
        
    }


}

