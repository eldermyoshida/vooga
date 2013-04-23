package vooga.fighter.util;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import util.Velocity;

public class Physicstester {
    private static final Velocity STILL = new Velocity(0, 0, 0, 0);
    private static final Velocity UP = new Velocity(0, 0, 90, 10);
    private static final Velocity DOWN = new Velocity(0, 0, 270, 10);
    private static final Velocity LEFT = new Velocity(0, 0, 180, 10);
    private static final Velocity RIGHT = new Velocity(0, 0, 0, 10);
    private static final Velocity RIGHTUP = new Velocity(0, 0, 45, 10);
    private static final Velocity RIGHTDOWN = new Velocity(0, 0, 315, 10);
    private static final Velocity LEFTUP = new Velocity(0, 0, 135, 10);
    private static final Velocity LEFTDOWN = new Velocity(0, 0, 225, 10);
    private static final int MASS = 10;

    @Before
    public void setUp () throws Exception {
        
    }

    @Test
    public void testElasticCollision () {
        fail("Not yet implemented");
    }

    @Test
    public void testInelasticCollision () {
        Velocity upVel = UP.clone();
        upVel.translate(0, -5);
        Velocity[] newVel = Physics.inelasticCollision(upVel, MASS, STILL, MASS);
        assertEquals(90.0,newVel[0].getDirection(),2);
        assertEquals(90.0,newVel[1].getDirection(),2);
        assertEquals(newVel[0].getMagnitude(),newVel[1].getMagnitude(),.01);
    }

    @Test
    public void testPartiallyInelasticCollision () {
        fail("Not yet implemented");
    }

    @Test
    public void testGravity () {
        fail("Not yet implemented");
    }

    @Test
    public void testFriction () {
        fail("Not yet implemented");
    }

    @Test
    public void testSliding () {
        fail("Not yet implemented");
    }

    @Test
    public void testBounce () {
        fail("Not yet implemented");
    }

    @Test
    public void testApplyForceVelocityDoubleVelocity () {
        fail("Not yet implemented");
    }

    @Test
    public void testApplyForceVelocityDoubleVelocityDouble () {
        fail("Not yet implemented");
    }

}
