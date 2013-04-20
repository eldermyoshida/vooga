package vooga.towerdefense.gameeditor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.InvocationTargetException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MapEditorScreen extends GameEditorScreen {

    private static final String MAP_CHOOSER_KEYWORD = "Add map to game";
    private static final String NEXT_SCREEN_NAME = "vooga.towerdefense.gameeditor.ViewEditorScreen";
    private JButton myMapChooserButton;
    private MouseAdapter myMouseAdapter;
    private GameEditorController myController;
    
    public MapEditorScreen(Dimension size, GameEditorController controller) {
        System.out.println("makeMapScreen");
        myController = controller;
        setLayout(new BorderLayout());
        setPreferredSize(size);
        makeMouseAdapter();
        makeButton();
        add(myMapChooserButton, BorderLayout.EAST);
    }
    
    public void paintComponent(Graphics pen) {
        super.paintComponent(pen);
        myMapChooserButton.paint(pen);
    }
    
    private void makeButton() {
        myMapChooserButton = new JButton(MAP_CHOOSER_KEYWORD);
        myMapChooserButton.addMouseListener(myMouseAdapter);
        myMapChooserButton.setVisible(true);
    }
    
    private void makeMouseAdapter() {
        myMouseAdapter = new MouseAdapter() {
            @Override
            public void mouseClicked (MouseEvent e) {
                if (e.getSource().equals(myMapChooserButton)) {
                    myController.addMapToGame();
                    try {
                        myController.displayNextScreen(NEXT_SCREEN_NAME);
                    }
                    catch (SecurityException e1) {
                        e1.printStackTrace();
                    }
                    catch (IllegalArgumentException e1) {
                        e1.printStackTrace();
                    }
                    catch (ClassNotFoundException e1) {
                        e1.printStackTrace();
                    }
                    catch (InstantiationException e1) {
                        e1.printStackTrace();
                    }
                    catch (IllegalAccessException e1) {
                        e1.printStackTrace();
                    }
                    catch (NoSuchMethodException e1) {
                        e1.printStackTrace();
                    }
                    catch (InvocationTargetException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        };
    }
}
