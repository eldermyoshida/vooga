package games.MouseAndVoiceDemo.inputExample;

import util.input.AlertObject;
import util.input.InputClassTarget;
import util.input.InputMethodTarget;

/**
 * An example of a subclass of an annotated class which still retains
 * the ability for input to make method calls to inherited annotated
 * methods but also has the ability to reference annotated new methods.
 * @author Aaron Krolik
 */
@InputClassTarget
public class PlayerSuperHero extends Player{

	private final int ACCELERATION_SPEED = 10;
	private final int DECELERATION_SPEED = -10;
	private final int INCREASE_HEIGHT = 10;
	private final int DECREASE_HEIGHT = -10;
	/**
	 * A super-powered version of player
	 * @param firstImage
	 * @param secondImage
	 */
    public PlayerSuperHero(Pixmap firstImage, Pixmap secondImage) {
        super(firstImage, secondImage);
    }
    
    /**
     * An overriden method which can be called by Input to speed
     * up the player.
     */
    @Override
    @InputMethodTarget(name="playerspeedup")
    public void speedUp(AlertObject alObj){
        changeMinigameSpeed(ACCELERATION_SPEED);
    }
    
    /**
     * An overriden method which can be called by Input to slow
     * down the player.
     */
    @Override
    @InputMethodTarget(name="playerslowdown")
    public void slowDown() {
        changeMinigameSpeed(DECELERATION_SPEED);
    }
    
    @InputMethodTarget(name="playerup")
    public void positionUp(){
    	changeYPosition(INCREASE_HEIGHT);
    }
    
    @InputMethodTarget(name="playerdown")
    public void positionDown(){
    	changeYPosition(DECREASE_HEIGHT);
    }
}
