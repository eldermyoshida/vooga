package vooga.rts.leveleditor.components;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import vooga.rts.util.Location;

/**
 * this class is responsible for generating a XML format map file
 * 
 * 
 * @author Richard Yang
 *
 */
public class MapSaver {

public void generateMapFile(EditableMap myMap , File mySavFile) throws IOException {
        
        if(!mySavFile.exists()) {
            mySavFile.createNewFile();
        } 
        int x = myMap.getMyXSize();
        int y = myMap.getMyYSize();
        int layerNumber = myMap.getMyLayers();
            
        FileWriter myWriter = new FileWriter(mySavFile);
        
        writeTitle(myMap,myWriter);
        
        myMap.addPlayer(10, 10);
        myMap.addPlayer(20, 20);
        myMap.addPlayer(30, 30);
        myMap.addPlayer(40, 40);
        myMap.addPlayer(50, 50);
        
        writePlayers(myMap,myWriter);
        
        for(int layer = 0 ; layer<layerNumber ; layer++ ) {
            for(int i =0 ; i < x ; i++) {
                for(int j = 0 ; j < y ; j++) {
                    if( layer < myMap.getMapNode(i, j).getLayerNumber()) {
                        myWriter.write(myMap.getMapNode(i, j).getFeature(layer)+"");                        
                    } else {
                        myWriter.write(0+"");
                    }
                }
                myWriter.write("\r\n");
            }
            for(int i = 0 ; i < 10 ; i++) {
                myWriter.write("**");
            }
            myWriter.write("\r\n");
        }
        myWriter.close();
    }

    public void writeTitle(EditableMap myMap, FileWriter myWriter) throws IOException {
        String name = myMap.getMyMapName();
        String description = myMap.getMyDescription();
        myWriter.write("<map>\r\n");
        myWriter.write("   <info>\r\n");
        myWriter.write("      <name>"+ name + "</name>\r\n");
        myWriter.write("      <desc>"+ description + "</desc>\r\n");
    } 

    public void writePlayers(EditableMap myMap, FileWriter myWriter) throws IOException {
        Map<Integer , Location> buffer = myMap.getAllPlayers();
        myWriter.write("      <players number = "+ buffer.size() +">\r\n");
        for(Integer i : buffer.keySet()) {
            Location loc = buffer.get(i);
            myWriter.write("         <player "+ i +" X=" + loc.getX() + " Y=" + loc.getY() + " />\r\n");
        }
        myWriter.write("      </players>\r\n");
        myWriter.write("   </info>\r\n");
    }
    
}
