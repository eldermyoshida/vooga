package vooga.towerdefense.arcadeinteraction;

import arcade.games.UserGameData;

/**
 * Creates a user profile for a towerdefense player.
 * Extends UserGameData from the arcade.
 *
 * @author Angelica Schwartz
 */
public class TowerDefenseUserGameData extends UserGameData {
    
    private double myMoney;
    
    public TowerDefenseUserGameData() {
        super();
      //TODO: get starting money value from resource file?
        myMoney = 10;
    }
    
    public void setStartingMoneyValue(double money) {
        myMoney = money;
    }
}
