package vooga.fighter.view;
 
import vooga.fighter.util.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MenuWindow  extends HUDWindow{

	private Dimension mySize;
	
	public MenuWindow (GameWindow gameWindow) {
		super (gameWindow);
		this.setPreferredSize(mySize);
		this.setBorder(ViewConstants.DEFAULT_BORDER);
		setVisible(true); 
	}

	public void addButton(String title, Pixmap image) { 
		
	}
	
	@Override
	protected void initializeVariables() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void addComponents() {
		// TODO Auto-generated method stub
		
	}


}
