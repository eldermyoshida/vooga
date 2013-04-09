package vooga.rts.leveleditor.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

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
        //myResourcePanel.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
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
        myMapPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        myMapPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
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
        menu.add(new AbstractAction("Save") {
            /**
             * 
             */
            private static final long serialVersionUID = 1L;

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
            /**
             * 
             */
            private static final long serialVersionUID = 1L;

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

    
    public static void main(String[] argv) {
        new Canvas();
    }

}
