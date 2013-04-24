package arcade.view;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import util.ImageHelper;
import arcade.controller.Controller;
import arcade.games.Comment;
import arcade.games.GameInfo;
import arcade.view.forms.payment.PaymentSelection;


/**
 * Detail View
 * 
 * 
 * @author David Liu, Ellango Jothimurugesan
 * 
 */
public class DetailView extends JFrame {
	private static final String COMMENT_AREA_CONTENT_TYPE = "text/html";
	private static final String COMMENTS = "Comments";
	private static final String PLAY_IMAGE_URL = "/src/arcade/resources/images/PlayIcon.jpg";
	private static final String USER_DIR = "user.dir";
	private static final String PRICE = "Price: ";
	private static final String BUY = "BUY";
	private static final int DESCRIPTION_COLUMN = 1;
	private static final int DESCRIPTION_ROWS = 10;
	private static final int DESCRIPTION_SECTION_BACKGROUND_OPACITY = 20;
	private static final String GAME_TITLE_FONT_TAIL = "</font></font></b></html>";
	private static final String GAME_TITLE_FONT_HEADER = "<html><b><font color = gray><font size = 6>";
	private static final String HTML_BOLD_HEADER = "<b>";
	private static final String HTML_BOLD_TAIL = "</b>";
	
	private static final int WINDOW_WIDTH = 600;
	private static final int WINDOW_HEIGHT = 600;
	private static final int LABEL_HEIGHT = 15;
	private static final int LABEL_WIDTH = 100;
	private static final int ORIGIN_X = 5;
	private static final String NEWLINE = "\n";
	private static final String HTML_NEWLINE = "<br>";
	


	private ResourceBundle myResources;
	private GameInfo myGameInfo;
	private JPanel myContentPanel;
	private JLabel myTitle,
	myPicture,
	myRating,
	myGenre,
	myDescription,
	myAuthor,
	myComments;

	private JTextField myCommentsWriter;
	private JTextField myRatingWriter;
	private JTextArea myDescriptionContent;
	private JEditorPane myCommentsContent;
	private JButton myPlayButton, myBuyButton;
	private Controller myController;

	public DetailView (GameInfo info, ResourceBundle resources, Controller controller) {
		myController = controller;
		setBackground(Color.WHITE);
		myGameInfo = info;
		myResources = resources;
		myContentPanel = (JPanel) getContentPane();
		setLayout(new BoxLayout(myContentPanel, BoxLayout.PAGE_AXIS));
		setTitle(resources.getString(TextKeywords.TITLE));
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, WINDOW_WIDTH, WINDOW_HEIGHT);

		// First Panel
		myContentPanel.add(createTheBasicInfoPanel());

		Color c = createBackGroundColorForDescriptionSection();
		createAndConfigureTheDescriptionSection(c);

		myComments = new JLabel(COMMENTS);
		myComments.setBackground(Color.gray);
		myContentPanel.add(myComments);

		myCommentsContent = new JEditorPane();
		myCommentsContent.setEditable(false);
		myCommentsContent.setContentType(COMMENT_AREA_CONTENT_TYPE);
		constructCommentAreaContent();
		JScrollPane commentPane = new JScrollPane(myCommentsContent);
		myContentPanel.add(commentPane);

		myCommentsWriter = new JTextField();
		myCommentsWriter.setBounds(ORIGIN_X, 600, WINDOW_WIDTH, 50);


