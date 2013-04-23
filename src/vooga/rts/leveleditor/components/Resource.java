package vooga.rts.leveleditor.components;

import vooga.rts.gamedesign.sprite.gamesprites.GameSprite;
import vooga.rts.util.Location3D;
import vooga.rts.util.Pixmap;
/**
 * This class represents the available resource types the designer can choose from
 * 
 * @author Yang Yang
 *
 */

public class Resource extends GameSprite{
   
    private int myID;
    private String myName;
    private String myImageName;
    private int myAmount;   
    /**
     * Constructor for this class
     * 
     * @param id
     * @param name
     * @param image
     */ 
    public Resource(Pixmap image, Location3D center , int id, String name , String imageName, int amount) {
        super(image,center,image.getMyDimension());
        myID = id;
        myName = name;
        myImageName = imageName;
    }
    
    public Resource(Pixmap image, int x , int y , int z , int id, String name , String imageName, int amount) {
       this(image,new Location3D(x,y,z),id,name,imageName,amount);
    }
    
    public Resource(Pixmap image, int x , int y , int layerCount , int layerHeight, int id, String name , String imageName, int amount) {
        this(image,x,y,layerCount*layerHeight,id,name,imageName,amount);
     }

    public int getMyID () {
        return myID;
    }   

    public String getMyName () {
        return myName;
    }

    public String getMyImageName () {
        return myImageName;
    }

    public int getMyAmount () {
        return myAmount;
    }

    public void setAmount(int amount) {
        myAmount = amount;
        
    }

    public void setName(String type) {
        myName = type;
        
    }    
}
