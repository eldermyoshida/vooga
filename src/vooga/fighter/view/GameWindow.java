package vooga.fighter.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import vooga.fighter.controller.Mode;

public class GameWindow extends HUDWindow {

	private Dimension mySize; 
	private GameLink myLink; 
	
	private PlayerStatisticsWindow player1StatsWindow; 
	private PlayerStatisticsWindow player2StatsWindow;
	private DamageStatisticsWindow player1DamageWindow; 
	private DamageStatisticsWindow player2DamageWindow; 
	private GameTimerWindow myGameTimerWindow;  
	
    
    public GameWindow (RootWindow rootWindow) { 
    	super(rootWindow); 
        setPreferredSize(mySize);
        setBorder(ViewConstants.DEFAULT_BORDER);
        player1StatsWindow = new PlayerStatisticsWindow(this); 
        player2StatsWindow = new PlayerStatisticsWindow(this); 
        player1DamageWindow = new DamageStatisticsWindow(this); 
        player2DamageWindow = new DamageStatisticsWindow(this); 
        myGameTimerWindow = new GameTimerWindow(this);
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
		// TODO Auto-generated method stub	
	}

	@Override
	protected void addComponents() {
		// TODO Auto-generated method stub
		//...Create the component...
		//...Set instance variables in the GridBagConstraints instance...
		//pane.add(theComponent, c);
		
		LayoutManager.layoutDefaultPlayerStatisticsWindows(this, player1StatsWindow, player2StatsWindow); 
		LayoutManager.layoutDefaultDamageStatisticsWindows(this, player1DamageWindow, player2DamageWindow);
		LayoutManager.layoutDefaultTimerWindow(this, myGameTimerWindow); 
	}
	
	public void setLink (Link link) { 
		myLink = (GameLink) link; 
	}
	
}
