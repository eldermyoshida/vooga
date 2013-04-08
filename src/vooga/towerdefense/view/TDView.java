package vooga.towerdefense.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * @author Leonard K. Ng'eno
 *
 */
public class TDView {

    private static final Dimension SIZE = new Dimension(1100, 800);
    private static final Dimension MAP_WINDOW_SIZE = new Dimension(800, 600);
    private static final Dimension EAST_WINDOW_SIZE = new Dimension(200, 600);
    private static final Dimension SHOP_WINDOW_SIZE = new Dimension(1000, 100);
    private static final Dimension EDITOR_WINDOW_SIZE = new Dimension(800, 600);
    private static final Dimension SPLASH_SCREEN_SIZE = new Dimension(800, 600);
    private static final String TITLE = "TOWER DEFENSE";
    private JPanel myPanel;
    private EastWindow myEastWindow;
    private JFrame myFrame;
    private MapScreen myMapWindow;
    private ShopScreen myShopWindow;
    private LevelsSelectorScreen myEditorWindow;
    private SplashScreen mySplashScreen;
    
    public TDView () {
        createGUI();
    }
    
    public void createGUI () {
        myFrame = new JFrame(TITLE);
        myPanel = new JPanel();
        myFrame.setContentPane(myPanel);
        myFrame.setPreferredSize(SIZE);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mySplashScreen = new SplashScreen(SPLASH_SCREEN_SIZE, this);
        myFrame.getContentPane().add(mySplashScreen, BorderLayout.SOUTH);
        
//        //add view components to the BorderLayout manager
//        myMapWindow = new MapScreen(MAP_WINDOW_SIZE);
//        myFrame.getContentPane().add(myMapWindow, BorderLayout.CENTER);
//        
//        myEastWindow = new EastWindow(EAST_WINDOW_SIZE);
//        myFrame.getContentPane().add(myEastWindow, BorderLayout.EAST);
//        
//        myShopWindow = new ShopScreen(SHOP_WINDOW_SIZE);
//        myFrame.getContentPane().add(myShopWindow, BorderLayout.SOUTH);

//        myEditorWindow = new LevelsEditorWindow(EDITOR_WINDOW_SIZE);
//        myFrame.getContentPane().add(myEditorWindow, BorderLayout.CENTER);

        myFrame.pack();
        myFrame.setVisible(true);
    }
    
    public void assembleScreens () {
    	
    	myFrame.remove(mySplashScreen);
    	
      //add view components to the BorderLayout manager
      myMapWindow = new MapScreen(MAP_WINDOW_SIZE);
      myFrame.getContentPane().add(myMapWindow, BorderLayout.CENTER);
      
      myEastWindow = new EastWindow(EAST_WINDOW_SIZE);
      myFrame.getContentPane().add(myEastWindow, BorderLayout.EAST);
      
      myShopWindow = new ShopScreen(SHOP_WINDOW_SIZE);
      myFrame.getContentPane().add(myShopWindow, BorderLayout.SOUTH);

      myEditorWindow = new LevelsSelectorScreen(EDITOR_WINDOW_SIZE);
      myFrame.getContentPane().add(myEditorWindow, BorderLayout.CENTER);
      
      myFrame.pack();
      myFrame.setVisible(true);
    }
}
