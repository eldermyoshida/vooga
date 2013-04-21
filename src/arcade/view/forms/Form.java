package arcade.view.forms;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ResourceBundle;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import util.BackgroundPanel;
import arcade.model.Model;
import arcade.view.TextKeywords;


/**
 * This represents a form that a user can fill out.
 * 
 * @author Ellango
 */
@SuppressWarnings("serial")
public abstract class Form extends JFrame {
    public static final String BACKGROUND_FILENAME =
            "arcade/resources/images/LoginBackGround.jpg";
    private static final int TEXT_FIELD_HEIGHT = 25;
    private static final int TEXT_FIELD_SIZE = 10;
    private static final int LABEL_WIDTH = 80;
    private static final int MESSAGE_WIDTH = 140;
    private static final int CHECKBOX_TRAILING_WIDTH = 35;

    private Model myModel;
    private ResourceBundle myResources;
    private JLabel myWarningMessage;

    /**
     * Constructs the form view with a Model and ResourceBundle. It adds a
     * background and adds all the components from makeComponents().
     * 
     * @param model
     * @param resources
     */
    public Form (Model model, ResourceBundle resources) {
        myModel = model;
        myResources = resources;

        BackgroundPanel background = new BackgroundPanel(BACKGROUND_FILENAME);
        getContentPane().add(background);

        JPanel mainContents = new JPanel();
        mainContents.setLayout(new BoxLayout(mainContents, BoxLayout.Y_AXIS));
        for (JComponent component : makeComponents()) {
            addTransparentComponent(mainContents, component);
        }
        background.add(mainContents);

        setTitle(myResources.getString(TextKeywords.TITLE));
        setResizable(false);
        setVisible(true);
    }

    /**
     * Display an error message in the view.
     * 
     * Called if user makes failed log in attempt or tries to register an account
     * that has already been named.
     * 
     * @param message
     */
    public void sendMessage (String message) {
        myWarningMessage.setText("<html><body style='width:" + MESSAGE_WIDTH + " px'>"
                                 + "<center><font color = red>" + message);
    }

    /**
     * Create all the components to be displayed in the form.
     * 
     * @return
     */
    protected abstract List<JComponent> makeComponents ();

    /**
     * Makes the provided component transparent, and then adds it to the provided
     * container.
     * 
     * @param container
     * @param component
     */
    private void addTransparentComponent (Container container, JComponent component) {
        component.setOpaque(false);
        container.add(component);
    }

    /**
     * Create a panel with a description and a corresponding text field.
     * 
     * @param descriptionKeyword is the keyword in the resource bundle.
     * @param inputField
     * @return
     */
    protected JPanel createTextPanel (String descriptionKeyword, JTextField inputField) {
        JPanel panel = new JPanel();

        String description = myResources.getString(descriptionKeyword);
        JLabel label = new JLabel("<html><b>" + description);
        label.setPreferredSize(new Dimension(LABEL_WIDTH, label.getPreferredSize().height));
        panel.add(label);

        inputField.setColumns(TEXT_FIELD_SIZE);
        inputField.setPreferredSize(new Dimension(getPreferredSize().width, TEXT_FIELD_HEIGHT));
        panel.add(inputField);

        return panel;
    }

    /**
     * Create a panel with a description of an instruction, and a button to
     * select an image.
     * 
     * @param descriptionKeyword is the ResourceBundle keyword for the description
     * @param buttonKeyword is the ResourceBundle keyword for the button label
     * @param action is the FileChooserAction with the method defined for what
     *        to do on approval
     */
    protected JComponent createImageSelector (String descriptionKeyword,
                                              String buttonKeyword,
                                              final FileChooserAction action) {
        JPanel panel = new JPanel();
        JLabel description = new JLabel(getResources().getString(descriptionKeyword));
        panel.add(description);
        JButton button = new JButton(getResources().getString(buttonKeyword));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent arg0) {
                JFileChooser chooser = new JFileChooser();
                FileFilter filter =
                        new FileNameExtensionFilter(getResources().getString(TextKeywords.IMAGE),
                                                    "jpg", "gif", "png");
                chooser.setFileFilter(filter);

                int returnVal = chooser.showOpenDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    action.approve(chooser);
                }
            }
        });
        panel.add(button);
        return panel;
    }

    /**
     * Creates the checkbox for the user to enter if the checkBoxMessage is true,
     * and if so, pops up a file chooser to select what is specified by
     * instructionKeyword. The result from the file chooser is dealt with by
     * the provided FileChooserAction.
     * 
     * There will be the specified width between the checkbox and the checkbox message.
     * 
     * @return
     */
    protected JComponent createCheckBox (String checkBoxMessageKeyword,
                                         final String instructionKeyword,
                                         int width,
                                         final FileChooserAction action) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        JLabel label = new JLabel(getResources().getString(checkBoxMessageKeyword));
        panel.add(label);
        panel.add(Box.createHorizontalStrut(width));
        JCheckBox box = new JCheckBox();
        box.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent arg0) {
                JOptionPane.showMessageDialog(null,
                                              getResources().getString(instructionKeyword),
                                              getResources().getString(TextKeywords.POPUP_TITLE),
                                              JOptionPane.INFORMATION_MESSAGE);
                JFileChooser chooser = new JFileChooser();
                int returnVal = chooser.showOpenDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    action.approve(chooser);
                }
            }
        });
        box.setOpaque(false);
        panel.add(box);
        panel.add(Box.createHorizontalStrut(CHECKBOX_TRAILING_WIDTH));
        return panel;
    }

    /**
     * Create a label where an error message can be displayed.
     * 
     * @return
     */
    protected JComponent createMessageArea () {
        JPanel panel = new JPanel();
        myWarningMessage = new JLabel();
        panel.add(myWarningMessage);
        return panel;
    }

    /**
     * Access to the model for subclasses.
     * 
     * @return
     */
    protected Model getModel () {
        return myModel;
    }

    /**
     * Access to the resources for subclasses.
     * 
     * @return
     */
    protected ResourceBundle getResources () {
        return myResources;
    }

}
