package arcade.controller;

public class GameSpecificData {
	/**
	 * This class is used to hold game-specific data entered by developer. When the publisher
	 * presses the "publish" button, The view stores all the game-specific information in this class
	 * and passes to controller.
	 * 
	 * Honestly, I do not think this class is necessary. However, our TA Jimmy was concerned that the 
	 * publish() method in the controller is receiving to many input variables and recommended that
	 * we use a class to encapsulate these variables.
	 * 
	 * If this class remains in final implementation, it may have to be moved to a different package.
	 * 
	 * @author Eunsu (Joe) Ryu - jesryu
	 */
	
	private String gameName;
	private String gameGenre;
	private String gameAuthor;
	private double gamePrice;
	private String extendsGamePath;
	private String extendsMultiplayerGamePath;
	private int gameAgeRating;
	private boolean gameIsSinglePlayer;
	private boolean gameIsMultiPlayer;
	private String gameThumbnailFilePath;
	private String gameAdScreenPath;
	private String gameDescription;
	
	public GameSpecificData(String name, String genre, String author, double price, String extendsGame, String extendsMultiplayerGame, int ageRating,
			boolean singleplayer, boolean multiplayer, String thumbnailPath, String adScreenPath, String description){
		gameName = name;
		gameGenre = genre;
		gameAuthor = author;
		gamePrice = price;
		extendsGamePath = extendsGame;
		extendsMultiplayerGamePath = extendsMultiplayerGame;
		gameAgeRating = ageRating;
		gameIsSinglePlayer = singleplayer;
		gameIsMultiPlayer = multiplayer;
		gameThumbnailFilePath = thumbnailPath;
		gameAdScreenPath = adScreenPath;
		gameDescription = description;
	}
	
	public String getName(){
		return gameName;
	}
	
	public String getGenre() {
		return gameGenre;
		
	}
	
	public String getAuthor () {
		return gameAuthor;
	}

	public String getExtendsGame(){
		return extendsGamePath;
	}
	
	public String getExtendsMultiplyaer(){
		return extendsMultiplayerGamePath;
	}

	public double getPrice() {
		return gamePrice;
	}
	
	public int getAgeRating(){
		return gameAgeRating;
	}
	
	public boolean isSinglePlayer(){
		return gameIsSinglePlayer;
	}
	
	public boolean isMultiplayer(){
		return gameIsMultiPlayer;
	}
	
	public String getThumbnailPath(){
		return gameThumbnailFilePath;
	}
	
	public String getAdScreenPath(){
		return gameAdScreenPath;
	}
	
	public String getDescription(){
		return gameDescription;
	}
}
