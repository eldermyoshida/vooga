package DavidandJacksGame.Game;

import vooga.fighter.controller.ControllerFactory;
import vooga.fighter.controller.GameManager;
import vooga.fighter.view.Canvas;

public class SubGameManager extends GameManager {

	public SubGameManager() {
	}
	
	@Override
	 public ControllerFactory makeFactory(Canvas canvas){
		 return new SubControllerFactory(canvas);
	 }
}
