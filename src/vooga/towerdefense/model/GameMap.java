package vooga.towerdefense.model;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import vooga.rts.util.Vector;
import vooga.towerdefense.gameElements.GameElement;
import vooga.towerdefense.gameElements.Unit;
import vooga.towerdefense.util.Location;


/**
 * 
 * 
 * @author Erick Gonzalez
 */
public class GameMap {
    // a normal computer screen will have
    private static final int TILE_SIZE = 25;

    private Image myBackgroundImage;
    private List<Unit> myUnits;
    private List<GameElement> myGameElements;
    private Tile[][] myGrid;
    private Location myDestination;
    private Dimension myDimension;
    private Path myPath;
    private Pathfinder myPathfinder;

    /**
     * 
     * @param background a background image
     * @param width the width of the map, in pixels
     * @param height the height of the map, in pixels
     * @param destination the destination point of all units
     */
    public GameMap (Image background, int width, int height, Location destination) {
        myBackgroundImage = background;
        myUnits = new ArrayList<Unit>();
        myGameElements = new ArrayList<GameElement>();
        myDestination = destination;
        myDimension = new Dimension(width, height);
        initializeGrid();
        myPathfinder = new Pathfinder(myGrid);
        
        //ExampleUnitFactory myTrollFactory = new ExampleUnitFactory("Troll", new TrollUnitDefinition());
        //GameElement troll1 = myTrollFactory.createUnit(new Location(500, 500), new TrollUnitDefinition());
        //GameElement troll2 = myTrollFactory.createUnit(new Location(350, 250), new TrollUnitDefinition());
        //addGameElement(troll1);
        //addGameElement(troll2);
    }

    /**
     * Initializes the grid so that each element in myGrid is a Tile object
     * containing it's center coordinates. Every tile is both walkable and
     * buildable.
     */
    private void initializeGrid () {
        int horizontalTileCount = (int) (myDimension.getWidth() / TILE_SIZE);
        int verticalTileCount = (int) (myDimension.getHeight() / TILE_SIZE);

        myGrid = new Tile[horizontalTileCount][verticalTileCount];

        for (int i = 0; i < myGrid.length; i++) {
            for (int j = 0; j < myGrid[i].length; j++) {
                int xCenter = (int) (i * TILE_SIZE + TILE_SIZE / 2);
                int yCenter = (int) (j * TILE_SIZE + TILE_SIZE / 2);
                // TODO: replace booleans with parsed values from file
                myGrid[i][j] = new Tile(new Point(xCenter, yCenter),
                                        true, true);
            }
        }
    }

    /**
     * 
     * @param elapsedTime time elapsed since last game clock tick.
     */
    public void update (double elapsedTime) {
        for (GameElement e : myGameElements) {
            e.update(elapsedTime);
        }
    }

    public void spawnUnit (Unit u) {
        myUnits.add(u);
    }

    public void addToMap (GameElement e, Tile t) {
        e.setCenter(t.getCenter().getX(), t.getCenter().getY());
        myGameElements.add(e);
    }

    /**
     * Given a point on the map, returns the Tile enclosing that point.
     * 
     * @param point a point (x, y) on the game map, where x and y are measured in pixels.
     * @return a Tile object containing this point (x, y)
     */
    public Tile getTile (Point point) {
        return myGrid[(int) (point.getX() / TILE_SIZE)][(int) (point.getY() / TILE_SIZE)];
    }

	/**
	 * Given a location on the map, returns the Tile enclosing that point.
	 * 
	 * @param location
	 *            a location (x, y) on the game map, where x and y are measured
	 *            in pixels.
	 * @return a Tile object containing this point (x, y)
	 */
	public Tile getTile(Location location) {
		return myGrid[(int) (location.getX() / TILE_SIZE)][(int) (location
				.getY() / TILE_SIZE)];
	}

    /**
     * 
     * @param pen a pen used to draw elements on this map.
     */
    public void paint (Graphics2D pen) {
        // TODO: draw background image on mapscreen
        for (Unit u : myUnits) {
            u.paint(pen);
        }
        for (GameElement e : myGameElements) {
            e.paint(pen);
        }
    }

    public List<GameElement> getAllGameElements () {
        return myGameElements;
    }

    public List<Unit> getUnits () {
        return myUnits;
    }

    public void addGameElement (GameElement gameElement) {
        myGameElements.add(gameElement);
    }

    public List<GameElement> getTargetsWithinRadius (Location source,
                                                                    double radius,
                                                                    int howMany) {
        List<GameElement> elementsWithinRadius = new ArrayList<GameElement>();

        for (GameElement gameElement : myGameElements) {
            if (Vector.distanceBetween(source, gameElement.getCenter()) <= radius) {
                elementsWithinRadius.add(gameElement);
            }
        }

        class GameElementComparator implements Comparator<GameElement> {
            private Location mySource;

            public GameElementComparator (Location source) {
                mySource = source;
            }

            @Override
            public int compare (GameElement o1, GameElement o2) {
                return Vector.distanceBetween(mySource, o1.getCenter()) -
                       Vector.distanceBetween(mySource, o2.getCenter()) > 0 ? 1 : -1;
            }
        }
        
        Collections.sort(elementsWithinRadius, new GameElementComparator(source));
        return elementsWithinRadius.subList(0, howMany);
    }

	public Path getShortestPath(Location start, Location finish) {
		int x1 = (int) (start.getX() / TILE_SIZE);
		int x2 = (int) (finish.getX() / TILE_SIZE);
		int y1 = (int) (start.getY() / TILE_SIZE);
		int y2 = (int) (finish.getY() / TILE_SIZE);
		Path thePath = myPathfinder.getShortestPath(x1, y1, x2, y2);
		thePath.add(finish);
		return thePath;
	}

}
