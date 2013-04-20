package vooga.scroller.util;

import java.awt.Dimension;
import java.awt.Graphics2D;
import util.input.Input;
import vooga.scroller.level_management.LevelManager;
import vooga.scroller.view.View;

public interface IGameComponent {

    
    public void update(double elapsedTime, Dimension bounds, View view);
    
    public void addManager (LevelManager lm);
    
    public void addInputListeners (Input myInput);
    
    public void removeInputListeners (Input myInput);
    
    public void paint (Graphics2D pen) {
    
    public String getInputFilePath ();
    
}
