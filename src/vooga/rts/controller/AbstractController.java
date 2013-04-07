package vooga.rts.controller;

import java.awt.Graphics2D;

import vooga.rts.command.Action;

public abstract class AbstractController {

    public abstract void receiveUserInput(Action a);
    
    public abstract void update();
    
    public abstract void paint (Graphics2D pen);
    
}
