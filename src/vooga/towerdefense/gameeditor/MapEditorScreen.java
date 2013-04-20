package vooga.towerdefense.gameeditor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
    private MouseAdapter myTilePainterListener;
    private MouseAdapter myTileEraserListener;
    private int myTileSize;
    private JPanel myTilePainter;
    private JPanel myPathEraser;
    
    /**
     * Constructor.
     * @param size
     * @param controller
     */
    public MapEditorScreen(Dimension size, GameEditorController controller) {
        super(size, controller, TITLE_NAME, NEXT_SCREEN_NAME);
        makeListeners();
        myMapMakerSize = getController().getMapSize();
        this.add(makeMapBox(myMapMakerSize), BorderLayout.NORTH);
        this.add(makeLabelText("TILE SIZE"), BorderLayout.EAST);
        this.add(makeTextField(), BorderLayout.EAST);
        this.add(makeLabelText("PATH PAINTER"), BorderLayout.EAST);
        this.add(makePathTilePainter(), BorderLayout.SOUTH);
        this.add(makeLabelText("PATH ERASER"), BorderLayout.EAST);
        this.add(makePathEraser(), BorderLayout.WEST);

        setVisible(true);
    }

    private JPanel makeMapBox (Dimension size) {
        myMapBox = new MapMaker(size, this);        
        return myMapBox;
    }
    
    private JTextField makeTextField () {

        myTextField = new JTextField(FIELD_SIZE);
        myTextField.addActionListener(myActionListener);
        myTextField.setVisible(true);

        return myTextField;
    }
    
    public void makeListeners () {
        myActionListener = new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                repaintGrids();
            }
        };
        
        myTilePainterListener = new MouseAdapter () {
            @Override
            public void mouseClicked (MouseEvent e) {
                setPainterColor(myTilePainter, Color.GREEN);
                myMapBox.setPaintingMode(true);
            }
        };
        
        myTileEraserListener = new MouseAdapter () {
            @Override
            public void mouseClicked (MouseEvent e) { 
                setPainterColor(myPathEraser, Color.GREEN);
                myMapBox.setEraseMode(true);
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
        getController().addMapToGame();
    }
    
    private JPanel makePathTilePainter () {
        myTilePainter = new JPanel();
        myTilePainter.setPreferredSize(new Dimension(50,50));
        myTilePainter.setBackground(Color.BLUE);
        myTilePainter.setVisible(true);  
        myTilePainter.addMouseListener(myTilePainterListener); 
        
        return myTilePainter;
    }
    
    private JPanel makePathEraser () {
        myPathEraser = new JPanel ();
        myPathEraser.setPreferredSize(new Dimension(50,50));
        myPathEraser.setBackground(Color.RED);
        myPathEraser.setVisible(true);
        myPathEraser.addMouseListener(myTileEraserListener);
        
        return myPathEraser;
    }
    
    public void setPainterColor (JPanel panel, Color color) {
        panel.setBackground(color);
    }
    
    public JPanel getTilePainter() {
        return myTilePainter;
    }
    
    public JPanel getPathEraser () {
        return myPathEraser;
    }

    @Override
    public void addAdditionalMouseBehavior (MouseEvent e) {
        // TODO Auto-generated method stub
    }
    
}
