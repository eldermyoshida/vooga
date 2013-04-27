package vooga.towerdefense.gameeditor.gamemaker;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public abstract class SubEditorSection extends JPanel {
    
    /**
     * constant for text area height.
     */
    public static final int TEXT_AREA_HEIGHT = 25;
    /**
     * constant for text area width.
     */
    public static final int TEXT_AREA_WIDTH = 10;
    /**
     * title for this screen.
     */
    private String myTitle;
    /**
     * box to enter the name of the game element.
     */
    private JTextField myNameBox;
    
    public SubEditorSection(String title) {
        myTitle = title;
        addCharacteristicsPanel();
    }
    
    private void addCharacteristicsPanel() {
        JPanel characteristicsPanel = new JPanel();
        myNameBox = new JTextField(TEXT_AREA_WIDTH);
        characteristicsPanel.add(new JLabel("Name: "));
        characteristicsPanel.add(myNameBox);
        add(characteristicsPanel, BorderLayout.NORTH);
    }
    
    public String getTitle() {
        return myTitle;
    }
    
    public String getName() {
        return myNameBox.getText();
    }
    
    public void clear() {
        myNameBox.setText("");
    }
    
    public abstract void doAdditionalMouseBehavior(MouseEvent e);

}
