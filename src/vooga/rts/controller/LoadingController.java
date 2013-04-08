package vooga.rts.controller;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class LoadingController extends AbstractController {

    public LoadingController() {
        
    }
    
    @Override
    public void receiveUserInput (Action a) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void update (double elapsedTime) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void paint (Graphics2D pen) {
        pen.draw(new Rectangle(new Dimension( 400, 560)));
        pen.setFont(new Font("Arial", Font.PLAIN, 12));
        pen.drawString("Game is Loading! Yolo.", 400, 500);
    }

    @Override
    public void receiveUserInput () {
        // TODO Auto-generated method stub
        
    }

}
