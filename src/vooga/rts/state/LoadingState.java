package vooga.rts.state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.Observer;
import vooga.rts.controller.Command;
import vooga.rts.resourcemanager.ResourceManager;

public class LoadingState extends SubState {
    
    AffineTransform myTransform;
    BufferedImage myBGImage;
    public static final String DEFAULT_BGIMAGE_LOCATION = "images/backgrounds/loading_bg.png";
    
    public LoadingState (Observer observer) {
        super(observer);
        myBGImage = ResourceManager.getInstance().<BufferedImage>getFile(DEFAULT_BGIMAGE_LOCATION, BufferedImage.class);
    }
    
    @Override
    public void update(double elapsedTime) {        
    }
    
    @Override
    public void paint (Graphics2D pen) {
        myTransform = new AffineTransform();
        double sx = pen.getDeviceConfiguration().getBounds().getWidth();
        sx /= myBGImage.getWidth();
        double sy = pen.getDeviceConfiguration().getBounds().getHeight();
        sy /= myBGImage.getHeight();
        myTransform.scale(sx, sy);
        pen.drawImage(myBGImage, myTransform, null);
        Rectangle screen = pen.getDeviceConfiguration().getBounds();
        pen.setColor(Color.white);
        pen.setFont(new Font("Georgia", Font.PLAIN, 72));
        pen.drawString("Game is Loading...", 200, 300);
        if (!ResourceManager.getInstance().isLoading()) {
            pen.setFont(new Font("Georgia", Font.PLAIN, 30));
            pen.drawString("Click to start.", 200, 380);
        }
    }
    
    @Override
    public void receiveCommand (Command command) {
        setChanged();
        notifyObservers();
    }
    
   
}
