package vooga.rts.leveleditor.components;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import javax.imageio.ImageIO;

public class EditableNode {

    private static final String RELATIVE_PATH = "vooga.rts.leveleditor.resource.";
    public static final Dimension DEFAULT_DIMENSION = new Dimension(50,50);
    
    private int myX;
    private int myY;
    
    private double myZoomRate;
    
    private Dimension myDimension;
    private List<Integer> myFeatures = new LinkedList<Integer>();
    private ResourceBundle myResources = ResourceBundle.getBundle(RELATIVE_PATH + "ImageIndex");
    
    
    public EditableNode() {
        this(0,0,DEFAULT_DIMENSION);
    }
    
    public EditableNode(int x, int y, Dimension dimension) {
        myX = x;
        myY = y;
        myDimension = dimension;
    }

    public int getMyX () {
        return myX;
    }

    public int getMyY () {
        return myY;
    }

    public Dimension getMyDimension () {
        return myDimension;
    }
    
    public void addFeature(int index) {
        myFeatures.add(index);
    }
    
    public void removeFeature(int index) {
        myFeatures.remove(index);
    }
    
    public void removeFeature(Integer content) {
        myFeatures.remove(content);
    }
    
    public void clearAllFeatures() {
        myFeatures.clear();
    }
    
    public int getLayerNumber() {
        return myFeatures.size();
    }
    
    public int getFeature(int featureIndex) {
        return myFeatures.get(featureIndex);
    }
    
    public double getMyZoomRate() {
        return myZoomRate;
    }
    
    public void setMyZoomRate(double rate) {
        myZoomRate = rate;
    }
    
    public void paint(Graphics pen) throws IOException {
        for(Integer i : myFeatures) {
            if(myResources.containsKey(i+"")) {
                String path = System.getProperty("user.dir") + RELATIVE_PATH + myResources.getString(i+"");
                BufferedImage myImage = ImageIO.read(new File(path));
                pen.drawImage(myImage, myX, myY, (int)(myDimension.getWidth()*myZoomRate), (int)(myDimension.getHeight()*myZoomRate), null);
            }    
        }
    }
    
    
    
    
    
    
}
