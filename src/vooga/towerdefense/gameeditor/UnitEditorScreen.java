package vooga.towerdefense.gameeditor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.InvocationTargetException;
import javax.swing.JButton;

public class UnitEditorScreen extends GameEditorScreen {

    private static final String UNIT_CHOOSER_KEYWORD = "Add this unit to game";
    private static final String UNIT_FINISH_KEYWORD = "Finish with units";
    private static final String NEXT_SCREEN_NAME = "vooga.towerdefense.gameeditor.WaveEditorScreen";
    private JButton myUnitChooserButton;
    private JButton myUnitFinishButton;
    private MouseAdapter myMouseAdapter;
    private GameEditorController myController;
    
    public UnitEditorScreen(Dimension size, GameEditorController controller) {
        myController = controller;
        setLayout(new BorderLayout());
        setPreferredSize(size);
        makeMouseAdapter();
        makeButtons();
        add(myUnitChooserButton);
        add(myUnitFinishButton);
    }
    
    private void makeButtons() {
        myUnitChooserButton = new JButton(UNIT_CHOOSER_KEYWORD);
        myUnitChooserButton.addMouseListener(myMouseAdapter);
        myUnitChooserButton.setVisible(true);
        myUnitFinishButton = new JButton(UNIT_FINISH_KEYWORD);
        myUnitFinishButton.addMouseListener(myMouseAdapter);
        myUnitFinishButton.setVisible(true);
    }
    
    private void makeMouseAdapter() {
        myMouseAdapter = new MouseAdapter() {
            @Override
            public void mouseClicked (MouseEvent e) {
                if (e.getSource().equals(myUnitChooserButton)) {
                    myController.addUnitToGame();
                if (e.getSource().equals(myUnitFinishButton))
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
