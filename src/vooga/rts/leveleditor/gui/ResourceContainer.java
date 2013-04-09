package vooga.rts.leveleditor.gui;
import javax.imageio.ImageIO;
import javax.swing.JComponent;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Color;
import java.awt.Cursor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import java.util.ArrayList;

class ResourceContainer extends JComponent implements MouseListener
{


    private Dimension size = new Dimension(36,36);
    private BufferedImage myResourceImage;
    public static final String IMAGE_PATH = "/vooga/rts/leveleditor/resource/tree1.jpg";


    private Dimension mySize = new Dimension(36,36);

    
    private Dimension arc = new Dimension((int)Math.sqrt(mySize.width), (int)Math.sqrt(mySize.height));

    
    
   
    private int myValue;
    private int myPosition;


    private boolean mouseEntered = false;
    private boolean mousePressed = false;

    private ResourceOutliner myContainer;

    public ResourceContainer(int pos, ResourceOutliner container)
    {
        this(null,pos,container);
        setImageRelative(IMAGE_PATH);
    }
    public ResourceContainer(ActionListener e, int pos,ResourceOutliner container)
    {
        super();

        this.myContainer = container;

        enableInputMethods(true);
        addMouseListener(this);

        setSize(mySize.width, mySize.height);
        setFocusable(true);

        this.myPosition = pos;
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        if(myValue != -1)
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

            g.drawImage(myResourceImage, 0, 0, getWidth(), getHeight(), this);
            

        }
    }

    public void mouseClicked(MouseEvent e)
    {
        return;
    }
    public void mouseEntered(MouseEvent e)
    {
        mouseEntered = true;
        if(myValue != -1)
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
        if(myValue != 0)
        {
            myContainer.repaint();
            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
        repaint();
    }

    
    public Dimension getPreferredSize() {

        return new Dimension(getWidth(), getHeight());
    }
    public Dimension getMinimumSize() {
        return getPreferredSize();
    }
    public Dimension getMaximumSize() {
        return getPreferredSize();
    }

    
    private void setImageRelative (String path) {
        try {
            myResourceImage = ImageIO.read(this.getClass().getResource(path));
        }
        catch (Exception e) {
            
        }
    }

    public int getMyValue () {
        return myValue;
    }
    public void setMyValue (int myValue) {
        this.myValue = myValue;
    }
    public Dimension getArc () {
        return arc;
    }
    



}
