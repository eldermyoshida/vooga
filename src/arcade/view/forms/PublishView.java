package arcade.view.forms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import arcade.model.Model;
import arcade.view.TextKeywords;


@SuppressWarnings("serial")
public class PublishView extends Form {
    private JTextField myNameTextField;
    private JTextField myGenreTextField;
    private JTextField myAuthorTextField;
    private JTextField myPriceTextField;
    private JTextField myAgeTextField;

    /**
     * Constructs the publish view dialog box with a Model and ResourceBundle.
     * 
     * @param model
     * @param resources
     */
    public PublishView (Model model, ResourceBundle resources) {
        super(model, resources);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    @Override
    protected List<JComponent> makeComponents () {
        List<JComponent> components = new ArrayList<JComponent>();
        components.add(createNameField());
        components.add(createGenreField());
        components.add(createAuthorField());
        components.add(createPriceField());
        components.add(createAgeTextField());
        components.add(createButton());
        return components;
    }

    /**
     * Creates the field to enter the name of the game.
     * @return
     */
    private JComponent createNameField () {
        myNameTextField = new JTextField();
        return createTextPanel(TextKeywords.GAME_NAME, myNameTextField);
    }

    /**
     * Creates the field to enter the genre for the game.
     * @return
     */
    private JComponent createGenreField () {
        myGenreTextField = new JTextField();
        return createTextPanel(TextKeywords.GENRE, myGenreTextField);
    }
    
    /**
     * Creates the field to enter the author for the game.
     * @return
     */
    private JComponent createAuthorField() {
        myAuthorTextField = new JTextField();
        return createTextPanel(TextKeywords.AUTHOR, myAuthorTextField);
    }
    
    /**
     * Creates the field to enter the price of the game.
     * @return
     */
    private JComponent createPriceField() {
        myPriceTextField = new JTextField();
        return createTextPanel(TextKeywords.PRICE, myPriceTextField);
    }
    
    /**
     * Creates the field to enter the age rating for the game.
     * @return
     */
    private JComponent createAgeTextField() {
        myAgeTextField = new JTextField();
        return createTextPanel(TextKeywords.AGE_RATING, myAgeTextField);
    }
    
//    /**
//     * Creates the field to select the game's small picture
//     */
//    private JComponent createSmallImageSelector () {
//        JPanel panel = new JPanel();
//        JLabel description = new JLabel(getResources().getString(TextKeywords.SMALL_PICTURE));
//        panel.add(description);
//        JButton button = new JButton(getResources().getString(TextKeywords.FILE_SELECT));
//        button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed (ActionEvent arg0) {
//                JFileChooser chooser = new JFileChooser();
//                FileFilter filter =
//                        new FileNameExtensionFilter(getResources().getString(TextKeywords.IMAGE),
//                                                    "jpg", "gif", "png");
//                chooser.setFileFilter(filter);
//
//                int returnVal = chooser.showOpenDialog(null);
//                if (returnVal == JFileChooser.APPROVE_OPTION) {
//                    myImagePath = chooser.getSelectedFile().getPath();
//                }
//            }
//        });
//        panel.add(button);
//        return panel;
//    }
//    

    /**
     * Creates the button to publish and tell the Model
     * @return
     */
    private JComponent createButton () {
        JPanel panel = new JPanel();
        JButton publish = new JButton(getResources().getString(TextKeywords.PUBLISH));
        publish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent arg0) {
                getModel().publish(myNameTextField.getText(),
                                   myGenreTextField.getText());
                
                dispose();
            }
        });
        panel.add(publish);
        return panel;
    }
}