		myRatingWriter = new JTextField();
		myRatingWriter.setBounds(ORIGIN_X, 650, WINDOW_WIDTH, 50);
		JButton ratingButton = new JButton("Submit");
		ratingButton.setBounds(ORIGIN_X, 700, WINDOW_WIDTH, 50);
		ratingButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed (ActionEvent arg0) {
				double rating = Double.parseDouble(myRatingWriter.getText());
				myController.commentAndRateGame(myCommentsWriter.getText(), rating, myGameInfo.getName());
			}
		});

		myContentPanel.add(myComments);
		myContentPanel.add(commentPane);
		myContentPanel.add(myCommentsWriter);
		myContentPanel.add(myRatingWriter);
		myContentPanel.add(ratingButton);

		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	private void createAndConfigureTheDescriptionSection(Color c) {

		myDescription = new JLabel("Description");
		myDescription.setBackground(c);

		myDescriptionContent = new JTextArea(myGameInfo.getDescription(), DESCRIPTION_ROWS, DESCRIPTION_COLUMN);
		myDescriptionContent.setLineWrap(true);
		myDescriptionContent.setWrapStyleWord(true);
		myDescriptionContent.setEditable(false);
		myDescriptionContent.setBackground(c);

		JScrollPane descriptionPane = new JScrollPane(myDescriptionContent);

		myContentPanel.add(myDescription);
		myContentPanel.add(descriptionPane);
	}

	private JPanel createTheBasicInfoPanel() {
		JPanel basicInfoPanel = new JPanel();

		ImageIcon icon = myGameInfo.getThumbnail();
		Image scaledImage = ImageHelper.getScaledImage(icon, 160);
		myPicture = new JLabel(new ImageIcon(scaledImage));

		basicInfoPanel.add(myPicture);
		basicInfoPanel.add(createSubPanelForBasicInfoPanel(myGameInfo));

		createThePlayButtonWithGameTriggeringActionListener();
		createThePurchaseButtonWithPaymentWindowTrigger();

		if (myController.getGamesPurchased().contains(myGameInfo))
			basicInfoPanel.add(myPlayButton);
		else
			basicInfoPanel.add(myBuyButton);
		return basicInfoPanel;
	}

	private Color createBackGroundColorForDescriptionSection() {
		int r = Color.GRAY.getRed();
		int g = Color.gray.getGreen();
		int b = Color.GRAY.getBlue();
		Color c = new Color(r, g, b, DESCRIPTION_SECTION_BACKGROUND_OPACITY);
		return c;
	}

	private void createThePurchaseButtonWithPaymentWindowTrigger() {
		myBuyButton = new JButton(BUY+ NEWLINE + PRICE + myGameInfo.getPrice()); 
		myBuyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent arg0) {
				new PaymentSelection(myController, myResources, myGameInfo);
			}
		});
	}

	private void createThePlayButtonWithGameTriggeringActionListener() {
		String localDirectory = System.getProperty(USER_DIR);
		ImageIcon playButtonIcon =
				new ImageIcon(localDirectory + PLAY_IMAGE_URL);
		myPlayButton = new JButton(playButtonIcon);
		myPlayButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent e) {
				myController.playGame(myGameInfo);
			}
		});
	}

	private JPanel createSubPanelForBasicInfoPanel(GameInfo info) {
		JPanel subPanelForBasicInfo = new JPanel();
		subPanelForBasicInfo.setLayout(new BoxLayout(subPanelForBasicInfo, BoxLayout.PAGE_AXIS));
		myTitle = new JLabel(GAME_TITLE_FONT_HEADER + myGameInfo.getName() + GAME_TITLE_FONT_TAIL);
		myGenre = new JLabel(myGameInfo.getGenre());
		myAuthor = new JLabel(myGameInfo.getAuthor());
		myRating = new JLabel(info.getRating()+"");
		subPanelForBasicInfo.add(myTitle);
		subPanelForBasicInfo.add(myGenre);
		subPanelForBasicInfo.add(myAuthor);
		subPanelForBasicInfo.add(myRating);
		return subPanelForBasicInfo;
	}

	private void constructCommentAreaContent () {
		List<Comment> comments = myGameInfo.getComments();
		StringBuilder sb = new StringBuilder();
		for (Comment comment : comments) {
			sb.append(HTML_BOLD_HEADER + comment.getUser() + HTML_BOLD_TAIL);
			sb.append(HTML_NEWLINE);
			sb.append(comment.getRating() + "");
			sb.append(HTML_NEWLINE);
			sb.append(comment.getComment());
			sb.append(HTML_NEWLINE);           
			sb.append(HTML_NEWLINE);
		}
		myCommentsContent.setText(sb.toString());
	}
}
