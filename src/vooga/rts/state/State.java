package vooga.rts.state;

import vooga.rts.IGameLoop;
import vooga.rts.controller.Command;

public interface State extends IGameLoop {
    
    public abstract void receiveInput (Command command);
}
