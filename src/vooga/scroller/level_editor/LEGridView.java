package vooga.scroller.level_editor;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import vooga.scroller.viewUtil.IView;
import vooga.scroller.viewUtil.ViewConstants;
import vooga.scroller.viewUtil.Renderable;
import vooga.scroller.viewUtil.WindowComponent;

public class LEGridView extends WindowComponent{
    /**
     * 
     */
    private static final long serialVersionUID = 8266835201464623542L;
    private Dimension mySize;
    private Renderable myLevel;

    public LEGridView (IView parent) {
        super(parent);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void initializeVariables () {
        // TODO Auto-generated method stub
        mySize = ViewConstants.DEFAULT_ROOM_SIZE;
        this.setPreferredSize(mySize);
        this.setMinimumSize(mySize);
        
    }

    @Override
    protected void addComponents () {
    }

    @Override
    public void render (Renderable r) {
        myLevel = r;
        repaint();
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
        if (myLevel != null) {
            myLevel.paint((Graphics2D) pen);
        }
    }

}
