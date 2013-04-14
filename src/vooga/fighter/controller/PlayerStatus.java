package vooga.fighter.controller;


import vooga.fighter.objects.utils.Health;

public class PlayerStatus {
    
    private String myName;
    private Health myHealth;
    private Integer myScore;
    
    public PlayerStatus (String name, Health health, Integer score) {
        myName = name;
        myHealth = health;
        myScore = score;
    }
    
    public String getName() {
        return myName;
    }
    
    public Health getHealth() {
        return myHealth;
    }
    
    public Integer getScore() {
        return myScore;
    }
    
}
