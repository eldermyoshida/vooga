package vooga.scroller.level_editor;

import java.awt.Image;
import java.util.Collection;
import vooga.scroller.util.Sprite;

public interface CreatableLib {

    public void add(Sprite s);
    public void add(Image b);
    public <E> void addAll(Collection<E> sprites);
    
}
