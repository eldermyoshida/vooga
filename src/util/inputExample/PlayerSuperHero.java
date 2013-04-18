package util.inputExample;

import util.input.AlertObject;
import util.input.InputClassTarget;
import util.input.InputMethodTarget;

@InputClassTarget
public class PlayerSuperHero extends Player{

	public PlayerSuperHero(Pixmap firstImage, Pixmap secondImage) {
		super(firstImage, secondImage);
	}
	
	@InputMethodTarget(name="speedup")
	public void speedUp(AlertObject alObj){
		changeMinigameSpeed(20);
	}
	
	@InputMethodTarget(name="slowdown")
	@Override
	public void slowDown() {
		changeMinigameSpeed(-5);
	}
}
