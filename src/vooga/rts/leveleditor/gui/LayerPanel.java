package vooga.rts.leveleditor.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class LayerPanel extends JPanel {
    
    private Canvas myCanvas;
    private JList myLayers;
    private Vector<String> myLayerVector;
    
    public LayerPanel (Canvas canvas) {
        myCanvas = canvas;
        myLayerVector = new Vector<String>();
        myLayers = new JList(myLayerVector);
        addListSelectionListener(myLayers);
        add(myLayers,BorderLayout.WEST);

    }

    private void addListSelectionListener(JList list) {
        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked (MouseEvent e) {
                //TODO
            }
        });
       
    }
    
    public void addLayer (int layerNum) {
        myLayerVector.add("Layer" + layerNum);
        myLayers.setListData(myLayerVector);
    }

}
