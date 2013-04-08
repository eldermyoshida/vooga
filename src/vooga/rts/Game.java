package vooga.rts;


import vooga.rts.controller.MainController;

public class Game {
	MainController myMainController;

	public static final int FPS = 60;
	
	public static long TIME_PER_FRAME() {
		double persecond = 1/(double)FPS;
		persecond *= 1000;
		return (long)persecond;
	}
	
    public Game () {
        myMainController = new MainController();
    }
    
    public static void main(String[] args) {
    	Game game = new Game();
    }
}

