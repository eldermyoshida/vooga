package DavidandJacksGame.Game;

import java.util.Map;

import vooga.fighter.controller.CharacterSelectController;
import vooga.fighter.controller.Controller;
import vooga.fighter.controller.ControllerFactory;
import vooga.fighter.controller.MainMenuController;
import vooga.fighter.controller.MapSelectController;
import vooga.fighter.controller.ModeSelectMenuController;
import vooga.fighter.controller.OneVOneController;
import vooga.fighter.controller.ScoreController;
import vooga.fighter.view.Canvas;

public class SubControllerFactory extends ControllerFactory {

	public SubControllerFactory(Canvas frame) {
		super(frame);
	}
    protected void setupControllerConfiguration(Canvas frame,  Map<String, Controller> controllermap) {
        Controller controller = new OneVOneController(ONE_V_ONE, frame);
        controllermap.put(controller.getName(), controller);
        controller = new MainMenuController(MAIN_MENU, frame);
        controllermap.put(controller.getName(), controller);
        controller = new CharacterSelectController(CHARACTER_SELECT, frame);
        controllermap.put(controller.getName(), controller);
        controller = new MapSelectController(MAP_SELECT, frame);
        controllermap.put(controller.getName(), controller);
        controller = new ScoreController(SCORE_CONTROLLER, frame);
        controllermap.put(controller.getName(), controller);
        controller = new ModeSelectMenuController(MODE_SELECT, frame);
        controllermap.put(controller.getName(), controller);
}

}
