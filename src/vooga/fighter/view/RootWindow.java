package vooga.fighter.view;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Point2D;
import java.awt.*;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;

import vooga.fighter.controller.Mode;
import vooga.fighter.controller.Controller; 


import vooga.fighter.util.Pixmap;
import vooga.fighter.util.Text;

public class RootWindow extends JFrame {

	private Dimension mySize;
	
	private Controller myController; 
	
	public RootWindow (String title, Controller controller) { 
        super(title);
        this.setResizable(false);
        setPreferredSize(mySize);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myController = controller;
        getContentPane().setLayout(new GridBagLayout());
        addComponents(); 
        setVisible(true); 
	}
	
	
	private void addComponents() { 
		GameWindow gameWindow = new GameWindow(this); 
		LayoutManager.layoutDefaultGameWindow(this, gameWindow); 
	}
	
}