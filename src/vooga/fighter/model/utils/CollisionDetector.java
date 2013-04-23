package vooga.fighter.model.utils;

import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import util.Location;
import util.Vector;

///NOtes
// Method w/ vector to determine exactly where you collided
// Collide without vector
//Use rectanges
//

public class CollisionDetector {

	public CollisionDetector() {
	}
	
	
	public boolean quickDetectCollision(Shape shape1, Shape shape2){
		return shape1.contains(shape2.getBounds2D());
	}
	
	public boolean quickDetectCollision(Shape shape1, Point2D point2){
		return shape1.contains(point2);
	}
	
	
	public boolean preciseDetectCollision(Shape shape1, Point2D point2, 
			double rotationAngle1, double precision){
		AffineTransform transform1 = new AffineTransform().getRotateInstance(Math.toRadians(
				AcceptableAngle(rotationAngle1)));
		PathIterator path1 = shape1.getPathIterator(transform1);
		Location center1 = getPrecisionCenter(shape1,AcceptableAngle( rotationAngle1));
		float[] coord1 = new float[6];
		Vector vector2 = center1.difference(point2);
		while(!path1.isDone()){
			path1.currentSegment(coord1);
			Location point1 = new Location(coord1[0],coord1[1]);
			Vector vector1 = center1.difference(point1);
			if(Math.abs(AcceptableAngle(vector1.getAngleBetween(vector2)))<precision&&
					vector1.getMagnitude()> vector2.getMagnitude()){
				return true;
			}
		}
		return false;
	}
	
	public boolean preciseDetectCollision(Shape shape1, Point2D point2, 
			double precision){
		return preciseDetectCollision(shape1, point2, 0,precision);
	}
		
		public boolean preciseDetectCollision(Shape shape1, Point2D point2){
			return preciseDetectCollision(shape1,point2, 1); //1 degree
	}
	
	public boolean preciseDetectCollision(Shape shape1, Shape shape2, double rotationAngle1,
			double rotationAngle2, double precision){
		AffineTransform transform2 = new AffineTransform().getRotateInstance(Math.toRadians(rotationAngle2));
		PathIterator path2 = shape2.getPathIterator(transform2);
		float[] coord2 = new float[6];
			while(!path2.isDone()){
				path2.currentSegment(coord2);
				Location point2 = new Location(coord2[0],coord2[1]);
				if(preciseDetectCollision(shape1, point2, rotationAngle1, precision)) return true;
			}
			
		return false;
	}
	
	public boolean preciseDetectCollision(Shape shape1, Shape shape2, double precision){
		return preciseDetectCollision(shape1,shape2,0,0,precision);
	}
	
	public boolean preciseDetectCollsion(Shape shape1, Shape shape2){
		double precision = 1; //degree
		return preciseDetectCollision(shape1,shape2,1);
	}
	
	public Location getQuickCenter(Shape shape1){
		Rectangle2D rect = shape1.getBounds2D();
		return new Location(rect.getCenterX(), rect.getCenterY());
	}
	
	private Location getPrecisionCenter(Shape shape1, double rotationAngle){
		AffineTransform affinetransform = new AffineTransform().getRotateInstance(Math.toRadians(rotationAngle));
		PathIterator path1 = shape1.getPathIterator(affinetransform);
		float sumX = 0;
		float sumY = 0;
		int count = 0;
		float[] coordinates = new float[6]
;		while(!path1.isDone()){
			path1.currentSegment(coordinates);
			sumX += coordinates[0];
			sumY += coordinates[1];
			path1.next();
		}
		return new Location(sumX/count, sumY/count);
	}
	
	public Location getBottomRightCorner(Shape shape1){
		Rectangle2D rect = shape1.getBounds2D();
		return new Location(rect.getMaxX(),rect.getMaxY());
	}
	
	
	public Location getBottomLeftCorner(Shape shape1){
		Rectangle2D rect = shape1.getBounds2D();
		return new Location(rect.getMinX(),rect.getMaxY());
	}
	
	
	public Location getTopRightCorner(Shape shape1){
		Rectangle2D rect = shape1.getBounds2D();
		return new Location(rect.getMaxX(),rect.getMinY());
	}
	
	
	public Location getTopLeftCorner(Shape shape1){
		Rectangle2D rect = shape1.getBounds2D();
		return new Location(rect.getMinX(),rect.getMinY());
	}
	
	
    /**
     * Convenience method
     * Returns approximate direction from center of Shape to Point.
     */
	public double getQuickDirection (Shape shape1, Point2D point2){
			Location center = getQuickCenter(shape1);
			return AcceptableAngle(Vector.angleBetween(point2, center));
	}
	
