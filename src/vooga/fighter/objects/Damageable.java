package vooga.fighter.objects;

public interface Damageable {
	public int getHealth(); 
	public void reduceHealth(int amount);
	public boolean isDestroyed();
}
