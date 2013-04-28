package vooga.towerdefense.gameeditor.gamemaker.editorscreens.subeditorscreens;

import java.awt.event.MouseEvent;
import javax.swing.JPanel;

public abstract class SubEditorSection extends JPanel {
    
    /**
     * default serialized id.
     */
    private static final long serialVersionUID = 1L;
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
    
    public SubEditorSection(String title) {
        myTitle = title;
    }
    
    public String getTitle() {
        return myTitle;
    }
    
    public abstract void clear();
    
    public abstract void doAdditionalMouseBehavior(MouseEvent e);

}
