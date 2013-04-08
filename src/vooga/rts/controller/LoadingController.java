package vooga.rts.controller;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import vooga.rts.resourcemanager.ResourceManager;

public class LoadingController extends AbstractController {

    public LoadingController() {
        
    }
    
    double elap = 0;
    @Override
    public void update (double elapsedTime) {
        /*
        elap += elapsedTime;        
        if (elap > 1000) {
            elap = 0;
            setChanged();
            notifyObservers(MainState.Menu);
        }*/
        
        if (!ResourceManager.instance().isLoading()) {
            setChanged();
            notifyObservers(MainState.Menu);
        }
        
    }

    @Override
    public void paint (Graphics2D pen) {
        Rectangle screen = pen.getDeviceConfiguration().getBounds();
        pen.draw(new Rectangle(new Dimension( 400, 560)));
        
        pen.setFont(new Font("Arial", Font.PLAIN, 72));
        pen.drawString("Game is Loading! Yolo.", screen.width / 2, screen.height / 2);
    }

    @Override
    public void activate (MainState gameState) {
        ResourceManager.instance().load();        
    }
}
