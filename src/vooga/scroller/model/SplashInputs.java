package vooga.scroller.model;

import java.lang.annotation.Annotation;
import javax.swing.JComponent;
import vooga.scroller.input.AlertObject;
import vooga.scroller.input.Input;
import vooga.scroller.input.InputClassTarget;
import vooga.scroller.input.InputMethodTarget;
import vooga.scroller.sprites.superclasses.Player;

@InputClassTarget
public class SplashInputs implements IInput{
    private static final String TEST_CONTROLS = "vooga/scroller/resources/controls/SplashMapping";

    private Input myInput;
    private Model myModel;

    /**
     * Creates a new set of ModelInputs based on
     * 
     * @param player on which the controls will act
     * @param view from where the controls come from.
     */
    public SplashInputs (Model model, JComponent view) {
        myInput = new Input(TEST_CONTROLS, view);
        myModel = model;
               
        myInput.addListenerTo(this);
        
    }
   
    
    /**
     * Player moves up
     * 
     * @param alObj
     */
    @InputMethodTarget(name = "space")
    public void spaceInput (AlertObject alObj) {
            myModel.start();
    }


    @Override
    public boolean isValidInputClass () {
        Class inputClass = this.getClass();
        return inputClass.getAnnotation(InputClassTarget.class) != null;
    }

    



}
