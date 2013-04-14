package vooga.fighter.controller;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.Timer;

import arcade.games.ArcadeInteraction;
import arcade.games.Game;
import arcade.games.UserGameData;

import vooga.fighter.util.Pixmap;
import vooga.fighter.util.Text;
import vooga.fighter.view.Canvas;
import vooga.fighter.controller.ControllerManager;
import vooga.fighter.controller.GameInfo;
import vooga.fighter.input.Input;
import vooga.fighter.input.InputClassTarget;

import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;



public class GameManager extends Game{
public static final Dimension SIZE = new Dimension(800, 600);
    public static final String TITLE = "Fighter!";
    private Canvas myCanvas;
    private ControllerManager myControllerManager;
    private GameInfo myGameInfo;
    
    public GameManager(ArcadeInteraction arcade){
    	super(arcade);
    	myCanvas = new Canvas(SIZE); 
        myGameInfo = new GameInfo();
        myControllerManager = new ControllerManager(myCanvas, myGameInfo);
    }
    
    
	 public void run (){
		 myControllerManager.run();
	    }
	 
	 public UserGameData generateNewProfile(){
		return myGameInfo;
	 }

}
