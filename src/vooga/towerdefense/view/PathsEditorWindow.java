package view;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class PathsEditorWindow extends JPanel {

    private static final long serialVersionUID = 1L;
    private static final int XCOORD = 0;
    private static final int YCOORD = 0;
    private Color myBackgroundColor = Color.WHITE;
    
    public PathsEditorWindow () {
        
    }
    
  @Override
  public void paintComponent (Graphics pen) {
      super.paintComponent(pen);
      pen.setColor(myBackgroundColor);
      pen.fillRect(XCOORD, YCOORD, getSize().width, getSize().height);
      
      //paint the map paths, units and towers
  }
    
}
