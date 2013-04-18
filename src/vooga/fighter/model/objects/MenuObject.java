package vooga.fighter.model.objects;

public class MenuObject extends GameObject {

	public MenuObject() {
		
	}

	@Override
	public boolean shouldBeRemoved() {
		return false;
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
