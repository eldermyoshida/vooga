package vooga.fighter.view;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JComponent; 

public abstract class HUDWindow extends JComponent {

     
	private GridBagConstraints myConstraints;
    private Container myParent;

    
    public HUDWindow () {
    	RootWindow root = new RootWindow(this);
    	myParent = root;
    	setLayoutManager();
        myConstraints = new GridBagConstraints();
        this.setBorder(ViewConstants.DEFAULT_BORDER);
        initializeVariables(); 
        addComponents();
    }
    
    public Container getParent() {
        return myParent;
    }

    
    private void setLayoutManager() {
        this.setLayout(new GridBagLayout());
        myConstraints = new GridBagConstraints();
        this.setBorder(ViewConstants.DEFAULT_BORDER);
    }
    
    protected GridBagConstraints getConstraints() {
        return myConstraints;
    }

    protected abstract void initializeVariables ();
    
    protected abstract void addComponents ();
    
}
