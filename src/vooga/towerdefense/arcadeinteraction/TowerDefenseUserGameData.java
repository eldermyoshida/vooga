package vooga.towerdefense.arcadeinteraction;

import arcade.games.UserGameData;

/**
 * Creates a user profile for a towerdefense player.
 * Extends UserGameData from the arcade.
 *
 * @author Angelica Schwartz
 */
public class TowerDefenseUserGameData extends UserGameData {
    
    /**
     * user's last money value.
     */
    private double myMoney;
    
    /**
     * constructor.
     */
    public TowerDefenseUserGameData() {
        super();
      //TODO: get starting money value from resource file?
        myMoney = 10;
    }
    
    /**
     * method to set the default starting money value.
     * @param money is the default value
     */
    public void setStartingMoneyValue(double money) {
        myMoney = money;
    }
}
