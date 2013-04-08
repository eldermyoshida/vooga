package vooga.rts;

public class Game {

	public static final int FPS = 60;
	
	public static long TIME_PER_FRAME() {
		double persecond = 1/(double)FPS;
		persecond *= 1000;
		return (long)persecond;
	}
	
    public Game () {
        // TODO Auto-generated constructor stub
    }
}
