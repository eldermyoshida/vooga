package vooga.rts.gui;

import java.awt.BufferCapabilities;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferStrategy;
import javax.swing.JPanel;

public class Canvas extends JPanel{

    BufferStrategy myStrategy;
    private Graphics myGraphics;
    
    public Canvas (BufferStrategy buffer) {
        super();
        myStrategy = buffer;
        setBackground(Color.WHITE);
    }
    
    public Graphics2D getGraphics() {    
        myGraphics = myStrategy.getDrawGraphics();  
        return (Graphics2D)myGraphics;
        
    }

    public void render() {
        myGraphics.dispose();
        myStrategy.show();
    }
}
