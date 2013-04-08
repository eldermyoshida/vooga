package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * 
 * @author Leonard K. Ng'eno
 *
 */
public class MapWindow extends JPanel {

    private static final long serialVersionUID = 1L;
    private static final int XCOORD = 0;
    private static final int YCOORD = 0;
    private Color myBackgroundColor = Color.WHITE;

    public MapWindow (Dimension size) {
        setPreferredSize(size);
        setFocusable(true);
        setVisible(true);
    }
    
    @Override
    public void paintComponent (Graphics pen) {
        super.paintComponent(pen);
        pen.setColor(myBackgroundColor);
        pen.fillRect(XCOORD, YCOORD, getSize().width, getSize().height);
        
        //paint the map paths, units and towers
    }
    
}
