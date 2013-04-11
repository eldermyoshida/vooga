package vooga.fighter.view;

import java.lang.reflect.Field;
import java.util.Observer;

public abstract class HUDElement implements Observer {
    protected String myName;
    protected String myFieldName;
    
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
}
