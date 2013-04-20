package vooga.towerdefense.gameeditor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.InvocationTargetException;
import javax.swing.JButton;

public class ViewEditorScreen extends GameEditorScreen {

    private static final String VIEW_CHOOSER_KEYWORD = "Add this view to game";
    private static final String NEXT_SCREEN_NAME = "vooga.towerdefense.gameeditor.ProjectileEditorScreen";
    private JButton myViewChooserButton;
    private MouseAdapter myMouseAdapter;
    private GameEditorController myController;
    
    public ViewEditorScreen(Dimension size, GameEditorController controller) {
        myController = controller;
        setLayout(new BorderLayout());
        setPreferredSize(size);
        makeMouseAdapter();
        makeButton();
    }
    
    private void makeButton() {
        myViewChooserButton = new JButton(VIEW_CHOOSER_KEYWORD);
        myViewChooserButton.addMouseListener(myMouseAdapter);
        myViewChooserButton.setVisible(true);
    }
    
    private void makeMouseAdapter() {
        myMouseAdapter = new MouseAdapter() {
            @Override
            public void mouseClicked (MouseEvent e) {
                if (e.getSource().equals(myViewChooserButton)) {
                    myController.addViewToGame();
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
