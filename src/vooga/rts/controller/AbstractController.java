package vooga.rts.controller;

import java.util.Observable;
import util.input.PositionObject;
import vooga.rts.IGameLoop;

public abstract class AbstractController extends Observable implements
		IGameLoop {

	public void onLeftMouseDown(PositionObject o) {
	};

	public void onLeftMouseUp(PositionObject o) {
	};

	public void onRightMouseDown(PositionObject o) {
	};

	public void onRightMouseUp(PositionObject o) {
	};

	public void onMouseDrag(PositionObject o) {
	};

	public abstract void activate();

	public abstract MainState getGameState();

	public void onMouseMove(PositionObject o) {
	}

}
