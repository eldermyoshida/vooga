package vooga.fighter.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class SplashScreenWindow extends HUDWindow {

	private Dimension mySize; 
	private Link myLink; 
    
    public SplashScreenWindow (RootWindow rootWindow) { 
    	super(rootWindow); 
        setPreferredSize(mySize);
        setBorder(ViewConstants.DEFAULT_BORDER);
        setVisible(true); 
    }
    
    @Override
    public void paintComponent(Graphics pen) { 
        pen.setColor(Color.WHITE);
        pen.fillRect(0, 0, getSize().width, getSize().height);
        // first time needs to be special cased :(
        if (myLink != null) {
        	// if it's in splash mode, only paint the splash
        	myLink.paint((Graphics2D) pen);
        }
    }

    
	@Override
	protected void initializeVariables() {
	}

	@Override
	protected void addComponents() {
	}
	
	public void setLink (Link link) { 
		myLink = link; 
	}	
}