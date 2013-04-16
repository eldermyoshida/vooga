package vooga.rts.controller;

import util.input.InputClassTarget;
import util.input.InputMethodTarget;
import util.input.PositionObject;


@InputClassTarget
public class InputController {

    public AbstractController myActiveController;

    public InputController (AbstractController myController) {
        myActiveController = myController;
    }

    public void setActiveController (AbstractController myController) {
        myActiveController = myController;
    }

    @InputMethodTarget(name = "onLeftMouseDown")
    public void onLeftMouseDown (PositionObject o) {
        System.out.println("down");
        myActiveController.onLeftMouseDown(o);
    }

    @InputMethodTarget(name = "onLeftMouseUp")
    public void onLeftMouseUp (PositionObject o) {
        System.out.println("up");
        myActiveController.onLeftMouseUp(o);
    }

    @InputMethodTarget(name = "onRightMouseDown")
    public void onRightMouseDown (PositionObject o) {
        myActiveController.onRightMouseDown(o);
    }

    @InputMethodTarget(name = "onRightMouseUp")
    public void onRightMouseUp (PositionObject o) {
        myActiveController.onRightMouseUp(o);
    }

    @InputMethodTarget(name = "onMouseDrag")
    public void onMouseDrag (PositionObject o) {        
        myActiveController.onMouseDrag(o);
    }
    
    @InputMethodTarget(name = "onMouseMove")
    public void onMouseMove (PositionObject o) {        
        myActiveController.onMouseMove(o);
    }

}
