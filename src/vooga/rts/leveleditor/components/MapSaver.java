package vooga.rts.leveleditor.components;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
       
        myWriter.write( myMap.getMyXSize() + "*" + myMap.getMyYSize() + "*" + layerNumber);
        myWriter.write("\r\n");
        
        for(int i=0 ; i< myMap.getMyPlayerNumber() ; i++) {
            int playerX = (int)myMap.getPlayer(i).getX();
            int playerY = (int)myMap.getPlayer(i).getY();
            myWriter.write("Player " + i + " " + playerX + " " + playerY );   
            myWriter.write("\r\n");
        }
        
        
        
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
}
