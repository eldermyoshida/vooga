package vooga.rts.util;

import java.awt.Dimension;

public class Camera {

    private Location myScreenLocation;    
    private Dimension myScreenSize;
    
    private Location3D myWorldCenter;
    
    public Camera (Location3D playerLoc) {
        myWorldCenter = new Location3D(playerLoc);
    }
    
    public Location worldToView(Location3D world) {
        return new Location();
    }
    
    public Location3D viewtoWorld(Location view) {
        return new Location3D();
    }
    
    

}
