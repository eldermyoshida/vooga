package arcade.view;

import java.util.ResourceBundle;

import javax.swing.JFrame;

import arcade.games.GameInfo;

public class DetailView extends JFrame{
	private ResourceBundle myResources;
	private GameInfo myGameInfo;
	
	/*
	 * TODO:
	 * I dont think we shouldpass resource bundle. THe resource bundle is in the game info.
	 * If you need something in the resource bundle, we should hide that inside the gameinfo class
	 */
	public DetailView(GameInfo info, ResourceBundle resources){
		myGameInfo= info;
		myResources = resources;
		
		
	/*
	 * TODO:
	 * display ad screen from resource bundle
	 * display description
	 * display play button (if game is single player)
	 * display multiplayer button (if game is multiplayer) 
	 * 
	 */
		
		
	}

}
