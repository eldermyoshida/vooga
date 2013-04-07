package vooga.fighter.objects;

public interface Wieldable {
	public void addAttackPower (int amount);
	public void unequip(CharacterObject o);
	public void equip (CharacterObject o);

}
