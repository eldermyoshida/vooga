package vooga.rts.leveleditor.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ResourceBundle;
import javax.swing.JPanel;

public abstract class MapComponentPanel extends JPanel {
    
    public static final String RELATIVE_PATH = "vooga.rts.leveleditor.resource.";

    protected Canvas myCanvas;
    protected JPanel myPanel;
    protected ResourceBundle myResource;
    
    MapComponentPanel(Canvas canvas) {      
        myCanvas = canvas;
        myPanel = new JPanel();
        myPanel.setLayout(new GridLayout(0,4));
        add(myPanel, BorderLayout.NORTH);
        setResourceBundle();
        addButton();
    }
    
    public Canvas getCanvas() {
        return myCanvas;
     }

    public abstract void setResourceBundle();

    public abstract void addButton(); 
}
