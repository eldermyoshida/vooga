package vooga.rts.gamedesign;

public class GameState {
	
	private AttackingState myAttackingState;
	private OccupyState myOccupyState;
	private ProducingState myProducingState;
	private MovementState myMovementState;
	
	public boolean canMove() { 
		return myMovementState == myMovementState.CAN_MOVE && myAttackingState == myAttackingState.CANNOT_ATTACK;
	}
	
	public void setState () {
		
	}
	
	public void update() {
		
	}
}
