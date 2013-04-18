package vooga.scroller.scrollingmanager;

import util.Location;
import vooga.scroller.sprites.superclasses.Player;
import vooga.scroller.view.View;

public class StaticScrollingManager extends DefaultScrollingManager {

    View myView;
    
    @Override
    public void initView(View view) {
        myView = view;
    }
    
    @Override
    public Location playerPaintLocation (Player p) {

        double halfwidth = myView.getWidth() / 2;
        double halfheight = myView.getHeight() / 2;
        
        return new Location(halfwidth, halfheight);
    }
    
    
}
