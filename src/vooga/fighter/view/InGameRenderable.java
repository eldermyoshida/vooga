package vooga.fighter.view;

import java.awt.Graphics2D;
import java.awt.List;

public interface InGameRenderable extends Renderable {

	
    public void paint(Graphics2D pen);
    
    public List getScores(); 
   
    public List getDamages(); 
}
