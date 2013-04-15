package vooga.towerdefense.model;

import vooga.towerdefense.controller.Controller;


public class GameController {
    private final int TICKS_PER_SECOND = 50;
    private final int SKIP_TICKS = 1000 / TICKS_PER_SECOND;
    private final int MAX_FRAMESKIP = 10;

    private boolean gameIsRunning = false;
    private Controller myController;

    public GameController (Controller controller) {
        // TODO: functions to construct model from file. Probably put that in
        // GameModel constructor.
        myController = controller;
    }

    public void start () {
        setRunning(true);
        run();
    }

    public void run () {
        // this game loop will update the game at up to TICKS_PER_SECOND, and
        // repaint the screen as fast as possible.
        long nextGameTick = System.currentTimeMillis();

        int loops = 0;
        while (gameIsRunning) {
            while (System.currentTimeMillis() > nextGameTick
                   && loops < MAX_FRAMESKIP) {
                myController.update(System.currentTimeMillis() - nextGameTick);
                nextGameTick += SKIP_TICKS;
                loops++;
            }
            myController.displayMap();
        }
    }

    public void setRunning (boolean isRunning) {
        gameIsRunning = isRunning;
        run();
    }
}
