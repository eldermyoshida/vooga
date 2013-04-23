package vooga.rts.leveleditor.components;


import vooga.rts.gamedesign.sprite.gamesprites.GameSprite;
import vooga.rts.util.Location3D;
import vooga.rts.util.Pixmap;


/**
 * all class of terrains, which is used as a part of map
 * 
 * @author Richard Yang
 * 
 */

public class Terrain extends GameSprite {

    private int myID;
    
    private String myName;
    private String myImageName;
    
    private int myWalkAbility; 

    public Terrain (Pixmap image, Location3D center , int id , String name , String imageName, int walkAbility) {
        super(image, center, image.getMyDimension());
        myID = id;
        myName = name;
        myImageName = name;
        myWalkAbility = walkAbility;
    }
   
    public Terrain (Pixmap image, int x, int y , int z, int id, String name , String imageName , int walkAbility) {
        this(image,new Location3D(x,y,z),id,name,imageName,walkAbility);
    }

    public Terrain (Pixmap image, int x, int y, int layerCount, int layerHeight, int id , String name , String imageName, int walkAbility) {
        this(image,x,y,layerCount*layerHeight,id,name,imageName,walkAbility);
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

    public int getMyWalkAbility () {
        return myWalkAbility;
    }
    
 }
