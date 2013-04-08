package vooga.towerdefense.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * This class makes a screen that can display any information in it.
 * Examples include information about game stats, units, towers, etc.
 *
 * @author Angelica Schwartz
 */
public class InfoScreen extends JPanel {

    private static final long serialVersionUID = 1L;
    private static final String INFO_LOCATION = BorderLayout.SOUTH;
    private int myWidth;
    private int myHeight;
    private JTextArea myTextArea;
    private String myTitle;
    
    /**
     * Constructor.
     * @param title
     * @param size
     */
    public InfoScreen (String title, Dimension size) {
        setPreferredSize(size);
        setLayout(new BorderLayout());
        myTitle = title + "\n";
        myWidth = size.width;
        myHeight = size.height;
        add(makeInfoTextArea(), INFO_LOCATION);
        setVisible(true);
    }
    
    /**
     * displays the information contained in the string parameter.
     * @param information is the string to display
     */
    public void displayInformation (String information) {
        myTextArea.setText(myTitle + information);
        repaint();
    }
    
    /**
     * clears the text from the information screen.
     */
    public void clearScreen() {
        displayInformation("");
    }
    
    /**
     * paints the InfoScreen.
     * @param pen
     */
    @Override
    public void paint(Graphics pen) {
        super.paintComponent(pen);
        myTextArea.paint(pen);
    }
    
    /**
     * helper method to create the text area.
     * @return the blank JTextArea
     */
    private JComponent makeInfoTextArea () {
        myTextArea = new JTextArea(myWidth, myHeight);
        myTextArea.setEditable(false);
        return myTextArea;
    }
    
    /**
     * sets the title of this particular InfoScreen.
     * @param title is the title of this screen
     * @return the JLabel with the title
     */
    private JLabel setTitle (String title) {
        return new JLabel(title);
    }
}
