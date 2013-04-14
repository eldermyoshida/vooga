package vooga.fighter.view;

import java.awt.geom.Point2D;
import java.lang.reflect.Field;
import java.util.Observer;
import vooga.fighter.util.Paintable;

public abstract class HUDElement implements Observer, Paintable {
    protected String myName;
    protected String myFieldName;
    protected Point2D.Double myLocation;
    
    public void setName (String name) {
        myName = name;
    }
    public void setObservedValue (String fieldName) {
        myFieldName = fieldName;
    }
    protected Object getObservedValue (Object o) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field member = o.getClass().getDeclaredField(myFieldName);
        member.setAccessible(true);
        return member.get(o);
    }
    
    public void setLocation(double x, double y) {
        myLocation.x = x;
        myLocation.y = y;
    }
    
    public void setLocation(Point2D location) {
        myLocation.x = location.getX();
        myLocation.y = location.getY();
    }
}
