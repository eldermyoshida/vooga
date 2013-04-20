package vooga.towerdefense.gameeditor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.InvocationTargetException;
import javax.swing.JButton;

public class LevelEditorScreen extends GameEditorScreen {

    private static final String LEVEL_CHOOSER_KEYWORD = "Add this level to game";
    private static final String LEVEL_FINISH_KEYWORD = "Finish with levels";
    private static final String NEXT_SCREEN_NAME = "vooga.towerdefense.gameeditor.FinishedScreen";
    private JButton myLevelChooserButton;
    private JButton myLevelFinishButton;
    private MouseAdapter myMouseAdapter;
    private GameEditorController myController;
    
    public LevelEditorScreen(Dimension size, GameEditorController controller) {
        myController = controller;
        setLayout(new BorderLayout());
        setPreferredSize(size);
        makeMouseAdapter();
        makeButtons();
        add(myLevelChooserButton);
        add(myLevelFinishButton);
    }
    
    private void makeButtons() {
        myLevelChooserButton = new JButton(LEVEL_CHOOSER_KEYWORD);
        myLevelChooserButton.addMouseListener(myMouseAdapter);
        myLevelChooserButton.setVisible(true);
        myLevelFinishButton = new JButton(LEVEL_FINISH_KEYWORD);
        myLevelFinishButton.addMouseListener(myMouseAdapter);
        myLevelFinishButton.setVisible(true);
    }
    
    private void makeMouseAdapter() {
        myMouseAdapter = new MouseAdapter() {
            @Override
            public void mouseClicked (MouseEvent e) {
                if (e.getSource().equals(myLevelChooserButton)) {
                    myController.addLevelToGame();
                if (e.getSource().equals(myLevelFinishButton))
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
