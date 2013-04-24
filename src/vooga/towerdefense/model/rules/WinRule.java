package vooga.towerdefense.model.rules;

import vooga.towerdefense.attributes.AttributeConstants;
import vooga.towerdefense.model.GameModel;

public class WinRule extends Rule {

	public WinRule(GameModel model) {
		super(model);
	}

	@Override
	protected boolean condition() {
		//return (myModel.getPlayer().getScore() > 1000);
	    //return (myModel.getPlayer().getAttributeManager().getAttribute("SCORE").getValue() > 1000);
	    return false;
	}

	@Override
	protected void execute() {
		myModel.win();
	}

}
