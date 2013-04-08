package vooga.fighter.controller;

public class PlayerStatus {
	Integer myTotalScore;
	public PlayerStatus() {
		myTotalScore = 0;
	}
	
	public void addScore(Integer score){
		myTotalScore += score;
	}
	
	public Integer getScore(){
		return myTotalScore;
	}

}
