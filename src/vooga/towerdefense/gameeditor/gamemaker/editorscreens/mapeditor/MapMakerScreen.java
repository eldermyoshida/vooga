package vooga.towerdefense.gameeditor.gamemaker.editorscreens.mapeditor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import util.Location;
import vooga.towerdefense.model.Tile;
import vooga.towerdefense.model.tiles.DefaultTile;


/**
 * This is the screen where the game maker places the tiles in order to make
 * a map. The tiles are placed one at a time on a grid contained in the screen.
 * 
 * @author Leonard K. Ng'eno
 * 
 */
public class MapMakerScreen extends JPanel {

    private static final long serialVersionUID = 1L;
    private static final Dimension DEFAULT_TILE_SIZE = new Dimension(50, 50);
    private static final Location DEFAULT_LOCATION = new Location(0, 0);
    private static final DefaultTile DEFAULT_TILE = new DefaultTile(DEFAULT_LOCATION, DEFAULT_TILE_SIZE);
    private static final int MINIMUM_TILE_SIZE = 10;
    private static final String RESOURCE_LOCATION = "/vooga/towerdefense/images/background/";
    private Dimension mySize;
    private Integer myTileSize;
    private MouseAdapter myMouseListener;
    private List<Grid> myGrids;
    private int myMap[][];
    private Tile myTileToBuild;
    private String myMapString;
    private java.awt.Image myBackgroundImage;

    public MapMakerScreen (Dimension size) {
        setSize(size);
        setPreferredSize(size);
        setBackgroundImage("bg1.jpg");
        mySize = size;
        myTileSize = 50;
        myGrids = new ArrayList<Grid>();
        myTileToBuild = DEFAULT_TILE;
        myMapString = "";

        makeListener();
        addMouseListener(myMouseListener);
    }

    public void setBackgroundImage (String fileName) {
        myBackgroundImage =
                new ImageIcon(getClass().getResource(RESOURCE_LOCATION + fileName)).getImage();
    }

    @Override
    public void paintComponent (Graphics pen) {
        super.paintComponent(pen);
        pen.drawImage(myBackgroundImage, 0, 0, getWidth(), getHeight(), null);
        setBackground(Color.CYAN);
        paintGridLines(pen);
        paintTilesOnGrid(pen);
    }

    private void paintTilesOnGrid (Graphics pen) {
        for (Grid g : myGrids) {
            if (g.getTile() != null) {
                g.paint((Graphics2D) pen);
            }
        }
    }

    /**
     * This method resets the sizes of the tiles. This also results in the paths the
     * game maker had build being reset.
     * 
     * @param size The size of each tile in pixels
     */
    public void setTileSizes (int size) {
        myTileSize = size;
        myTileToBuild = DEFAULT_TILE;
        repaint();
    }

    private void paintGridLines (Graphics pen) {
        if (myTileSize > MINIMUM_TILE_SIZE) {
            myGrids.removeAll(myGrids);
            myMap = new int[mySize.width / myTileSize][mySize.height / myTileSize];
            for (int i = 0; i < mySize.width; i += myTileSize) {
                for (int j = 0; j < mySize.height; j += myTileSize) {
                    pen.drawLine(i, 0, i, mySize.height);
                    pen.drawLine(0, j, mySize.width, j);
                    Grid rect = new Grid(i, j, myTileSize, myTileSize, DEFAULT_TILE);
                    myGrids.add(rect);
                    myMap[i / myTileSize][j / myTileSize] = DEFAULT_TILE.getTileId();
                }
            }
        }

    }

    private void makeListener () {
        myMouseListener = new MouseAdapter() {
            @Override
            public void mouseClicked (MouseEvent e) {
                setTileClicked(e.getPoint());
            }
        };
    }

    private void setTileClicked (Point point) {
        for (Grid tile : myGrids) {
            if (tile.contains(point)) {
                tile.setTile(myTileToBuild);
                myMap[tile.x / myTileSize][tile.y / myTileSize] = myTileToBuild.getTileId();
                paintTilesOnGrid(getGraphics());
            }
        }
    }

    /**
     * Sets the tile to build to be tile t.
     * 
     * @param t The tile to be fixed on the grid that the game maker clicks on
     */
    public void setTile (Tile t) {
        myTileToBuild = t;
    }

    /**
     * gets the string representation of the tile id's in the map
     * 
     * @return a string representation of the tile id's
     */
    public String getMapString () {
        myMapString = "";
        for (int j = 0; j < myMap.length; j++) {
            for (int[] element : myMap) {
                myMapString += Integer.toString(element[j]) + " ";
            }
        }
        return myMapString;
    }

    /**
     * get map width
     * 
     * @return width of the map
     */
    public String getMapWidth () {
        return Integer.toString(getWidth());
    }

    /**
     * get map height
     * 
     * @return height of map
     */
    public String getMapHeight () {
        return Integer.toString(getHeight());
    }
}
