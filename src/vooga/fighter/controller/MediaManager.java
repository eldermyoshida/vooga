package vooga.fighter.controller;

public class MediaManager {
	private PaintManager myPaintManager;
	private SoundManager mySoundManager;
	
	public MediaManager() {
		myPaintManager = new PaintManager();
		mySoundManager = new SoundManager();
	}

	public SoundManager getSoundManager(){
		return mySoundManager;
	}
	
	public PaintManager getPaintManager(){
		return myPaintManager;
	}
}
