package vooga.rts.controller;

import java.awt.Graphics2D;
import vooga.rts.IGameLoop;

import vooga.rts.command.Action;

public abstract class AbstractController implements IGameLoop {

    public abstract void receiveUserInput(Action a);
    
}
