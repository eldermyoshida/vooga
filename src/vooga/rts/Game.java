package vooga.rts;


import vooga.rts.controller.MainController;

public class Game {
	MainController myMainController;

	public static final int FPS = 60;
	
	public static double TIME_PER_FRAME() {
		double persecond = 1/(double)FPS;
		return persecond;
	}
	
    public Game () {
        // TODO Auto-generated constructor stub
    }
    
}