	public boolean hitTop(Shape shape1, Point2D point2){
		double hitdirection = getQuickDirection(shape1,point2);
		if((hitdirection-getQuickDirection(shape1, getTopLeftCorner(shape1) ) > 0 &&
			(hitdirection-getQuickDirection(shape1, getTopRightCorner(shape1))) <= 0)){
					return true;
				}
		return false;
	}
	public boolean hitRight(Shape shape1, Point2D point2){
		double hitdirection = getQuickDirection(shape1,point2);
		if((hitdirection-getQuickDirection(shape1, getTopRightCorner(shape1) ) > 0 ||
			(hitdirection-getQuickDirection(shape1, getBottomRightCorner(shape1))) <= 0)){
					return true;
				}
		return false;
	}
	public boolean hitLeft(Shape shape1, Point2D point2){
		double hitdirection = getQuickDirection(shape1,point2);
		if((hitdirection-getQuickDirection(shape1, getBottomLeftCorner(shape1) ) > 0 &&
			(hitdirection-getQuickDirection(shape1, getTopLeftCorner(shape1))) <= 0)){
					return true;
				}
		return false;
	}
	public boolean hitBottom(Shape shape1, Point2D point2){
		double hitdirection = getQuickDirection(shape1,point2);
		if((hitdirection-getQuickDirection(shape1, getBottomLeftCorner(shape1) ) <= 0 &&
			(hitdirection-getQuickDirection(shape1, getBottomRightCorner(shape1))) > 0)){
					return true;
				}
		return false;
	}
	
	/**
	 * Returns whether the second shape has collided with the top of the 
	 * first shape
	 */
	public boolean hitTop(Shape shape1, Shape shape2){
		if(quickDetectCollision(shape1, getBottomRightCorner(shape2)))
			return hitTop(shape1, getBottomRightCorner(shape2));	
		else if(quickDetectCollision(shape1, getBottomLeftCorner(shape2)))
			return hitTop(shape1, getBottomLeftCorner(shape2));	
		return false;
	}
	/**
	 * Returns whether the second shape has collided with the right of the 
	 * first shape
	 */
	public boolean hitRight(Shape shape1, Shape shape2){
		if(quickDetectCollision(shape1, getBottomLeftCorner(shape2))){
			System.out.println("BOTTOM LEFT");
			return hitRight(shape1, getBottomLeftCorner(shape2));
		}
		else if(quickDetectCollision(shape1, getTopLeftCorner(shape2))){
			System.out.println("TOP LEFT");
			return hitRight(shape1, getTopLeftCorner(shape2));	
		}
		return false;
	}
	
	/**
	 * Returns whether the second shape has collided with the Bottom of the 
	 * first shape
	 */
	public boolean hitBottom(Shape shape1, Shape shape2){
		if(quickDetectCollision(shape1, getTopRightCorner(shape2)))
			return hitBottom(shape1, getTopRightCorner(shape2));	
		else if(quickDetectCollision(shape1, getTopLeftCorner(shape2)))
			return hitBottom(shape1, getTopLeftCorner(shape2));	
		return false;
	}
	/**
	 * Returns whether the second shape has collided with the left of the 
	 * first shape
	 */
	public boolean hitLeft(Shape shape1, Shape shape2){
		if(quickDetectCollision(shape1, getBottomRightCorner(shape2)))
			return hitLeft(shape1, getBottomRightCorner(shape2));	
		else if(quickDetectCollision(shape1, getTopRightCorner(shape2)))
			return hitLeft(shape1, getTopRightCorner(shape2));	
		return false;
	}
	

	private double turn(double Angle, double turnAngle) {
		double angle = AcceptableAngle(Angle + turnAngle);
		return angle;
	}

	public double AcceptableAngle(double Angle) {
		while (Angle > 360)
			Angle -= 360;
		while (Angle < 0)
			Angle += 360;
		return Angle;
	}

}
