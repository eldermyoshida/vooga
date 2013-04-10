package vooga.rts.leveleditor.components;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import vooga.rts.map.GameMap;
import vooga.rts.util.Location;




public class EditableMap {

    
    private int myXSize;
    private int myYSize; 
    EditableNode[][] myIndexMatrix;
    private Dimension nodeDimension;

    
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
    
    public void initializeMap(int nodeX, int nodeY) {
        myIndexMatrix = new EditableNode[myXSize][myYSize];
        for(int i =0 ; i<myXSize ; i++) {
            for(int j =0 ; j<myXSize ; j++) {
                myIndexMatrix[i][j] = new EditableNode(i*nodeX,j*nodeY,new Dimension(nodeX,nodeY));
            }
        }
    }
    public void initializeMap() {
        initializeMap((int)EditableNode.DEFAULT_DIMENSION.getWidth(),(int)EditableNode.DEFAULT_DIMENSION.getHeight());
    }
    
    
    public EditableMap() {
        this(0,0);
    }
    
    
    public void addFeature(int x , int y , int index) {
        myIndexMatrix[x][y].addFeature(index);
    }
    public void addFeature(Location loc, int index) {
        addFeature((int)loc.getX(),(int)loc.getY(),index);
    }
    
    public void removeFeatures(Location loc) {
        removeFeatures((int)loc.getX(),(int)loc.getY());
    }
    
    public void removeFeatures(int x ,int y) {
        myIndexMatrix[x][y].clearAllFeatures();
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
        File resourceFile = new File(fileName);
        Scanner myScanner = new Scanner(resourceFile);
        int x = countRows(resourceFile) ;
        int y = countColumns(resourceFile);
        
        int buffer[][] = new int[x][y];
        String line = myScanner.nextLine();
        
        for(int i =0 ; i<x ; i++) {
            for(int j =0 ; j<y ; j++) {
                buffer[i][j] = Integer.parseInt(line.charAt(j)+"");
            }
            if(myScanner.hasNextLine()) {
               line = myScanner.nextLine();
            } else {
                break;
            }
        }
        //TO Fix
        //myIndexMatrix = buffer;
        myScanner.close();
    }
    
    public int countRows(File file) throws FileNotFoundException {
        int rows = 1;
        Scanner myScanner = new Scanner(file);
        String line = myScanner.nextLine();
        while(myScanner.hasNextLine()) {
            line = myScanner.nextLine();
            rows ++;
        }
        myScanner.close();
        return rows;
        
    }
    
    public int countColumns(File file) throws FileNotFoundException {
        Scanner myScanner = new Scanner(file);
        String line = myScanner.nextLine();
        int column = line.length();
        while(myScanner.hasNextLine()) {
            line = myScanner.nextLine();
            if(line.length() > column) {
                column = line.length();
            }
        }
        myScanner.close();
        return column;
    } 
   
    public void printMatrix() {
        int x = myIndexMatrix.length;
        int y = myIndexMatrix[0].length;
        for(int i =0 ; i<x ; i++) {
            for(int j =0 ; j<y ; j++) {
                System.out.print(myIndexMatrix[i][j]);
                System.out.print(" ");
            }
            System.out.print("\n");
        }
    }
    
   
    
    public static void main(String[] args) {
        EditableMap test = new EditableMap(100,100);
        test.addFeature(99, 99, 1);
        test.addFeature(99, 99, 1);
        test.addFeature(99, 99, 1);
        test.addFeature(99, 99, 1);
        try {
            test.generateMapFile("test.dat");
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }




    
}
