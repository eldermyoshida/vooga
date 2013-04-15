package vooga.rts.tests;

import static org.junit.Assert.*;
import org.junit.Test;
import vooga.rts.util.Camera;
import vooga.rts.util.Location;
import vooga.rts.util.Location3D;


public class TestCamera {

    Camera myCamera = new Camera(new Location3D());

    @Test
    public void test () {
        fail("Not yet implemented");
    }

    @Test
    public void TestBasicWorldtoScreen () {
        Location3D loc = new Location3D(0, 0, 0);
        Location res = myCamera.worldToView(loc);
        System.out.println(res);
        assertEquals(res, new Location(0, 0));
    }
    
    @Test
    public void TestPositiveWorldtoScreen () {
        Location3D loc = new Location3D(100, 50, 0);
        Location res = myCamera.worldToView(loc);
        System.out.println(res);
        //assertEquals(res, new Location(0, 0));
    }

}
