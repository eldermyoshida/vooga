package vooga.fighter.objects;

public interface Attackable {
	public void inflictDamage(GameObject o, int amount);
	public void hasPriority (GameObject o);
}
