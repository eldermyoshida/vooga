package arcade.controller;

public class GameData {
	/**
	 * This class is used to hold game-specific data entered by developer. When the publisher
	 * presses the "publish" button, The view stores all the game-specific information in this class
	 * and passes to controller.
	 * 
	 * Honestly, I do not think this class is necessary. However, our TA Jimmy was concerned that the 
	 * publish() method in the controller is receiving to many input variables and recommended that
	 * we use a class to encapsulate these variables.
	 * 
	 * @author Eunsu (Joe) Ryu - jesryu
	 */
	
	private String gameName;
	private String gameGenre;
	private String gameAuthor;
	private double gamePrice;
	private String thisGameExtendsGame;
	private String thisGameExtendsMultiplayerGame;
	private int gameAgeRating;
	private boolean gameIsSinglePlayer;
	private boolean gameIsMultiPlayer;
	private String gameThumbnailFilePath;
	private String gameAdScreenPath;
	private String gameDescription;
	
	public GameData(String name, String genre, String author, double price, String extendsGame, String extendsMultiplayerGame, int ageRating,
			boolean singlePlayer, boolean multiplayer, String thumbnailPath, String adScreenPath, String description){
		
	}

}
