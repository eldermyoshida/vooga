package vooga.towerdefense.gameeditor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import vooga.towerdefense.view.MapMaker;

/**
 * MapEditorScreen is responsible for helping
 *      the game developer make maps.
 *
 * @author Angelica Schwartz
 * @author Leonard K. Ng'eno
 */
public class MapEditorScreen extends GameEditorScreen {

    private static final long serialVersionUID = 1L;
    private static final String NEXT_SCREEN_NAME = "ProjectileEditorScreen";
    private static final String TITLE_NAME = "MAP ";
    private MapMaker myMapBox;
    private Dimension myMapMakerSize;
    private JTextField myTextField;
    private final int FIELD_SIZE = 10;
    private ActionListener myActionListener;
    private int myTileSize;
    
    /**
     * Constructor.
     * @param size
     * @param controller
     */
    public MapEditorScreen(Dimension size, GameEditorController controller) {
        super(size, controller, TITLE_NAME, NEXT_SCREEN_NAME);
        makeListener();
        myMapMakerSize = getController().getMapSize();
        this.add(makeMapBox(myMapMakerSize), BorderLayout.SOUTH);
        this.add(makeLabelText("TILE SIZE"), BorderLayout.EAST);
        this.add(makeTextField(), BorderLayout.EAST);
        setVisible(true);
    }

    private JPanel makeMapBox (Dimension size) {
        myMapBox = new MapMaker(size, 25);        
        return myMapBox;
    }
    
    private JTextField makeTextField () {

        myTextField = new JTextField(FIELD_SIZE);
        myTextField.addActionListener(myActionListener);
        myTextField.setVisible(true);

        return myTextField;
    }
    
    public void makeListener () {
        myActionListener = new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                repaintGrids();
            }

        };
    }
    
    private JLabel makeLabelText (String text) {
        return new JLabel(text);
    }
    
    private void repaintGrids(){
        myTileSize = Integer.parseInt(myTextField.getText()); // TODO make sure myTileSize is an int!! or appropriate int!!
        myMapBox.setTileSizes(myTileSize);
    }
    
    @Override
    public void paintComponent(Graphics pen) {
        super.paintComponent(pen);
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
