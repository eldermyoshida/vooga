package vooga.towerdefense.gameeditor.gamemaker.editorscreens.mapeditor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JPanel;
import util.Location;
import vooga.towerdefense.util.Pixmap;


/**
 * This is the class that displays the pixmap images of the types of tile factories that the game
 * developer can use
 * to build their map. The class gives the game developer the ability to click on the
 * type of tile factory that they want and then click on a grid on the MapMaker to
 * place it on the clicked grid.
 * 
 * @author Leonard K. Ng'eno
 * 
 */
public class TilePanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private static final Dimension DEFAULT_SIZE = new Dimension(50, 50);
    private MouseAdapter myMouseListener;
    private List<Pixmap> myPixmaps;
    private Map<Pixmap, Rectangle> myBounds;
    private MapEditorScreen myEditor;

    public TilePanel (Dimension size, List<Pixmap> pixmaps, MapEditorScreen editor) {
        setSize(size);
        setPreferredSize(size);
        setVisible(true);
        makeListener();
        myEditor = editor;
        myPixmaps = new ArrayList<Pixmap>();
        myPixmaps = pixmaps;
        myBounds = new HashMap<Pixmap, Rectangle>();
        addMouseListener(myMouseListener);
        add(new JLabel("TILE IMAGES"), BorderLayout.NORTH);
    }

    /**
     * Paints the graphics on this component
     */
    @Override
    public void paintComponent (Graphics pen) {
        super.paintComponents(pen);

        paintTileImages((Graphics2D) pen);
    }

    private void paintTileImages (Graphics2D pen) {
        int xCenter = 25;
        int yCenter = 50;
        for (int k = 0; k < myPixmaps.size(); k++) {
            myPixmaps.get(k)
                    .paint(pen, new Location(k * DEFAULT_SIZE.width + xCenter, yCenter),
                           DEFAULT_SIZE);
            myBounds.put(myPixmaps.get(k), new Rectangle((k * DEFAULT_SIZE.width + xCenter) -
                                                         (DEFAULT_SIZE.width / 2),
                                                         yCenter - (DEFAULT_SIZE.height / 2),
                                                         DEFAULT_SIZE.width, DEFAULT_SIZE.height));
            xCenter += 10;
        }
    }

    private void makeListener () {
        myMouseListener = new MouseAdapter() {
            @Override
            public void mouseClicked (MouseEvent e) {
                handlePixmapClicked(e.getPoint());
            }
        };
    }

    private void handlePixmapClicked (Point point) {
        for (Pixmap pixmap : myPixmaps) {
            if (myBounds.get(pixmap).contains(point)) {
                String[] name = pixmap.getFilePath().split("/");
                myEditor.makeTileInstances(name[name.length - 1]);
            }
        }
    }

}
