package vooga.fighter.controller;



import java.awt.Graphics;
import java.awt.Graphics2D;

public interface Mode {
	public void update(double stepTime);
	public String getNextModeName();
	public String getModeName();
	public boolean needNextMode();
	public void reset();
	public void paint(Graphics2D pen);
	public void setupPainting(PaintManager paintmanager);
	public Integer getStatus();
}
