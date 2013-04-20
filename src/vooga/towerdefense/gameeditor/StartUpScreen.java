package vooga.towerdefense.gameeditor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.InvocationTargetException;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartUpScreen extends JPanel {

    private static final long serialVersionUID = 1L;
    private static final String WELCOME_KEYWORD = "WELCOME TO GAME EDITOR";
    private static final String START_KEYWORD = "START";
    private static final String NEXT_SCREEN_NAME = "vooga.towerdefense.gameeditor.MapEditorScreen";
    private JButton myStartButton;
    private MouseAdapter myMouseAdapter;
    private GameEditorController myController;
    
    public StartUpScreen(Dimension size, GameEditorController controller) {
        myController = controller;
        setSize(size);
        setPreferredSize(size);
        setVisible(true);
        makeMouseAdapter();
        add(makeLabel(), BorderLayout.NORTH);
        add(makeButton(), BorderLayout.SOUTH);
    }
    
    @Override
    public void paintComponent(Graphics pen) {
        super.paintComponents(pen);
        pen.setColor(Color.WHITE);
        pen.fillRect(0, 0, getSize().width, getSize().height);
    }
    
    private JLabel makeLabel() {
        return new JLabel(WELCOME_KEYWORD);
    }
    
    private JComponent makeButton() {
        myStartButton = new JButton(START_KEYWORD);
        myStartButton.addMouseListener(myMouseAdapter);
        return myStartButton;
    }
    
    private void makeMouseAdapter() {
        myMouseAdapter = new MouseAdapter() {
            @Override
            public void mouseClicked (MouseEvent e) {
                if (e.getSource().equals(myStartButton)) {
                    try {
                        setVisible(false);
                        myController.displayNextScreen(NEXT_SCREEN_NAME);
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
                    catch (SecurityException e1) {
                        e1.printStackTrace();
                    }
                    catch (IllegalArgumentException e1) {
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
