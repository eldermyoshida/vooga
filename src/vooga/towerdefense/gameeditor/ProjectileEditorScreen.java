package vooga.towerdefense.gameeditor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.InvocationTargetException;
import javax.swing.JButton;

public class ProjectileEditorScreen extends GameEditorScreen {

    private static final String PROJECTILE_CHOOSER_KEYWORD = "Add this projectile to game";
    private static final String PROJECTILE_FINISH_KEYWORD = "Finish with projectiles";
    private static final String NEXT_SCREEN_NAME = "vooga.towerdefense.gameeditor.UnitEditorScreen";
    private JButton myProjectileChooserButton;
    private JButton myProjectileFinishButton;
    private MouseAdapter myMouseAdapter;
    private GameEditorController myController;
    
    public ProjectileEditorScreen(Dimension size, GameEditorController controller) {
        myController = controller;
        setLayout(new BorderLayout());
        setPreferredSize(size);
        makeMouseAdapter();
        makeButtons();
        add(myProjectileChooserButton);
        add(myProjectileFinishButton);
    }
    
    private void makeButtons() {
        myProjectileChooserButton = new JButton(PROJECTILE_CHOOSER_KEYWORD);
        myProjectileChooserButton.addMouseListener(myMouseAdapter);
        myProjectileChooserButton.setVisible(true);
        myProjectileFinishButton = new JButton(PROJECTILE_FINISH_KEYWORD);
        myProjectileFinishButton.addMouseListener(myMouseAdapter);
        myProjectileFinishButton.setVisible(true);
    }
    
    private void makeMouseAdapter() {
        myMouseAdapter = new MouseAdapter() {
            @Override
            public void mouseClicked (MouseEvent e) {
                if (e.getSource().equals(myProjectileChooserButton)) {
                    myController.addProjectileToGame();
                if (e.getSource().equals(myProjectileFinishButton))
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
