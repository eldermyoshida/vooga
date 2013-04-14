package vooga.towerdefense.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JPanel;
import vooga.towerdefense.util.Location;
import vooga.towerdefense.util.Pixmap;


/**
 * This view screen enables the player to select the mode they want to play in.
 * There is easy, medium and hard modes.
 * 
 * @author Leonard K. Ng'eno
 * 
 */
public class LevelsSelectorScreen extends JPanel {
    private static final String CHECKED_IMAGE = "checked.gif";
    private static final long serialVersionUID = 1L;
    private static final int XCOORD = 0;
    private static final int YCOORD = 0;
    private Color myBackgroundColor = Color.WHITE;
    private TDView myView;
    private static final Dimension SIZE = new Dimension(150, 150);
    private MouseAdapter myMouseListener;
    private Pixmap myEasyLevel;
    private Pixmap myMediumLevel;
    private Pixmap myHardLevel;
    private Map<Pixmap, Rectangle> myLevelsImages;
    private JButton myNextScreen;
    private boolean myLevelSelected = false;
    private String myPrevName = "";

    public LevelsSelectorScreen (Dimension size, TDView view) {
        setPreferredSize(size);
        setInputListener();
        myView = view;
        add(nextScreenButton(), BorderLayout.SOUTH);
        myLevelsImages = new HashMap<Pixmap, Rectangle>();
        initLevelsImages();
        addMouseListener(myMouseListener);
        setVisible(true);
    }

    private void initLevelsImages () {
        myEasyLevel = new Pixmap("easy.gif");
        myMediumLevel = new Pixmap("medium.gif");
        myHardLevel = new Pixmap("hard.gif");

        myLevelsImages.put(myEasyLevel, new Rectangle(new Point(100, 200), SIZE));
        myLevelsImages.put(myMediumLevel, new Rectangle(new Point(300, 200), SIZE));
        myLevelsImages.put(myHardLevel, new Rectangle(new Point(500, 200), SIZE));
    }

    @Override
    public void paintComponent (Graphics pen) {
        super.paintComponent(pen);
        pen.setColor(myBackgroundColor);
        pen.fillRect(XCOORD, YCOORD, getSize().width, getSize().height);

        displayLevels((Graphics2D) pen);
    }

    private void displayLevels (Graphics2D pen) {
        for (Map.Entry<Pixmap, Rectangle> entry : myLevelsImages.entrySet()) {
            entry.getKey().paint(pen,
                                 new Location(entry.getValue().getCenterX(), entry.getValue()
                                         .getCenterY()), SIZE);
        }
    }

    private JButton nextScreenButton () {
        myNextScreen = new JButton("NEXT");
        myNextScreen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                if (myLevelSelected == true) {
                    myView.assembleScreens();
                }
            }
        });
        return myNextScreen;
    }

    private void setInputListener () {
        myMouseListener = new MouseAdapter() {
            @Override
            public void mouseClicked (MouseEvent e) {
                checkPositionClicked(e.getPoint());
            }
        };
    }

    private void checkPositionClicked (Point point) {
        
        if (!myPrevName.isEmpty()) {
            for (Map.Entry<Pixmap, Rectangle> entry1 : myLevelsImages.entrySet()) {
                if (entry1.getKey().getFileName().equals(CHECKED_IMAGE)) {
                    entry1.getKey().setImage(myPrevName);
                    repaint();
                }
            }
        }
        
        for (Map.Entry<Pixmap, Rectangle> entry : myLevelsImages.entrySet()) {
            if (entry.getValue().contains(point)) {
                myLevelSelected = true;
                selectedImage (entry.getKey());
            }
        }
    }
    
    private void selectedImage (Pixmap myImage) {
        myPrevName = myImage.getFileName();
        myImage.setImage(CHECKED_IMAGE);
        repaint();
    }
}
