package vooga.towerdefense.gameeditor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.InvocationTargetException;
import javax.swing.JButton;

public class TowerEditorScreen extends GameEditorScreen {

    private static final String TOWER_CHOOSER_KEYWORD = "Add this tower to game";
    private static final String TOWER_FINISH_KEYWORD = "Finish with towers";
    private static final String NEXT_SCREEN_NAME = "vooga.towerdefense.gameeditor.UnitEditorScreen";
    private JButton myTowerChooserButton;
    private JButton myTowerFinishButton;
    private MouseAdapter myMouseAdapter;
    private GameEditorController myController;
    
    public TowerEditorScreen(Dimension size, GameEditorController controller) {
        myController = controller;
        setLayout(new BorderLayout());
        setPreferredSize(size);
        makeMouseAdapter();
        makeButtons();
        add(myTowerChooserButton);
        add(myTowerFinishButton);
    }
    
    private void makeButtons() {
        myTowerChooserButton = new JButton(TOWER_CHOOSER_KEYWORD);
        myTowerChooserButton.addMouseListener(myMouseAdapter);
        myTowerChooserButton.setVisible(true);
        myTowerFinishButton = new JButton(TOWER_FINISH_KEYWORD);
        myTowerFinishButton.addMouseListener(myMouseAdapter);
        myTowerFinishButton.setVisible(true);
    }
    
    private void makeMouseAdapter() {
        myMouseAdapter = new MouseAdapter() {
            @Override
            public void mouseClicked (MouseEvent e) {
                if (e.getSource().equals(myTowerChooserButton)) {
                    myController.addTowerToGame();
                if (e.getSource().equals(myTowerFinishButton))
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
