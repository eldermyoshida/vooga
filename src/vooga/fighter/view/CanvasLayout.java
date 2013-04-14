package fighter.view;

public abstract class CanvasLayout {
    public abstract void paintComponents (Graphics pen, ViewDataSource data);
    
    protected void defaultPaint(Graphics pen, ViewDataSource data, int objectNumber) {
        data.getPaintable(objectNumber).paint(pen, data.getLocation(objectNumber),data.size(objectNumber));
    }
}
