package vooga.rts.util;

/**
 * This allows the game to execute something at a later time.
 * The DelayedTask is updated every cycle of update in order
 * to keep track of how much time has occurred in total. <br />
 * When the elapsed time is greater than the time to run, the
 * Runnable passed in to the constructor will be executed.
 * 
 * @author Jonathan Schmidt
 * 
 */
public class DelayedTask {

    private double myElapsedTime;
    private double myTotalTime;
    private Runnable myTask;

    /**
     * Creates a Delayed Task with the specified time until the
     * task runs as well as a Runnable which defines the task
     * to run.
     * 
     * @param runIn The number of seconds until the a task is executed.
     * @param toRun The Runnable to run after the specified time.
     */
    public DelayedTask (double runIn, Runnable toRun) {
        myTotalTime = runIn;
        myTask = toRun;
        myElapsedTime = 0;
    }

    /**
     * Updates the DelayedTask with the time that has elapsed
     * since the last time it was updated.
     * If the total elapsed time is greater than the time required
     * before the task is run, it will run the task.
     * 
     * @param elapsedTime
     */
    public void update (double elapsedTime) {
        if (isActive()) {
            myElapsedTime += elapsedTime;
            if (myTotalTime <= myElapsedTime) {
                myTask.run();
            }
        }
    }

    public boolean isActive () {
        return myElapsedTime < myTotalTime;
    }

    public void cancel () {
        myElapsedTime = myTotalTime;
    }

    public void restart () {
        myElapsedTime = 0;
    }

    public double getPercentCompleted () {
        if (myTotalTime != 0) {
            return (myElapsedTime / myTotalTime) * 100;
        }
        return 0;
    }
}
