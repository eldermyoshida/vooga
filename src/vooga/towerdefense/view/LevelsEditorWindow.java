package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class LevelsEditorWindow extends JPanel {
    private static final long serialVersionUID = 1L;
    private static final int XCOORD = 0;
    private static final int YCOORD = 0;
    private Color myBackgroundColor = Color.WHITE;
    
    public LevelsEditorWindow (Dimension size) {
        setPreferredSize(size);
        
        add(makePathsEditor (), BorderLayout.NORTH);
        add(loadLevelsEditor (), BorderLayout.SOUTH); 
        
        setVisible(true);
    }

//    @Override
//    public void paintComponent (Graphics pen) {
//        super.paintComponent(pen);
//        pen.setColor(myBackgroundColor);
//        pen.fillRect(XCOORD, YCOORD, getSize().width, getSize().height);
//        
//        //paint the map paths, units and towers
//    }
    
    private JPanel makePathsEditor () {
        // allow the player to choose the levels
        JPanel paths = new JPanel ();
        paths.setPreferredSize(new Dimension (500, 500));
        
        //load available paths here
        
        return paths;
    }

    private void makeLevelsEditor () {
        // display the types of available maps here
    }
    
    private JButton loadLevelsEditor () {
        JButton result = new JButton(" >> ");
        result.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                // Load next screen
                makeLevelsEditor ();
            }
        });
        return result;
    }
}
