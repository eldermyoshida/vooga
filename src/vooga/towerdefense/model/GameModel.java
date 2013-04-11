package vooga.towerdefense.model;
import java.util.List;

import vooga.towerdefense.gameElements.Wave;


public class GameModel {
    private List<Wave> myWaves;  
    private GameMap myGameMap;
    private double myWaveTimeElapsed;
    private Wave myCurrentWave;
    
    public GameModel(List<Wave> waves, GameMap gameMap) {
        myWaves = waves;
        myGameMap = gameMap;
        myWaveTimeElapsed = 0;
        startNextWave();
    }
    
    public void update(double elapsedTime) {
        updateWave(elapsedTime);
        myGameMap.update(elapsedTime);
    }
    
    public void updateWave(double elapsedTime) {
        myWaveTimeElapsed += elapsedTime;
        if (myWaveTimeElapsed > myCurrentWave.getDuration()) {            
            myWaveTimeElapsed = 0;
            startNextWave();
        }
    }
    
    private void startNextWave() {
        myCurrentWave = myWaves.iterator().next();
    }
}
