package vooga.fighter.objects;

import java.util.List;

public class CollisionManager {
	List<GameObject> myObjects;
	
	public CollisionManager (List<GameObject> objects){
		myObjects= objects; 
	}
	
	public void checkCollisions(){
		for (int i=0; i<myObjects.size()-1; i++){
			for (int j=i+1; j<myObjects.size(); j++){
				GameObject o1=myObjects.get(i);
				GameObject o2=myObjects.get(j);
				if (o1.getCurrentState().getCurrentRectangle().intersects(o2.getCurrentState().getCurrentRectangle())){
					handleCollisions(o1,o2);
				}
			}
		}
	}
	
	public void handleCollisions(GameObject o1, GameObject o2){
		o1.applyCollideEffect(o2);
		o2.applyCollideEffect(o2);
	}



	
}
