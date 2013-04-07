package controller;

import java.awt.Graphics2D;

public abstract class AbstractController {

    public abstract void receiveUserInput();
    
    public abstract void update();
    
    public abstract void paint (Graphics2D pen);
    
}
