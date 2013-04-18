package vooga.towerdefense.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JPanel;

import vooga.towerdefense.controller.Controller;
import vooga.towerdefense.gameElements.GameElement;
import vooga.towerdefense.util.Location;

/**
 * This class enables the player to click on items
 *              on the ShopScreen section, buy these
 *              items, and then place them on the map screen.
 * 
 * @author Leonard K. Ng'eno
 * 
 */
public class ShopScreen extends JPanel {

    private static final long serialVersionUID = 1L;
    private static final int XCOORD = 0;
    private static final int YCOORD = 0;
    private static final int ICON_WIDTH = 50;
    private static final int ICON_HEIGHT = 50;
    private static final String CANCEL_BUTTON_KEYWORD = "CancelButtonName";
    private int myWidth;
    private Color myBackgroundColor = Color.WHITE;
    private MouseAdapter myMouseListener;
    private Controller myController;
    private Map<String, GameElement> myShopItems;
    private Map<String, Rectangle> myShopIcons;
    private JButton myCancelButton;
    
    /**
     * constructor.
     * @param size
     * @param controller
     */
    public ShopScreen (Dimension size, Controller controller) {
        setPreferredSize(size);
        myWidth = size.width;
        setFocusable(true);
        myController = controller;
        makeMouseListener();
        addMouseListener(myMouseListener);
        setVisible(true);
        myShopItems = new HashMap<String, GameElement>();
        myShopIcons = new HashMap<String, Rectangle>();
        initShopItems();
        makeCancelButton();
    }

    /**
     * initializes the icons that will display
     *          in the ShopScreen.
     */
    private void initShopItems () {
        myShopItems = myController.getShopItemIcons();
        int originX = 10 ; 
        int originY = 10;
        for(String item : myShopItems.keySet()) {
            Rectangle rect = new Rectangle(originX, originY, ICON_WIDTH, ICON_HEIGHT);
            myShopIcons.put(item, rect);
            originX +=ICON_WIDTH;
            if (originX >= myWidth) {
                originX = 10;
                originY += ICON_HEIGHT; 
            }
        }
    }

    /**
     * paints the ShopScreen.
     * @param pen
     */
    @Override
    public void paintComponent (Graphics pen) {
        super.paintComponent(pen);
        pen.setColor(myBackgroundColor);
        pen.fillRect(XCOORD, YCOORD, getSize().width, getSize().height);
        displayShopItems((Graphics2D) pen);
    }

    /**
     * helper method to display the shop items
     *          in the shop. 
     * @param pen
     */
    private void displayShopItems (Graphics2D pen) {
        
        for (Map.Entry<String, Rectangle> entry : myShopIcons.entrySet()) {
            if (myShopItems.containsKey(entry.getKey())) {
                myShopItems.get(entry.getKey()).getPixmap().paint(pen, new Location (entry.getValue().getCenterX(), entry.getValue().getCenterY()), new Dimension(50, 50));
            }
       }
    }

    /**
     * helper method to make the mouse listener.
     */
    private void makeMouseListener() {
        myMouseListener = new MouseAdapter() {
            @Override
            public void mouseClicked (MouseEvent e) {
                handleClick(e.getPoint());
            }
        };
    }

    /**
     * helper method to determine if the mouse click was
     *          on an item.
     * @param point
     */
    private void handleClick(Point point) {

        for (Map.Entry<String, Rectangle> entry : myShopIcons.entrySet()) {
            if (entry.getValue().contains(point)) {
                myController.handleShopClickOnItem(entry.getKey());
            }
        }
    }
    
    private void makeCancelButton () {
        myCancelButton = new JButton(myController.getStringFromResources(CANCEL_BUTTON_KEYWORD));
        myCancelButton.addMouseListener(myMouseListener);
        myCancelButton.setVisible(true);
        this.add(myCancelButton, BorderLayout.SOUTH);
    }
}
