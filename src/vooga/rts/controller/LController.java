package vooga.rts.controller;

import vooga.rts.input.PositionObject;
import vooga.rts.state.LoadingState;

public class LController implements Controller {
    
    private LoadingState myState;
    
    public LController (LoadingState state) {
        myState = state;
    }
    
    @Override
    public void sendCommand (Command command) {
        myState.receiveCommand(command);
    }
    
    public void onLeftMouseUp (PositionObject o) {
        sendCommand(new LeftClickCommand("leftclick", o));
    }

}
