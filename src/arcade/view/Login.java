package arcade.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import arcade.model.Model;
import arcade.util.BackgroundPanel;


/**
 * The initial view when the arcade is launched. Allows a user to login
 * or create a new account.
 * 
 * @author Luzhuo, Ellango
 * 
 */
@SuppressWarnings("serial")
public class Login extends JFrame {

    private static final String IMAGES_LOCATION = "../resources/images/";
    private static final String BACKGROUND_FILENAME = "LoginBackGround.jpg";
    private static final String LOGO_FILENAME = "VoogaLogo.png";
    private static final String TITLE_KEYWORD = "title";
    private static final String LOGIN_KEYWORD = "login";
    private static final String REGISTER_KEYWORD = "new_account";
    private static final String USERNAME_KEYWORD = "username";
    private static final String PASSWORD_KEYWORD = "password";
    public static final int WINDOW_WIDTH = 300;
    public static final int WINDOW_HEIGHT = 240;
    //private static final int NO_KEY_PRESSED = -1;

    private Model myModel;
    private ResourceBundle myResources;
    private JTextField myUserNameTextField;
    private JPasswordField myPasswordTextField;
    private JLabel myWarningMessage;
    //private int myLastKeyPressed;

    /**
     * Constructor
     * 
     * @param language
     */
    public Login (Model model, ResourceBundle resources) {
        myModel = model;
        myResources = resources;

        setTitle(myResources.getString(TITLE_KEYWORD));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);

        JPanel background = new BackgroundPanel(IMAGES_LOCATION + BACKGROUND_FILENAME);
        getContentPane().add(background);
        background.add(createMainContents());

       // setResizable(false);
        setVisible(true);
    }
    
    public void sendMessage (String message) {
        myWarningMessage.setText("<html><font color = red>" + message + "</font></html>");
    }

    private Component createMainContents () {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        addTransparentComponent(panel, createLogo());
        addTransparentComponent(panel, createUsernameField());
        addTransparentComponent(panel, createPasswordField());
        addTransparentComponent(panel, createMessageArea());
        addTransparentComponent(panel, createButtons());

        panel.setOpaque(false);
        panel.setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        return panel;
    }

    private void addTransparentComponent (Container container, JComponent component) {
        component.setOpaque(false);
        container.add(component);
    }

    /**
     * create the main logo
     */
    private JComponent createLogo () {
        JPanel panel = new JPanel();
        ImageIcon headIcon = new ImageIcon(this.getClass().getResource(IMAGES_LOCATION + LOGO_FILENAME));
        JLabel head = new JLabel(headIcon);
        head.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(head);
        return panel;
    }

    private JComponent createUsernameField () {
        myUserNameTextField = new JTextField();
        return createTextPanel(USERNAME_KEYWORD, myUserNameTextField);
    }

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
        return createTextPanel(PASSWORD_KEYWORD, myPasswordTextField);
    }

    private JPanel createTextPanel (String descriptionKeyword, JTextField inputField) {
        JPanel panel = new JPanel();

        String description = myResources.getString(descriptionKeyword);
        JLabel label = new JLabel("<html><b>" + description + "</b></html>");
        label.setPreferredSize(new Dimension(80, label.getPreferredSize().height));
        panel.add(label);

        inputField.setColumns(10);
        inputField.setPreferredSize(new Dimension(getPreferredSize().width, 25));
        panel.add(inputField);

        return panel;
    }

    private JComponent createMessageArea () {
        JPanel panel = new JPanel();
        myWarningMessage = new JLabel();
        myWarningMessage.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(myWarningMessage);
        return panel;
    }

    private JComponent createButtons () {
        JPanel buttonPanel = new JPanel();

        JButton login = new JButton(myResources.getString(LOGIN_KEYWORD));
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent arg0) {
                tryLogin();
            }
        });
        buttonPanel.add(login);

        JButton register = new JButton(myResources.getString(REGISTER_KEYWORD));
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent arg0) {
                sendMessage("register message");
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

    private void tryLogin () {
        String usernameInput = myUserNameTextField.getText();
        String passwordInput = new String(myPasswordTextField.getPassword());
        resetTextFields();
        myModel.authenticate(usernameInput, passwordInput);
    }

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
