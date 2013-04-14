package vooga.towerdefense.gameElements;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import vooga.towerdefense.action.AbstractAction;
import vooga.towerdefense.attributes.Attacker;
import vooga.towerdefense.attributes.AttackerAttributes;
import vooga.towerdefense.attributes.Targetable;
import vooga.towerdefense.util.Location;
import vooga.towerdefense.util.Pixmap;
import vooga.towerdefense.gameElements.GameElement;


public class Projectile extends GameElement implements Attacker {
    private static int DEFAULT_WIDTH;
    private static final Pixmap DEFAULT_IMAGE = new Pixmap("defined by designer");
    private static final Dimension DEFAULT_SIZE = new Dimension(DEFAULT_WIDTH, DEFAULT_WIDTH);
    private static final List<AbstractAction> DEFAULT_ACTIONS = new ArrayList<AbstractAction>();
    private AttackerAttributes myAttackAttributes;

    public Projectile (GameElement initiator, Targetable target) {
        super(DEFAULT_IMAGE, initiator.getCenter(), DEFAULT_SIZE, DEFAULT_ACTIONS);

    }

    @Override
    public double getAttackRadius () {
        return myAttackAttributes.getAttackRadius().getValue();
    }

    @Override
    public int getNumberOfTargets () {
        return (int) myAttackAttributes.getNumberOfTargets().getValue();
    }

    @Override
    public double getAttackDamage () {
        return myAttackAttributes.getAttackDamage().getValue();
    }

    @Override
    public Targetable getTarget () {

        return null;
    }

    @Override
    public void addTarget () {

    }

}
