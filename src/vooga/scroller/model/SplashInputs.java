package vooga.scroller.model;

import javax.swing.JComponent;
import vooga.scroller.input.AlertObject;
import vooga.scroller.input.Input;
import vooga.scroller.input.InputClassTarget;
import vooga.scroller.input.InputMethodTarget;
import vooga.scroller.level_management.SplashPage;

@InputClassTarget
public class SplashInputs implements IInput{
    private static final String TEST_CONTROLS = "vooga/scroller/resources/controls/SplashMapping";

    private Input myInput;
    private SplashPage mySplashPage;
    /**
     * Creates a new set of ModelInputs based on
     * 
     * @param player on which the controls will act
     * @param view from where the controls come from.
     */
    public SplashInputs (SplashPage sp, JComponent view) {
        myInput = new Input(TEST_CONTROLS, view);              
        myInput.addListenerTo(this); 
        mySplashPage = sp;
    }
   
    
    /**
     * Player moves up
     * 
     * @param alObj
     */
    @InputMethodTarget(name = "space")
    public void spaceInput (AlertObject alObj) {
        System.out.println("hit space");

            mySplashPage.exit();
    }
    
    @InputMethodTarget(name = "exit")
    public void exitInput(AlertObject alobj) {
        System.exit(-1);
    }


    @Override
    public boolean isValidInputClass () {
        Class inputClass = this.getClass();
        return inputClass.getAnnotation(InputClassTarget.class) != null;
    }

    



}
