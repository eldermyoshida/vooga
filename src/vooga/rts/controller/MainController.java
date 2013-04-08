package vooga.rts.controller;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import vooga.rts.IGameLoop;
import vooga.rts.gui.Window;

import vooga.rts.command.Action;

public class MainController extends AbstractController implements IGameLoop {

	public GameController myGameController;
	public LoadingController myLoadingController;
	public MenuController myMenuController;
	public Window myWindow;
	public Graphics2D myGraphics;

	Timer myTimer;
	public static final int ONE_SECOND = 1000;
	public static final int FRAMES_PER_SECOND = 25;
	public static final int DEFAULT_DELAY = ONE_SECOND / FRAMES_PER_SECOND;

	public MainController() {
		myGameController = new GameController();
		myLoadingController = new LoadingController();
		myMenuController = new MenuController();
		myWindow = new Window();
		myGraphics = myWindow.getCanvas().getGraphics();
	}

	@Override
	public void receiveUserInput(Action a) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(double elapsedTime) {
		// TODO Auto-generated method stub

	}

	/**
	 * Start the animation.
	 */
	public void start() {
		// create a timer to animate the canvas
		myTimer = new Timer(DEFAULT_DELAY, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				step();
			}

		});
		// start animation
		myTimer.start();
	}

	/**
	 * Take one step in the animation.
	 */
	public void step() {
		update(DEFAULT_DELAY);
		paint();
	}

	/**
	 * Stop the animation.
	 */
	public void stop() {
		myTimer.stop();
	}

	public void paint() {
		paint(myGraphics);
	}
	
	@Override
	public void paint(Graphics2D pen) {
		pen.setColor(Color.BLACK);
		pen.drawRect(10, 10, 100, 100);
	}

}
