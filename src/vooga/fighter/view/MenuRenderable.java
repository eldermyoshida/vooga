package vooga.fighter.view;

import java.awt.Graphics2D;
import java.awt.List;

public interface MenuRenderable extends Renderable {
	
    public void paint(Graphics2D pen);
    
    public List getButton(); 
   
    public List getDamages(); 

}
