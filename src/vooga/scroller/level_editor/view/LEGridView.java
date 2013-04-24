package vooga.scroller.level_editor.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JScrollPane;
import javax.swing.Scrollable;
import vooga.scroller.level_editor.commands.CommandConstants;
import vooga.scroller.level_editor.controllerSuite.LEGrid;
import vooga.scroller.level_editor.exceptions.LevelEditorException;
import vooga.scroller.util.Renderable;
import vooga.scroller.util.Renderer;
import vooga.scroller.util.mvc.IView;
import vooga.scroller.util.mvc.vcFramework.WindowComponent;


public class LEGridView extends WindowComponent<LevelEditing> 
implements Scrollable, Renderer<LevelEditing>{
    private class GridPositionListener implements MouseListener {

        @Override
        public void mouseClicked (MouseEvent e) {
            if (e.getButton() == 3) { //Right Click
                deleteSprite(e.getX(), e.getY());
            }
            else if(e.getButton() == 1){ //Left Click
                createSprite(e.getX(), e.getY());
            }
        }

        @Override
        public void mouseEntered (MouseEvent e) {
        }

        @Override
        public void mouseExited (MouseEvent e) {
        }

        @Override
        public void mousePressed (MouseEvent e) {
        }

        @Override
        public void mouseReleased (MouseEvent e) {
        }

    }
    
    
    public static double getDefaultHeightRatio() {
        return LevelEditing.VIEW_CONSTANTS.DEFAULT_GRIDVIEW_HEIGHT_RATIO;
    }
    
    
    public static double getDefaultWidthRatio() {
        return LevelEditing.VIEW_CONSTANTS.DEFAULT_GRIDVIEW_WIDTH_RATIO;
    }
    
            
    /**
     * 
     */
    private static final long serialVersionUID = 8266835201464623542L;
    private LEGrid myGrid;

    /**
     * Specify a container parent and a width and height ratio.
     * @param parent
     * @param d
     * @param e
     */
    public LEGridView (IView parent, Renderable<LevelEditing> r) {
        // TODO Auto-generated constructor stub
        super(parent,((LEGrid) r).getPixelSize());
        this.addMouseListener(new GridPositionListener());
        
    }

    private void createSprite (int x, int y) {
        String cmd = CommandConstants.CREATE_SPRITE + CommandConstants.SPACE
                     + x + CommandConstants.SPACE + y;
        process(cmd);
    }

    private void deleteSprite (int x, int y) {
        String cmd = CommandConstants.DELETE_SPRITE + CommandConstants.SPACE
                + x + CommandConstants.SPACE + y;
        process(cmd);  
    }

    @Override
    public Dimension getPreferredScrollableViewportSize () {
        // TODO Auto-generated method stub
        Dimension d = this.getResponsible().getSize();
        Dimension res = new Dimension((int)(d.width*getDefaultWidthRatio()), 
                                      (int)(d.height*getDefaultHeightRatio()));
        return res;
    }

    @Override
    public int getScrollableBlockIncrement (Rectangle visibleRect, int orientation, int direction) {
        return myGrid.getScrollableBlockIncrement(visibleRect, orientation, direction);
    }

    @Override
    public boolean getScrollableTracksViewportHeight () {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean getScrollableTracksViewportWidth () {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int getScrollableUnitIncrement (Rectangle visibleRect, int orientation, int direction) {
        return myGrid.getScrollableUnitIncrement(visibleRect, orientation, direction);
    }

    public boolean isValidForSimulation () {
        return myGrid.isValidForSimulation();
    }

    /**
     * Paint the contents of the canvas.
     * 
     * Never called by you directly, instead called by Java runtime
     * when area of screen covered by this container needs to be
     * displayed (i.e., creation, uncovering, change in status)
     * 
     * @param pen used to paint shape on the screen
     */
    @Override
    public void paintComponent (Graphics pen) {
        pen.setColor(Color.WHITE);
        pen.fillRect(0, 0, getSize().width, getSize().height);
        if (myGrid != null) {
            myGrid.paint((Graphics2D) pen);
        }
    }


    @Override
    public void setRenderable (Renderable<LevelEditing>  r) {
        myGrid = (LEGrid) r;
        setSize(myGrid.getPixelSize());
        repaint();
    }

    @Override
    public void render (Renderable<LevelEditing> r) {
       if (r instanceof LEGrid) {
           render((LEGrid) r);
       }
    else try {
        throw new LevelEditorException("LEGridView cannot render" + r.getClass().getName());
    }
    catch (LevelEditorException e) {
        e.printStackTrace();
    }
           
    }

    @Override
    public Renderable<LevelEditing> getRenderable () {
        return myGrid;
    }


    public void simulate () {
        myGrid.simulate();
    }

}
