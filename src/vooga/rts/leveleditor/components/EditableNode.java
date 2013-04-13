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
import vooga.rts.leveleditor.gui.MapPanel;


/**
 * the class of a single editable map node. This node has a linked list
 * to store the information of tiles, terrains and resources.
 * 
 * @author Richard Yang
 *
 */

public class EditableNode {

    private static final String RELATIVE_PATH = "vooga.rts.leveleditor.resource.";
    
    private int myX;
    private int myY;
    private int myWidth;
    private int myHeight;
    
    private double myZoomRate;
    private boolean myOccupied;
    
    private BufferedImage myImage;
    private Dimension myDimension;
    private List<Integer> myFeatures;
    private ResourceBundle myResources = ResourceBundle.getBundle(RELATIVE_PATH + "ImageIndex");
    
    
    public EditableNode() {
        this(0, 0, MapPanel.DEFAULT_TILE_WIDTH, MapPanel.DEFAULT_TILE_HEIGHT, false);
    }
    public EditableNode(int x, int y, int width, int height, boolean isOccupied) {
        myX = x;
        myY = y;
        myWidth = width;
        myHeight = height;
        myOccupied = isOccupied;
        myFeatures = new LinkedList<Integer>();
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
    
    public void setOccupied(boolean b) {
        myOccupied = b;
    }
    
    
    public boolean getOccupied() {
        return myOccupied;
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
    
    public void setImage(BufferedImage i) {
        myImage = i;
    }
    
    public void refreshImage(int i) {
        String imageName = myResources.getString(i+"");
        try {
            myImage = ImageIO.read(new File(System.getProperty("user.dir")+ "./src/vooga/rts/levelEditor/resource/" + imageName));
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public void paint(Graphics pen) throws IOException {
        pen.drawImage(myImage, myX*myWidth, myY*myHeight, myWidth, myHeight,null);
    }

    public void ZoomIn() {
        myWidth = (int)(myWidth * MapPanel.ZOOM_RATE);
        myHeight = (int)(myHeight * MapPanel.ZOOM_RATE);
    }

    public void ZoomOut() {
        myWidth = (int)(myWidth / MapPanel.ZOOM_RATE);
        myHeight = (int)(myHeight / MapPanel.ZOOM_RATE);
    }
    public void reset() {
        myOccupied = false;
        myFeatures.clear();
    }
    
    
    
    
    
    
}
