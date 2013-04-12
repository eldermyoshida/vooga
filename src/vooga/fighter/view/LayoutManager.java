package vooga.fighter.view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JComponent;

public class LayoutManager {

	private static GridBagLayout gameGrid = new GridBagLayout();
	private static GridBagConstraints gameGridConstraints = new GridBagConstraints(); 
	private static GridBagLayout menuGrid = new GridBagLayout(); 
	private static GridBagConstraints menuGridConstraints = new GridBagConstraints(); 
	
    
	/**
     * Creates horizontal grid layout with equal sized components
     * @param parent The parent container which the children will go in
     * @param children The array of children components that will be added to the parent
     */   
	/*
    public static void layoutHorizontal(Container parent, JComponent ... children) {
        layoutHelper(true, parent, children);
    }
*/
    /**
     * Creates vertical grid layout with equal sized components
     * @param parent The parent container which the children will go in
     * @param children The array of children components that will be added to the parent
     */ 
    /*
	public static void layoutVertical(Container parent, JComponent ... children) {
        layoutHelper(false, parent, children);
    }
	
    private static void layoutHelper(boolean isHorizontal,
                                     Container parent, JComponent ... children) {
        parent.setLayout(new GridBagLayout());
        int size = children.length;
        int childwidth = parent.getWidth() / size;
        int childheight = parent.getHeight() / size;
        
        GridBagConstraints c = new GridBagConstraints();
        configureDefault(c);
        for (int i = 0; i < size; i++) {
            if (isHorizontal) {
                c.gridx = i;
                c.gridy = 0;
                children[i].setPreferredSize(new Dimension(childwidth, parent.getHeight()));
            } 
            else {
                c.gridx = 0;
                c.gridy = i;
                children[i].setPreferredSize(new Dimension(parent.getWidth(), childheight));
            }
            parent.add(children[i], c);
        }  
    }
    
    private static void configureDefault(GridBagConstraints c) {
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = 1;
        c.gridwidth = 1;
        c.gridheight = 1;
    }
    */
    /**
     * Adds game window
     * @param parent
     * @param gameWindow
     */
    public static void layoutDefaultGameWindow (Container parent, JComponent gameWindow) { 
    	
    	parent.setLayout(new GridBagLayout()); 
    	GridBagConstraints c = new GridBagConstraints(); 
    	
    	c.fill = GridBagConstraints.BOTH; 
    	c.gridx = 0; 
    	c.gridy = 0; 
    	parent.add(gameWindow); 
    }
    
    /**
     * For 2 players only, as of now
     * @param parent
     * @param player1
     * @param player2
     */
    public static void layoutDefaultPlayerStatisticsWindows (Container parent, JComponent player1, JComponent player2) { 
    	
    	parent.setLayout(gameGrid); 
    	
    	//player 1
    	gameGridConstraints.fill = GridBagConstraints.HORIZONTAL; 
    	gameGridConstraints.anchor = GridBagConstraints.LAST_LINE_START; 
    	gameGridConstraints.weightx = 0.5; 
    	gameGridConstraints.gridx = 1;
    	gameGridConstraints.gridy = 7; 
    	gameGridConstraints.gridheight = 2; 
    	gameGridConstraints.gridwidth = 5; 
    	parent.add(player1, gameGridConstraints); 
    	
    	//player 2 
    	gameGridConstraints.fill = GridBagConstraints.HORIZONTAL; 
    	gameGridConstraints.anchor = GridBagConstraints.LAST_LINE_END;
    	gameGridConstraints.weightx = 0.5; 
    	gameGridConstraints.gridx = 8; 
    	gameGridConstraints.gridy = 7; 
    	gameGridConstraints.gridheight = 2; 
    	gameGridConstraints.gridwidth = 5; 
    	parent.add(player2, gameGridConstraints); 

    }
    
    public static void layoutDefaultDamageStatisticsWindows (Container parent, JComponent player1, JComponent player2) { 
    	
    	parent.setLayout(gameGrid);
    	
    	//player 1
    	gameGridConstraints.fill = GridBagConstraints.HORIZONTAL; 
    	gameGridConstraints.anchor = GridBagConstraints.FIRST_LINE_START; 
    	gameGridConstraints.weightx = 0.5; 
    	gameGridConstraints.gridx = 1; 
    	gameGridConstraints.gridy = 0; 
    	gameGridConstraints.gridheight = 1; 
    	gameGridConstraints.gridwidth = 5; 
    	parent.add(player1, gameGridConstraints); 
    	
    	//player 2
    	gameGridConstraints.fill = GridBagConstraints.HORIZONTAL; 
    	gameGridConstraints.anchor = GridBagConstraints.FIRST_LINE_END; 
    	gameGridConstraints.weightx = 0.5; 
    	gameGridConstraints.gridx = 8; 
    	gameGridConstraints.gridy = 0; 
    	gameGridConstraints.gridheight = 1; 
    	gameGridConstraints.gridwidth = 5; 
    	parent.add(player2, gameGridConstraints); 
    
    }
    
    public static void layoutDefaultTimerWindow (Container parent, JComponent timer) { 
    	
    	parent.setLayout(gameGrid);  
    	
    	gameGridConstraints.fill = GridBagConstraints.HORIZONTAL; 
    	gameGridConstraints.anchor = GridBagConstraints.PAGE_START; 
    	gameGridConstraints.weightx = 0.5;
    	gameGridConstraints.gridx = 6; 
    	gameGridConstraints.gridy = 0; 
    	gameGridConstraints.gridheight = 1; 
    	gameGridConstraints.gridwidth = 2; 
    	parent.add(timer, gameGridConstraints); 
    		
    }
	
}
