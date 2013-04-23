package vooga.rts.leveleditor.components;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;
import vooga.rts.leveleditor.gui.MapPanel;
import vooga.rts.map.GameMap;
import vooga.rts.util.Location;
import vooga.rts.util.Pixmap;


/**
 * a class of EditableMap, this editable map is used to generate a
 * map that can be used for game players. This class enables them to
 * generated their own map
 * 
 * @author Richard Yang
 * 
 */

public class EditableMap {


    private static final int DEFAULT_PLAYER_UPPER_LIMIT = 8;
    private static final int DEFAULT_TEAM_UPPER_LIMIT = 4;
    
    private List<Terrain> myTerrains;
    
    private List<Resource> myResources;
    
    private String myMapName = "CIEMAS";
    private String myDescription = " our RTS is the best one !";

    private EditableTileMap myTileMap;

    private PlayerSet myPlayerSet;

    private MapSaver mySaver;
    private MapLoader myLoader;

    public EditableMap (String name, String desc, int xSize, int ySize, int tileWidth, int tileHeight) {
        myMapName = name;
        myDescription =desc;
        myTileMap = new EditableTileMap(new Dimension(tileWidth,tileHeight),ySize,xSize);
   
        
        initializeMap();
    }

    public EditableMap () {
        this("", "", 0, 0, 0, 0);
    }

    public void initializeMap () {
        myTileMap.initialize();
        myPlayerSet = new PlayerSet(DEFAULT_PLAYER_UPPER_LIMIT,DEFAULT_TEAM_UPPER_LIMIT);
        myTerrains = new ArrayList<Terrain>();
        myResources = new ArrayList<Resource>();

        try {
                mySaver = new MapSaver(this);
                myLoader = new MapLoader(this);
            }
            catch (ParserConfigurationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
    }



    

    public void clearMap () {
        myTileMap.removeAllTiles();
        
    }

    public void printMatrix () {
        System.out.println("printmatrix executed");
        System.out.println("X Size : " + getMyXsize());
        System.out.println("Y Size : " + getMyYsize());

        
        for(int i =0 ; i<getMyXsize() ; i++) {
            for(int j =0 ; j<getMyYsize() ; j++) {
                System.out.print(myTileMap.getTile(i, j).getMyID());
                System.out.print(" ");
            }
            System.out.print("\n");
        }
        for (int i = 0; i < 10; i++) {
            System.out.print("**");
        }
        System.out.print("\n");
    }

    public void load (File resourceFile) {
        
        try {
            System.out.println("LOAD MAP IN THE FILE");
            myLoader.loadMapFile(resourceFile);
            
        }
        catch (SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
        }
          
    }

    public void load (String filePath) {
        File bufferFile = new File(filePath);
        load(bufferFile);
    }

    public void save (File objectiveFile) {
        try {
            mySaver.generateMapFile(objectiveFile);
        }
        catch (TransformerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

    public void save (String filePath) {
        File bufferFile = new File(filePath);
        save(bufferFile);
    }
    
    public void addPlayer(int teamIndex, Location location) {
        myPlayerSet.addPlayer(location, teamIndex);
    }
    
    public void addPlayer(int teamIndex, int x , int y) {
        myPlayerSet.addPlayer(x, y,teamIndex);
    }
    
    public void removePlayer(Location start, Location end) {
        myPlayerSet.removePlayer(start, end);
    }
    
    public void removePlayer(int startX, int startY, int endX, int endY) {
        myPlayerSet.removePlayer(startX, startY, endX, endY);
    }
    
    public void addTerrain(Terrain ter) {
        myTerrains.add(ter);
    } 
    
    public void addTerrain() {
        myTerrains.add(new Terrain());
    }
    
    public int getMyXsize() {
        return myTileMap.getMyHeight();
    }
    
    public int getMyYsize() {
        return myTileMap.getMyWidth();
    }
    
    public int getMyTileWidth() {
        return (int)myTileMap.getMyTileSize().getWidth();
    }
    
    public int getMyTileHeight() {
        return (int)myTileMap.getMyTileSize().getHeight();
    }
    
    public String getMyMapName () {
        return myMapName;
    }

    public void setMyMapName (String myMapName) {
        this.myMapName = myMapName;
    }

    public String getMyDescription () {
        return myDescription;
    }

    public void setMyDescription (String myDescription) {
        this.myDescription = myDescription;
    }
    
    public void paint(Graphics2D pen) {
       myTileMap.paint(pen);
       for(Terrain ter : myTerrains) {
           ter.paint(pen);
       }
       for(Resource res : myResources) {
           res.paint(pen);
       }
    }
    
    public static void main(String[] args) {
        EditableMap test = new EditableMap("TestMap","This is a test map",10,10,50,50);
        test.addPlayer(1,2);
        test.addPlayer(2,3);
        test.addPlayer(3,4);
        test.addPlayer(5,7);
        test.addTile(1, 1, 1);
        test.addTile(2, 2, 2);
        test.addTile(3, 3, 3);
        test.addTerrain(3, new Terrain(2,2,1));
        test.addTerrain(2, new Terrain(3,3,2));
        test.addResource(7, 7, 1);
        test.addResource(8, 8, 2);
        MapSaver saver = null;
        try {
            saver = new MapSaver(test);
        }
        catch (ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            saver.generateMapFile(new File(System.getProperty("user.dir") + "./turtleRock"));
        }
        catch (TransformerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    
    }
}
