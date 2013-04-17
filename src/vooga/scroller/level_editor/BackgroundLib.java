package vooga.scroller.level_editor;

import java.util.HashMap;
import java.util.Map;
import javax.swing.Icon;
import javax.swing.ImageIcon;


public class BackgroundLib implements IBackgroundLibrary {

    private static final String BACKGROUND_LOCATION = "/vooga/scroller/images/backgrounds";
    private Map<Integer, Icon> myBackgrounds;

    public BackgroundLib (String[] fileNames) {
        int i = 0;
        myBackgrounds = new HashMap<Integer, Icon>();
        for (String fn : fileNames) {
            myBackgrounds.put(i, new ImageIcon(BACKGROUND_LOCATION+fn));
            i++;
        }
    }

    @Override
    public Map<Integer, Icon> getBackgrounds () {
        return myBackgrounds;
    }

}
