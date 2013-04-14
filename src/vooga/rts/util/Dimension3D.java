package vooga.rts.util;

public class Dimension3D {
    
    // Uses a Location3D to store the values of the dimension
    // X = width
    // Y = depth
    // Z = height
    private Location3D mySize;

    
    public Dimension3D (double width, double depth, double height) {
        mySize = new Location3D(width, depth, height);
    }

}

