package vooga.rts.leveleditor.gui;

import vooga.rts.map.GameMap;
import vooga.rts.util.Location;




public class EditableMap {

    int[][] myIndexMatrix;
    GameMap myMap;
    //Camera myCamera;
    
    public EditableMap(int x , int y) {
        myIndexMatrix = new int[x][y];
        myMap = new GameMap(x,y);
        //myCamera = new Camera(0,0);  
    }
    
    public void editValue(int x , int y , int index) {
        myIndexMatrix[x][y] = index;
    }
    
    public void editValue(Location loc , int index) {
        myIndexMatrix[(int)loc.getX()][(int)loc.getY()] = index;
    }
    
   
    public void setVoid(int x, int y) {
        myIndexMatrix[x][y] = 0;
    }
    
    public void setVoid(Location loc) {
        myIndexMatrix[(int)loc.getX()][(int)loc.getY()] = 0;
    }
    
    public void clearMap() {
        int row = myIndexMatrix.length;
        int column = myIndexMatrix[0].length;
        for( int i =0 ; i< row ; i++) {
            for( int j =0 ; j< column ; j++)
            setVoid(i,j);
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
}
