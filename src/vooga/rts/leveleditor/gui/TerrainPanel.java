package vooga.rts.leveleditor.gui;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ResourceBundle;
import javax.imageio.ImageIO;
import vooga.rts.leveleditor.components.Terrain;
import vooga.rts.util.Pixmap;


public class TerrainPanel extends MapComponentPanel {

    public TerrainPanel (Canvas canvas) {
        super(canvas);
    }

    @Override
    public void setResourceBundle () {
        myResource = ResourceBundle.getBundle(RELATIVE_PATH + "TerrainIndex");
    }

    @Override
    public void addButton () {
        for(int i=0; i<myFiles.length; ++i) {
            try {
                Pixmap image = new Pixmap(ImageIO.read(myFiles[i]));
                myPanel.add(new TerrainButton(new Terrain(image,0,0,0,i+1,"",myFiles[i].getName(),0),this));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public void setCurrentSelectTerrain (Terrain t) {
        myCanvas.setCurrentSelectTerrain(t);
        
    }

}
