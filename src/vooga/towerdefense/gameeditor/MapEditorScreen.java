package vooga.towerdefense.gameeditor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * MapEditorScreen is responsible for helping
 *      the game developer make maps.
 *
 * @author Angelica Schwartz
 */
public class MapEditorScreen extends GameEditorScreen {

    private static final long serialVersionUID = 1L;
    private static final String NEXT_SCREEN_NAME = "ProjectileEditorScreen";
    private static final String TITLE_NAME = "MAP ";
    private JPanel myMapBox;
    private Dimension myMapMakerSize;
    
    /**
     * Constructor.
     * @param size
     * @param controller
     */
    public MapEditorScreen(Dimension size, GameEditorController controller) {
        super(size, controller, TITLE_NAME, NEXT_SCREEN_NAME);
        myMapMakerSize = getController().getMapSize();
        this.add(makeMapBox(new Dimension(500, 500)), BorderLayout.WEST);
    }

    private JPanel makeMapBox (Dimension size) {
        myMapBox = new JPanel();
        myMapBox.setPreferredSize(size);
        
        return myMapBox;
    }
    
    @Override
    public void paintComponent(Graphics pen) {
        super.paintComponent(pen);
        paintMapBox(pen);
    }
    
    private void paintMapBox (Graphics pen) {
        myMapBox.setBackground(Color.RED);  
          for (int i = 0; i < myMapBox.getWidth(); i += 25) {
              pen.drawLine(i, 0, i, myMapBox.getHeight());
          }
          for (int j = 0; j < myMapBox.getHeight(); j += 25) {
              pen.drawLine(0, j, myMapBox.getWidth(), j);
          }
    }

    /**
     * adds this level to the game.
     */
    @Override
    public void addElementToGame () {
        System.out.println("add to game MapEditorScreen");
        getController().addMapToGame();
    }
}
