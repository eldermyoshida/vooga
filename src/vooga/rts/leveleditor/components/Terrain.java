package vooga.rts.leveleditor.components;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import vooga.rts.util.Location;

public class Terrain {
   
   private Location myLocation;
    
   private int myID;
   private String myName;
   private int myWalkAbility;
   
   private Dimension myDimension;
   
   private BufferedImage myImage;
   
   public Terrain(int id , String name , int walkAbility, Dimension dimension) {
       myID = id;
       myName = name;
       myWalkAbility = walkAbility;
       myDimension = dimension;
   }
   
   //temporary method, need further modifications
   public void setImage(BufferedImage image) {
       myImage = image;
   }

   public int getMyID () {
    return myID;
   }

   public String getMyName () {
    return myName;
   }

   public int getMyWalkAbility () {
    return myWalkAbility;
   }
   
   public Dimension getMyDimension() {
       return myDimension;
   }
   
   public Location getMyLocation() {
       return myLocation;
   }
   
   public void paint(Graphics pen) {
       pen.drawImage(myImage, (int)myLocation.getX(), (int)myLocation.getY(), (int)myDimension.getWidth(), 
                     (int)myDimension.getHeight(), null);
   }
   
   
   
   
   
}
