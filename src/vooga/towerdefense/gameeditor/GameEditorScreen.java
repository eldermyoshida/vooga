package vooga.towerdefense.gameeditor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.InvocationTargetException;
import javax.swing.JButton;
import javax.swing.JPanel;

public abstract class GameEditorScreen extends JPanel {

    /**
     * default serialized id.
     */
    private static final long serialVersionUID = 1L;
    private static final String ADD_BUTTON_TEXT = "Add to game";
    private static final String FINISH_BUTTON_TEXT = "Next section";
    private String myNextScreenName = "vooga.towerdefense.gameeditor.";
    private JButton myAddButton;
    private JButton myFinishButton;
    private Dimension mySize;
    private GameEditorController myController;
    
    public GameEditorScreen(Dimension size, GameEditorController controller, String nextScreenName) {
        mySize = size;
        setPreferredSize(mySize);
        myController = controller;
        myNextScreenName += nextScreenName;
        addButtons();
    }
    
    public void display() {
        setVisible(true);
        repaint();
    }
    
    private void addButtons() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        myAddButton = new JButton(ADD_BUTTON_TEXT);
        myAddButton.addMouseListener(makeMouseAdapter());
        myAddButton.setVisible(true);
        myFinishButton = new JButton(FINISH_BUTTON_TEXT);
        myFinishButton.addMouseListener(makeMouseAdapter());
        myFinishButton.setVisible(true);
        buttonPanel.add(myAddButton, BorderLayout.NORTH);
        buttonPanel.add(myFinishButton, BorderLayout.SOUTH);
        add(buttonPanel, BorderLayout.EAST);
    }
    
    public MouseAdapter makeMouseAdapter() {
        MouseAdapter myMouseAdapter = new MouseAdapter() {
            @Override
            public void mouseClicked (MouseEvent e) {
                if (e.getSource().equals(myAddButton)) {
                    addElementToGame();
                if (e.getSource().equals(myFinishButton))
                    try {
                        myController.displayNextScreen(myNextScreenName);
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
        return myMouseAdapter;
    }
    
    public abstract void addElementToGame();
}
