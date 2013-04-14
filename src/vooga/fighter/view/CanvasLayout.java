package fighter.view;

import java.awt.Dimension;
import java.awt.Graphics;
import src.vooga.fighter.controller.ViewDataSource;

public abstract class CanvasLayout {
    public abstract void paintComponents (Graphics pen, ViewDataSource data, Dimension screenSize);
    
    protected void defaultPaint(Graphics pen, ViewDataSource data, int objectNumber) {
        data.getPaintable(objectNumber).paint(pen, data.getLocation(objectNumber),data.size(objectNumber));
    }
}
