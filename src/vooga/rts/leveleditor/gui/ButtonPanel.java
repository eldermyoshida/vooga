package vooga.rts.leveleditor.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel {
    
    private Canvas myCanvas;
    
    public ButtonPanel(Canvas canvas) {
        myCanvas = canvas;
        initializeButton();
    }

    public void initializeButton() {
        JButton ZoomInButton = new JButton("ZoomIn");
        ZoomInButton.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e) {
                myCanvas.ZoomIn();
            }
        });
        JButton ZoomOutButton = new JButton("ZoomOut");
        ZoomOutButton.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e) {
                myCanvas.ZoomOut();
            }
        });
        JButton RemoveButton = new JButton("Remove");
        RemoveButton.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e) {
                //TODO
            }
        });

        this.add(ZoomInButton);
        this.add(ZoomOutButton);
        this.add(RemoveButton);
    }



}
