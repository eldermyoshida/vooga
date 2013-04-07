package vooga.rts.controller;

import java.awt.Graphics2D;
import vooga.rts.GameLoop;

public abstract class AbstractController implements GameLoop {

    public abstract void receiveUserInput();
    
}
