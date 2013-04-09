package vooga.rts.leveleditor.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import vooga.rts.leveleditor.components.EditableMap;

public class Canvas extends JFrame {
    
    public static final Dimension DEFAULT_CANVAS_SIZE  = new Dimension (800,600);
    public static final Dimension DEFAULT_RESOURCE_SIZE  = new Dimension (200,600);
    public static final String USER_DIR = "user.dir";
    
    private MapPanel myMapPanel;
    private JPanel myResourcePanel;
    private JScrollPane myMapPane;
    private JFileChooser myChooser;
    private ResourceOutliner myResourceOutliner;
    
    public Canvas() {
        setTitle("Level Editor");
        myMapPanel = new MapPanel();
        myResourcePanel = new JPanel(new BorderLayout());
        myResourcePanel.setSize(DEFAULT_RESOURCE_SIZE);
        JPanel ButtonPanel = createButtonPanel();
        
        ResourceContainer[] top = new ResourceContainer[5];
        myResourceOutliner = new ResourceOutliner(top);
        for(int i = 0; i < 5; i++)
        {
            myResourceOutliner.addDice();
        }
        
       
        myResourcePanel.add(myResourceOutliner, BorderLayout.NORTH);
        myResourcePanel.add(ButtonPanel, BorderLayout.SOUTH);
        myMapPane = new JScrollPane(myMapPanel);
        myChooser = new JFileChooser(System.getProperties().getProperty(USER_DIR));
        getContentPane().add(myMapPane, BorderLayout.CENTER);
        getContentPane().add(myResourcePanel, BorderLayout.EAST);
        
        setJMenuBar(createMenuBar());
        
        setPreferredSize(DEFAULT_CANVAS_SIZE);
        pack();
        setVisible(true);
        
        
        
    }
    
    private JPanel createButtonPanel() {
        JPanel ButtonPanel = new JPanel();
        JButton ZoomInButton = new JButton("ZoomIn");
        ZoomInButton.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent arg0) {
                //TODO
            }
        });
        JButton ZoomOutButton = new JButton("ZoomOut");
        ZoomOutButton.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent arg0) {
                //TODO
            }
        });
        JButton RemoveButton = new JButton("Remove");
        RemoveButton.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent arg0) {
                //TODO
            }
        });

        ButtonPanel.add(ZoomInButton);
        ButtonPanel.add(ZoomOutButton);
        ButtonPanel.add(RemoveButton);
        return ButtonPanel;
    }

    public JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(createFileMenu());
        return menuBar;
    }
    
    private JMenu createFileMenu() {
        JMenu menu = new JMenu("File");
        createFileMenu(menu);
        return menu;
    }

    private void createFileMenu(JMenu menu) {
        
        menu.add(new AbstractAction("New") {
            @Override
            public void actionPerformed (ActionEvent e) {
                showCustomizeMapDialog();
            }
        });
        
        menu.add(new AbstractAction("Save") {
            @Override
            public void actionPerformed (ActionEvent e) {
                try {
                    int response = myChooser.showSaveDialog(null);
                    if (response == JFileChooser.APPROVE_OPTION) {
                       //TODO
                    }
                }
                catch (Exception exception) {
                    //TODO
                }
            }
        });
        
        menu.add(new AbstractAction("Load") {

            @Override
            public void actionPerformed (ActionEvent e) {
                try {
                    int response = myChooser.showOpenDialog(null);
                    if (response == JFileChooser.APPROVE_OPTION) {
                      //TODO  
                    }
                }
                catch (Exception exception) {
                    //TODO
                }
            }
        });
        
    }

    
    protected void showCustomizeMapDialog() {
        JTextField MapWidth = new JTextField();
        JTextField MapHeight = new JTextField();
        
        Object[] message = {"MapWidth", MapWidth, "MapHeight", MapHeight};
        
        int option = JOptionPane.showConfirmDialog(null, message,"Set Map Size",JOptionPane.OK_CANCEL_OPTION);
        
        if (option == JOptionPane.OK_OPTION) {
            try {
                int w = Integer.parseInt(MapWidth.getText());
                int h = Integer.parseInt(MapHeight.getText());
                myMapPanel.setWidth(w);
                myMapPanel.setHeight(h);
            }
            catch (Exception e1) {
                //TODO
            }
        }
    }

    public static void main(String[] argv) {
        new Canvas();
    }

}
