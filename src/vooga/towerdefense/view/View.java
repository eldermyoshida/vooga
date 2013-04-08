package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * @author Leonard K. Ng'eno
 *
 */
public class View {

    private static final Dimension SIZE = new Dimension(1100, 800);
    private static final Dimension MAP_WINDOW_SIZE = new Dimension(800, 600);
    private static final Dimension EAST_WINDOW_SIZE = new Dimension(200, 600);
    private static final Dimension SHOP_WINDOW_SIZE = new Dimension(1000, 100);
    private static final Dimension EDITOR_WINDOW_SIZE = new Dimension(800, 600);
    private static final String TITLE = "TOWER DEFENSE";
    private JPanel myPanel;
    private EastWindow myEastWindow;
    private JFrame myFrame;
    private MapWindow myMapWindow;
    private ShopWindow myShopWindow;
    private LevelsEditorWindow myEditorWindow;
    
    public View () {
        createGUI();
    }
    
    public void createGUI () {
        myFrame = new JFrame(TITLE);
        myPanel = new JPanel();
        myFrame.setContentPane(myPanel);
        myFrame.setPreferredSize(SIZE);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //add view components to the BorderLayout manager
        myMapWindow = new MapWindow(MAP_WINDOW_SIZE);
        myFrame.getContentPane().add(myMapWindow, BorderLayout.CENTER);
        
        myEastWindow = new EastWindow(EAST_WINDOW_SIZE);
        myFrame.getContentPane().add(myEastWindow, BorderLayout.EAST);
        
        myShopWindow = new ShopWindow(SHOP_WINDOW_SIZE);
        myFrame.getContentPane().add(myShopWindow, BorderLayout.SOUTH);

//        myEditorWindow = new LevelsEditorWindow(EDITOR_WINDOW_SIZE);
//        myFrame.getContentPane().add(myEditorWindow, BorderLayout.CENTER);

        myFrame.pack();
        myFrame.setVisible(true);
    }
}
