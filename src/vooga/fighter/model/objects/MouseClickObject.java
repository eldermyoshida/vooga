package vooga.fighter.model.objects;

import java.awt.geom.Point2D;
import vooga.fighter.model.loaders.MouseClickLoader;
import vooga.fighter.model.utils.UpdatableLocation;


public class MouseClickObject extends GameObject {

    private int myTicks;

    public MouseClickObject (Point2D loc) {
        setLocation(new UpdatableLocation(loc.getX(), loc.getY()));
        setLoader(new MouseClickLoader(this));
        System.out.println();
        myTicks = 0;
        setImageData();
    }

    @Override
    public boolean shouldBeRemoved () {
        return (myTicks > 30);
    }

    @Override
    public void completeUpdate () {
        myTicks++;
    }

    @Override
    public void dispatchCollision (GameObject other) {
        // TODO Auto-generated method stub

    }

    @Override
    public void handleCollision (CharacterObject other) {
        // TODO Auto-generated method stub

    }

    @Override
    public void handleCollision (AttackObject other) {
        // TODO Auto-generated method stub

    }

    @Override
    public void handleCollision (EnvironmentObject other) {
        // TODO Auto-generated method stub

    }
}
