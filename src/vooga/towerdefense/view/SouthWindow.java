package vooga.towerdefense.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import vooga.towerdefense.controller.Controller;

//TODO: refactor so east & south are one class
/**
 * 
 * @author Angelica Schwartz
 * 
 *         This class enables having multiple JPanels on the east border of the screen
 * 
 */
public class SouthWindow extends JPanel {

    private static final long serialVersionUID = 1L;
    private ShopScreen myShopScreen;
    private NextWaveScreen myNextWaveScreen;
    private Controller myController;
    private static final Dimension SHOP_WINDOW_SIZE = new Dimension(600, 100);
    private static final Dimension WAVE_WINDOW_SIZE = new Dimension(200, 100);

    public SouthWindow (Dimension size, Controller controller) {
        setPreferredSize(size);
        setFocusable(true);
        myController = controller;
        initAndAddWindows();

        setVisible(true);
    }

    private void initAndAddWindows () {
        myShopScreen = new ShopScreen(SHOP_WINDOW_SIZE, myController);
        myNextWaveScreen = new NextWaveScreen(WAVE_WINDOW_SIZE, myController);
        add(myShopScreen, BorderLayout.WEST);
        add(myNextWaveScreen, BorderLayout.EAST);
    }

    public NextWaveScreen getNextWaveScreen() {
        return myNextWaveScreen;
    }

    public ShopScreen getShopScreen() {
        return myShopScreen;
    }
}
