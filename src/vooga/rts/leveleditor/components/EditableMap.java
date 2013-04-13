package vooga.rts.leveleditor.components;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import vooga.rts.leveleditor.gui.MapPanel;
import vooga.rts.util.Location;

/**
 * a class of EditableMap, this editable map is used to generate a 
 * map that can be used for game players. This class enables them to
 * generated their own map
 * 
 * @author Richard Yang
 *
 */


public class EditableMap {

    
    private int myXSize;
    private int myYSize; 
    
    private int myLayers;
    
    private String myMapName = "CIEMAS";
    private String myDescription = " our RTS is the best one !";
    
    EditableNode[][] myIndexMatrix;
    
    private Map<Integer , Location> myPlayerLocations;
    private int myPlayerNumber;
    
    private MapSaver mySaver;
    private MapLoader myLoader;
    
    public EditableMap(int x , int y, int nodeX, int nodeY) {
        
        myXSize = x;
        myYSize = y;
        
        initializeMap(nodeX,nodeY); 
    }
    
    public EditableMap(int x , int y) {
        myXSize = x;
        myYSize = y;
        initializeMap();
    }
    
    public EditableMap() {
        this(0,0);
    }
    
    public void initializeMap(int width, int height) {
        myIndexMatrix = new EditableNode[myXSize][myYSize];
        for(int i =0 ; i<myXSize ; i++) {
            for(int j =0 ; j<myYSize ; j++) {
                myIndexMatrix[i][j] = new EditableNode(i,j,width, height, false);
            }
        }
        myPlayerLocations = new HashMap<Integer , Location>();
        myPlayerNumber = 0;
        mySaver = new MapSaver();
        myLoader = new MapLoader();
    }
    
    public void initializeMap() {
        initializeMap(MapPanel.DEFAULT_TILE_WIDTH,MapPanel.DEFAULT_TILE_HEIGHT);
    }
    
    public void addFeature(int x , int y , int index) {
        myIndexMatrix[x][y].addFeature(index);
        refreshLayerNumber();
    }
    
    public void addFeature(Location loc, int index) {
        addFeature((int)loc.getX(),(int)loc.getY(),index);
    }
    
    public void removeFeatures(Location loc) {
        removeFeatures((int)loc.getX(),(int)loc.getY());
    }
    
    public void removeFeatures(int x ,int y) {
       
        myIndexMatrix[x][y].clearAllFeatures();
        refreshLayerNumber(); 
    
    }
   
    public void addPlayer(int x, int y) {
        
        myPlayerLocations.put(myPlayerNumber, new Location(x,y));
        myPlayerNumber ++;
        
    }
    
    public void addPlayer(Location loc) {
        myPlayerLocations.put(myPlayerNumber, loc);
        myPlayerNumber ++;
    }
    
    public void removePlayer(int index) {
        myPlayerLocations.remove(index);
        myPlayerNumber --;
    }
    
    
    public void clearMap() {
        for( int i =0 ; i< myXSize ; i++) {
            for( int j =0 ; j< myYSize ; j++) {
            removeFeatures(i,j);
            }
        }
    }
    
    
    public void refreshLayerNumber() {
        int count =0;
        for( int i =0 ; i< myXSize; i++) {
            for( int j =0 ; j< myYSize ; j++) {
                if (myIndexMatrix[i][j].getLayerNumber() >= count) {
                    count = myIndexMatrix[i][j].getLayerNumber();
                }
            }
        }
        myLayers = count;
    }
    
   
    public void printMatrix() {
        System.out.println("printmatrix executed");
        System.out.println("layers : " + myLayers);
        System.out.println("X Size : " + myXSize);
        System.out.println("Y Size : " + myYSize);
        for(int l =0 ; l< myLayers ; l++) {
            for(int i =0 ; i<myXSize ; i++) {
                for(int j =0 ; j<myYSize ; j++) {
                    if( l>= myIndexMatrix[i][j].getLayerNumber()) {
                        System.out.print("0");
                        System.out.print(" ");    
                    } else {
                        System.out.print(myIndexMatrix[i][j].getFeature(l));
                        System.out.print(" ");    
                    }
                }
                System.out.print("\n");
            }
            for(int i = 0 ; i<10 ; i++) {
                System.out.print("**");
            }
            System.out.print("\n");
    
        }
    }
    
    public void load(File resourceFile) {
        try {
            myLoader.loadMapFile(this, resourceFile);
        }
        catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public void load(String filePath) {
        File bufferFile = new File(filePath);
        load(bufferFile);
    }
    
    public void save(File objectiveFile) { 
        try {
            mySaver.generateMapFile(this, objectiveFile);
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public void save(String filePath) {
        File bufferFile = new File(filePath);
        save(bufferFile);
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

    public EditableNode getMapNode(int x, int y) {
        return myIndexMatrix[x][y];
    }
   
    public EditableNode[][] getMap() {
        return myIndexMatrix;
    }
    
    
    public int getMyLayers () {
        return myLayers;
    }

    
    
    public int getMyPlayerNumber () {
        return myPlayerNumber;
    }
    
    public int getMyXSize () {
        return myXSize;
    }

    public int getMyYSize () {
        return myYSize;
    }  

    public void setMyXSize (int myXSize) {
        this.myXSize = myXSize;
    }

    public void setMyYSize (int myYSize) {
        this.myYSize = myYSize;
    }

    public Location getPlayer(int index) {
        return myPlayerLocations.get(index); 
    }
    
    

    public Map<Integer, Location> getAllPlayers () {
        return myPlayerLocations;
    }
 
    public int getWidth() {
        return myXSize;
    }

    public int getHeight() {
        return myYSize;
    }

    public void setWidth(int w) {
        myXSize = w;

    }

    public void setHeight(int h) {
        myXSize = h;

    }
    
    public void setMyLayers (int myLayers) {
        this.myLayers = myLayers;
    }
    
    
    public void ZoomIn() {
        for(int i =0 ; i<myXSize ; i++) {
            for(int j =0 ; j<myYSize ; j++) {
                myIndexMatrix[i][j].ZoomIn();
            }
        }
        
    }

    public void ZoomOut() {
        for(int i =0 ; i<myXSize ; i++) {
            for(int j =0 ; j<myYSize ; j++) {
                myIndexMatrix[i][j].ZoomOut();
            }
        }
        
    }
    
    public void clear() {
        for(int i =0 ; i<myXSize ; i++) {
            for(int j =0 ; j<myYSize ; j++) {
                myIndexMatrix[i][j].reset();
            }
        }
        
    }


    

}
