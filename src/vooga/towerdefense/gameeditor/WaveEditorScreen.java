package vooga.towerdefense.gameeditor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.InvocationTargetException;
import javax.swing.JButton;

public class WaveEditorScreen extends GameEditorScreen {

    private static final String WAVE_CHOOSER_KEYWORD = "Add this wave to game";
    private static final String WAVE_FINISH_KEYWORD = "Finish with waves";
    private static final String NEXT_SCREEN_NAME = "vooga.towerdefense.gameeditor.WaveEditorScreen";
    private JButton myWaveChooserButton;
    private JButton myWaveFinishButton;
    private MouseAdapter myMouseAdapter;
    private GameEditorController myController;
    
    public WaveEditorScreen(Dimension size, GameEditorController controller) {
        myController = controller;
        setLayout(new BorderLayout());
        setPreferredSize(size);
        makeMouseAdapter();
        makeButtons();
        add(myWaveChooserButton);
        add(myWaveFinishButton);
    }
    
    private void makeButtons() {
        myWaveChooserButton = new JButton(WAVE_CHOOSER_KEYWORD);
        myWaveChooserButton.addMouseListener(myMouseAdapter);
        myWaveChooserButton.setVisible(true);
        myWaveFinishButton = new JButton(WAVE_FINISH_KEYWORD);
        myWaveFinishButton.addMouseListener(myMouseAdapter);
        myWaveFinishButton.setVisible(true);
    }
    
    private void makeMouseAdapter() {
        myMouseAdapter = new MouseAdapter() {
            @Override
            public void mouseClicked (MouseEvent e) {
                if (e.getSource().equals(myWaveChooserButton)) {
                    myController.addWaveToGame();
                if (e.getSource().equals(myWaveFinishButton))
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
