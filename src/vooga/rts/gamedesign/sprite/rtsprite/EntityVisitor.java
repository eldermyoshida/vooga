package vooga.rts.gamedesign.sprite.rtsprite;

import vooga.rts.gamedesign.sprite.rtsprite.interactive.IOccupiable;


/**
 * 
 * @author Ryan Fishel
 * @author Kevin Oh
 * @author Francesco Agosti
 * @author Wenshun Liu 
 *
 */
public interface EntityVisitor {

   
    public void visit(IAttackable a);
    public void visit(IOccupiable o);

    public void visit(IGatherable g);

}