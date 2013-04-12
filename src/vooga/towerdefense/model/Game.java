package vooga.towerdefense.model;

import java.util.ArrayList;
import java.util.List;

import vooga.towerdefense.gameElements.ExampleWave;
import vooga.towerdefense.gameElements.Unit;
import vooga.towerdefense.gameElements.Wave;
import vooga.towerdefense.view.TDView;



public class Game {
	private final int TICKS_PER_SECOND = 50;
	private final int SKIP_TICKS = 1000 / TICKS_PER_SECOND;
	private final int MAX_FRAMESKIP = 10;

	private boolean game_is_running = false;
	private GameModel myModel;

	public Game(TDView view) {
		// TODO: functions to construct model from file. Probably put that in
		// GameModel constructor.
		
		List<Unit> units = new ArrayList<Unit>();
		double spawnDelay = 100;
		double duration = 60000;
		Wave wave = new ExampleWave(myModel.getMap(), units, spawnDelay,
				duration);
		List<Wave> waves = new ArrayList<Wave>();
		waves.add(wave);
		
		myModel = new GameModel(view, waves, myModel.getMap());
	}

	public void start() {
		setRunning(true);
		run();
	}

	public void run() {
		// this game loop will update the game at up to TICKS_PER_SECOND, and
		// repaint the screen as fast as possible.
		long next_game_tick = System.currentTimeMillis();

		int loops;

		while (game_is_running) {
			loops = 0;
			while (System.currentTimeMillis() > next_game_tick
					&& loops < MAX_FRAMESKIP) {
				myModel.update(System.currentTimeMillis() - next_game_tick);
				next_game_tick += SKIP_TICKS;
				loops++;
			}
			myModel.displayMap();
		}
	}

	public void setRunning(boolean isRunning) {
		game_is_running = isRunning;
		run();
	}
}
