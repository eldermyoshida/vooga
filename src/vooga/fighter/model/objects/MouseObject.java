package vooga.fighter.model.objects;

import java.awt.geom.Point2D;

import vooga.fighter.model.loaders.MouseLoader;
import vooga.fighter.model.utils.UpdatableLocation;

public class MouseObject extends GameObject {

	private static final String MOUSE_IMAGE_TAG = "mouse";
    private int myTicks;
    
	public MouseObject(Point2D loc) {
        setLocation(new UpdatableLocation(loc.getX(), loc.getY()));
        setLoader(new MouseLoader(this));
        setImageData();
        myTicks = 0;
	}
	

    @Override
    public boolean shouldBeRemoved () {
        return (myTicks > 0);
    }

    @Override
    public void completeUpdate () {
        myTicks++;
    }
	
    public String getImageTag(){
    	return MOUSE_IMAGE_TAG;
    }



	@Override
	public void dispatchCollision(GameObject other) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void handleCollision(CharacterObject other) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void handleCollision(AttackObject other) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void handleCollision(EnvironmentObject other) {
		// TODO Auto-generated method stub
		
	}

}
