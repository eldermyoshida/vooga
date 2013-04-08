package vooga.rts.controller;

import vooga.rts.IGameLoop;
import vooga.rts.input.PositionObject;

public abstract class AbstractController implements IGameLoop {
    
	public void onLeftMouseDown (PositionObject o) {};
	public void onLeftMouseUp (PositionObject o) {};
	public void onRightMouseDown (PositionObject o) {};
	public void onRightMouseUp (PositionObject o) {};
	public void onMouseDrag (PositionObject o) {};

}
