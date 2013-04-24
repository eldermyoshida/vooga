package vooga.fighter.model.objects;

import java.awt.geom.Point2D;


public class MouseClickObject extends MouseObject {

	private static final String MOUSE_CLICK_IMAGE_TAG = "mouseclick";

    public MouseClickObject (Point2D loc) {
    	super(loc);
    }
    
    @Override
    public String getImageTag(){
    	return MOUSE_CLICK_IMAGE_TAG;
    }
}
