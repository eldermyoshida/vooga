package vooga.rts.controller;

import java.awt.Graphics2D;
import vooga.rts.IGameLoop;

public abstract class AbstractController implements IGameLoop {

    public abstract void receiveUserInput();
    
}
