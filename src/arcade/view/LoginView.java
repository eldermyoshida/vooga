package arcade.view;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ResourceBundle;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import util.BackgroundPanel;
import arcade.model.Model;


/**
 * The initial view when the arcade is launched. Allows a user to login
 * or create a new account.
 * 
 * @author Luzhuo, Ellango
 * 
 */
@SuppressWarnings("serial")
public class LoginView extends JFrame {
    private static final String BACKGROUND_FILENAME = "../arcade/resources/images/LoginBackGround.jpg";
    private static final String LOGO_FILENAME = "../resources/images/VoogaLogo.png";
    public static final int WINDOW_WIDTH = 260;
    public static final int WINDOW_HEIGHT = 240;
    private static final int TEXT_FIELD_HEIGHT = 25;
    private static final int TEXT_FIELD_SIZE = 10;
    private static final int LABEL_WIDTH = 80;
    private static final int MESSAGE_WIDTH = 140;
    //private static final int NO_KEY_PRESSED = -1;

    private Model myModel;
    private ResourceBundle myResources;
    private JTextField myUserNameTextField;
    private JPasswordField myPasswordTextField;
    private JLabel myWarningMessage;
    //private int myLastKeyPressed;

    /**
     * Constructs the LoginView with a Model and ResourceBundle
     * 
     * @param model to authenticate the login information
     * @param resources to display text of appropriate language on screen
     */
    public LoginView (Model model, ResourceBundle resources) {
        myModel = model;
        myResources = resources;

        setTitle(myResources.getString(TextKeywords.TITLE));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);

        BackgroundPanel background = new BackgroundPanel(BACKGROUND_FILENAME);
        getContentPane().add(background);
        background.add(createMainContents());

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
     * Create the main contents of the view: the logo, username and password 
     * fields, the message area, and the buttons.
     * 
     * @return
     */
    private JComponent createMainContents () {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        addTransparentComponent(panel, createLogo());
        addTransparentComponent(panel, createUsernameField());
        addTransparentComponent(panel, createPasswordField());
        addTransparentComponent(panel, createMessageArea());
        addTransparentComponent(panel, createButtons());

        return panel;
    }

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
     * create the main logo and center it.
     */
    private JComponent createLogo () {
        JPanel panel = new JPanel();
        ImageIcon headIcon = new ImageIcon(this.getClass().getResource(LOGO_FILENAME));
        JLabel head = new JLabel(headIcon);
        panel.add(head);
        return panel;
    }

    /**
     * Create the label and text field for the username entry
     * @return
     */
    private JComponent createUsernameField () {
        myUserNameTextField = new JTextField();
        return createTextPanel(TextKeywords.USERNAME, myUserNameTextField);
    }

    /**
     * Create the label and text field for the password entry.
     * @return
     */
    private JComponent createPasswordField () {
        myPasswordTextField = new JPasswordField();
        myPasswordTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed (KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    tryLogin();
                }
            }
        });
        return createTextPanel(TextKeywords.PASSWORD, myPasswordTextField);
    }

    /**
     * Create a panel with a description and a corresponding text field.
     * @param descriptionKeyword
     * @param inputField
     * @return
     */
    private JPanel createTextPanel (String descriptionKeyword, JTextField inputField) {
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
     * Create a label where an error message can be displayed.
     * @return
     */
    private JComponent createMessageArea () {
        JPanel panel = new JPanel();
        myWarningMessage = new JLabel();
        panel.add(myWarningMessage);
        return panel;
    }

    /**
     * Create the login and register buttons.
     * 
     * @return
     */
    private JComponent createButtons () {
        JPanel buttonPanel = new JPanel();

        JButton login = new JButton(myResources.getString(TextKeywords.LOGIN));
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent arg0) {
                tryLogin();
            }
        });
        buttonPanel.add(login);

        JButton register = new JButton(myResources.getString(TextKeywords.REGISTER));
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent arg0) {
                //TODO: would prefer to call model here to check if username/password okay.
                //RegisterView register = new RegisterView(myModel, myResources);
                //register.send(myUserNameTextField.getText(), new String(myPasswordTextField.getPassword()); )
                
                dispose();
            }
        });
        buttonPanel.add(register);

        resizeComponentWidths(buttonPanel);
        return buttonPanel;
    }

    /**
     * Finds the maximum preferred width for all components in a container,
     * and then resizes all components to match that width.
     * 
     * @param container
     */
    private void resizeComponentWidths (Container container) {
        int max = 0;
        for (Component c : container.getComponents()) {
            int width = c.getPreferredSize().width;
            if (width > max) {
                max = width;
            }
        }

        for (Component c : container.getComponents()) {
            c.setPreferredSize(new Dimension(max, c.getPreferredSize().height));
        }
    }

    /**
     * Sends the inputs to the model to try logging in.
     */
    private void tryLogin () {
        String usernameInput = myUserNameTextField.getText();
        String passwordInput = new String(myPasswordTextField.getPassword());
        resetTextFields();
        myModel.authenticate(usernameInput, passwordInput);
    }

    /**
     * Clears the iniput text fields.
     */
    private void resetTextFields () {
        myUserNameTextField.setText("");
        myPasswordTextField.setText("");
    }

//    /**
//     * create KeyListener: listen to "Enter" key
//     * Reset the myLastKeyPressed to -1 after the key is released
//     * 
//     * @return
//     */
//    private KeyAdapter createKeyAdapter () {
//        KeyAdapter keyAdapter = new KeyAdapter() {
//            @Override
//            public void keyPressed (KeyEvent e) {
//                myLastKeyPressed = e.getKeyCode();
//                if (myLastKeyPressed == KeyEvent.VK_ENTER) {
//                    tryLogin();
//                }
//            }
//
//            @Override
//            public void keyReleased (KeyEvent e) {
//                myLastKeyPressed = NO_KEY_PRESSED;
//            }
//        };
//        return keyAdapter;
//    }
}
