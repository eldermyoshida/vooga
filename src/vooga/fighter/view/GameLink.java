package vooga.fighter.view;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.List;
import java.awt.Rectangle;
import java.util.Observable;
import java.util.Observer;



public class GameLink implements Link, Observer, InGameRenderable {

	
	private RootWindow myRootWindow; 
	private GameWindow myView; 
	private InGameRenderable myModel;
	private Rectangle myBounds; 
	private String gameTitle = "FIGHTING GAME"; 
	
	public GameLink(InGameRenderable renderable) { 
		myView = new GameWindow(gameTitle);
		myView.setLink(this); 
		myModel = renderable; 
		myBounds = myView.getBounds(); 
		myModel.addObserver(this); 	
	}
	
	
	@Override
	public void paint(Graphics2D pen) {
		myModel.paint(pen); 
	}


	public List getScores() {
		return myModel.getScores();
	}


	public List getDamages() {
		return myModel.getDamages(); 
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		myView.repaint();
		getScores(); 
		getDamages(); 
	}
	
	public Rectangle getBounds () {
		myBounds = myView.getBounds(); 
		return myBounds; 
	}
	
	public void setGameTitle (String title) { 
		gameTitle = title; 
	}


	@Override
	public Renderable getNextRenderable() {
		return myModel.getNextRenderable(); 
	}


	@Override
	public void setNextRenderable() {
		myModel.setNextRenderable(); 
	}
	
}
