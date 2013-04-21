package arcade.view.forms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import arcade.exceptions.DOBFormatException;
import arcade.exceptions.UsernameFormatException;
import arcade.exceptions.UsernameTakenException;
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
        components.add(createRegisterButton());
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
     * 
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
    private JComponent createRegisterButton () {
        return createButton(TextKeywords.REGISTER,
                            new ActionListener() {
                                @Override
                                public void actionPerformed (ActionEvent arg0) {
                                    registerNewUser();
                                }
                            });
    }

    /**
     * Tries to register a new user in the database. Checks if username and
     * date of birth are in the correct format.
     * 
     * If register successful, logs in to the arcade.
     * 
     */
    private void registerNewUser () {
        try {
            if (!isUsernameCorrectFormat(getUsername())) { throw new UsernameFormatException(); }

            if (!isDOBCorrectFormat(myDOBTextField.getText())) { throw new DOBFormatException(); }

            getModel().createNewUserProfile(getUsername(),
                                            getPassword(),
                                            myFirstNameTextField.getText(),
                                            myLastNameTextField.getText(),
                                            myDOBTextField.getText());// ,
            // myImagePath);
            dispose();

        }
        catch (UsernameFormatException e) {
            sendMessage(getResources().getString(e.getLocalizedMessage()));
            return;
        }
        catch (DOBFormatException e) {
            sendMessage(getResources().getString(e.getLocalizedMessage()));
            myDOBTextField.setText(TextKeywords.BIRTHDATE_MESSAGE);
            return;
        }
        catch (UsernameTakenException e) {
            sendMessage(getResources().getString(e.getLocalizedMessage()));
            clearUsername();
            return;
        }
    }

    /**
     * Checks if the username is in an okay format. This implementation only
     * requires that it contains some characters, but this method can be overriden
     * if more checks are desired (e.g. a minimum length, no profanity)
     * 
     * @param username
     * @return
     */
    private boolean isUsernameCorrectFormat (String username) {
        return !(username.isEmpty());
    }

    /**
     * Checks if the date of birth is in the correct format.
     * 
     * @param text
     * @return
     */
    private boolean isDOBCorrectFormat (String dob) {
        // TODO: USE REGULAR EXPRESSIONS
        return true;
    }

}