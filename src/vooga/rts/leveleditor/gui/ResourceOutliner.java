package vooga.rts.leveleditor.gui;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import java.util.Arrays;
import java.util.ArrayList;

public class ResourceOutliner extends JPanel
{
    
    public ResourceContainer[] resourceContainer = new ResourceContainer[5];
    
    public ResourceOutliner(ResourceContainer[] d)
    {
        this.resourceContainer = d;

        for(int i = 0; i < resourceContainer.length; i++)
        {
            resourceContainer[i] = new ResourceContainer(i, this);
            resourceContainer[i].val = -1;


            add(resourceContainer[i]);
        }

        repaint();
    }
    public void paint(Graphics g)
    {
        super.paint(g);

        // turn on anti-alias mode
        Graphics2D antiAlias = (Graphics2D)g;
        antiAlias.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int arc = 15;
        int offset = 1;

        g.setColor(Color.decode("#555555"));
        g.fillRoundRect(0, 0, getWidth(), getHeight(), arc, arc);

        g.setColor(Color.decode("#cccccc"));
        g.fillRoundRect(offset, offset, getWidth() - (offset * 2), getHeight() - (offset * 2), arc, arc);

        g.setColor(Color.WHITE);
        for(int i = 0; i < resourceContainer.length; i++)
        {
            g.fillRoundRect(
                resourceContainer[i].getX() - offset,
                resourceContainer[i].getY() - offset,
                resourceContainer[i].getWidth() + (offset * 2),
                resourceContainer[i].getHeight() + (offset * 2),
                resourceContainer[i].arc.width,
                resourceContainer[i].arc.height
            );
        }

        super.paintChildren(g);
    }
    public void addDice()
    {
        for(int i = 0; i < resourceContainer.length; i++)
        {
            if(resourceContainer[i].val == -1)
            {
                resourceContainer[i].val = 0;
                return;
            }
        }
        return;
    }
}
