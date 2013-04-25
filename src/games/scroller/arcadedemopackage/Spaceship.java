package games.scroller.arcadedemopackage;

import java.awt.Dimension;
import util.Location;
import util.Vector;
import util.input.InputMethodTarget;
import vooga.scroller.scrollingmanager.ScrollingManager;
import vooga.scroller.sprites.superclasses.Player;
import vooga.scroller.util.Sprite;
import vooga.scroller.view.GameView;
import vooga.scroller.util.Pixmap;


public class Spaceship extends Player {
    private int myScore =0;
    private static final Pixmap DEFAULT_IMAGE =
            new Pixmap("/games/scroller/arcadedemopackage/images/spaceship.jpg");
    private static final Dimension DEFAULT_SIZE = new Dimension(30, 30);
    private static final int DEFAULT_HEALTH = 5;
    private static final int DEFAULT_DAMAGE = 1;
    private static final double MOVE_MAGNITUDE = 10;
    public Spaceship (Location center,
                      GameView gameView,
                      ScrollingManager sm) {
        super(DEFAULT_IMAGE, center, DEFAULT_SIZE, gameView, sm, DEFAULT_HEALTH, DEFAULT_DAMAGE);
    }

    @Override
    public String getInputFilePath () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void handleDeath () {

    }
    @InputMethodTarget(name = "left")
    public void flyLeft() {
        Vector force = this.getVelocity().getComponentVector(Player.RIGHT_DIRECTION);
        force.negate();
        this.addVector(force);
        this.translate(new Vector(Sprite.LEFT_DIRECTION, MOVE_MAGNITUDE));
    }

    @InputMethodTarget(name = "right")
    public void flyRight() {
        Vector force = this.getVelocity().getComponentVector(Player.LEFT_DIRECTION);
        force.negate();
        this.addVector(force);     
        this.translate(new Vector(Sprite.RIGHT_DIRECTION, MOVE_MAGNITUDE));

    }
    @InputMethodTarget(name = "down")
    public void flyDown() {
        Vector force = this.getVelocity().getComponentVector(Player.UP_DIRECTION);
        force.negate();
        this.addVector(force);     
        this.translate(new Vector(Sprite.DOWN_DIRECTION, MOVE_MAGNITUDE));

    }
    @InputMethodTarget(name = "up")
    public void flyUp() {
        Vector force = this.getVelocity().getComponentVector(Player.DOWN_DIRECTION);
        force.negate();
        this.addVector(force);     
        this.translate(new Vector(Sprite.UP_DIRECTION, MOVE_MAGNITUDE));
    }
    public void incrementScore (int increment) {
        myScore+=increment;
    }
}
