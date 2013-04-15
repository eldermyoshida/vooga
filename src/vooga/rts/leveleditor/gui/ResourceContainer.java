package vooga.rts.leveleditor.gui;
import javax.swing.JComponent;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Color;
import java.awt.Cursor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.util.ArrayList;

class ResourceContainer extends JComponent implements MouseListener
{
    
    private Dimension size = new Dimension(36,36);

    
    public Dimension arc = new Dimension((int)Math.sqrt(size.width), (int)Math.sqrt(size.height));

   
    public int val;
    public int pos;

    private boolean mouseEntered = false;
    private boolean mousePressed = false;

    private ResourceOutliner container;

    public ResourceContainer(int pos, ResourceOutliner container)
    {
        this(null,pos,container);
    }
    public ResourceContainer(ActionListener e, int pos,ResourceOutliner container)
    {
        super();

        this.container = container;

        enableInputMethods(true);
        addMouseListener(this);

        setSize(size.width, size.height);
        setFocusable(true);

        this.pos = pos;
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        if(val != -1)
        {
            // turn on anti-alias mode
            Graphics2D antiAlias = (Graphics2D)g;
            antiAlias.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

           
            // draw black border
            if (mousePressed){
            	g.setColor(Color.RED);
            }
            else if(mouseEntered)
            {
                g.setColor(Color.YELLOW);
            }
            else
            {
                g.setColor(Color.BLACK);
            }
            g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arc.width, arc.height);

            // draw inside light border
            g.setColor(Color.decode("#c0c0c0"));
            g.drawRoundRect(1, 1, getWidth() - 3, getHeight() - 3, arc.width, arc.height);

           
        }
    }
   
    public void mouseClicked(MouseEvent e)
    {
    	return;
    }
    public void mouseEntered(MouseEvent e)
    {
        mouseEntered = true;
        if(val != -1)
        {
            setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
        repaint();
    }
    public void mouseExited(MouseEvent e)
    {
        mouseEntered = false;
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        repaint();
    }
    public void mousePressed(MouseEvent e)
    {
        if (mousePressed){
        	mousePressed = false; //TODO: make only one selected
        }else{
        	mousePressed = true;
        }
        repaint();
    }
    public void mouseReleased(MouseEvent e)
    {
        //mousePressed = false;
        if(val != 0)
        {
            container.repaint();
            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
        repaint();
    }
    
    public Dimension getPreferredSize()
    {
        return new Dimension(getWidth(), getHeight());
    }
    public Dimension getMinimumSize()
    {
        return getPreferredSize();
    }
    public Dimension getMaximumSize()
    {
        return getPreferredSize();
    }
}
