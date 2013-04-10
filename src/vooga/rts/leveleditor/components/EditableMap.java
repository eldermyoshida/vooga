package vooga.rts.leveleditor.components;

import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import vooga.rts.map.GameMap;
import vooga.rts.util.Location;




public class EditableMap {

    
    private int myXSize;
    private int myYSize; 
    
    private int myLayers;
    
    EditableNode[][] myIndexMatrix;
    
    private Map<Integer , Location> myPlayerLocations;
    private int myPlayerNumber;
    
    
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
    
    public void initializeMap(int nodeX, int nodeY) {
        myIndexMatrix = new EditableNode[myXSize][myYSize];
        for(int i =0 ; i<myXSize ; i++) {
            for(int j =0 ; j<myXSize ; j++) {
                myIndexMatrix[i][j] = new EditableNode(i*nodeX,j*nodeY,new Dimension(nodeX,nodeY));
            }
        }
        myPlayerLocations = new HashMap<Integer , Location>();
        myPlayerNumber = 0;
    }
    public void initializeMap() {
        initializeMap((int)EditableNode.DEFAULT_DIMENSION.getWidth(),(int)EditableNode.DEFAULT_DIMENSION.getHeight());
    }
    
    public void addFeature(int x , int y , int index) {
        myIndexMatrix[x][y].addFeature(index);
        if(myIndexMatrix[x][y].getLayerNumber() > myLayers) {
            myLayers = myIndexMatrix[x][y].getLayerNumber();
        }
    }
    
    public void addFeature(Location loc, int index) {
        addFeature((int)loc.getX(),(int)loc.getY(),index);
    }
    
    public void removeFeatures(Location loc) {
        removeFeatures((int)loc.getX(),(int)loc.getY());
    }
    
    public void removeFeatures(int x ,int y) {
       
        myIndexMatrix[x][y].clearAllFeatures();
        myLayers = getLayerNumber(); 
    
    }
   
    public void addPlayer(int x, int y) {
        
        myPlayerLocations.put(myPlayerNumber, new Location(x,y));
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
    
//    public Location calculateAbsolutePosition(Location loc) {
//        int x = myCamera.getX() + loc.getX();
//        int y = myCamera.getY() + loc.getY();
//        return new Location(x,y);
//    }
//    
//    public Location calculateAbsolutePosition(int x , int y) {
//        int newX = myCamera.getX() + x;
//        int newY = myCamera.getY() + y;
//        return new Location(newX,newY);
//    }
    
    public void generateMapFile(String fileName) throws IOException {
        
        File mySavFile = new File(System.getProperty("user.dir") + "./src/" + fileName);
        if(!mySavFile.exists()) {
            mySavFile.createNewFile();
        } 
        int x = myXSize;
        int y = myYSize;
        int layerNumber = getLayerNumber();
            
        FileWriter myWriter = new FileWriter(mySavFile);
       
        myWriter.write( myXSize + "*" + myYSize + "*" + myLayers);
        myWriter.write("\r\n");
        
        for(int i=0 ; i< myPlayerNumber ; i++) {
            int playerX = (int)myPlayerLocations.get(i).getX();
            int playerY = (int)myPlayerLocations.get(i).getY();
            myWriter.write("Player " + i + " " + playerX + " " + playerY );   
            myWriter.write("\r\n");
        }
        
        
        
        for(int layer = 0 ; layer<layerNumber ; layer++ ) {
            for(int i =0 ; i < x ; i++) {
                for(int j = 0 ; j < y ; j++) {
                    if( layer < myIndexMatrix[i][j].getLayerNumber()) {
                        myWriter.write(myIndexMatrix[i][j].getFeature(layer)+"");                        
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
    
    public int getLayerNumber() {
        int count =0;
        for( int i =0 ; i< myXSize; i++) {
            for( int j =0 ; j< myYSize ; j++) {
                if (myIndexMatrix[i][j].getLayerNumber() >= count) {
                    count = myIndexMatrix[i][j].getLayerNumber();
                }
            }
        }
        return count;
    }
    
    public void loadMapFile(String fileName) throws FileNotFoundException {
        File resourceFile = new File(System.getProperty("user.dir") + "./src/" + fileName);
        Scanner myScanner = new Scanner(resourceFile);
        String line = myScanner.nextLine();
        
        String[] sizeBuffer = line.split("\\*");
        int x = Integer.parseInt(sizeBuffer[0]);
        int y = Integer.parseInt(sizeBuffer[1]);
        int layerCount = Integer.parseInt(sizeBuffer[2]);
        
        EditableMap buffer = new EditableMap(x,y);
        buffer.setMyLayers(layerCount);
        
        line = myScanner.nextLine();
        int count =0;
        
        while(line.contains("Player")) {
            String[] playerBuffer = line.split(" ");
            buffer.addPlayer(Integer.parseInt(playerBuffer[2]), Integer.parseInt(playerBuffer[3]));
            System.out.println("player added");
            count ++;
            line = myScanner.nextLine();
            
        }
        buffer.setMyPlayerNumber(count);
        
        
        
        for(int l = 0 ; l<layerCount ; l++) {
            if(line.contains("*")) {
                line = myScanner.nextLine();
            }
            for(int i =0 ; i<x ; i++) {
                for(int j =0 ; j<y ; j++) {
                    if(Integer.parseInt(line.charAt(j)+"") != 0){
                        buffer.getMapNode(i, j).addFeature(Integer.parseInt(line.charAt(j)+""));    
                    }
                }
                if(myScanner.hasNextLine()) {
                    line = myScanner.nextLine();
                } else {
                    break;
                }
            }
        }
        
        
        myIndexMatrix = buffer.getMap();
        myPlayerLocations = new HashMap<Integer,Location>(buffer.getAllPlayers());
        myPlayerNumber = buffer.getMyPlayerNumber();
        myXSize = x;
        myYSize = y;
        myLayers = layerCount;
        
        
        myScanner.close();
    }
   
    public void printMatrix() {
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

    public void setMyPlayerNumber (int myPlayerNumber) {
        this.myPlayerNumber = myPlayerNumber;
    }

    public void setMyLayers (int myLayers) {
        this.myLayers = myLayers;
    }
    
    public Location getPlayer(int index) {
        return myPlayerLocations.get(index); 
    }
    
    

    public Map<Integer, Location> getAllPlayers () {
        return myPlayerLocations;
    }

    public static void main(String[] args) {
        EditableMap test = new EditableMap(100,100);
        try {
            test.loadMapFile("test.sav");
        }
        catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Map Size : " + test.myXSize + "*" + test.myYSize );
        int players = test.getMyPlayerNumber();
        System.out.println("Player Number : " + players);
        for(int i=0 ; i<players ; i++) {
            System.out.println("Players : " + (int)test.getPlayer(i).getX() + "*" + (int)test.getPlayer(i).getY() );
        }
        test.printMatrix();
       
    }
    
}
