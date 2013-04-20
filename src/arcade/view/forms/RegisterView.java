package arcade.view.forms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
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
import arcade.model.Model;
import arcade.view.TextKeywords;


/**
 * The view that allows a new user to register an account.
 * 
 * @author Ellango
 * 
 */
@SuppressWarnings("serial")
public class RegisterView extends Account {
    private static final String DEFAULT_IMAGE =
            new File(System.getProperty("user.dir") + "/src/arcade/resources/images/rcd.jpg")
                    .getPath();
    private static final int WINDOW_WIDTH = 240;
    private static final int WINDOW_HEIGHT = 330;
    private JTextField myFirstNameTextField;
    private JTextField myLastNameTextField;
    private JTextField myDOBTextField;
    private String myImagePath = DEFAULT_IMAGE;

    /**
     * Constructs the register view with a Model and Resource Bundle
     * 
     * 
     * @param model
     * @param resources
     */
    public RegisterView (Model model, ResourceBundle resources) {
        this(model, resources, "", "");
    }

    /**
     * Constructs the register view with a Model, ResourceBundle, and also
     * fills in the username and password fields with some initial values.
     * This might be useful if the user already typed in these values at a
     * previous point such as the login view.
     * 
     * @param model
     * @param resources
     * @param initialUsername
     * @param initialPassword
     */
    public RegisterView (Model model,
                         ResourceBundle resources,
                         String initialUsername,
                         String initialPassword) {
        super(model, resources);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);

        setUsername(initialUsername);
        setPassword(initialPassword);
    }

    /**
     * Lets the user know that the username has already been taken and prompts
     * them to choose a different one.
     */
    public void sendUsernameTakenError () {
        clearUsername();
        sendMessage(getResources().getString(TextKeywords.USERNAME_ERROR));
    }

    /**
     * Lets the user know that they formatted the date of birth field
     * incorrectly and prompts them to try reentering.
     */
    public void sendDOBError () {
        myDOBTextField.setText(TextKeywords.BIRTHDATE_MESSAGE);
        sendMessage(getResources().getString(TextKeywords.BIRTHDATE_ERROR));
    }

    @Override
    protected List<JComponent> makeComponents () {
        List<JComponent> components = new ArrayList<JComponent>();
        components.add(createInstructions());
        components.add(createUsernameField());
        components.add(createPasswordField());
        components.add(createFirstNameField());
        components.add(createLastNameField());
        components.add(createDOBField());
        components.add(createProfilePictureSelector());
        components.add(createMessageArea());
        components.add(createButton());
        return components;
    }

    /**
     * Creates a label representing instructions for the user.
     * 
     * @return
     */
    private JComponent createInstructions () {
        JPanel panel = new JPanel();
        JLabel instruction = new JLabel(getResources().getString(TextKeywords.REGISTER_MESSAGE));
        panel.add(instruction);
        return panel;
    }

    /**
     * Creates the field where the user can enter his/her first name
     * 
     * @return
     */
    private JComponent createFirstNameField () {
        myFirstNameTextField = new JTextField();
        return createTextPanel(TextKeywords.FIRSTNAME, myFirstNameTextField);
    }

    /**
     * Creates the field where the user can enter his/her last name.
     * 
     * @return
     */
    private JComponent createLastNameField () {
        myLastNameTextField = new JTextField();
        return createTextPanel(TextKeywords.LASTNAME, myLastNameTextField);
    }

    /**
     * Creates the field where the user can enter his/her date of birth.
     * 
     * @return
     */
    private JComponent createDOBField () {
        myDOBTextField = new JTextField();
        myDOBTextField.setText(getResources().getString(TextKeywords.BIRTHDATE_MESSAGE));
        myDOBTextField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained (FocusEvent arg0) {
                myDOBTextField.setText("");
            }

            @Override
            public void focusLost (FocusEvent arg0) {
                // do nothing
            }
        });
        return createTextPanel(TextKeywords.BIRTHDATE, myDOBTextField);
    }
    
    /**
     * Creates the panel where the user can select his/her profile picture
     * @return
     */
    private JComponent createProfilePictureSelector () {
        return createImageSelector(TextKeywords.IMAGE_MESSAGE,
                                   TextKeywords.IMAGE_BUTTON,
                                   new FileChooserAction() {
                                       @Override
                                       public void approve (JFileChooser chooser) {
                                           myImagePath = chooser.getSelectedFile().getPath();
                                       }
                                   });
    }

    /**
     * Creates the button where the user can submit his/her information.
     * 
     * @return
     */
    private JComponent createButton () {
        JPanel panel = new JPanel();
        JButton register = new JButton(getResources().getString(TextKeywords.REGISTER));
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent arg0) {
                getModel().createNewUserProfile(getUsername(),
                                                getPassword(),
                                                myFirstNameTextField.getText(),
                                                myLastNameTextField.getText(),
                                                myDOBTextField.getText());// ,
                // myImagePath);
                // maybe.
                dispose();
            }
        });
        panel.add(register);
        return panel;
    }

}
