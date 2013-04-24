package vooga.rts.leveleditor.gui;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;
import javax.imageio.ImageIO;
import vooga.rts.leveleditor.components.EditableTile;
import vooga.rts.util.Pixmap;

public class TilePanel extends MapComponentPanel {
    
    public TilePanel(Canvas canvas) {
        super(canvas);
    }
    
    @Override
    public void setResourceBundle() {
        myResource = ResourceBundle.getBundle(RELATIVE_PATH+"TileIndex");
    }
    
    @Override
    public void addButton() {
        for(int i=0; i<myFiles.length; ++i) {
            try {
                System.out.println("test1");
                BufferedImage image = ImageIO.read(myFiles[i]);
                Pixmap image1 = new Pixmap(image);
                System.out.println("test1.5");
                EditableTile tile = new EditableTile(image1, 0, 0, new Dimension(0,0), i+1, "", myFiles[i].getName(),false);
                System.out.println("test1.8");
                TileButton b = new TileButton(tile,image,this);
                System.out.println("test1.9");
                myPanel.add(b);
                System.out.println("test2");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void setCurrentSelectTile(EditableTile myTile) {
        myCanvas.setCurrentSelectTile(myTile);        
    }        
}
