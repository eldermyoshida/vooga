package vooga.rts.leveleditor.gui;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class LevelEditor extends JPanel //TODO: implements listener
{
   
    ResourceOutliner resourceOutliner;

    ResourceContainer[] top = new ResourceContainer[5];
    JButton removeButton;
    JButton addButton;

    public LevelEditor()
    {
        resourceOutliner = new ResourceOutliner(top);
        for(int i = 0; i < 5; i++)
        {
            resourceOutliner.addDice();
        }

        removeButton = new JButton("Remove");
        //removeButton.addActionListener((ActionListener) this);
        addButton = new JButton("Add");
        
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(5, 5, 5, 5);

        c.gridx = 0;
        c.gridy = 0;
        add(resourceOutliner, c);
        
        c.gridx = 0;
        c.gridy = 1;
        //c.gridheight = 2;
        add(removeButton, c);
        
        c.gridx = 1;
        c.gridy = 1;
        add(addButton, c);
    }

    public static void main(String[] argv)
    {
        JFrame left = new JFrame();
        JPanel game = new LevelEditor();
        
        
        left.getContentPane().setLayout(new GridBagLayout());
        left.getContentPane().add(game);
        left.pack();

        left.setResizable(false);
        left.setTitle("Level Editor");
        left.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        left.setLocationRelativeTo(null);
   
      

        left.setVisible(true);
        

    }
}
