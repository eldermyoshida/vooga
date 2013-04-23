package vooga.fighter.test;

import static org.junit.Assert.*;

import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Point2D;

import org.junit.Test;

import util.Location;
import vooga.fighter.model.utils.CollisionDetector;

public class CollisionDetectorTester {
	CollisionDetector myDetector;
	
    public void setUp(){
    	myDetector = new CollisionDetector();
    }
    
	@Test
	public void testgetQuickCenter() {
		setUp();
		Rectangle rect2 = new Rectangle(100,100);
		assertTrue(myDetector.getQuickCenter(rect2).getX()==50.0);
		assertTrue(myDetector.getQuickCenter(rect2).getY()==50.0);
	}
	
	@Test
	public void testgetBottomRightCorner() {
		setUp();
		Rectangle rect2 = new Rectangle(100,100);
		assertTrue(myDetector.getBottomRightCorner(rect2).getX()==100);
		assertTrue(myDetector.getBottomRightCorner(rect2).getY()==100);
	}
	
	@Test
	public void testgetBottomLeftCorner() {
		setUp();
		Rectangle rect2 = new Rectangle(100,100);
		assertTrue(myDetector.getBottomLeftCorner(rect2).getX()==0);
		assertTrue(myDetector.getBottomLeftCorner(rect2).getY()==100);
	}
    
	@Test
	public void testgetQuickDirection (){
		setUp();
		Rectangle rect2 = new Rectangle(100,100);
		Location loc = new Location(50,100);
		assertTrue(myDetector.getQuickDirection(rect2, loc)==90);
	}
	
	@Test
	public void testquickDetectCollision (){
		setUp();
		Rectangle rect2 = new Rectangle(100,100);
		Location loc = new Location(0,0);
		assertTrue(myDetector.quickDetectCollision(rect2, loc));
	}
    
	@Test
	public void testHitTopPoint() {
		setUp();
		Rectangle rect1 = new Rectangle(100,100);
		Location loc = new Location(50,10);
		assertTrue(myDetector.hitTop(rect1,loc));
	}
	
	@Test
	public void testHitBottomPoint() {
		setUp();
		Rectangle rect1 = new Rectangle(100,100);
		Location loc = new Location(50,90);
		assertTrue(myDetector.hitBottom(rect1,loc));
	}
	
	@Test
	public void testHitRightPoint() {
		setUp();
		Rectangle rect1 = new Rectangle(100,100);
		Location loc = new Location(90,50);
		assertTrue(myDetector.hitRight(rect1,loc));
	}
	@Test
	public void testHitLeftPoint() {
		setUp();
		Rectangle rect1 = new Rectangle(100,100);
		Location loc = new Location(10,50);
		assertTrue(myDetector.hitLeft(rect1,loc));
	}
	
	
	@Test
	public void testHitTop() {
		setUp();
		Rectangle rect1 = new Rectangle(100,100);
		Rectangle rect2 = new Rectangle(50,10,1,1);
		assertTrue(myDetector.hitTop(rect1,rect2));
	}
	
	@Test
	public void testHitBottom() {
		setUp();
		Rectangle rect1 = new Rectangle(100,100);
		Rectangle rect2 = new Rectangle(50,90,1,1);
		assertTrue(myDetector.hitBottom(rect1,rect2));
	}
	
	@Test
	public void testHitRight() {
		setUp();
		Rectangle rect1 = new Rectangle(100,100);
		Rectangle rect2 = new Rectangle(90, 50,1,1);
		assertTrue(myDetector.hitRight(rect1,rect2));
	}
	@Test
	public void testHitLeft() {
		setUp();
		Rectangle rect1 = new Rectangle(100,100);
		Rectangle rect2 = new Rectangle(10,50,1,5);
		assertTrue(myDetector.hitLeft(rect1,rect2));
	}

}
