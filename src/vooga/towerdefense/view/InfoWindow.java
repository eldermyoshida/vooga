package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * 
 * @author Leonard K. Ng'eno
 *
 */
public class InfoWindow extends JPanel {

    private static final long serialVersionUID = 1L;
    private static final int HEIGHT_FIELD_SIZE = 18;
    private static final int WIDTH_FIELD_SIZE = 18;
    private JTextArea myTextArea;
    
    public InfoWindow (Dimension size) {
        setPreferredSize(size);
        setFocusable(true);
        add(labelText("INFO"));
        add(makeInfoTextArea(), BorderLayout.CENTER);
        setVisible(true);
    }
    
    private JComponent makeInfoTextArea () {
        myTextArea = new JTextArea(HEIGHT_FIELD_SIZE, WIDTH_FIELD_SIZE);
        myTextArea.setEditable(false);
        
        return new JScrollPane(myTextArea);
    }
    
    private JLabel labelText (String text) {
        return new JLabel(text);
    }
    
    public void update () {
        //update information on this screen
    }
}
