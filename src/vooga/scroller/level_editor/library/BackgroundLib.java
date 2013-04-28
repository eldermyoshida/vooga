package vooga.scroller.level_editor.library;

import java.util.HashMap;
import java.util.Map;
import vooga.scroller.util.IBackgroundView;
import vooga.scroller.util.Pixmap;


public class BackgroundLib implements IBackgroundLibrary {

    private Map<Integer, IBackgroundView> myPixmaps;

    
    public BackgroundLib (String backgroundLocation, String[] fileNames) {
        int i = 0;
        myPixmaps = new HashMap<Integer, IBackgroundView>();
        for (String fn : fileNames) {
            Pixmap p =new Pixmap(backgroundLocation,fn);
            myPixmaps.put(i, p);
            i++;
        }
    }

    @Override
    public Map<Integer, IBackgroundView> getBackgrounds () {
        return myPixmaps;
    }

}
