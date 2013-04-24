package vooga.fighter.controller;

import java.util.List;
import vooga.fighter.util.HUDFactory;
import vooga.fighter.util.HUDVariable;
import vooga.fighter.view.HUDElement;

public class ScoreInfo extends DisplayInfo implements ViewDataSource{
    
    @HUDVariable(
                 name = "Winner",
                 HUDElementClass = "Text"
            )
    private String myWinner;
    
    public ScoreInfo() {
        super();
    }
    
    public void setWinners(List<Integer> winners) {
        System.out.println("Winner is Player " + winners.get(0));
        for (int i = 0; i < winners.size(); i++) {
            myWinner = "Winner is Player " + i;
        }
        addHUDElements();
    }
    
    protected void addHUDElements () {
        try {
            for (HUDElement e : HUDFactory.getHUDElements(this)) {
                addHUDDisplay(e);
            }
        }
        catch (InstantiationException e) {
            throw new NullPointerException("Could not instantiate HUDElement: " + e.getMessage());
        }
        catch (IllegalAccessException e) {
            throw new NullPointerException("Could not access member variable: " + e.getMessage());
        }
        catch (ClassNotFoundException e) {
            throw new NullPointerException("Could not find class: " + e.getMessage());
        }
    }
    
    
}
