package vooga.scroller.viewUtil;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BackgroundButton extends JButton {

    private static final long serialVersionUID = 1L;
    private String myID;
    
    public BackgroundButton(ImageIcon icon, String id){
        super(icon);
        myID = id;   
    }
    
    public String getID(){
        return myID;
    }

}
