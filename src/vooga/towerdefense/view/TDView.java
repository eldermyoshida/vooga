package vooga.towerdefense.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import vooga.towerdefense.controller.Controller;


/**
 * Container that holds the screens for the view.
 * 
 * @author Leonard K. Ng'eno
 * @author Angelica Schwartz
 * 
 */
public class TDView {

    private static final Dimension SIZE = new Dimension(1100, 800);
    private static final Dimension MAP_WINDOW_SIZE = new Dimension(800, 600);
    private static final Dimension EAST_WINDOW_SIZE = new Dimension(200, 600);
    private static final Dimension SOUTH_WINDOW_SIZE = new Dimension(1000, 200);
    private static final Dimension EDITOR_WINDOW_SIZE = new Dimension(800, 600);
    private static final Dimension SPLASH_SCREEN_SIZE = new Dimension(800, 600);
    private static final Dimension NEXT_WAVE_SCREEN_SIZE = new Dimension(200, 200);
    private static final String TITLE = "TOWER DEFENSE";
    private JPanel myPanel;
    private EastWindow myEastWindow;
    private SouthWindow mySouthWindow;
    private JFrame myFrame;
    private InformationScreen myTowerInfoScreen;
    private InformationScreen myPlayerInfoScreen;
    private MapScreen myMapScreen;
    private LevelsSelectorScreen myEditorWindow;
    private SplashScreen mySplashScreen;
    private Controller myController;
    private MapsSelectorScreen myMapSelector;
    private LevelsSelectorScreen myLevelSelector;
    private JButton myNextScreen;

    public TDView (Controller controller) {
        myController = controller;
        createGUI();
    }

    public void createGUI () {
        myFrame = new JFrame(TITLE);
        myPanel = new JPanel();
        myFrame.setContentPane(myPanel);
        myFrame.setPreferredSize(SIZE);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mySplashScreen = new SplashScreen(SPLASH_SCREEN_SIZE, this);
        myFrame.getContentPane().add(mySplashScreen, BorderLayout.NORTH);

        myFrame.getContentPane().add(nextScreenButton());

        myFrame.pack();
        myFrame.setVisible(true);
    }

    private Component nextScreenButton () {
        myNextScreen = new JButton("NEXT");
        myNextScreen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                showPredefinedMaps();
            }
        });
        myNextScreen.setBounds(1000, 850, 50, 50);

        return myNextScreen;

    }

    private void showPredefinedMaps () {
        myFrame.remove(mySplashScreen);
        myFrame.remove(myNextScreen);

        myMapSelector = new MapsSelectorScreen(MAP_WINDOW_SIZE, this);
        myFrame.getContentPane().add(myMapSelector, BorderLayout.CENTER);

        myFrame.pack();
        myFrame.setVisible(true);
    }

    public void showModesScreen () {
        myFrame.remove(myMapSelector);

        myLevelSelector = new LevelsSelectorScreen(MAP_WINDOW_SIZE, this);
        myFrame.getContentPane().add(myLevelSelector, BorderLayout.CENTER);

        myFrame.pack();
        myFrame.setVisible(true);
    }

    public void assembleScreens () {

        myFrame.remove(myLevelSelector);

        // add view components to the BorderLayout manager
        myMapScreen = new MapScreen(MAP_WINDOW_SIZE, myController);
        myFrame.getContentPane().add(myMapScreen, BorderLayout.CENTER);

        myEastWindow = new EastWindow(EAST_WINDOW_SIZE, myController);
        myFrame.getContentPane().add(myEastWindow, BorderLayout.EAST);

        mySouthWindow = new SouthWindow(SOUTH_WINDOW_SIZE, myController);
        myFrame.getContentPane().add(mySouthWindow, BorderLayout.SOUTH);

        myFrame.pack();
        myFrame.setVisible(true);
    }

    public MapScreen getMapScreen () {
        return myMapScreen;
    }

    public GameElementInformationScreen getTowerInfoScreen () {
        return myEastWindow.getTowerScreen();
    }

    public InformationScreen getPlayerInfoScreen () {
        return myEastWindow.getPlayerScreen();
    }
}
