package games.scroller.arcadedemopackage;
import java.awt.Dimension;
import util.Location;
import vooga.scroller.scrollingmanager.ScrollingManager;
import vooga.scroller.sprites.superclasses.Player;
import vooga.scroller.util.ISpriteView;
import vooga.scroller.view.GameView;
import vooga.scroller.util.Pixmap;

public class Spaceship extends Player {
    
    private static final Pixmap DEFAULT_IMAGE = new Pixmap( "/games/scroller/arcadedemopackage/images/spaceship.jpg");
    private static final Dimension DEFAULT_SIZE  = new Dimension( 30 , 30);
    public Spaceship (ISpriteView image,
                       Location center,
                       Dimension size,
                       
                       GameView gameView,
                       ScrollingManager sm,
                       int health,
                       int damage) {
        super(DEFAULT_IMAGE,  center, size, gameView, sm, health, damage);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String getInputFilePath () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void handleDeath () {
        // TODO Auto-generated method stub
        
    }

}
